package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Direction;

public class VastheartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Direction direction, Entity entity, ItemStack itemstack) {
		if (direction == null || entity == null)
			return;
		double itemmode = 0;
		itemmode = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("mode");
		if (itemmode == 0) {
			WaterplaceProcedure.execute(world, x, y, z, direction);
		} else if (itemmode == 3) {
			WarmheartProcedure.execute(world, x, y, z, blockstate, entity, itemstack);
		}
	}
}