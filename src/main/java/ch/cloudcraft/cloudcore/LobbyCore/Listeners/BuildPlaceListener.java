package ch.cloudcraft.cloudcore.LobbyCore.Listeners;

import ch.cloudcraft.cloudcore.LobbyCore.Methods.Methods;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.HashMap;

public class BuildPlaceListener implements Listener {
    public static HashMap<Player/*AppliedPlayer*/, Boolean /*IsAllowed*/> buildmode = new HashMap<>();

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (buildmode.getOrDefault(event.getPlayer(), false)) {
            event.setCancelled(false);


        } else if (!buildmode.getOrDefault(event.getPlayer(), false)) {
            event.setCancelled(true);
            Methods.sendMessage(event.getPlayer(), "§cDu darfst hier nichts abbauen!");
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (buildmode.getOrDefault(event.getPlayer(), false)) {
            event.setCancelled(false);


        } else if (!buildmode.getOrDefault(event.getPlayer(), false)) {
            event.setCancelled(true);
            Methods.sendMessage(event.getPlayer(), "§cDu kannst hier nichts platzieren!");
        }
    }
}
