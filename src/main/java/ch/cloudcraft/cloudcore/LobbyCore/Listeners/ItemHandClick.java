package ch.cloudcraft.cloudcore.LobbyCore.Listeners;

import ch.cloudcraft.cloudcore.LobbyCore.GUIManager.GUIItemManager;
import ch.cloudcraft.cloudcore.LobbyCore.GUIManager.GUIManager;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ItemHandClick implements Listener {


    @EventHandler
    public void ItemHandonClick(PlayerInteractEvent event) {
        if (event.getPlayer().getGameMode().equals(GameMode.CREATIVE) && BuildPlaceListener.buildmode.getOrDefault(event.getPlayer(), false)) {
            return;
        }
        if (event.getItem().getType().equals(Material.COMPASS)) {
            event.getPlayer().openInventory(GUIManager.getDefaultGUI());
        }
    }

    @EventHandler
    public void PlayerItemHeld(PlayerItemHeldEvent event) {
        if (event.getPlayer().getGameMode().equals(GameMode.CREATIVE) && BuildPlaceListener.buildmode.getOrDefault(event.getPlayer(), false)) {
            return;
        }
        ItemStack item = GUIItemManager.getGlassPane(DyeColor.LIGHT_BLUE);

        Inventory inventory = event.getPlayer().getInventory();

        if (inventory.getItem(event.getPreviousSlot()) == null) {
            inventory.setItem(event.getPreviousSlot(), item);
            if (inventory.getItem(event.getNewSlot()).getType().equals(Material.COMPASS)) {

            } else {
                inventory.setItem(event.getNewSlot(), new ItemStack(Material.AIR));

            }
        }
        if (inventory.getItem(event.getNewSlot()) == null) {
            inventory.setItem(event.getPreviousSlot(), item);
            inventory.setItem(event.getNewSlot(), new ItemStack(Material.AIR));
        }
        if (inventory.getItem(event.getNewSlot()).getType().equals(Material.COMPASS)) {
            inventory.setItem(event.getPreviousSlot(), item);
        }
        if (inventory.getItem(event.getNewSlot()).getType().equals(Material.STAINED_GLASS_PANE)) {
            if (inventory.getItem(event.getNewSlot()).getType().equals(Material.COMPASS)) {

            } else {
                inventory.setItem(event.getNewSlot(), new ItemStack(Material.AIR));

            }
        }


        ItemStack itemcompass = GUIItemManager.getItem(Material.COMPASS, 1, "§9CloudCraft", "§eBenutze diesen heiligen Kompass, um", "§eIm Server herumzunavigieren.");
        event.getPlayer().getInventory().setItem(4, itemcompass);

    }
}
