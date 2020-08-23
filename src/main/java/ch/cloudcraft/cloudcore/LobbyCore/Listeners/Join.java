package ch.cloudcraft.cloudcore.LobbyCore.Listeners;

import ch.cloudcraft.cloudcore.LobbyCore.GUIManager.GUIItemManager;
import ch.cloudcraft.cloudcore.LobbyCore.Methods.BuildModeStateUpdate;
import ch.cloudcraft.cloudcore.LobbyCore.Methods.Methods;
import ch.cloudcraft.cloudcore.Main;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

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
        Methods.sendMessage(event.getPlayer(), "§e§nBenutze LabyMod für das beste Servererlebnis! https://labymod.net");


        for (int i = 0; i < 9; i++) {
            if (i != 4)
                event.getPlayer().getInventory().setItem(i, GUIItemManager.getGlassPane(DyeColor.LIGHT_BLUE));


        }
        ItemStack item = GUIItemManager.getItem(Material.COMPASS, 1, "§9CloudCraft", "§eBenutze diesen heiligen Kompass, um", "§eIm Server herumzunavigieren.");
        event.getPlayer().getInventory().setItem(4, item);
        event.getPlayer().updateInventory();
        event.getPlayer().setHealthScale(2.0);
        event.getPlayer().setSaturation(20);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        if (event.getPlayer().hasPermission("cloudcraft.staff")) {
            event.setQuitMessage("§c§l! §r§c« §b§lDas Teammitglied §c§l" + event.getPlayer().getName() + "§b§l hat den Server verlassen!");
        } else {
            event.setQuitMessage("§c« §b§lDer Spieler §9§l" + event.getPlayer().getName() + "§b§l hat den Server verlassen.");

        }
        if (BuildPlaceListener.buildmode.getOrDefault(event.getPlayer(), false)) {
            BuildModeStateUpdate.updateBuildMode(event.getPlayer(), event.getPlayer());
        }
    }
}
