package dev.j3fftw.luckypanda.surprise;

import dev.j3fftw.luckypanda.LuckyPanda;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class HoleSurprise implements Surprise {

    @Nonnull
    @Override
    public NamespacedKey getId() {
        return new NamespacedKey(LuckyPanda.getInstance(), "hole");
    }

    @Override
    public void process(@Nonnull Player player, @Nonnull Block block) {
        for (int x = -4; x < 4; x++) {
            for (int z = -4; z < 4; z++) {
                for (int y = block.getY(); y > 0; y--) {
                    block.getWorld().getBlockAt(x, y, z).setType(Material.AIR);
                }
            }
        }
    }
}
