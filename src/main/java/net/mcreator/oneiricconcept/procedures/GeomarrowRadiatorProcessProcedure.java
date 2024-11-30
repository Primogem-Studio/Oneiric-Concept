package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class GeomarrowRadiatorProcessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double repeat = 0;
		ItemStack i1 = ItemStack.EMPTY;
		i1 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		if (i1.getItem() == OneiricconceptModItems.SAUSAGE.get()) {
			i1.shrink(1);
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity, new ItemStack(OneiricconceptModItems.BELOBOG_SAUSAGE.get()), 0, 1, 2);
		} else if (i1.getItem() == Items.WHEAT_SEEDS && i1.getCount() >= 8) {
			i1.shrink(8);
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity, new ItemStack(OneiricconceptModItems.WAFFLE.get()), 0, 1, 2);
		} else if (i1.getItem() == OneiricconceptModBlocks.THE_ANOTHER_WORLD_SAPLING.get().asItem()) {
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity, new ItemStack(OneiricconceptModItems.PRIMOGEM_WAFFLE.get()), 0, 1, 5);
			i1.shrink(1);
		} else if (i1.getItem() == OneiricconceptModBlocks.CLOUD.get().asItem()) {
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity, new ItemStack(OneiricconceptModItems.SKY_WAFFLE.get()), 0, 1, 5);
			i1.shrink(1);
		} else if (i1.getItem() == OneiricconceptModItems.S_2AUSAGE.get()) {
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity, new ItemStack(OneiricconceptModItems.B_2ELOBOG_SAUSAGE.get()), 1, 1, 1);
			i1.shrink(1);
		}
	}
}
