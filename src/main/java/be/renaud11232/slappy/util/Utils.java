package be.renaud11232.slappy.util;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Random;

public class Utils {

    private static final Random RANDOM = new Random();

    public static void slap(Player player, double slapness) {
        double localSlapness = 0.7 * Math.min(Math.max(slapness, 0), 10);
        double angle1 = Math.toRadians((RANDOM.nextDouble() * 180) - 90);
        double angle2 = Math.toRadians(RANDOM.nextDouble() * 360);
        double x = localSlapness * Math.sin(angle1) * Math.cos(angle2);
        double y = localSlapness * Math.cos(angle1);
        double z = localSlapness * Math.sin(angle1) * Math.sin(angle2);
        player.setVelocity(new Vector(x, y, z));
    }

}
