package ch.cloudcraft.cloudcore.LobbyCore.Listeners;

import ch.cloudcraft.cloudcore.LobbyCore.Methods.Methods;
import ch.cloudcraft.cloudcore.Main;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Join implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission("cloudcraft.staff")) {
            event.setJoinMessage("§c§l! §r§a» §b§lDas Teammitglied §c§l" + event.getPlayer().getName() + "§b§l hat den Server betreten!");
        } else {
            event.setJoinMessage("§a» §b§lDer Spieler §9§l" + event.getPlayer().getName() + "§b§l ist beigetreten.");

        }
        Location spawnLoc = (Location) Main.getPlugin().getConfig().get("locations.spawn.coords");

        // event.getPlayer().sendMessage(spawnLoc.getWorld().getName());

        event.getPlayer().teleport(spawnLoc);
        Methods.sendMessage(event.getPlayer(), "§aDieser Server verwendet Cloudcore | Version §e" + Main.getPlugin().getDescription().getVersion());


    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        if (event.getPlayer().hasPermission("cloudcraft.staff")) {
            event.setQuitMessage("§c§l! §r§c« §b§lDas Teammitglied §c§l" + event.getPlayer().getName() + "§b§l hat den Server verlassen!");
        } else {
            event.setQuitMessage("§c« §b§lDer Spieler §9§l" + event.getPlayer().getName() + "§b§l hat den Server verlassen.");

        }
    }
}
