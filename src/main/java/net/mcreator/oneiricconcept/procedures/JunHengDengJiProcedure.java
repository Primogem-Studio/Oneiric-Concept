package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.per.primogemcraft.system.weapon.Equilibrium;

public class JunHengDengJiProcedure {
    public static double execute(Entity entity) {
        return entity instanceof Player player ? Equilibrium.of(player).tier() : 0;
    }
}
