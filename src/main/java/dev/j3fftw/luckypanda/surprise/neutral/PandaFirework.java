package dev.j3fftw.luckypanda.surprise.neutral;

import dev.j3fftw.luckypanda.Constants;
import dev.j3fftw.luckypanda.Utils;
import dev.j3fftw.luckypanda.surprise.Surprise;
import io.github.bakedlibs.dough.data.persistent.PersistentDataAPI;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import javax.annotation.Nonnull;
import java.util.concurrent.ThreadLocalRandom;

public class PandaFirework implements Surprise {

    @Nonnull
    @Override
    public NamespacedKey getId() {
        return Utils.getKey("panda_firework");
    }

    //todo make an actual panda firework just like the creeper one
    @Override
    public void process(@Nonnull Player player, @Nonnull Entity entity) {
        final Location location = entity.getLocation();
        final Firework firework = (Firework) location.getWorld().spawnEntity(location, EntityType.FIREWORK);
        final FireworkMeta fireworkMeta = firework.getFireworkMeta();
        fireworkMeta.setPower(ThreadLocalRandom.current().nextInt(1, 5));
        fireworkMeta.addEffect(FireworkEffect.builder()
            .with(FireworkEffect.Type.BALL_LARGE)
            .withColor(getRandomColors(15))
            .withFade(getRandomColors(15))
            .trail(ThreadLocalRandom.current().nextBoolean())
            .flicker(ThreadLocalRandom.current().nextBoolean())
            .build());
        firework.setFireworkMeta(fireworkMeta);
        firework.addPassenger(Utils.spawnSurprisedPanda(location));
        PersistentDataAPI.setBoolean(firework, Constants.SURPRISE_FIREWORK, true);
    }

    public Color[] getRandomColors(int amount) {
        final Color[] colors = new Color[amount];
        final ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < amount; i++) {
            colors[i] = Color.fromRGB(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        }
        return colors;
    }
}


//    public FireworkRocketEntity(Level debug1, double debug2, double debug4, double debug6, ItemStack debug8) {
//        super(EntityType.FIREWORK_ROCKET, debug1);
//        this.life = 0;
//        this.setPos(debug2, debug4, debug6);
//        int debug9 = 1;
//        if(!debug8.isEmpty() && debug8.hasTag()) {
//            this.entityData.set(DATA_ID_FIREWORKS_ITEM, debug8.copy());
//            debug9 += debug8.getOrCreateTagElement("Fireworks").getByte("Flight");
//        }
//
//        this.setDeltaMovement(this.random.nextGaussian() * 0.001D, 0.05D, this.random.nextGaussian() * 0.001D);
//        this.lifetime = 10 * debug9 + this.random.nextInt(6) + this.random.nextInt(7);
//    }