package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.oneiricconcept.procedures.ArborProcedure;

public class HiltwoodFromTheArborItem extends Item {
	public HiltwoodFromTheArborItem() {
		super(new Item.Properties().fireResistant());
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		ArborProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ());
		return InteractionResult.SUCCESS;
	}
}