package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class CactusHitProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		OneiricconceptMod.queueServerWork(10, () -> {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.CACTUS)), 1);
		});
	}
}
