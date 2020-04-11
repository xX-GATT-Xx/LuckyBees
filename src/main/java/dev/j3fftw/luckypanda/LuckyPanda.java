package dev.j3fftw.luckypanda;

import dev.j3fftw.luckypanda.surprise.Surprise;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public final class LuckyPanda extends JavaPlugin implements SlimefunAddon {

    private static LuckyPanda instance;

    private final Set<Surprise> surprises = new HashSet<>();

    @Override
    public void onEnable() {
        instance = this;

        getCommand("lucky").setExecutor(new LuckyCommand());
        getServer().getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public JavaPlugin getJavaPlugin() {
        return this;
    }

    public String getBugTrackerURL() {
        return "https://github.com/j3fftw/LuckyPanda/issues/";
    }

    public static LuckyPanda getInstance() {
        return instance;
    }
}
