package com.lilyth.modules;

import com.lilyth.EndsimExtras;
import com.lilyth.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ToggleSprint {
    private final Config config = EndsimExtras.config;
    private static Minecraft mc = Minecraft.getMinecraft();
    private boolean isToggled = false;
    public int cooldown;
    public KeyBinding toggleKey = Minecraft.getMinecraft().gameSettings.keyBindSprint;

    @SubscribeEvent
    public void autoSprint(TickEvent.ClientTickEvent event) {
        if (mc.thePlayer == null || mc.theWorld == null || !config.AUTOSPRINT ) return;
        if (cooldown != 0) {
            cooldown = cooldown - 1;
        }
        if (cooldown == 0) {
            if (toggleKey.isKeyDown()) {
                isToggled = !isToggled;
                cooldown = 20;
            }
        }
        if (isToggled && mc.thePlayer.moveForward > 0) {
            if (!mc.thePlayer.isSneaking()) {
                mc.thePlayer.setSprinting(true);
            }
        }
    }

    @SubscribeEvent
    public void autoSprintGUI(TickEvent.RenderTickEvent event) {
        if (mc.thePlayer == null || mc.theWorld == null || !isToggled) return;
        mc.fontRendererObj.drawStringWithShadow("Autosprint: enabled", ((float) mc.displayWidth / 200) * config.AUTOSPRINT_X, ((float) mc.displayHeight / 200) * config.AUTOSPRINT_Y, 0xFFFFFF);
    }
}
