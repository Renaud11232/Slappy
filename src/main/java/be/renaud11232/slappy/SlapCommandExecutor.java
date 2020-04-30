package be.renaud11232.slappy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Random;

public class SlapCommandExecutor implements CommandExecutor {

    private final Random random;

    public SlapCommandExecutor() {
        random = new Random();
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length < 1 || strings.length > 2) {
            return false;
        }
        Player player = Bukkit.getPlayer(strings[0]);
        if(player == null) {
            return false;
        }
        double slapness = 1;
        if(strings.length == 2) {
            try {
                slapness = Double.parseDouble(strings[1]);
            } catch (NumberFormatException ignored) {
                return false;
            }
        }
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_NODAMAGE, 1, 1);
        player.setVelocity(new Vector((random.nextDouble() * slapness * 2) - slapness, random.nextDouble() * slapness, (random.nextDouble() * slapness * 2) - slapness));
        commandSender.sendMessage("You slapped " + ChatColor.AQUA + strings[0]);
        return true;
    }
}
