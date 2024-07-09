package com.lilyth.modules;

import com.lilyth.EndsimExtras;
import com.lilyth.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class FPScounter {
    public static Config config = EndsimExtras.config;
    private static Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void fpsCounterGUI(TickEvent.RenderTickEvent event) {
        if (mc.thePlayer == null || mc.theWorld == null || !config.FPS_COUNTER ) return;
        mc.fontRendererObj.drawStringWithShadow("FPS: " + Minecraft.getDebugFPS(), ((float) mc.displayWidth / 200) * config.FPS_COUNTER_X, ((float) mc.displayHeight / 200) * config.FPS_COUNTER_Y, 0xFFFFFF);
    }
}