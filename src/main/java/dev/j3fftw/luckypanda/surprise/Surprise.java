package dev.j3fftw.luckypanda.surprise;

import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public interface Surprise {

    @Nonnull
    NamespacedKey getId();

    void process(@Nonnull Player player, @Nonnull Block block);

    default double getChance() {
        // Same chance for everything else.
        return -1;
    }
}
