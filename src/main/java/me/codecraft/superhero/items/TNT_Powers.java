package me.codecraft.superhero.items;

import me.codecraft.superhero.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class TNT_Powers implements Listener {
    List<FallingBlock> throwedtnt = new ArrayList<>();

    private Main plugin;

    public TNT_Powers(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }
    @EventHandler
    public void OnIntract(PlayerInteractEvent e){
        Player p = e.getPlayer();
       
        ///gets the tnt
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR)||e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(p.getInventory().getItemInMainHand().getItemMeta()!= null && p.getInventory().getItemInMainHand().getItemMeta().getLore()!=null && p.getInventory().getItemInMainHand().getItemMeta().getLore().contains("the Power to Create launch Tnt")){
                FallingBlock tnt = p.getWorld().spawnFallingBlock(p.getEyeLocation(), Material.TNT,(byte) 0);
                tnt.setDropItem(false);
                throwedtnt.add(tnt);
                tnt.setVelocity(p.getLocation().getDirection().multiply(5));
                p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,10,5,true,false));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,10*20,5,true,false));
                e.setCancelled(true);
            }
        }
        if(p.getInventory().getItemInMainHand().getItemMeta()!= null && p.getInventory().getItemInMainHand().getItemMeta().getLore()!=null && p.getInventory().getItemInMainHand().getItemMeta().getLore().contains("the Power to Create launch Tnt")){
            p.getInventory().setHelmet(ItemManager.creeper_helmet);
            p.getInventory().setChestplate(ItemManager.creeper_chestplate);
            p.getInventory().setLeggings(ItemManager.creeper_leggings);
            p.getInventory().setBoots(ItemManager.creeper_boots);
            p.getInventory().setItem(2,ItemManager.summoner);
        }
    }
    @EventHandler
    public void onFall(EntityChangeBlockEvent e){
        if (e.getEntity() instanceof FallingBlock){
            if(throwedtnt.contains(e.getEntity())){
                e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(),5,false,false);
                e.setCancelled(true);
                e.getEntity().remove();
                throwedtnt.remove(e.getEntity());
            }
        }
    }
}
