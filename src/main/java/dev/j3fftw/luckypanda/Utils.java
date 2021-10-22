package dev.j3fftw.luckypanda;

import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public final class Utils {

    public static NamespacedKey getKey(@Nonnull String id) {
        return new NamespacedKey(LuckyPanda.getInstance(), id);
    }

    public static void dropItem(@Nonnull Player player, @Nonnull ItemStack itemStack) {
        player.getWorld().dropItemNaturally(player.getLocation(), itemStack);
    }

    private Utils() {}
}
