package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

public class IsEntityDamageProcedure {
	public static boolean execute(LevelAccessor world, Entity entity, Entity target) {
		if (entity == null || target == null)
			return false;
		return (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.FRIENDSHIP_MODE) && target instanceof Player || entity == (target instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) || target instanceof Monster)
				&& !(entity == target);
	}
}