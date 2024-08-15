package com.lilyth.modules.utils;

import gg.essential.universal.ChatColor;
import net.minecraft.client.Minecraft;

public class Utils {
    public static boolean isOnEndsim() {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.isSingleplayer()) {
            return false;
        } else {
            return mc.getCurrentServerData().serverIP.contains("endsim.net") || mc.getCurrentServerData().serverIP.contains("dragsim.net");
        }
    }

    public static void showTitle(ChatColor chatColor, String text, Integer displayTime){
        Minecraft.getMinecraft().ingameGUI.displayTitle(chatColor + text, "", 0, displayTime, 0);
    }

}
