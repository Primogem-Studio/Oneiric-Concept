package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class BowPullProcedure {
	public static double execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return 0;
		return itemstack.getItem() == (entity instanceof LivingEntity _entUseItem1 ? _entUseItem1.getUseItem() : ItemStack.EMPTY).getItem() ? (entity instanceof LivingEntity _entUseTicks3 ? _entUseTicks3.getTicksUsingItem() : 0) : 0;
	}
}