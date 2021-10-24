package dev.j3fftw.luckypanda;

import dev.j3fftw.luckypanda.surprise.Surprise;
import io.github.bakedlibs.dough.data.persistent.PersistentDataAPI;
import io.github.bakedlibs.dough.protection.Interaction;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class Events implements Listener {

    @EventHandler
    public void onPandaDeath(EntityDeathEvent event) {
        Player killer = event.getEntity().getKiller();
        Entity killed = event.getEntity();
        if (killed instanceof Panda
            && killer != null
            && !Utils.isSurprisePanda((Panda) killed)
        ) {
            Surprise surprise = LuckyPanda.getInstance().getRandomSurprise();
            if (surprise != null) {
                surprise.process(killer, killed);
            }
        }
    }


    /**
     * Credits to Sefiraat for explaining/actually telling me what to write
     */
    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player
            && event.getDamager() instanceof Panda
        ) {
            Panda damager = (Panda) event.getDamager();
            if (PersistentDataAPI.getBoolean(damager, Constants.EXPLOSIVE_PANDA)) {
                final Player damaged = (Player) event.getEntity();
                final Location location = damager.getLocation();
                final double range = 7;
                final int density = 20;
                location.getWorld().createExplosion(location, (float) range, true);
                for (double height = 0; height <= Math.PI; height += Math.PI / density) {
                    for (int i = 0; i < range; i++) {
                        final double radius = i * Math.sin(height);
                        final double y = i * Math.cos(height);
                        for (double angle = 0; angle < Math.PI * 2; angle += Math.PI / density) {
                            final double x = Math.cos(angle) * radius;
                            final double z = Math.sin(angle) * radius;
                            final Location block = location.clone().add(x, y, z);
                            if (LuckyPanda.getInstance().getProtectionManager()
                                .hasPermission(damaged, block, Interaction.BREAK_BLOCK)
                            ) {
                                block.getBlock().breakNaturally();
                            }
                        }
                    }
                }
            }
        }
    }
}
