package net.mcreator.oneiricconcept.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.oneiricconcept.procedures.H10Procedure;

public class ToastpizzaItem extends Item {
	public ToastpizzaItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(20).saturationModifier(1f).alwaysEdible().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		H10Procedure.execute(entity);
		return retval;
	}
}