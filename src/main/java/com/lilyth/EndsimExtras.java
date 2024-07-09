package com.lilyth;

import com.lilyth.modules.commands.vigilance.ExampleCommand;
import com.lilyth.config.Config;
import com.lilyth.modules.features.copychat.AutoCopyChat;
import com.lilyth.modules.features.hud.ToggleSprint;
import com.lilyth.modules.features.notifiers.RareDropNotifier;
import com.lilyth.modules.features.random.DragonSpawn;
import com.lilyth.modules.features.utils.DamageFormatting;
import com.lilyth.modules.features.utils.EndermanWaypoints;
import com.lilyth.modules.features.copychat.CopyChat;
import com.lilyth.modules.features.hud.FPScounter;
import com.lilyth.modules.features.hud.PingCounter;
import com.lilyth.modules.features.notifiers.DivineSuperior;
import com.lilyth.modules.trackers.EyesDropped;
import com.lilyth.modules.trackers.FirstLoad;
import com.lilyth.modules.utils.DisableEndermanTP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;

@Mod(
        modid = EndsimExtras.MODID,
        name = EndsimExtras.MOD_NAME,
        version = EndsimExtras.VERSION,
        clientSideOnly = true,
        acceptedMinecraftVersions = EndsimExtras.MC_VERSION
)
public class EndsimExtras {
    public static final String MODID = "endsimextras";
    public static final String MOD_NAME = "Endsim-Extras";
    public static final String VERSION = "1.0";
    public static final String MC_VERSION = "1.8.9";
    public static EndsimExtras instance;

    public static Config config;

    /////
    public EndsimExtras() {
        instance=this;
        config = new Config();
    }

    /////

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        config.preload();
        new ExampleCommand("endsim").register();
        MinecraftForge.EVENT_BUS.register(new FirstLoad());
        MinecraftForge.EVENT_BUS.register(new AutoCopyChat());
        MinecraftForge.EVENT_BUS.register(new CopyChat());
        MinecraftForge.EVENT_BUS.register(new FPScounter());
        MinecraftForge.EVENT_BUS.register(new PingCounter());
        MinecraftForge.EVENT_BUS.register(new ToggleSprint());
        MinecraftForge.EVENT_BUS.register(new DivineSuperior());
        MinecraftForge.EVENT_BUS.register(new RareDropNotifier());
        MinecraftForge.EVENT_BUS.register(new DragonSpawn());
        MinecraftForge.EVENT_BUS.register(new DamageFormatting());
        MinecraftForge.EVENT_BUS.register(new EndermanWaypoints());
        MinecraftForge.EVENT_BUS.register(new EyesDropped());
        MinecraftForge.EVENT_BUS.register(new DisableEndermanTP());
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
    }
    /////

    public static EndsimExtras getInstance() {
        return instance;
    }
}
