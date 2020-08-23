package ch.cloudcraft.cloudcore.LobbyCore.Listeners;

import ch.cloudcraft.cloudcore.LobbyCore.Methods.BuildModeStateUpdate;
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
            return true;
        }

        if (args.length == 0) {
            BuildModeStateUpdate.updateBuildMode(p, p);
            return true;

        }
        if (Validator.isOnlinePlayer(args[0])) {
            BuildModeStateUpdate.updateBuildMode(p, Validator.getPlayer(args[0]));


        } else {
            Methods.sendMessage(p, "§eDieser Spieler ist nicht online!");
        }
        return true;
    }
}
