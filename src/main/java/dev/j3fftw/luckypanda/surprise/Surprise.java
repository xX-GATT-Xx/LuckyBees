package dev.j3fftw.luckypanda.surprise;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public interface Surprise {

    @Nonnull
    NamespacedKey getId();

    void process(@Nonnull Player player, @Nonnull Entity entity);

}
