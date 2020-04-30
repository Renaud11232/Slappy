package be.renaud11232.slappy;

import org.bukkit.plugin.java.JavaPlugin;

public class SlappyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        getCommand("slap").setExecutor(new SlapCommandExecutor());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
