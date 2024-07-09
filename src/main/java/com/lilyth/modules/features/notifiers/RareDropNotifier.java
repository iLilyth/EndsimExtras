package com.lilyth.modules.features.notifiers;

import com.lilyth.EndsimExtras;
import com.lilyth.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RareDropNotifier {
    private final Config config = EndsimExtras.config;
    public String[] target2 = {"Shadow Assassin", "Dragon Wing", "Necron's", "Giant's Sword", "Terminator"};
    public String[] target3 = {"Infernal Crimson", "Warden Helmet", "Hyperion", "Scylla", "Book of Seidr", "Divine Helmet", "Dichroic Glass"};
    public String[] target4 = {"Divine Alloy", "Sorrow", "Divine Handle", "Golden String", "Celestium", "Strong Dragon Eye", "Wise Dragon Eye"};
    public int[] playSoundPitch = {1, 2, 3, 5, 8, 13};
    public boolean dragonDownlol1;
    public boolean dragonDownlol2;
    public boolean dragonDownlol3;
    public boolean dragonDownlol4;
    @SubscribeEvent
    public void rareDropNotifier2(RenderLivingEvent.Specials.Pre<EntityLivingBase> e) {
        if(!config.RARE_DROPS) return;
        Minecraft mc = Minecraft.getMinecraft();
        Entity entity = e.entity;
        if(dragonDownlol2 && entity.hasCustomName() && entity.getName().contains("§k")){
            for (int i = 0; i < target2.length; i++) {
                if (entity.getName().contains(target2[i])) {
                    mc.ingameGUI.displayTitle(entity.getName(), "", 0, 100, 0);
                    for (int soundPitch : playSoundPitch) {
                        mc.thePlayer.playSound("random.orb", 1, soundPitch);
                    }
                    dragonDownlol2 = false;
                }
            }
        }
    }
    @SubscribeEvent
    public void rareDropNotifier3(RenderLivingEvent.Specials.Pre<EntityLivingBase> e) {
        if(!config.RARE_DROPS) return;
        Minecraft mc = Minecraft.getMinecraft();
        Entity entity = e.entity;
        if(dragonDownlol2 && entity.hasCustomName() && entity.getName().contains("§k")){
            for (int i = 0; i < target3.length; i++) {
                if (entity.getName().contains(target3[i])) {
                    mc.ingameGUI.displayTitle(entity.getName(), "", 0, 100, 0);
                    for (int soundPitch : playSoundPitch) {
                        mc.thePlayer.playSound("random.orb", 1, soundPitch);
                    }
                    dragonDownlol2 = false;
                }
            }
        }
    }
    @SubscribeEvent
    public void rareDropNotifier4(RenderLivingEvent.Specials.Pre<EntityLivingBase> e) {
        if(!config.RARE_DROPS) return;
        Minecraft mc = Minecraft.getMinecraft();
        Entity entity = e.entity;
        if(dragonDownlol2 && entity.hasCustomName() && entity.getName().contains("§k")){
            for (int i = 0; i < target4.length; i++) {
                if (entity.getName().contains(target4[i])) {
                    mc.ingameGUI.displayTitle(entity.getName(), "", 0, 100, 0);
                    for (int soundPitch : playSoundPitch) {
                        mc.thePlayer.playSound("random.orb", 1, soundPitch);
                    }
                    dragonDownlol2 = false;
                }
            }
        }
    }
    @SubscribeEvent
    public void dragonDown(ClientChatReceivedEvent event) {
        if(!config.RARE_DROPS) return;
        String msg = event.message.getUnformattedText();
        if(msg.startsWith("Dragon down!")){
            dragonDownlol2 = true;
            dragonDownlol3 = true;
            dragonDownlol4 = true;
        }
    }
    @SubscribeEvent
    public void dragonEggSpawn(ClientChatReceivedEvent event) {
        if(!config.RARE_DROPS) return;
        String msg = event.message.getUnformattedText();
        if(msg.startsWith("* The Dragon Egg has spawned!")){
            dragonDownlol2 = false;
            dragonDownlol3 = false;
            dragonDownlol4 = false;
        }
    }
}
