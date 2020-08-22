package ch.cloudcraft.cloudcore.LobbyCore.GUIManager;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUIItemManager {

    public static ItemStack getGlassPane(DyeColor color) {

        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, color.getData());
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§c");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getItem(Material mat, int amount, String display, String... lore) {

        ItemStack item = new ItemStack(mat, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(display);

        List<String> list = new ArrayList<String>();

        for (String x : lore) {
            list.add(x);
        }

        meta.setLore(list);
        item.setItemMeta(meta);

        return item;
    }
}
