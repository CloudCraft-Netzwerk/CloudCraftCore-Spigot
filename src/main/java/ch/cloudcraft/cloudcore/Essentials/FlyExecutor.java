package ch.cloudcraft.cloudcore.Essentials;

import ch.cloudcraft.cloudcore.LobbyCore.Methods.Methods;
import ch.cloudcraft.cloudcore.utils.QueryPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyExecutor implements CommandExecutor {
    private static String Eprx = Methods.getPrefix();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Dieser Befehl kann nur als Spieler benutzt werden");
            return true;
        }
        if (args.length == 0) {
            if (!commandSender.hasPermission("cloudcraft.essentials.fly")) {
                commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um deinen Flugmodus zu ändern!!");
                return true;
            }
            PlayerStateUpdate.updateFlymode(commandSender, (Player) commandSender);
            return true;
        } else if (args.length == 1) {
            if (!commandSender.hasPermission("cloudcraft.essentials.fly.others")) {
                commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um den Flugmodus anderer Spieler zu ändern!!");
                return true;
            }
            if (!QueryPlayer.isOnlinePlayer(args[0])) {
                commandSender.sendMessage(Eprx + "§c" + args[0] + " ist zurzeit nicht online!");
                return true;
            }
            PlayerStateUpdate.updateFlymode(commandSender, QueryPlayer.getPlayer(args[0]));
            return true;

        } else {
            commandSender.sendMessage(Eprx + "§cBenutzung: §7/fly <Spieler>");
            return true;
        }


    }
}
