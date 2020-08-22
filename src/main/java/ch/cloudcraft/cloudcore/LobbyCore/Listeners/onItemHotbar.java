package ch.cloudcraft.cloudcore.LobbyCore.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.HashMap;

public class onItemHotbar implements Listener {


    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player p = event.getPlayer();
        HashMap<Player, Boolean> buildmode = BuildPlaceListener.buildmode;

        if (!buildmode.getOrDefault(p, false)) {
            event.setCancelled(true);
        } else {
            //Kappa
        }


    }
}
