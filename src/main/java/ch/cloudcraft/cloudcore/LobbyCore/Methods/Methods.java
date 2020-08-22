package ch.cloudcraft.cloudcore.LobbyCore.Methods;

import org.bukkit.entity.Player;

public class Methods {


    public static void sendMessage(Player p, String message) {
        p.sendMessage(getPrefix() + message);
    }

    public static String getPrefix() {
        return "§9§l[§b§lCloudCraft§9§l]§r§b ";

    }

}
