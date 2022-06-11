package me.codecraft.superhero.items;

import me.codecraft.superhero.Main;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack tnt;
    public static ItemStack creeper_helmet;
    public static ItemStack creeper_chestplate;
    public static ItemStack creeper_leggings;
    public static ItemStack creeper_boots;
    public static ItemStack summoner;

    private static Main plugin;

    public static void init(){
        CreateThrowableTnt();
    }

    private static void CreateThrowableTnt(){
        ItemStack item = new ItemStack(Material.IRON_NUGGET);
        ItemMeta tntmeta = item.getItemMeta();
        tntmeta.setCustomModelData(234678);
        tntmeta.setDisplayName(ChatColor.DARK_RED+"TNT Launcher");
        List<String> lore = new ArrayList<String>();
        lore.add("the Power to Create launch Tnt");
        tntmeta.setLore(lore);
        item.setItemMeta(tntmeta);
        tnt = item;

        //Armor
         List<String> armorlore = new ArrayList<String>();
        armorlore.add("This Armor is Made form the origin core of Acnologia");
        armorlore.add("Wear the complete set of armor to get the power of Destruction");
            //helmets
            ItemStack helemt = new ItemStack(Material.NETHERITE_HELMET);
            ItemMeta helmet_meta = helemt.getItemMeta();
            enchantedItems(helmet_meta, armorlore);
            helmet_meta.setDisplayName(ChatColor.DARK_GREEN+"Creeper Helmet");
            helemt.setItemMeta(helmet_meta);
            creeper_helmet = helemt;
            //Chestplate
            ItemStack chest = new ItemStack(Material.NETHERITE_CHESTPLATE);
            ItemMeta chest_meta = chest.getItemMeta();
            enchantedItems(chest_meta, armorlore);
            chest_meta.setDisplayName(ChatColor.DARK_GREEN+"Creeper Chestplate");
            chest.setItemMeta(chest_meta);
            creeper_chestplate = chest;
            //leggings
            ItemStack leg = new ItemStack(Material.NETHERITE_LEGGINGS);
            ItemMeta leg_meta = leg.getItemMeta();
            enchantedItems(leg_meta, armorlore);
            leg_meta.setDisplayName(ChatColor.DARK_GREEN+"Creeper Leggings");
            leg.setItemMeta(leg_meta);
            creeper_leggings = leg;
            //boots
            ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
            ItemMeta boots_meta = boots.getItemMeta();
            enchantedItems(boots_meta, armorlore);
            boots_meta.setDisplayName(ChatColor.DARK_GREEN+"Creeper Boots");
            boots.setItemMeta(boots_meta);
            creeper_boots = boots;


        ShapedRecipe tnt_launcher = new ShapedRecipe(NamespacedKey.minecraft("tnt_launcher"),item);
        tnt_launcher.shape("XXX","XTX","XXX");
        tnt_launcher.setIngredient('T',Material.TNT);
        tnt_launcher.setIngredient('X',Material.CREEPER_HEAD);
        Bukkit.addRecipe(tnt_launcher);

    }

    private static void enchantedItems(ItemMeta meta, List<String> lore) {
        meta.isUnbreakable();
        meta.addEnchant(Enchantment.PROTECTION_FIRE,1000000000,false);
        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS,333,true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,333,true);
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE,333,true);
        meta.addEnchant(Enchantment.PROTECTION_FALL,333,true);
        meta.isUnbreakable();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setLore(lore);

    }
}
