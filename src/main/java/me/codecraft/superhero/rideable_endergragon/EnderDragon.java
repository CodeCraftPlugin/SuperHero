package me.codecraft.superhero.rideable_endergragon;

import me.codecraft.superhero.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


public class EnderDragon implements Listener {

    private Main plugin;
    Set<EntityType> ridableTypes =  Arrays.stream(EntityType.values())
            .filter(t -> t.isAlive() && !Vehicle.class.isAssignableFrom(t.getEntityClass()))
            .collect(Collectors.toSet());


    public EnderDragon(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR)||e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (p.getInventory().getItemInMainHand().getItemMeta() != null && p.getInventory().getItemInMainHand().getItemMeta().getLore() != null && p.getInventory().getItemInMainHand().getItemMeta().getLore().contains("Summons the Demonic Dragon")) {
                Entity enderdragon = p.getWorld().spawnEntity(p.getLocation().add(1, 1, 1), EntityType.ENDER_DRAGON);
                enderdragon.addPassenger(p);
            }
        }

    }
}
