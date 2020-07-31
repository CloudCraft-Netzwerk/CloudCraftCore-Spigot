package ch.cloudcraft.cloudcore.Essentials;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class PlayerStateUpdate {
    private static String Eprx = "§9[§r§o§bCloudEssentials§r§9] ";

    public static void updateGamemode(CommandSender sender, Player target, GameMode gameMode, boolean responseOnOwn) {
        Player Psender = (Player) sender;
        if (target.getGameMode().equals(gameMode)) {
            if (!target.equals(Psender)) {
                switch (gameMode) {
                    case CREATIVE:
                        sender.sendMessage(Eprx + "§c" + target.getName() + " befindet sich bereits im Kreativ-Modus!");
                        break;
                    case SURVIVAL:
                        sender.sendMessage(Eprx + "§c" + target.getName() + " befindet sich bereits im Überlebens-Modus!");
                        break;
                    case ADVENTURE:
                        sender.sendMessage(Eprx + "§c" + target.getName() + " befindet sich bereits im Abenteuer-Modus!");
                        break;
                    case SPECTATOR:
                        sender.sendMessage(Eprx + "§c" + target.getName() + " befindet sich bereits im Zuschauer-Modus!");
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
        target.setGameMode(gameMode);
        target.sendMessage(Eprx + "§aDein Spielmodus wurde geändert!");
        if (responseOnOwn) {
            if (!target.equals(Psender)) {
                sender.sendMessage(Eprx + "§aDer Spielmodus von " + target.getName() + " wurde geändert!");
            }
        }
    }

    public static void updateFlymode(CommandSender sender, Player target) {
        if (sender instanceof ConsoleCommandSender) {
            return;
        }
        Player yourself = (Player) sender;
        if (!target.equals(yourself)) {
            switch (target.getGameMode()) {
                case SPECTATOR:
                    sender.sendMessage(Eprx + "§cDu kannst den Flugmodus nicht wechseln währenddessen sich " + target.getName() + " im Zuschauer-Modus befindet!");
                    break;
                case CREATIVE:
                    sender.sendMessage(Eprx + "§cDu kannst den Flugmodus nicht wechseln währenddessen sich " + target.getName() + " im Kreativ-Modus befindet!");
                    break;
                case ADVENTURE:
                case SURVIVAL:
                    if (target.getAllowFlight()) {
                        target.setAllowFlight(false);
                        if (!target.equals(yourself)) {
                            yourself.sendMessage(Eprx + "§aDer Flugmodus von " + target.getName() + " wurde deaktiviert!");

                        }
                        target.sendMessage(Eprx + "§aDein Flugmodus wurde deaktiviert!");

                    } else {
                        target.setAllowFlight(true);
                        if (!target.equals(yourself)) {
                            yourself.sendMessage(Eprx + "§aDer Flugmodus von " + target.getName() + " wurde aktiviert!");

                        }
                        target.sendMessage(Eprx + "§aDein Flugmodus wurde aktiviert!");

                    }
                    break;

            }
        } else {
            switch (target.getGameMode()) {
                case SPECTATOR:
                    sender.sendMessage(Eprx + "§cDu kannst den Flugmodus nicht wechseln währenddessen du dich im Zuschauer-Modus befindest!");
                    break;
                case CREATIVE:
                    sender.sendMessage(Eprx + "§cDu kannst den Flugmodus nicht wechseln währenddessen du dich im Kreativ-Modus befindest!");
                    break;
                case ADVENTURE:
                case SURVIVAL:
                    if (target.getAllowFlight()) {
                        target.setAllowFlight(false);
                        if (!target.equals(yourself)) {
                            yourself.sendMessage(Eprx + "§aDer Flugmodus von " + target.getName() + " wurde deaktiviert!");

                        }
                        target.sendMessage(Eprx + "§aDein Flugmodus wurde deaktiviert!");

                    } else {
                        target.setAllowFlight(true);
                        if (!target.equals(yourself)) {
                            yourself.sendMessage(Eprx + "§aDer Flugmodus von " + target.getName() + " wurde aktiviert!");

                        }
                        target.sendMessage(Eprx + "§aDein Flugmodus wurde aktiviert!");

                    }
                    break;
            }
        }

    }
}
