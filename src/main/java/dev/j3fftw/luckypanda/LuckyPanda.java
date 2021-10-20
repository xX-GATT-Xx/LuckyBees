package dev.j3fftw.luckypanda;

import dev.j3fftw.luckypanda.surprise.BabyPandaSurprise;
import dev.j3fftw.luckypanda.surprise.HoleSurprise;
import dev.j3fftw.luckypanda.surprise.JailAnvilSurprise;
import dev.j3fftw.luckypanda.surprise.JailLavaSurprise;
import dev.j3fftw.luckypanda.surprise.Surprise;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class LuckyPanda extends JavaPlugin {

    private static LuckyPanda instance;

    private final List<Surprise> surprises = new ArrayList<>();

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

    public static LuckyPanda getInstance() {
        return instance;
    }

    public void addSurprise(Surprise surprise) {
        this.getConfig().addDefault(surprise.getId().toString(), true);
        if (this.getConfig().getBoolean(surprise.getId().toString())) {
            surprises.add(surprise);
        }
    }

    public Surprise getRandomSurprise() {
        final int chance = ThreadLocalRandom.current().nextInt(0, 10);
        if (chance == 0) {
            final int randomValue = ThreadLocalRandom.current().nextInt(surprises.size());
            return surprises.get(randomValue);
        }
        return null;
    }

    public List<Surprise> getSurprises() {
        return surprises;
    }

    private void addDefaultSurprises() {
        this.addSurprise(new HoleSurprise());
        this.addSurprise(new JailAnvilSurprise());
        this.addSurprise(new JailLavaSurprise());
        this.addSurprise(new BabyPandaSurprise());
    }

}
