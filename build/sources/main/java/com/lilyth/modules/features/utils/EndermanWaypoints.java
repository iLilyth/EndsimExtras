package com.lilyth.modules;

import com.lilyth.EndsimExtras;
import com.lilyth.config.Config;
import com.lilyth.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class EndermanWaypoints {
    public final Config config = EndsimExtras.config;

    @SubscribeEvent
    public void endermanWaypoints(RenderLivingEvent.Specials.Pre<EntityLivingBase> e) {
        if (!config.ENDERMAN_WAYPOINTS || !Utils.isOnEndsim()) return;
        Minecraft mc = Minecraft.getMinecraft();
        Entity entity = e.entity;
        if (entity instanceof EntityEnderman) {
            String name = "Z";
            float x = entity.getPosition().getX();
            float y = entity.getPosition().getY();
            float z = entity.getPosition().getZ();
            FontRenderer fontRenderer = mc.fontRendererObj;
            float viewerYaw = mc.thePlayer.rotationYaw;
            float viewerPitch = mc.thePlayer.rotationPitch;
            RenderManager renderManager = mc.getRenderManager();
            double distanceScale = 0.003;
            double distance = Minecraft.getMinecraft().thePlayer.getDistance((double) x, (double) y, (double) z);
            GlStateManager.pushMatrix();
            GlStateManager.translate(x - renderManager.viewerPosX, y - renderManager.viewerPosY + entity.height - 1.5D, z - renderManager.viewerPosZ);
            GlStateManager.rotate(-viewerYaw, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(viewerPitch, 1.0F, 0.0F, 0.0F);
            GlStateManager.scale(distance * distanceScale, distance * distanceScale, distance * distanceScale);
            GlStateManager.disableLighting();
            GlStateManager.depthMask(false);
            GlStateManager.disableDepth();
            GlStateManager.enableBlend();
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldRenderer = tessellator.getWorldRenderer();
            float textWidth = fontRenderer.getStringWidth(name);
            GlStateManager.disableTexture2D();
            worldRenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
            worldRenderer.pos(-textWidth / 2 - 1, -1, 0.0D).color(0.0F, 0.0F, 0.0F, 0.8F).endVertex();
            worldRenderer.pos(-textWidth / 2 - 1, 8, 0.0D).color(0.0F, 0.0F, 0.0F, 0.8F).endVertex();
            worldRenderer.pos(textWidth / 2 + 1, 8, 0.0D).color(0.0F, 0.0F, 0.0F, 0.8F).endVertex();
            worldRenderer.pos(textWidth / 2 + 1, -1, 0.0D).color(0.0F, 0.0F, 0.0F, 0.8F).endVertex();
            tessellator.draw();
            GlStateManager.enableTexture2D();
            fontRenderer.drawString(name, (int) (-textWidth / 2), 0, 0xFFFFFF);
            GlStateManager.enableDepth();
            GlStateManager.depthMask(true);
            fontRenderer.drawString(name, (int) (-textWidth / 2), -0, 0xFFFFFF);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }
}
