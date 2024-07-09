package com.lilyth.modules.utils;

import gg.essential.universal.ChatColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryUtils {
    private int cooldown;
    public void showFullInventoryWarning() {
        Minecraft mc = Minecraft.getMinecraft();
        if(hasOpenInventorySlots()) return;
        if(cooldown!=0){
            cooldown = cooldown - 1;
        }
        if(cooldown==0){
            mc.thePlayer.playSound("random.orb", 0.5f, 1);
            mc.ingameGUI.displayTitle(ChatColor.RED + "INVENTORY FULL!", "", 0, 65, 0);
            cooldown = 60;
        }
    }
    public static boolean hasOpenInventorySlots() {
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        IInventory inventory = player.inventory;
        int armorSlots = 5;
        int inventorySize = inventory.getSizeInventory();
        inventorySize = inventorySize - armorSlots;
        int emptySlots = 0;
        for (int i = 0; i < inventorySize; i++) {
            ItemStack itemStack = inventory.getStackInSlot(i);
            if (itemStack==null) {
                emptySlots++;
            }
        }
        return emptySlots > 0;
    }
}