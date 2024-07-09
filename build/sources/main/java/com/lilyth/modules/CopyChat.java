package com.lilyth.modules;

import com.lilyth.EndsimExtras;
import com.lilyth.config.Config;
import com.lilyth.utils.Utils;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CopyChat {
    public final Config config = EndsimExtras.config;

    @SubscribeEvent
    public void copyChat(ClientChatReceivedEvent e) {
        if (!config.COPY_CHAT || !Utils.isOnEndsim()) return;
        ChatComponentText text = new ChatComponentText(e.message.getUnformattedText());
        if (e.message.getChatStyle().getChatClickEvent() != null) return;
        text.setChatStyle(e.message.getChatStyle());
        text.getChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, e.message.getUnformattedText()));
    }
}