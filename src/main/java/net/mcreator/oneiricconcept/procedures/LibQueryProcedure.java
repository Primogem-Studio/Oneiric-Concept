package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class LibQueryProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		QueryUIDProcedure.execute(world, entity);
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
