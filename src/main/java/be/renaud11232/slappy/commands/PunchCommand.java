package be.renaud11232.slappy.commands;

import be.renaud11232.awesomecommand.AwesomeCommandExecutor;
import be.renaud11232.awesomecommand.annotation.args.CommandSenderParameter;
import be.renaud11232.awesomecommand.annotation.args.PositionalArgument;
import be.renaud11232.awesomecommand.annotation.command.AwesomeCommand;
import be.renaud11232.slappy.util.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@AwesomeCommand(
        name = "punch",
        description = "Punches a naughty player",
        usage = "/<command> <player> <damage> [punchness]",
        permission = "slappy.punch"
)
public class PunchCommand implements AwesomeCommandExecutor {

    @PositionalArgument(position = 0)
    private Player player;

    @PositionalArgument(position = 1)
    private int damage;

    @PositionalArgument(position = 2, defaultValue = "1")
    private Double punchness;

    @CommandSenderParameter
    private CommandSender commandSender;

    @Override
    public boolean execute() {
        player.damage(damage);
        Utils.slap(player, punchness);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT, 1, 1);
        commandSender.sendMessage("You slapped " + ChatColor.AQUA + player.getName());
        return true;
    }
}
