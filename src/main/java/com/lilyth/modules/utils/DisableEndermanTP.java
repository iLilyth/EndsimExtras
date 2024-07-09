package com.lilyth.modules.utils;

import com.lilyth.EndsimExtras;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DisableEndermanTP {
    @SubscribeEvent
    public void aaa(EnderTeleportEvent e){
        if(EndsimExtras.config.DISABLE_ENDERMAN_TP) e.setCanceled(true);
    }
}
