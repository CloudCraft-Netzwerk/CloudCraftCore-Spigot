package ch.cloudcraft.cloudcore.LobbyCore.Methods;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Validator {

    public static boolean isOnlinePlayer(String Username) {
        try {
            return Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(Username));

        } catch (Exception e) {
            return false;
        }

    }

    public static Player getPlayer(String Username) {
        return Bukkit.getPlayer(Username);
    }
}

