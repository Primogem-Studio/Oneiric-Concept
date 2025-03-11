package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

public class BackUIDEntityProcedure {
	public static Entity execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return null;
		return BackUIDPlayerListProcedure.execute(world).get((int) entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).ListOrder) instanceof Entity _e ? _e : null;
	}
}
