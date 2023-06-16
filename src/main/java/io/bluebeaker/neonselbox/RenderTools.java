package io.bluebeaker.neonselbox;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Matrix4f;

public class RenderTools {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void renderShape(MatrixStack matrix, IVertexBuilder vertices, VoxelShape shape, double d1, double d2, double d3, float r, float g, float b, float a, float width) {
        Matrix4f matrix4f = matrix.last().pose();
        Tessellator tessellator = Tessellator.getInstance();
        shape.forAllEdges((x1, y1, z1, x2, y2, z2) -> {
            BufferBuilder bufferbuilder = tessellator.getBuilder();
            if(!ConfigRegistry.DisableDepth.get())
            RenderSystem.enableDepthTest();
            RenderSystem.defaultAlphaFunc();
            RenderSystem.disableTexture();
            RenderSystem.disableBlend();
            RenderSystem.lineWidth(width);
            bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.vertex(matrix4f, (float)(x1 + d1), (float)(y1 + d2), (float)(z1 + d3)).color(r, g, b, a).endVertex();
            bufferbuilder.vertex(matrix4f, (float)(x2 + d1), (float)(y2 + d2), (float)(z2 + d3)).color(r, g, b, a).endVertex();
            tessellator.end();
        });
    }
}
