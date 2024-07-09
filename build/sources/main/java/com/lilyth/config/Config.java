package com.lilyth.config;

import gg.essential.universal.UChat;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.awt.*;
import java.io.File;

public class Config extends Vigilant {

    @Property(
            type = PropertyType.CHECKBOX,
            name = "FPS counter",
            description = "",
            category = "!Visual",
            subcategory = "FPS counter"
    )
    public boolean FPS_COUNTER = true;
    @Property(
            type = PropertyType.SLIDER,
            name = "FPS counter X",
            description = "",
            category = "!Visual",
            subcategory = "FPS counter",
            min = 0,
            max = 100
    )
    public int FPS_COUNTER_X = 1;

   /* @Property(
            type = PropertyType.CHECKBOX,
            name = "Damage Formatting",
            description = "",
            category = "!Visual",
            subcategory = "Checkboxes"
    )
    public boolean DMG_FORMATTING = true; */

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Rare Drop Notifier",
            description = "",
            category = "!Features",
            subcategory = "Rare Drops"
    )
    public boolean RARE_DROPS = true;

    @Property(
            type = PropertyType.SLIDER,
            name = "FPS counter Y",
            description = "",
            category = "!Visual",
            subcategory = "FPS counter",
            min = 0,
            max = 100
    )
    public int FPS_COUNTER_Y = 3;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Ping counter",
            description = "",
            category = "!Visual",
            subcategory = "Ping counter"
    )
    public boolean PING_COUNTER = true;
    @Property(
            type = PropertyType.SLIDER,
            name = "Ping counter X",
            description = "",
            category = "!Visual",
            subcategory = "Ping counter",
            min = 0,
            max = 100
    )
    public int PING_COUNTER_X = 1;


    @Property(
            type = PropertyType.SLIDER,
            name = "Ping counter Y",
            description = "",
            category = "!Visual",
            subcategory = "Ping counter",
            min = 0,
            max = 100
    )
    public int PING_COUNTER_Y = 5;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Eye Display",
            description = "",
            category = "!Visual",
            subcategory = "Eye display"
    )
    public boolean EYE_DISPLAY = true;
    @Property(
            type = PropertyType.SLIDER,
            name = "Eye display X",
            description = "",
            category = "!Visual",
            subcategory = "Eye display",
            min = 0,
            max = 100
    )
    public int EYE_DISPLAY_X = 1;


    @Property(
            type = PropertyType.SLIDER,
            name = "Eye Display Y",
            description = "",
            category = "!Visual",
            subcategory = "Eye display",
            min = 0,
            max = 100
    )
    public int EYE_DISPLAY_Y = 5;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Disable Enderman Teleport",
            description = "",
            category = "!Visual",
            subcategory = "misc"
    )
    public boolean DISABLE_ENDERMAN_TP = true;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Copy Chat",
            description = "Click a message to send it ingame!",
            category = "!Features",
            subcategory = "Copy chat"
    )
    public boolean COPY_CHAT = true;

    /*@Property(
            type = PropertyType.CHECKBOX,
            name = "Inventory Full Notifier",
            description = "Notifies you when your inventory is full",
            category = "!Features",
            subcategory = "Notifiers"
    )
    public boolean INV_FULL_NOTIFIER = true;*/

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Dragon Notifier",
            description = "Notifies on rare dragon spawn",
            category = "!Features",
            subcategory = "Notifiers"
    )
    public boolean DRAGON_NOTIFIER = true;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Dragon Egg spawn notifier",
            description = "",
            category = "!Features",
            subcategory = "Notifiers"
    )
    public boolean DRAGON_SPAWN = true;
    @Property(
            type = PropertyType.CHECKBOX,
            name = "Automatically copy rare drops",
            description = "",
            category = "!Features",
            subcategory = "Copy chat"
    )
    public boolean AUTO_COPY_CHAT = true;

    @Property(
            type = PropertyType.SLIDER,
            name = "Auto copy rare drop filter",
            description = "0 = filter none, 1 = filter RARE DROP! (+ yolks), 2 = filter CRAZY RARE DROP!, 4 = filter RNGesus INCARNATE! + INSANE DROP!",
            category = "!Features",
            subcategory = "Copy chat",
            min = 0,
            max = 4
    )
    public int AUTO_COPY_CHAT_FILTER = 1;

    /*@Property(
            type = PropertyType.CHECKBOX,
            name = "Fullbright",
            description = "",
            category = "!Visual",
            subcategory = "misc"
    )
    public boolean FULLBRIGHT = true;*/

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Enderman Waypoints",
            description = "",
            category = "!Visual",
            subcategory = "Enderman Waypoints"
    )
    public boolean ENDERMAN_WAYPOINTS = true;


    @Property(
            type = PropertyType.CHECKBOX,
            name = "Togglesprint",
            description = "(you have to press sprint keybind for it to toggle)",
            category = "!Features",
            subcategory = "Togglesprint"
    )
    public boolean AUTOSPRINT = true;
    @Property(
            type = PropertyType.SLIDER,
            name = "Togglesprint X",
            description = "",
            category = "!Features",
            subcategory = "Togglesprint",
            min = 0,
            max = 100
    )
    public int AUTOSPRINT_X = 1;


    @Property(
            type = PropertyType.SLIDER,
            name = "Togglesprint Y",
            description = "",
            category = "!Features",
            subcategory = "Togglesprint",
            min = 0,
            max = 100
    )
    public int AUTOSPRINT_Y = 5;

    @Property(
            type = PropertyType.CHECKBOX,
            name = "Dragon Spawn Timer",
            description = "",
            category = "!Features",
            subcategory = "Dragon Spawn Timer"
    )
    public boolean DRAGON_TIMER = true;
    @Property(
            type = PropertyType.SLIDER,
            name = "Dragon Spawn Timer X",
            description = "",
            category = "!Features",
            subcategory = "Dragon Spawn Timer",
            min = 0,
            max = 100
    )
    public int DRAGON_TIMER_X = 1;


    @Property(
            type = PropertyType.SLIDER,
            name = "Dragon Spawn Timer Y",
            description = "",
            category = "!Features",
            subcategory = "Dragon Spawn Timer",
            min = 0,
            max = 100
    )
    public int DRAGON_TIMER_Y = 5;


    public Config() {
        super(new File("./config/EndsimExtras/EndsimExtrasconfig.toml"));
        initialize();
    }
}
