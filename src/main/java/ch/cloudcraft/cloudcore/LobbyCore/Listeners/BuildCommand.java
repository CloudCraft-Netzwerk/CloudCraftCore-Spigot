package ch.cloudcraft.cloudcore.LobbyCore.Listeners;

import ch.cloudcraft.cloudcore.LobbyCore.Methods.LoggingManager;
import ch.cloudcraft.cloudcore.LobbyCore.Methods.Methods;
import ch.cloudcraft.cloudcore.LobbyCore.Methods.Validator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;

        if (!commandSender.isOp()) {
            Methods.sendMessage(p, "§cDu hast zu wenig Rechte für diesen Befehl");

            // Reimplement with Cooldown to avoid abuse | LoggingManager.logAction(p, "buildCommand", false, "Lobby", "");
            return true;
        }

        if (args.length == 0) {
            boolean isBuildMode = BuildPlaceListener.buildmode.getOrDefault(p, false);

            if (!isBuildMode) {

                BuildPlaceListener.buildmode.put(p, true);
                Methods.sendMessage(p, "§aDein Baumodus wurde aktiviert!");

                LoggingManager.logAction(p, "buildCommand", true, "Lobby", p.getName() + " (" + p.getUniqueId() + ") hat den Baumodus für **sich selber** aktiviert");

            } else {
                BuildPlaceListener.buildmode.put(p, false);
                Methods.sendMessage(p, "§cDein Baumodus wurde deaktiviert!");
                LoggingManager.logAction(p, "buildCommand", true, "Lobby", p.getName() + " (" + p.getUniqueId() + ") hat den Baumodus für **sich selber** deaktiviert");

            }
            return true;

        }
        if (Validator.isOnlinePlayer(args[0])) {
            boolean isBuildMode = BuildPlaceListener.buildmode.getOrDefault(Validator.getPlayer(args[0]), false);

            if (!isBuildMode) {
                BuildPlaceListener.buildmode.put(Validator.getPlayer(args[0]), true);
                Methods.sendMessage(Validator.getPlayer(args[0]), "§aDein Baumodus wurde aktiviert!");
                Methods.sendMessage(p, "§aDer Baumodus von §e" + args[0] + "§a wurde aktiviert!");
                LoggingManager.logAction(p, "buildCommand", true, "Lobby", p.getName() + " (" + p.getUniqueId() + ") hat den Baumodus für " + Validator.getPlayer(args[0]).getName() + " (" + Validator.getPlayer(args[0]).getUniqueId() + ") aktiviert");

                return true;
            } else {
                BuildPlaceListener.buildmode.put(Validator.getPlayer(args[0]), false);
                Methods.sendMessage(Validator.getPlayer(args[0]), "§cDein Baumodus wurde deaktiviert!");
                Methods.sendMessage(p, "§aDer Baumodus von §e" + args[0] + "§a wurde deaktiviert!");
                LoggingManager.logAction(p, "buildCommand", true, "Lobby", p.getName() + " (" + p.getUniqueId() + ") hat den Baumodus für " + Validator.getPlayer(args[0]).getName() + " (" + Validator.getPlayer(args[0]).getUniqueId() + ") deaktiviert");
                return true;

            }


        } else {
            Methods.sendMessage(p, "§eDieser Spieler ist nicht online!");
            return true;
        }
    }
}
