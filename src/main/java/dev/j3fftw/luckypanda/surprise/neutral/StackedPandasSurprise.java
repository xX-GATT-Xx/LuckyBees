package dev.j3fftw.luckypanda.surprise.neutral;

import dev.j3fftw.luckypanda.Utils;
import dev.j3fftw.luckypanda.surprise.Surprise;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
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
    public void process(@Nonnull Player player, @Nonnull Entity entity) {
        final Location location = player.getLocation();
        Panda panda = Utils.spawnSurprisedPanda(location.clone().add(
            ThreadLocalRandom.current().nextDouble(5),
            ThreadLocalRandom.current().nextDouble(1),
            ThreadLocalRandom.current().nextDouble(5))
        );
        for (int i = 1; i <= 9; i++) {
            final Panda passenger = Utils.spawnSurprisedPanda(location);
            panda.addPassenger(passenger);
            panda = passenger;
        }
    }
}
