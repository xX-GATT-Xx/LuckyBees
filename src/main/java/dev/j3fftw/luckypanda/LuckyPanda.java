package dev.j3fftw.luckypanda;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.plugin.java.JavaPlugin;

public class LuckyPanda extends JavaPlugin implements SlimefunAddon {

    private static LuckyPanda instance;

    public static LuckyPanda getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;

        getServer().getPluginManager().registerEvents(new Events(), this);

    }

    public void onDisable() {
        instance = null;
    }

    public JavaPlugin getJavaPlugin() {
        return this;
    }

    public String getBugTrackerURL() {
        return "https://github.com/j3fftw/LuckyPanda";
    }
}
