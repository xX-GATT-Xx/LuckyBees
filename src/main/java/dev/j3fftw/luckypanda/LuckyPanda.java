package dev.j3fftw.luckypanda;

import dev.j3fftw.luckypanda.surprise.HoleSurprise;
import dev.j3fftw.luckypanda.surprise.JailAnvilSurprise;
import dev.j3fftw.luckypanda.surprise.JailLavaSurprise;
import dev.j3fftw.luckypanda.surprise.Surprise;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
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

        this.saveDefaultConfig();
        addDefaultSurprises();
        getCommand("lucky").setExecutor(new LuckyCommand());
        getServer().getPluginManager().registerEvents(new Events(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
        this.saveConfig();
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
        this.getConfig().addDefault(surprise.getId().toString(), true);
        if (this.getConfig().getBoolean(surprise.getId().toString())) {
            surprises.add(surprise);
        }
    }

    Surprise getRandomSurprise() {
        final int randomValue = ThreadLocalRandom.current().nextInt(surprises.size());
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
        this.addSurprise(new HoleSurprise());
        this.addSurprise(new JailAnvilSurprise());
        this.addSurprise(new JailLavaSurprise());
        this.saveConfig();
    }

}
