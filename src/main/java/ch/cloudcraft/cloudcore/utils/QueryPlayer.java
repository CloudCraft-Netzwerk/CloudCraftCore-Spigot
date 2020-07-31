package ch.cloudcraft.cloudcore.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class QueryPlayer {
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
