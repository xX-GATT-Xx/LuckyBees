package dev.j3fftw.luckypanda;

import dev.j3fftw.luckypanda.surprise.HoleSurprise;
import dev.j3fftw.luckypanda.surprise.Surprise;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.ThreadLocalRandom;

public class LuckyCommand implements CommandExecutor {

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        Block block = player.getWorld().getBlockAt(player.getLocation().clone().subtract(0, 2, 0));

        if (args.length != 0) {

            for (Surprise surprise : LuckyPanda.getInstance().getSurprises()) {
                if (surprise.getId().getKey().equals(args[0])) {
                    surprise.process(player, block);
                    return true;
                }
            }
            player.sendMessage("There isn't an element with this ID, you not-so-dumb blob.");
        } else {
            chooseSurprise().process(player, block);
        }
        return true;
    }

    private Surprise chooseSurprise() {
        double random = ThreadLocalRandom.current().nextDouble() + ThreadLocalRandom.current().nextInt(101);

        return LuckyPanda.getInstance().getRandomSurprise();
    }
}
