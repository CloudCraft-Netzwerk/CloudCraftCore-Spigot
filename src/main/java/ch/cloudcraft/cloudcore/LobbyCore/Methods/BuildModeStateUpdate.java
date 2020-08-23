package ch.cloudcraft.cloudcore.LobbyCore.Methods;

import ch.cloudcraft.cloudcore.LobbyCore.Listeners.BuildPlaceListener;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class BuildModeStateUpdate {

    private static final HashMap<Player, ItemStack[]> HotbarSave = new HashMap<>();

    public static void updateBuildMode(Player sender, Player target) {
        boolean isBuildMode = BuildPlaceListener.buildmode.getOrDefault(target, false);


        if (!isBuildMode) {
            BuildPlaceListener.buildmode.put(target, true);
            Methods.sendMessage(target, "§aDein Baumodus wurde aktiviert!");

            if (!sender.equals(target)) {
                Methods.sendMessage(sender, "§aDer Baumodus von §e" + target.getName() + "§a wurde aktiviert!");
                LoggingManager.logAction(sender, "buildCommand", true, "Lobby", sender.getName() + " (" + sender.getUniqueId() + ") hat den Baumodus für " + target.getName() + " (" + target.getUniqueId() + ") aktiviert");

            } else {
                LoggingManager.logAction(sender, "buildCommand", true, "Lobby", sender.getName() + " (" + sender.getUniqueId() + ") hat den Baumodus für **sich selber** aktiviert");
            }
            switchHotbar(target, false);
            target.getPlayer().setHealthScale(20);
            target.getPlayer().setSaturation(20);
        } else {

            BuildPlaceListener.buildmode.put(target, false);
            Methods.sendMessage(target, "§aDein Baumodus wurde deaktiviert!");

            if (!sender.equals(target)) {
                Methods.sendMessage(sender, "§aDer Baumodus von §e" + target.getName() + "§a wurde deaktiviert!");
                LoggingManager.logAction(sender, "buildCommand", true, "Lobby", sender.getName() + " (" + sender.getUniqueId() + ") hat den Baumodus für " + target.getName() + " (" + target.getUniqueId() + ") deaktiviert");
            } else {
                LoggingManager.logAction(sender, "buildCommand", true, "Lobby", sender.getName() + " (" + sender.getUniqueId() + ") hat den Baumodus für **sich selber** deaktiviert");

            }

            switchHotbar(target, true);
            target.getPlayer().setHealthScale(2.0);
            target.getPlayer().setSaturation(20);

        }
    }

    private static void switchHotbar(Player p, boolean get) {
        if (get) {
            p.getInventory().setContents(HotbarSave.get(p));
            p.updateInventory();
        } else {
            HotbarSave.put(p, p.getInventory().getContents());
            p.getInventory().clear();
        }


    }
}
