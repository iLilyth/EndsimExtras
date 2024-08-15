package com.lilyth.modules.mixins;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.util.ChatComponentText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMerchant.class)
public class MixinExample {

    @Inject(method = "initGui", at = @At("HEAD"))
    public void onStartGame(CallbackInfo ci) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Opened Inv"));
    }
}