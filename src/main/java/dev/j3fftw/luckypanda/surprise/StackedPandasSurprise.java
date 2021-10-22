package dev.j3fftw.luckypanda.surprise;

import dev.j3fftw.luckypanda.LuckyPanda;
import dev.j3fftw.luckypanda.Utils;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.concurrent.ThreadLocalRandom;

public class StackedPandasSurprise implements Surprise {

    @Nonnull
    @Override
    public NamespacedKey getId() {
        return Utils.getKey("stacked_pandas");
    }

    @Override
    public void process(@Nonnull Player player, @Nonnull Block block) {
        final Location location = player.getLocation();
        final World locationWorld = location.getWorld();
        Panda panda = (Panda) locationWorld.spawnEntity(
            location.clone().add(
                ThreadLocalRandom.current().nextDouble(5),
                ThreadLocalRandom.current().nextDouble(1),
                ThreadLocalRandom.current().nextDouble(5)
            ),
            EntityType.PANDA
        );
        for (int i = 1; i <= 9; i++) {
            final Panda passenger = (Panda)locationWorld.spawnEntity(location, EntityType.PANDA);
            panda.addPassenger(passenger);
            panda = passenger;
        }
    }
}
