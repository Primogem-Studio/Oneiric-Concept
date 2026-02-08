package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

public class MinusUIDLIstorderProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double listoder = 0;
		MinusLIstorderProcedure.execute(world, entity, OneiricconceptModVariables.MapVariables.get(world).playername.size());
	}
}