package dev.j3fftw.luckypanda.surprise;

import dev.j3fftw.luckypanda.LuckyPanda;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class JailLavaSurprise implements Surprise {

    @Nonnull
    @Override
    public NamespacedKey getId() {
        return new NamespacedKey(LuckyPanda.getInstance(), "jail_lava");
    }

    @Override
    public void process(@Nonnull Player player, @Nonnull Block block) {
        final Location playerLoc = player.getLocation();
        for (byte x = 0; x < 5; x++) {
            for (byte z = 0; z < 5; z++) {
                playerLoc.clone().add(2 - x, -1, 2 - z).getBlock().setType(Material.STONE_BRICKS);
            }
        }
        for (byte y = 0; y < 4; y++) {
            for (byte x = 0; x < 3; x++) {
                for (byte z = 0; z < 3; z++) {
                    playerLoc.clone().add(1 - x, y, 1 - z).getBlock().setType(Material.IRON_BARS);
                }
            }
            playerLoc.clone().add(0, y, 0).getBlock().setType(Material.AIR);
        }
        playerLoc.clone().add(0, 3, 0).getBlock().setType(Material.LAVA);

    }
}
