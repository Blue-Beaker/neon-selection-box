package io.bluebeaker.neonselbox.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.shapes.VoxelShape;
@Mixin(WorldRenderer.class)
public interface AccessorWorldRenderer {
    @Accessor
    ClientWorld getLevel();
    @Invoker("renderShape")
    public static void renderShape(MatrixStack matrix, IVertexBuilder vertices, VoxelShape shape, double d1, double d2, double d3, float r, float g, float b, float width){
        throw new AssertionError();
    };
}
