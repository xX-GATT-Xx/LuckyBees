package dev.j3fftw.luckypanda.surprise;

import dev.j3fftw.luckypanda.LuckyPanda;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class TryAgainPandaSurprise implements Surprise {

    @Nonnull
    @Override
    public NamespacedKey getId() {
        return new NamespacedKey(LuckyPanda.getInstance(), "try_again_panda");
    }

    @Override
    public void process(@Nonnull Player player, @Nonnull Block block) {
        block.getLocation().getWorld().spawnEntity(block.getLocation().add(0, 1, 0), EntityType.PANDA);
        player.sendMessage(ChatColor.BLUE + "You have gotten another chance");
    }
}
