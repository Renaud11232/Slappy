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
        double slapness = 0.7;
        if(strings.length == 2) {
            try {
                slapness *= Double.parseDouble(strings[1]);
            } catch (NumberFormatException ignored) {
                return false;
            }
        }
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_NODAMAGE, 1, 1);
        double angle1 = Math.toRadians((random.nextDouble() * 180) - 90);
        double angle2 = Math.toRadians(random.nextDouble() * 360);
        double x = slapness * Math.sin(angle1) * Math.cos(angle2);
        double y = slapness * Math.cos(angle1);
        double z = slapness * Math.sin(angle1) * Math.sin(angle2);
        player.setVelocity(new Vector(x, y, z));
        commandSender.sendMessage("You slapped " + ChatColor.AQUA + strings[0]);
        return true;
    }
}
