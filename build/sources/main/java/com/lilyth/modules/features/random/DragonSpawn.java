package com.lilyth.modules;

import com.lilyth.EndsimExtras;
import com.lilyth.config.Config;
import com.lilyth.utils.Utils;
import gg.essential.universal.ChatColor;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class DragonSpawn {

    public final Config config = EndsimExtras.config;
    public int respawnTimer;
    private Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void dragonSpawn(ClientChatReceivedEvent e) {
        if (!config.DRAGON_SPAWN || !Utils.isOnEndsim()) return;
        String msg = e.message.getUnformattedText();
        if (msg.startsWith("* The Dragon Egg has spawned!")) {
            Utils.showTitle(ChatColor.WHITE, "DRAGON EGG SPAWNED!", 20);
        }
        if (msg.startsWith("Dragon down!")) {
            respawnTimer = 300;
        }
    }

    @SubscribeEvent
    public void dragonSpawnGUI(TickEvent.RenderTickEvent event) {
        if (mc.thePlayer == null || mc.theWorld == null || !config.DRAGON_TIMER || !Utils.isOnEndsim()) return;
        mc.fontRendererObj.drawStringWithShadow("Dragon spawn in: " + (float) (respawnTimer / 20) + "s", ((float) mc.displayWidth / 200) * config.DRAGON_TIMER_X, ((float) mc.displayHeight / 200) * config.DRAGON_TIMER_Y, 0xFFFFFF);
    }

    @SubscribeEvent
    public void dragonSpawnCountdown(TickEvent.ClientTickEvent event) {
        if (respawnTimer > 0) {
            respawnTimer = respawnTimer - 1;
        }
    }
}
