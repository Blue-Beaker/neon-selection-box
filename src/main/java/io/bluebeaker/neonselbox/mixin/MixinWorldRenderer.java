package io.bluebeaker.neonselbox.mixin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.bluebeaker.neonselbox.ConfigRegistry;
import io.bluebeaker.neonselbox.RenderTools;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;

@Mixin(WorldRenderer.class)
public abstract class MixinWorldRenderer {
    private static final Logger LOGGER = LogManager.getLogger();
    @Inject(method = "renderHitOutline", at = @At(value = "HEAD"),cancellable = true)
    public void renderHitOutline(MatrixStack matrix, IVertexBuilder vertices, Entity entity, double d1, double d2, double d3, BlockPos pos, BlockState state,CallbackInfo ci){
        if(!ConfigRegistry.Enable.get()) return;
        float r=ConfigRegistry.Red.get().floatValue();
        float g=ConfigRegistry.Green.get().floatValue();
        float b=ConfigRegistry.Blue.get().floatValue();
        float a=ConfigRegistry.Alpha.get().floatValue();
        float w=ConfigRegistry.Width.get().floatValue();
        int interval=ConfigRegistry.BlinkInterval.get();
        if(interval>0){
            float mix=Math.abs(System.currentTimeMillis()%(2*interval)-interval)/(float)interval;
            r=mix*ConfigRegistry.Red2.get().floatValue()+(1-mix)*r;
            g=mix*ConfigRegistry.Green2.get().floatValue()+(1-mix)*g;
            b=mix*ConfigRegistry.Blue2.get().floatValue()+(1-mix)*b;
            a=mix*ConfigRegistry.Alpha2.get().floatValue()+(1-mix)*a;
        }
        RenderTools.renderShape(matrix, vertices, state.getShape(((AccessorWorldRenderer)(Object)this).getLevel(), pos, ISelectionContext.of(entity)), (double)pos.getX() - d1, (double)pos.getY() - d2, (double)pos.getZ() - d3,r,g,b,a,w);
        ci.cancel();
    }
}
