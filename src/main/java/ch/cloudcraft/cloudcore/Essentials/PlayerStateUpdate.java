package ch.cloudcraft.cloudcore.Essentials;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerStateUpdate {

    public static void updateGamemode(CommandSender sender, Player p, GameMode gameMode, boolean responseOnOwn) {
        Player Psender = (Player) sender;
        String Eprx = "§9[§r§o§bCloudEssentials§r§9] ";
        if (p.getGameMode().equals(gameMode)) {
            if (!p.equals(Psender)) {
                switch (gameMode) {
                    case CREATIVE:
                        sender.sendMessage(Eprx + "§c" + p.getName() + " befindet sich bereits im Kreativ-Modus!");
                        break;
                    case SURVIVAL:
                        sender.sendMessage(Eprx + "§c" + p.getName() + " befindet sich bereits im Überlebens-Modus!");
                        break;
                    case ADVENTURE:
                        sender.sendMessage(Eprx + "§c" + p.getName() + " befindet sich bereits im Abenteuer-Modus!");
                        break;
                    case SPECTATOR:
                        sender.sendMessage(Eprx + "§c" + p.getName() + " befindet sich bereits im Zuschauer-Modus!");
                        break;
                }

            } else {
                switch (gameMode) {
                    case CREATIVE:
                        sender.sendMessage(Eprx + "§cDu bist bereits im Kreativ-Modus!");
                        break;
                    case SURVIVAL:
                        sender.sendMessage(Eprx + "§cDu bist bereits im Überlebens-Modus!");
                        break;
                    case ADVENTURE:
                        sender.sendMessage(Eprx + "§cDu bist bereits im Abenteuer-Modus!");
                        break;
                    case SPECTATOR:
                        sender.sendMessage(Eprx + "§cDu bist bereits im Zuschauer-Modus!");
                        break;
                }
            }
            return;
        }
        p.setGameMode(gameMode);
        p.sendMessage(Eprx + "§aDein Spielmodus wurde geändert!");
        if (responseOnOwn) {
            if (!p.equals(Psender)) {
                sender.sendMessage(Eprx + "§aDer Spielmodus von " + p.getName() + " wurde geändert!");
            }
        }
    }
}
