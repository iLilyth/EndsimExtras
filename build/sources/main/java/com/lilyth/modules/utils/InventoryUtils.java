package com.lilyth.modules;

import com.lilyth.utils.Utils;
import gg.essential.universal.ChatColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FullInventoryWarning {
    private int cooldown;
    Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void inventoryNotifier(EntityItemPickupEvent e) {
        if (mc.thePlayer == null || mc.theWorld == null || e.entity != mc.thePlayer || !Utils.isOnEndsim()) return;
        if (!hasOpenInventorySlots()) {
            showFullInventoryWarning();
        }

    }

    public void showFullInventoryWarning() {
        Minecraft mc = Minecraft.getMinecraft();
        if (cooldown != 0) {
            cooldown = cooldown - 1;
        }
        if (cooldown == 0) {
            mc.thePlayer.playSound("random.orb", 0.5f, 1);
            mc.ingameGUI.displayTitle(ChatColor.RED + "INVENTORY FULL!", "", 0, 40, 0);
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
            if (itemStack == null) {
                emptySlots++;
            }
        }
        return emptySlots > 0;
    }
}