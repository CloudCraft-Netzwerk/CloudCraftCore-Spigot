package ch.cloudcraft.cloudcore.Essentials;

import ch.cloudcraft.cloudcore.utils.QueryPlayer;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeExecutor implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        String Eprx = "§9[§r§o§bCloudEssentials§r§9] ";

        if (!commandSender.hasPermission("cloudcraft.essentials.gamemode")) {
            commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um diesen Befehl auszuführen!");
            return true;
        }
        switch (s.toLowerCase()) {

            case "gamemode":
            case "gm":

                if (args.length == 0 || args.length > 2) {
                    commandSender.sendMessage(Eprx + "§cBenutzung: \n§7/" + s + " 0/survival/s§c | §71/creative/c§c | §72/adventure/a§c | §73/spectator/spc");
                    return true;
                }
                if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")) {
                    if (args.length == 1) {


                        if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.0")) {
                            commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um dich selber in den Survival-Modus zu setzen!!");
                            return true;
                        }
                        PlayerStateUpdate.updateGamemode(commandSender, (Player) commandSender, GameMode.SURVIVAL, false);
                        // commandSender.sendMessage(Eprx+"§aDein Spielmodus wurde aktualisiert!");

                    } else if (args.length == 2) {
                        if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others")) {
                            commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um den Spielmodus anderer Spieler zu ändern!!");
                            return true;
                        }
                        if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others.0")) {
                            commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um andere Spieler in den Survival-Modus zu setzen!!");
                            return true;
                        }
                        if (!QueryPlayer.isOnlinePlayer(args[1])) {
                            commandSender.sendMessage(Eprx + "§c" + args[1] + " ist zurzeit nicht online!");
                            return false;
                        }
                        PlayerStateUpdate.updateGamemode(commandSender, QueryPlayer.getPlayer(args[1]), GameMode.SURVIVAL, true);
                        return true;
                    }
                } else if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")) {
                    if (args.length == 1) {


                        if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.1")) {
                            commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um dich selber in den Kreativ-Modus zu setzen!!");
                            return true;
                        }
                        PlayerStateUpdate.updateGamemode(commandSender, (Player) commandSender, GameMode.CREATIVE, false);
                        // commandSender.sendMessage(Eprx+"§aDein Spielmodus wurde aktualisiert!");

                    } else if (args.length == 2) {
                        if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others")) {
                            commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um den Spielmodus anderer Spieler zu ändern!!");
                            return true;
                        }
                        if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others.1")) {
                            commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um andere Spieler in den Kreativ-Modus zu setzen!!");
                            return true;
                        }
                        if (!QueryPlayer.isOnlinePlayer(args[1])) {
                            commandSender.sendMessage(Eprx + "§c" + args[1] + " ist zurzeit nicht online!");
                            return false;
                        }
                        PlayerStateUpdate.updateGamemode(commandSender, QueryPlayer.getPlayer(args[1]), GameMode.CREATIVE, true);
                        return true;
                    }
                } else if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")) {
                    if (args.length == 1) {


                        if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.2")) {
                            commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um dich selber in den Abenteuer-Modus zu setzen!!");
                            return true;
                        }
                        PlayerStateUpdate.updateGamemode(commandSender, (Player) commandSender, GameMode.ADVENTURE, false);
                        // commandSender.sendMessage(Eprx+"§aDein Spielmodus wurde aktualisiert!");

                    } else if (args.length == 2) {
                        if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others")) {
                            commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um den Spielmodus anderer Spieler zu ändern!!");
                            return true;
                        }
                        if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others.2")) {
                            commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um andere Spieler in den Abenteuer-Modus zu setzen!!");
                            return true;
                        }
                        if (!QueryPlayer.isOnlinePlayer(args[1])) {
                            commandSender.sendMessage(Eprx + "§c" + args[1] + " ist zurzeit nicht online!");
                            return false;
                        }
                        PlayerStateUpdate.updateGamemode(commandSender, QueryPlayer.getPlayer(args[1]), GameMode.ADVENTURE, true);
                        return true;
                    }
                } else if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spc")) {
                    if (args.length == 1) {


                        if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.3")) {
                            commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um dich selber in den Zuschauer-Modus zu setzen!!");
                            return true;
                        }
                        PlayerStateUpdate.updateGamemode(commandSender, (Player) commandSender, GameMode.SPECTATOR, false);
                        // commandSender.sendMessage(Eprx+"§aDein Spielmodus wurde aktualisiert!");

                    } else if (args.length == 2) {
                        if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others")) {
                            commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um den Spielmodus anderer Spieler zu ändern!!");
                            return true;
                        }
                        if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others.3")) {
                            commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um andere Spieler in den Zuschauer-Modus zu setzen!!");
                            return true;
                        }
                        if (!QueryPlayer.isOnlinePlayer(args[1])) {
                            commandSender.sendMessage(Eprx + "§c" + args[1] + " ist zurzeit nicht online!");
                            return false;
                        }
                        PlayerStateUpdate.updateGamemode(commandSender, QueryPlayer.getPlayer(args[1]), GameMode.SPECTATOR, true);
                        return true;
                    }
                } else {
                    commandSender.sendMessage(Eprx + "§cBenutzung: \n§7/" + s + " 0/survival/s§c | §71/creative/c§c | §72/adventure/a§c | §73/spectator/spc");
                    return true;
                }
                break;

            case "gms":
            case "gm0":
                if (args.length == 0) {


                    if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.0")) {
                        commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um dich selber in den Survival-Modus zu setzen!!");
                        return true;
                    }
                    PlayerStateUpdate.updateGamemode(commandSender, (Player) commandSender, GameMode.SURVIVAL, false);
                    // commandSender.sendMessage(Eprx+"§aDein Spielmodus wurde aktualisiert!");

                } else if (args.length == 1) {
                    if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others")) {
                        commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um den Spielmodus anderer Spieler zu ändern!!");
                        return true;
                    }
                    if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others.0")) {
                        commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um andere Spieler in den Survival-Modus zu setzen!!");
                        return true;
                    }
                    if (!QueryPlayer.isOnlinePlayer(args[0])) {
                        commandSender.sendMessage(Eprx + "§c" + args[0] + " ist zurzeit nicht online!");
                        return false;
                    }
                    PlayerStateUpdate.updateGamemode(commandSender, QueryPlayer.getPlayer(args[0]), GameMode.SURVIVAL, true);
                    return true;
                } else {
                    commandSender.sendMessage(Eprx + "§cBenutzung: \n§7/" + s + " <Spieler>");
                    return true;
                }
                break;
            case "gm1":
            case "gmc":
                if (args.length == 0) {


                    if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.1")) {
                        commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um dich selber in den Kreativ-Modus zu setzen!!");
                        return true;
                    }
                    PlayerStateUpdate.updateGamemode(commandSender, (Player) commandSender, GameMode.CREATIVE, false);
                    // commandSender.sendMessage(Eprx+"§aDein Spielmodus wurde aktualisiert!");

                } else if (args.length == 1) {
                    if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others")) {
                        commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um den Spielmodus anderer Spieler zu ändern!!");
                        return true;
                    }
                    if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others.1")) {
                        commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um andere Spieler in den Kreativ-Modus zu setzen!!");
                        return true;
                    }
                    if (!QueryPlayer.isOnlinePlayer(args[0])) {
                        commandSender.sendMessage(Eprx + "§c" + args[0] + " ist zurzeit nicht online!");
                        return false;
                    }
                    PlayerStateUpdate.updateGamemode(commandSender, QueryPlayer.getPlayer(args[0]), GameMode.CREATIVE, true);
                    return true;
                } else {
                    commandSender.sendMessage(Eprx + "§cBenutzung: \n§7/" + s + " <Spieler>");
                    return true;
                }
                break;
            case "gma":
            case "gm2":
                if (args.length == 0) {


                    if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.2")) {
                        commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um dich selber in den Abenteuer-Modus zu setzen!!");
                        return true;
                    }
                    PlayerStateUpdate.updateGamemode(commandSender, (Player) commandSender, GameMode.ADVENTURE, false);
                    // commandSender.sendMessage(Eprx+"§aDein Spielmodus wurde aktualisiert!");

                } else if (args.length == 1) {
                    if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others")) {
                        commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um den Spielmodus anderer Spieler zu ändern!!");
                        return true;
                    }
                    if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others.2")) {
                        commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um andere Spieler in den Abenteuer-Modus zu setzen!!");
                        return true;
                    }
                    if (!QueryPlayer.isOnlinePlayer(args[0])) {
                        commandSender.sendMessage(Eprx + "§c" + args[0] + " ist zurzeit nicht online!");
                        return false;
                    }
                    PlayerStateUpdate.updateGamemode(commandSender, QueryPlayer.getPlayer(args[0]), GameMode.ADVENTURE, true);
                    return true;
                } else {
                    commandSender.sendMessage(Eprx + "§cBenutzung: \n§7/" + s + " <Spieler>");
                    return true;
                }
                break;
            case "gmspc":
            case "gm3":
                if (args.length == 0) {


                    if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.3")) {
                        commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um dich selber in den Zuschauer-Modus zu setzen!!");
                        return true;
                    }
                    PlayerStateUpdate.updateGamemode(commandSender, (Player) commandSender, GameMode.SPECTATOR, false);
                    // commandSender.sendMessage(Eprx+"§aDein Spielmodus wurde aktualisiert!");

                } else if (args.length == 1) {
                    if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others")) {
                        commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um den Spielmodus anderer Spieler zu ändern!!");
                        return true;
                    }
                    if (!commandSender.hasPermission("cloudcraft.essentials.gamemode.others.3")) {
                        commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um andere Spieler in den Zuschauer-Modus zu setzen!!");
                        return true;
                    }
                    if (!QueryPlayer.isOnlinePlayer(args[0])) {
                        commandSender.sendMessage(Eprx + "§c" + args[0] + " ist zurzeit nicht online!");
                        return false;
                    }
                    PlayerStateUpdate.updateGamemode(commandSender, QueryPlayer.getPlayer(args[0]), GameMode.SPECTATOR, true);
                    return true;
                } else {
                    commandSender.sendMessage(Eprx + "§cBenutzung: \n§7/" + s + " <Spieler>");
                    return true;
                }
                break;

        }
        return true;
    }
}
