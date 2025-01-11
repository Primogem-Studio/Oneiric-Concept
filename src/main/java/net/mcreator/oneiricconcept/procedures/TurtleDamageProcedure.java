package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.oneiricconcept.entity.CrystalTurtleEntity;

public class TurtleDamageProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		ItemStack items = ItemStack.EMPTY;
		double Times = 0;
		Times = entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_ShrinkingShellTime) : 0;
		if ((entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_crystal) : 0) <= 0) {
			items = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:ysjsj"))).copy();
			items.setCount((int) RandomintProcedure.execute(5, 1));
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, items);
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (entity instanceof CrystalTurtleEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CrystalTurtleEntity.DATA_crystal, 1200);
		}
		if (Times < 1200) {
			if (entity instanceof CrystalTurtleEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CrystalTurtleEntity.DATA_ShrinkingShellTime, (int) (Times + 600));
		}
		return !ShrinkingShellSuoKeProcedure.execute(entity);
	}
}
