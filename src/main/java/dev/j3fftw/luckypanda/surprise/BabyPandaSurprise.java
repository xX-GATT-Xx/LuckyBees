package dev.j3fftw.luckypanda.surprise;

import dev.j3fftw.luckypanda.LuckyPanda;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class BabyPandaSurprise implements Surprise {

    @Nonnull
    @Override
    public NamespacedKey getId() {
        return new NamespacedKey(LuckyPanda.getInstance(), "baby_panda");
    }

    @Override
    public void process(@Nonnull Player player, @Nonnull Block block) {
        final Location location = player.getLocation();
        for (int i = 1; i <= 10; i++) {
            final Panda panda = (Panda) location.getWorld().spawnEntity(location, EntityType.PANDA);
            panda.setBaby();
            panda.setCustomNameVisible(true);
            if (i == 5) {
                panda.setCustomName(ChatColor.of("#FB9900") + "The Almighty Walshy");
                panda.setMainGene(Panda.Gene.AGGRESSIVE);
                panda.setTarget(player);
                panda.setCanPickupItems(true);
                panda.isBreedItem(Material.ACACIA_FENCE_GATE);
            } else if (i == 7) {
                panda.setCustomName(ChatColor.of("#0099FF") + "The Crazy Sefi");
                panda.setMainGene(Panda.Gene.PLAYFUL);
                panda.setAdult();
                panda.addPassenger(location.getWorld().spawnEntity(location, EntityType.BOAT));
                panda.isBreedItem(Material.BEETROOT_SEEDS);
            } else if (i == 9) {
                panda.setCustomName(ChatColor.of("#803CA1") + "The Lazy Jeff");
                panda.setMainGene(Panda.Gene.LAZY);
                panda.setVisualFire(true);
            }

        }
    }
}
