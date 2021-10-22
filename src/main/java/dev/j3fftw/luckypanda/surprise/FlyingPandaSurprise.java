package dev.j3fftw.luckypanda.surprise;

import dev.j3fftw.luckypanda.LuckyPanda;
import dev.j3fftw.luckypanda.Utils;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class FlyingPandaSurprise implements Surprise {

    @Nonnull
    @Override
    public NamespacedKey getId() {
        return Utils.getKey("flying_panda");
    }

    @Override
    public void process(@Nonnull Player player, @Nonnull Block block) {
        final Location location = player.getLocation();
        final Location spawnLocation = location.clone().add(0, 5, 0);
        final Bat bat = (Bat) location.getWorld().spawnEntity(spawnLocation, EntityType.BAT);
        bat.addPassenger(location.getWorld().spawnEntity(spawnLocation, EntityType.PANDA));
        bat.setInvisible(true);
    }
}
