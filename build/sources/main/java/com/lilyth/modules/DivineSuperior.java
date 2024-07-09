package com.lilyth.modules;

import com.lilyth.EndsimExtras;
import com.lilyth.config.Config;
import com.lilyth.utils.Utils;
import gg.essential.universal.ChatColor;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DivineSuperior {
    public final Config config = EndsimExtras.config;

    @SubscribeEvent
    public void divineSuperior(ClientChatReceivedEvent event) {
        if (!config.DRAGON_NOTIFIER || !Utils.isOnEndsim()) return;
        if (event.message.getUnformattedText().startsWith("* The SUPERIOR Dragon has spawned!")) {
            Utils.showTitle(ChatColor.GOLD, "SUPERIOR!", 40);
        }
        if (event.message.getUnformattedText().contains("* The DIVINE Dragon has spawned!")) {
            Utils.showTitle(ChatColor.AQUA, "DIVINE!", 60);
        }
    }
}