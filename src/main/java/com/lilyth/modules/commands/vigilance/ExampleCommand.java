package com.lilyth.modules.commands.vigilance;

import com.lilyth.EndsimExtras;
import com.lilyth.config.Config;
import gg.essential.api.EssentialAPI;
import gg.essential.api.commands.Command;
import gg.essential.api.commands.DefaultHandler;

public class ExampleCommand extends Command {
    private final Config config = EndsimExtras.config;
    public ExampleCommand(String name) {
        super(name);
    }
    @DefaultHandler
    public void handle() {
        EssentialAPI.getGuiUtil().openScreen(config.gui());
    }
}