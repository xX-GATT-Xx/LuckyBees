package dev.j3fftw.luckypanda.surprise;

import dev.j3fftw.luckypanda.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import javax.annotation.Nonnull;

public class PandaLeggingSurprise implements Surprise {

    @Nonnull
    @Override
    public NamespacedKey getId() {
        return Utils.getKey("panda_leggings");
    }

    @Override
    public void process(@Nonnull Player player, @Nonnull Block block) {
        final ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        final ItemMeta itemMeta = leggings.getItemMeta();
        final LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
        itemMeta.setDisplayName(ChatColor.BLUE + "Panda Leggings");
        leatherArmorMeta.setColor(Color.fromRGB(255, 255, 255));
        itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        itemMeta.addEnchant(Enchantment.DURABILITY, 10, true);
        itemMeta.addEnchant(Enchantment.MENDING, 1, true);
        Utils.dropItem(player, leggings);
    }
}
