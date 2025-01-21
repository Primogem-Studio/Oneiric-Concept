package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class Vastheart2Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double itemmode = 0;
		itemmode = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("mode");
		if (itemmode == 1) {
			HearticeProcedure.execute(world, entity, itemstack);
		} else if (itemmode == 2) {
			CloudheartmodeProcedure.execute(world, itemstack);
		}
	}
}
