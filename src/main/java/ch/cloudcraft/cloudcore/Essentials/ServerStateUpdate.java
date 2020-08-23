package ch.cloudcraft.cloudcore.Essentials;

import ch.cloudcraft.cloudcore.LobbyCore.Methods.Methods;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ServerStateUpdate {
    public static String Eprx = Methods.getPrefix();

    public static void kickAll(String reason, Player WhoWasIt, boolean Console) {
        if (Console) {
            String Preparement = "§cAlle Spieler wurden aus dem Server geworfen!\n§eGrund: §7" + reason + "\n§eVon: §7Konsole";
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (p.hasPermission("cloudcraft.essentials.kickall.avoid")) {
                    p.sendMessage(Eprx + "§7§oEin Kickall wurde ausgeführt, da du immun bist, wurdest du nicht rausgeworfen.");
                } else {
                    p.kickPlayer(Preparement);

                }
            }
            return;
        }
        String Preparement = "§cAlle Spieler wurden aus dem Server geworfen!\n§eGrund: §7" + reason + "\n§eVon: §7" + WhoWasIt.getName() + "";
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission("cloudcraft.essentials.kickall.avoid") || p.equals(WhoWasIt)) {
                p.sendMessage(Eprx + "§7§oEin Kickall wurde ausgeführt, da du immun bist, wurdest du nicht rausgeworfen.");
            } else {
                p.kickPlayer(Preparement);

            }
        }
    }
}
