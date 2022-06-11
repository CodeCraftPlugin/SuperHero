package me.codecraft.superhero;

import me.codecraft.superhero.items.ItemManager;
import me.codecraft.superhero.items.TNT_Powers;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Main extends JavaPlugin {



    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemManager.init();
        new TNT_Powers(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
