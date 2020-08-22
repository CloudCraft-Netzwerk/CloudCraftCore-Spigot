package ch.cloudcraft.cloudcore.LobbyCore.GUIManager;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class GUIManager {

    public static Inventory getDefaultGUI() {

        Inventory inv = Bukkit.createInventory(new GUIHolder(), 6 * 9, "§b§9CloudCraft [Lobby]");
        for (int i = 0; i < 6 * 9; i++) {
            inv.setItem(i, GUIItemManager.getGlassPane(DyeColor.BLACK));
        }


        //13, 21, 23, 29, 33, 37, 39, 41, 43 yes


        inv.setItem(13, GUIItemManager.getItem(Material.NETHER_STAR, 1, "§b§9Spawn", "§c", "§eKlicke um zum Spawn teleportiert zu werden"));
        inv.setItem(21, GUIItemManager.getItem(Material.BARRIER, 1, "Bald", "Bald"));
        inv.setItem(23, GUIItemManager.getItem(Material.BARRIER, 1, "Bald", "Bald"));
        inv.setItem(29, GUIItemManager.getItem(Material.BARRIER, 1, "Bald", "Bald"));
        inv.setItem(33, GUIItemManager.getItem(Material.BARRIER, 1, "Bald", "Bald"));
        inv.setItem(37, GUIItemManager.getItem(Material.BARRIER, 1, "Bald", "Bald"));
        inv.setItem(39, GUIItemManager.getItem(Material.BARRIER, 1, "Bald", "Bald"));
        inv.setItem(41, GUIItemManager.getItem(Material.BARRIER, 1, "Bald", "Bald"));
        inv.setItem(43, GUIItemManager.getItem(Material.BARRIER, 1, "Bald", "Bald"));


        return inv;

    }
}
