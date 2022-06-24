package me.codecraft.superhero;

import me.codecraft.superhero.items.ItemManager;
import me.codecraft.superhero.items.TNT_Powers;
import me.codecraft.superhero.rideable_endergragon.EnderDragon;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemManager.init();
        new TNT_Powers(this);
        new EnderDragon(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
