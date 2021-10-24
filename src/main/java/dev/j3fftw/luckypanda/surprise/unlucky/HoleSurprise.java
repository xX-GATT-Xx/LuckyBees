package dev.j3fftw.luckypanda.surprise.unlucky;

import dev.j3fftw.luckypanda.LuckyPanda;
import dev.j3fftw.luckypanda.surprise.Surprise;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class HoleSurprise implements Surprise {

    @Nonnull
    @Override
    public NamespacedKey getId() {
        return new NamespacedKey(LuckyPanda.getInstance(), "hole");
    }

    @Override
    public void process(@Nonnull Player player, @Nonnull Entity entity) {
        final Location playerLoc = player.getLocation();
        final Block block = entity.getLocation().getBlock();
        for (int x = -4; x < 4; x++) {
            for (int z = -4; z < 4; z++) {
                for (int y = block.getY() + 1; y >= 0; y--) {
                    block.getWorld()
                        .getBlockAt(playerLoc.getBlockX() + x, y, playerLoc.getBlockZ() + z)
                        .setType(Material.AIR);
                }
            }
        }
    }
}
