package be.renaud11232.slappy;

import be.renaud11232.awesomecommand.AwesomePlugin;
import be.renaud11232.slappy.commands.PunchCommand;
import be.renaud11232.slappy.commands.SlapCommand;

public class SlappyPlugin extends AwesomePlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        initCommand(SlapCommand.class);
        initCommand(PunchCommand.class);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
