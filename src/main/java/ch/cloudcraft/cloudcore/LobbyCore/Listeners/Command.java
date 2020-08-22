package ch.cloudcraft.cloudcore.LobbyCore.Listeners;

import ch.cloudcraft.cloudcore.LobbyCore.GUIManager.GUIManager;
import ch.cloudcraft.cloudcore.LobbyCore.Methods.Methods;
import ch.cloudcraft.cloudcore.Main;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;


public class Command implements CommandExecutor {
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String s, String[] args) {

        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("Dieser Befehl kann nur als Spieler verwendet werden.");
            return false;

        }

        Player p = (Player) sender;
        String pfx = Methods.getPrefix();


        if (!p.isOp()) {
            Methods.sendMessage(p, "Lobbysystem by HopeDev");
            return true;
        }

        if (args[0].equalsIgnoreCase("set")) {
            if (args[1].equalsIgnoreCase("spawn")) {
                Location loc = p.getLocation();
                Main.getPlugin().getConfig().createSection("locations.spawn");
                Main.getPlugin().getConfig().set("locations.spawn.coords", loc);
                Main.getPlugin().saveConfig();
                Methods.sendMessage(p, "Spawn gesetzt auf X: " + loc.getBlockX() + " Y:" + loc.getBlockY() + " Z:" + loc.getBlockZ());
            } else {

                //Later
            }

            return true;
        }

        if (args[0].equalsIgnoreCase("goto")) {
            if (args[1].equalsIgnoreCase("spawn")) {
                Location loc = (Location) Main.getPlugin().getConfig().get("locations.spawn.coords");
                p.teleport(loc);

                // Praktisch ne
            }
            return true;
        }
        if (args[0].equalsIgnoreCase("gui")) {
            p.openInventory(GUIManager.getDefaultGUI());
            return true;
        }


        return true;
    }
}
