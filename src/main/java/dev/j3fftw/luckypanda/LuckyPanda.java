package dev.j3fftw.luckypanda;

import dev.j3fftw.luckypanda.surprise.HoleSurprise;
import dev.j3fftw.luckypanda.surprise.JailAnvilSurprise;
import dev.j3fftw.luckypanda.surprise.JailLavaSurprise;
import dev.j3fftw.luckypanda.surprise.Surprise;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class LuckyPanda extends JavaPlugin implements SlimefunAddon {

    private static LuckyPanda instance;

    private final Set<Surprise> surprises = new HashSet<>();

    @Override
    public void onEnable() {
        instance = this;

        addDefaultSurprises();
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

    public void addSurprise(Surprise surprise) {
        surprises.add(surprise);
    }

    public Surprise getRandomSurprise() {
        int randomValue = ThreadLocalRandom.current().nextInt(surprises.size());
        short tmp = 0;
        for (Surprise surprise : surprises) {
            if (tmp++ == randomValue) {
                return surprise;
            }
        }
        return null;
    }

    public Set<Surprise> getSurprises() {
        return surprises;
    }

    private void addDefaultSurprises() {
        surprises.add(new HoleSurprise());
        surprises.add(new JailAnvilSurprise());
        surprises.add(new JailLavaSurprise());
    }

}
