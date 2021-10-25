package dev.j3fftw.luckypanda;

import io.github.bakedlibs.dough.data.persistent.PersistentDataAPI;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.Nonnull;

public final class Utils {

    private Utils() {}

    public static NamespacedKey getKey(@Nonnull String id) {
        return new NamespacedKey(LuckyPanda.getInstance(), id);
    }

    public static void dropItem(@Nonnull Player player, @Nonnull ItemStack itemStack) {
        player.getWorld().dropItemNaturally(player.getLocation(), itemStack);
    }

    public static Panda spawnSurprisedPanda(Location location) {
        final Panda surprisePanda = (Panda) location.getWorld().spawnEntity(
            location, EntityType.PANDA

        );
        PersistentDataAPI.setBoolean(surprisePanda, Constants.SURPRISE_PANDA, true);

        return surprisePanda;
    }

    public static void applyPotion(PotionMeta potionMeta, PotionEffectType effectType, int duration, int amplifier) {
        potionMeta.addCustomEffect(new PotionEffect(effectType, duration, amplifier), false);
    }

    public static boolean isSurprisePanda(Panda potentiallyASurprisePanda) {
        return PersistentDataAPI.getBoolean(potentiallyASurprisePanda, Constants.SURPRISE_PANDA);
    }
}
