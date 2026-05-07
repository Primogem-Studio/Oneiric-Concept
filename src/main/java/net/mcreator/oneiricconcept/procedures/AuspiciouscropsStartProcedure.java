package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Direction;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class AuspiciouscropsStartProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack seed = ItemStack.EMPTY;
		double pow = 0;
		double seeds = 0;
		pow = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("power");
		if (pow < 6400) {
			seed = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
			seeds = seed.getCount();
			if (Items.WHEAT_SEEDS == seed.getItem()) {
				pow = pow + seeds;
			} else if (OneiricconceptModBlocks.AMBROSIAL_ARBOR_SAPLING.get().asItem() == seed.getItem()) {
				pow = pow + 10 * seeds;
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = seed;
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) seeds, _player.inventoryMenu.getCraftSlots());
			}
			{
				final String _tagName = "power";
				final double _tagValue = pow;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((pow + "/6400")), true);
		} else if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("enable")) {
			{
				final String _tagName = "enable";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
			}
		} else {
			for (Direction directioniterator : Direction.Plane.HORIZONTAL) {
				AuspiciouscropsProcedure.execute(world, x, z, directioniterator, true, 42);
			}
			AuspiciouscropsProcedure.execute(world, x, z, Direction.UP, false, 42);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 60);
		}
	}
}