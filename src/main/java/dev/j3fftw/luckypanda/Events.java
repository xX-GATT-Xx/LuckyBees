package dev.j3fftw.luckypanda;

import dev.j3fftw.luckypanda.surprise.Surprise;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class Events implements Listener {

    @EventHandler
    public void onPandaDeath(EntityDeathEvent event) {
        Player killer = event.getEntity().getKiller();
        Entity killed = event.getEntity();
        if (killed instanceof Panda
            && killer != null
        ) {
            Surprise surprise = LuckyPanda.getInstance().getRandomSurprise();
            if (surprise != null) {
                surprise.process(killer, killed.getLocation().getBlock().getRelative(BlockFace.DOWN));
            }
        }
    }

}
