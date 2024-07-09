package com.lilyth.modules;

import com.lilyth.EndsimExtras;
import com.lilyth.utils.Utils;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DisableEndermanTP {
    @SubscribeEvent
    public void aaa(EnderTeleportEvent e) {
        if (EndsimExtras.config.DISABLE_ENDERMAN_TP || !Utils.isOnEndsim()) e.setCanceled(true);
    }
}
