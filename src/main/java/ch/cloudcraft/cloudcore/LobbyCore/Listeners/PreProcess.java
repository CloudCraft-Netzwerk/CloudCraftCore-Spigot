package ch.cloudcraft.cloudcore.LobbyCore.Listeners;

import ch.cloudcraft.cloudcore.LobbyCore.Methods.Methods;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PreProcess implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMessagePreprocess(PlayerCommandPreprocessEvent event) {
        String[] cmdlist = {"/pl", "/plugins", "/bukkit:pl", "/bukkit:plugins"};
        String[] extendedlist = {"/?", "/bukkit:?", "/bukkit:help", "/help"};
        for (String x : cmdlist) {
            if (event.getMessage().toLowerCase().startsWith(x)) {
                event.setCancelled(true);
                event.getPlayer().sendMessage("Plugins (1): §aCloudCore");
                break;
            }
        }
        for (String x : extendedlist) {
            if (event.getMessage().toLowerCase().startsWith(x)) {
                event.setCancelled(true);
                Methods.sendMessage(event.getPlayer(), "§c Nope.");
                break;
            }

        }
    }


}
