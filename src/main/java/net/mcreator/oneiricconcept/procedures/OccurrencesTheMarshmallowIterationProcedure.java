package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OccurrencesTheMarshmallowIterationProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean L = false;
		double a = 0;
		double enx = 0;
		double eny = 0;
		double enz = 0;
		a = entity.getPersistentData().getDouble("PlayerLife");
		L = a > 0;
		for (int index0 = 0; index0 < 10; index0++) {
			enx = entity.getX();
			eny = entity.getY() + index0;
			enz = entity.getZ();
			if (-1 != world.getBlockState(BlockPos.containing(enx, eny, enz)).getDestroySpeed(world, BlockPos.containing(enx, eny, enz))) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, enx, eny, enz, (new ItemStack((world.getBlockState(BlockPos.containing(enx, eny, enz))).getBlock())));
					entityToSpawn.setPickUpDelay(0);
					_level.addFreshEntity(entityToSpawn);
				}
				world.destroyBlock(BlockPos.containing(enx, eny, enz), false);
			}
		}
		if (entity.onGround() && L) {
			OneiricconceptMod.queueServerWork(2, () -> {
				if (entity.isAlive()) {
					net.mcreator.ceshi.procedures.EventGroupProcedure.execute(world, entity, (int) (1001 + a));
				}
			});
		} else if (!entity.onGround() && L) {
			OneiricconceptMod.queueServerWork(2, () -> {
				OccurrencesTheMarshmallowIterationProcedure.execute(world, entity);
			});
		}
	}
}