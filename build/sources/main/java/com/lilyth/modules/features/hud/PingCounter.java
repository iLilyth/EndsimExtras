package com.lilyth.modules;

import com.lilyth.EndsimExtras;
import com.lilyth.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class PingCounter {
    public final Config config = EndsimExtras.config;
    private static Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void pingCounterGUI(TickEvent.RenderTickEvent event) {

        if (mc.thePlayer == null || mc.theWorld == null || !config.PING_COUNTER) return;
        if (!mc.isSingleplayer()) {
            mc.fontRendererObj.drawStringWithShadow("Ping: " + mc.getCurrentServerData().pingToServer, ((float) mc.displayWidth / 200) * config.PING_COUNTER_X, ((float) mc.displayHeight / 200) * config.PING_COUNTER_Y, 0xFFFFFF);
        }
    }
}