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
        name = "slap",
        description = "Slaps a naughty player",
        usage = "/<command> <player> [slapness]",
        permission = "slappy.slap"
)
public class SlapCommand implements AwesomeCommandExecutor {

    @PositionalArgument(position = 0)
    private Player player;

    @PositionalArgument(position = 1, defaultValue = "1")
    private Double slapness;

    @CommandSenderParameter
    private CommandSender commandSender;

    @Override
    public boolean execute() {
        Utils.slap(player, slapness);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_NODAMAGE, 1, 1);
        commandSender.sendMessage("You slapped " + ChatColor.AQUA + player.getName());
        return true;
    }
}
