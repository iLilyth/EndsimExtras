package com.lilyth.modules.features.copychat;

import com.lilyth.EndsimExtras;
import com.lilyth.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class AutoCopyChat {
    private final Config config = EndsimExtras.config;
    int[] playSoundPitch = {1, 2, 3, 5, 8, 13};

    @SubscribeEvent
    public void autoCopyChat(ClientChatReceivedEvent e) {
        if(!config.AUTO_COPY_CHAT) return;
        Minecraft mc = Minecraft.getMinecraft();
        String msg = e.message.getUnformattedText();
        StringSelection stringSelection = new StringSelection(msg);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        if(!msg.contains(":")){
            if(msg.contains("RARE DROP! Summoning Eye") && config.AUTO_COPY_CHAT_FILTER<1){
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int soundPitch : playSoundPitch) {
                    mc.thePlayer.playSound("random.orb", 1, soundPitch);
                }
            }else if(msg.contains("RARE DROP! Zealot Candy") && config.AUTO_COPY_CHAT_FILTER<1){
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int soundPitch : playSoundPitch) {
                    mc.thePlayer.playSound("random.orb", 1, soundPitch);
                }
            }else if(msg.contains("RARE DROP! Shell Fragment") && config.AUTO_COPY_CHAT_FILTER<1){
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int soundPitch : playSoundPitch) {
                    mc.thePlayer.playSound("random.orb", 1, soundPitch);
                }
            }else if(msg.contains("RNGesus INCARNATE! Protector Yolk") && config.AUTO_COPY_CHAT_FILTER<2){
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int soundPitch : playSoundPitch) {
                    mc.thePlayer.playSound("random.orb", 1, soundPitch);
                }
            }else if(msg.contains("RARE DROP! Ice Eye") && config.AUTO_COPY_CHAT_FILTER<2){
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int soundPitch : playSoundPitch) {
                    mc.thePlayer.playSound("random.orb", 1, soundPitch);
                }
            }else if(msg.contains("RARE DROP! Cosmic Eye") && config.AUTO_COPY_CHAT_FILTER<3){
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int soundPitch : playSoundPitch) {
                    mc.thePlayer.playSound("random.orb", 1, soundPitch);
                }
            }else if(msg.contains("CRAZY RARE DROP! Radioactive Eye") && config.AUTO_COPY_CHAT_FILTER<4){
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int soundPitch : playSoundPitch) {
                    mc.thePlayer.playSound("random.anvil_land", 1, soundPitch);
                }
            }else if(msg.contains("RNGesus INCARNATE! Flaming Eye") && config.AUTO_COPY_CHAT_FILTER<5){
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int soundPitch : playSoundPitch) {
                    mc.thePlayer.playSound("mob.enderdragon.growl", 1, soundPitch);
                }
            }else if(msg.contains("RNGesus INCARNATE! Divine Eye") && config.AUTO_COPY_CHAT_FILTER<6){
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int soundPitch : playSoundPitch) {
                    mc.thePlayer.playSound("mob.enderdragon.growl", 1, soundPitch);
                }
            }else if(msg.contains("INSANE DROP! Divine Ameliorate") && config.AUTO_COPY_CHAT_FILTER<6){
                clipboard.setContents(stringSelection, null);
                mc.thePlayer.addChatMessage(new ChatComponentText("Drop copied to clipboard!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
                for (int soundPitch : playSoundPitch) {
                    mc.thePlayer.playSound("mob.enderdragon.growl", 1, soundPitch);
                }
            }
        }
    }
}
