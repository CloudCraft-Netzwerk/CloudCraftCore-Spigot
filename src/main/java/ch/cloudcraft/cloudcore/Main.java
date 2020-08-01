package ch.cloudcraft.cloudcore;

import ch.cloudcraft.cloudcore.Essentials.FlyExecutor;
import ch.cloudcraft.cloudcore.Essentials.GamemodeExecutor;
import ch.cloudcraft.cloudcore.Essentials.KickAllExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    // Plugin default shit
    static Plugin plugin;


    // Default onEnable
    @Override
    public void onEnable() {
        this.plugin = this;

        // Gamemode
        String[] str = {"gamemode", "gm0", "gm1", "gm2", "gm3"};
        for (String cmd : str) {
            getCommand(cmd).setExecutor(new GamemodeExecutor());
        }
        getCommand("fly").setExecutor(new FlyExecutor());
        getCommand("kickall").setExecutor(new KickAllExecutor());


        System.out.println("Plugin enabled");
    }

    //Default onDisable
    @Override
    public void onDisable() {
        System.out.println("Plugin disabled");
    }

    //Default getPlugin()
    public Plugin getPlugin() { return plugin; }
}
