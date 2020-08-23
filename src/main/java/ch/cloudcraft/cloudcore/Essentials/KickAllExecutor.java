package ch.cloudcraft.cloudcore.Essentials;

import ch.cloudcraft.cloudcore.LobbyCore.Methods.Methods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class KickAllExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        String Eprx = Methods.getPrefix();
        if (!commandSender.hasPermission("cloudcraft.essentials.kickall")) {
            commandSender.sendMessage(Eprx + "§cDu besitzt nicht genügend Rechte, um einen Kickall auszuführen!!");
            return true;
        }
        if (args.length == 0) {
            if (commandSender instanceof ConsoleCommandSender) {
                ServerStateUpdate.kickAll("Keinen Grund angegeben", null, true);
                commandSender.sendMessage(Eprx + "§aKickall wurde ausgeführt!");
            } else {
                ServerStateUpdate.kickAll("Keinen Grund angegeben", (Player) commandSender, false);
                commandSender.sendMessage(Eprx + "Kickall wurde ausgeführt!");
            }

            return true;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                sb.append(args[i]).append(" ");
            }
            if (commandSender instanceof ConsoleCommandSender) {
                ServerStateUpdate.kickAll(sb.toString(), null, true);
                commandSender.sendMessage(Eprx + "§aKickall wurde ausgeführt!");
            } else {
                ServerStateUpdate.kickAll(sb.toString(), (Player) commandSender, false);
                commandSender.sendMessage(Eprx + "Kickall wurde ausgeführt!");

            }

            commandSender.sendMessage(Eprx + "§7Grund: §8" + sb.toString());

            return true;
        }


    }
}
