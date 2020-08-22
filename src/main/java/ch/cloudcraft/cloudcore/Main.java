package ch.cloudcraft.cloudcore;

import ch.cloudcraft.cloudcore.Essentials.FlyExecutor;
import ch.cloudcraft.cloudcore.Essentials.GamemodeExecutor;
import ch.cloudcraft.cloudcore.Essentials.KickAllExecutor;
import ch.cloudcraft.cloudcore.LobbyCore.GUIManager.ClickListener;
import ch.cloudcraft.cloudcore.LobbyCore.Listeners.*;
import ch.cloudcraft.cloudcore.utils.ApplicationLoader;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    // Plugin default shit
    static Plugin plugin;
    private static ApplicationLoader.Application application;

    //Default getPlugin()
    public static Plugin getPlugin() {
        return plugin;
    }

    //Default onDisable
    @Override
    public void onDisable() {
        System.out.println("Plugin disabled");
    }

    // Default onEnable
    @Override
    public void onEnable() {
        this.plugin = this;


        // Essentials-specific //
        // Gamemode
        String[] str = {"gamemode", "gm0", "gm1", "gm2", "gm3"};
        for (String cmd : str) {
            getCommand(cmd).setExecutor(new GamemodeExecutor());
        }
        getCommand("fly").setExecutor(new FlyExecutor());
        getCommand("kickall").setExecutor(new KickAllExecutor());

        System.out.println("Plugin enabled");

        // Depending on Application use //
        getPlugin().saveConfig();
        getPlugin().reloadConfig();
        getServer().getPluginManager().registerEvents(new PreProcess(), this);
        getServer().getPluginManager().registerEvents(new ClickListener(), this);
        getServer().getPluginManager().registerEvents(new Join(), this);
        getCommand("lobby").setExecutor(new Command());
        getCommand("build").setExecutor(new BuildCommand());
        Bukkit.broadcastMessage("LobbyPRE " + System.currentTimeMillis());
        getServer().getPluginManager().registerEvents(new ClickListener(), this);
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        System.out.println("Plugin enabled, loading configs");
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new BuildPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new onItemHotbar(), this);
        // ApplicationLoader.resolve();


    }

    public enum Prefix {
        ESSENTIALS,
        LOBBY
    }


}
