package com.lilyth.modules;

import com.lilyth.EndsimExtras;
import com.lilyth.config.Config;
import com.lilyth.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class AutoCopyChat {
    private final Config config = EndsimExtras.config;
    int[] playSoundPitch = {1, 2, 3, 5, 8, 13};
    Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void autoCopyChat2(ClientChatReceivedEvent e) {
        if (!config.AUTO_COPY_CHAT || mc.thePlayer == null || mc.theWorld == null || !Utils.isOnEndsim()) return;
        String msg = e.message.getUnformattedText();
        if (msg.contains(":")) return;
        if ((msg.startsWith("RARE DROP!") || msg.startsWith("RNGesus INCARNATE! Protector Yolk")) && config.AUTO_COPY_CHAT_FILTER < 1) {
            mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
            for (int soundPitch : playSoundPitch) mc.thePlayer.playSound("random.orb", 1, soundPitch);
            copyChat(msg);
        }
        if (msg.startsWith("CRAZY RARE DROP!") && config.AUTO_COPY_CHAT_FILTER < 2) {
            for (int soundPitch : playSoundPitch) mc.thePlayer.playSound("random.orb", 1, soundPitch);
            copyChat(msg);
        }
        if (msg.startsWith("INSANE DROP!") && config.AUTO_COPY_CHAT_FILTER < 3) {
            for (int soundPitch : playSoundPitch) mc.thePlayer.playSound("random.orb", 1, soundPitch);
            copyChat(msg);
        }
        if (msg.startsWith("RNGesus INCARNATE!") && config.AUTO_COPY_CHAT_FILTER < 4 && !msg.contains("Protector Yolk")) {

            for (int soundPitch : playSoundPitch) mc.thePlayer.playSound("random.orb", 1, soundPitch);
            copyChat(msg);
        }
    }

    public void copyChat(String msg) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(msg), null);
    }
}
