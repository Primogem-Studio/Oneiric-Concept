package net.mcreator.oneiricconcept.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;

public class TimesincerestSet0Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.awardStat(Stats.CUSTOM.get(Stats.TIME_SINCE_REST), -_serverPlayer.getStats().getValue(Stats.CUSTOM.get(Stats.TIME_SINCE_REST)));
	}
}