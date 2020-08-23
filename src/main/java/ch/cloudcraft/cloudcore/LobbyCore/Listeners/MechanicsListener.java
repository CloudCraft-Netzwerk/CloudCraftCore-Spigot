package ch.cloudcraft.cloudcore.LobbyCore.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class MechanicsListener implements Listener {


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getDamager() instanceof Player) {
                Player causer = (Player) event.getEntity();
                Player victim = (Player) event.getDamager();

                if (BuildPlaceListener.buildmode.getOrDefault(causer, false) && BuildPlaceListener.buildmode.getOrDefault(victim, false)) {
                    event.setCancelled(false);
                } else {
                    event.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void onDamageEntity(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player p = (Player) event.getEntity();
            if (BuildPlaceListener.buildmode.getOrDefault(p, false)) {
                event.setCancelled(false);
            } else {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        Player p = (Player) event.getEntity();
        if (BuildPlaceListener.buildmode.getOrDefault(p, false)) {
            event.setCancelled(false);
        } else {
            event.setFoodLevel(20);
        }
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }
}
