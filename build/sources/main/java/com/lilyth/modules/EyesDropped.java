package com.lilyth.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lilyth.EndsimExtras;
import com.lilyth.config.Config;
import com.lilyth.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public class EyesDropped {
    private final Config config = EndsimExtras.config;
    public int placed1, placed2, candy, summoning, ice, cosmic, radioactive, flaming, ameliorate, divine, shell, yolk, tear;
    public EyesDropped() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileReader reader = new FileReader("./config/EndsimExtras/dropstorage.json")) {
            Type mapType = new TypeToken<LinkedHashMap<String, Integer>>() {
            }.getType();
            LinkedHashMap<String, Integer> map = gson.fromJson(reader, mapType);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().equals("placed1")) placed1 = entry.getValue();
                if (entry.getKey().equals("placed2")) placed2 = entry.getValue();
                if (entry.getKey().equals("candy")) candy = entry.getValue();
                if (entry.getKey().equals("summoning")) summoning = entry.getValue();
                if (entry.getKey().equals("ice")) ice = entry.getValue();
                if (entry.getKey().equals("cosmic")) cosmic = entry.getValue();
                if (entry.getKey().equals("radioactive")) radioactive = entry.getValue();
                if (entry.getKey().equals("flaming")) flaming = entry.getValue();
                if (entry.getKey().equals("ameliorate")) ameliorate = entry.getValue();
                if (entry.getKey().equals("divine")) divine = entry.getValue();
                if (entry.getKey().equals("shell")) shell = entry.getValue();
                if (entry.getKey().equals("yolk")) yolk = entry.getValue();
                if (entry.getKey().equals("tear")) tear = entry.getValue();
            }
            try (FileWriter writer = new FileWriter("./config/EndsimExtras/dropstorage.json")) {
                gson.toJson(map, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SubscribeEvent
    public void addEye(ClientChatReceivedEvent e) {
        if(!Utils.isOnEndsim())  return;
        String text = e.message.getUnformattedText();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        if (text.contains("* You placed a Summoning Eye")) placed1++;
        if (text.contains("* You placed a Divine Eye")) placed2++;
        if (text.contains("RARE DROP! Summoning Eye")) summoning++;
        if (text.contains("RARE DROP! Ice Eye")) ice++;
        if (text.contains("RARE DROP! Cosmic Eye")) cosmic++;
        if (text.contains("CRAZY RARE DROP! Radioactive Eye")) radioactive++;
        if (text.contains("RNGesus INCARNATE! Flaming Eye")) flaming++;
        if (text.contains("RNGesus INCARNATE! Divine Eye")) divine++;
        if (text.contains("RNGesus INCARNATE! Protector Yolk")) yolk++;
        if (text.contains("RARE DROP! Shell Fragment")) shell++;
        if (text.contains("RARE DROP! Zealot Candy")) candy++;


        try (FileReader reader = new FileReader("./config/EndsimExtras/dropstorage.json")) {
            Type mapType = new TypeToken<LinkedHashMap<String, Integer>>() {
            }.getType();
            LinkedHashMap<String, Integer> map = gson.fromJson(reader, mapType);
            int counter = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().equals("placed1")) entry.setValue(placed1);
                if (entry.getKey().equals("placed2")) entry.setValue(placed2);
                if (entry.getKey().equals("candy")) entry.setValue(candy);
                if (entry.getKey().equals("summoning")) entry.setValue(summoning);
                if (entry.getKey().equals("ice")) entry.setValue(ice);
                if (entry.getKey().equals("cosmic")) entry.setValue(cosmic);
                if (entry.getKey().equals("radioactive")) entry.setValue(radioactive);
                if (entry.getKey().equals("flaming")) entry.setValue(flaming);
                if (entry.getKey().equals("ameliorate")) entry.setValue(ameliorate);
                if (entry.getKey().equals("divine")) entry.setValue(divine);
                if (entry.getKey().equals("shell")) entry.setValue(shell);
                if (entry.getKey().equals("yolk")) entry.setValue(yolk);
                if (entry.getKey().equals("tear")) entry.setValue(tear);
            }
            try (FileWriter writer = new FileWriter("./config/EndsimExtras/dropstorage.json")) {
                gson.toJson(map, writer);
            }
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }

    @SubscribeEvent
    public void eyeDropGui(TickEvent.RenderTickEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.thePlayer == null || mc.theWorld == null || !config.EYE_DISPLAY) return;
        mc.fontRendererObj.drawStringWithShadow("Eyes placed: " + placed1, ((float) mc.displayWidth / 200) * config.EYE_DISPLAY_X, ((float) mc.displayHeight / 200) * config.EYE_DISPLAY_Y - 30, 0xAA00AA);
        mc.fontRendererObj.drawStringWithShadow("Divine Eyes placed: " + placed2, ((float) mc.displayWidth / 200) * config.EYE_DISPLAY_X, ((float) mc.displayHeight / 200) * config.EYE_DISPLAY_Y - 20, 0x55FFFF);
        mc.fontRendererObj.drawStringWithShadow("Summoning Eyes: " + summoning, ((float) mc.displayWidth / 200) * config.EYE_DISPLAY_X, ((float) mc.displayHeight / 200) * config.EYE_DISPLAY_Y, 0xAA00AA);
        mc.fontRendererObj.drawStringWithShadow("Ice Eyes: " + ice, (((float) mc.displayWidth / 200) * config.EYE_DISPLAY_X), (((float) mc.displayHeight / 200) * config.EYE_DISPLAY_Y) + 10, 0x00AAAA);
        mc.fontRendererObj.drawStringWithShadow("Cosmic Eyes: " + cosmic, (((float) mc.displayWidth / 200) * config.EYE_DISPLAY_X), (((float) mc.displayHeight / 200) * config.EYE_DISPLAY_Y) + 20, 0xFF55FF);
        mc.fontRendererObj.drawStringWithShadow("Radioactive Eyes: " + radioactive, (((float) mc.displayWidth / 200) * config.EYE_DISPLAY_X), (((float) mc.displayHeight / 200) * config.EYE_DISPLAY_Y) + 30, 0x55FF55);
        mc.fontRendererObj.drawStringWithShadow("Flaming Eyes: " + flaming, (((float) mc.displayWidth / 200) * config.EYE_DISPLAY_X), (((float) mc.displayHeight / 200) * config.EYE_DISPLAY_Y) + 40, 0xFF5555);
        mc.fontRendererObj.drawStringWithShadow("Divine Eyes: " + divine, (((float) mc.displayWidth / 200) * config.EYE_DISPLAY_X), (((float) mc.displayHeight / 200) * config.EYE_DISPLAY_Y) + 50, 0x55FFFF);
        mc.fontRendererObj.drawStringWithShadow("Shell Fragments: " + ameliorate, (((float) mc.displayWidth / 200) * config.EYE_DISPLAY_X), (((float) mc.displayHeight / 200) * config.EYE_DISPLAY_Y) + 60, 0xFFAA00);
        mc.fontRendererObj.drawStringWithShadow("Protector Yolks: " + ameliorate, (((float) mc.displayWidth / 200) * config.EYE_DISPLAY_X), (((float) mc.displayHeight / 200) * config.EYE_DISPLAY_Y) + 70, 0xFFFF55);
        mc.fontRendererObj.drawStringWithShadow("Zealot Tears: " + ameliorate, (((float) mc.displayWidth / 200) * config.EYE_DISPLAY_X), (((float) mc.displayHeight / 200) * config.EYE_DISPLAY_Y) + 80, 0x5555FF);
        mc.fontRendererObj.drawStringWithShadow("Zealot Candy: " + ameliorate, (((float) mc.displayWidth / 200) * config.EYE_DISPLAY_X), (((float) mc.displayHeight / 200) * config.EYE_DISPLAY_Y) + 90, 0xFFFFFF);
    }
}