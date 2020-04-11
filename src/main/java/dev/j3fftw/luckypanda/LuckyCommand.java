package dev.j3fftw.luckypanda;

    import dev.j3fftw.luckypanda.surprise.HoleSurprise;
    import dev.j3fftw.luckypanda.surprise.Surprise;
    import org.bukkit.command.Command;
    import org.bukkit.command.CommandExecutor;
    import org.bukkit.command.CommandSender;
    import org.bukkit.entity.Player;

    import javax.annotation.ParametersAreNonnullByDefault;
    import java.util.concurrent.ThreadLocalRandom;

public class LuckyCommand implements CommandExecutor {

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;

        chooseSurprise().process(player, player.getWorld().getBlockAt(player.getLocation().clone().subtract(0, 2, 0)));
        return true;
    }

    private Surprise chooseSurprise() {
        double random = ThreadLocalRandom.current().nextDouble() + ThreadLocalRandom.current().nextInt(101);

        return new HoleSurprise();
    }
}
