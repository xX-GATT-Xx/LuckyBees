package dev.j3fftw.luckypanda.surprise.unlucky;

import dev.j3fftw.luckypanda.Utils;
import dev.j3fftw.luckypanda.surprise.Surprise;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class JailLavaSurprise implements Surprise {

    @Nonnull
    @Override
    public NamespacedKey getId() {
        return Utils.getKey("jail_lava");
    }

    @Override
    public void process(@Nonnull Player player, @Nonnull Entity entity) {
        final Location playerLoc = player.getLocation();
        for (byte y = -1; y < 4; y++) {
            for (byte x = 2; x > -3; x--) {
                for (byte z = 2; z > -3; z--) {
                    if (y == -1)
                        playerLoc.clone().add(x, -1, z).getBlock().setType(Material.STONE_BRICKS);
                    else if (x == 0 && z == 0) {
                        if (y == 3) {
                            playerLoc.clone().add(x, y, z).getBlock().setType(Material.LAVA);
                        }
                    } else if (x > -2 && x < 2 && z > -2 && z < 2)
                        playerLoc.clone().add(x, y, z).getBlock().setType(Material.IRON_BARS);
                }
            }
        }
    }
}
