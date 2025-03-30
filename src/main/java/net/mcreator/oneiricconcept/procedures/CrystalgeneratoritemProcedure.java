package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class CrystalgeneratoritemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack crystal = ItemStack.EMPTY;
		double crystal_power = 0;
		String pgc = "";
		boolean iscrystals = false;
		pgc = "primogemcraft:";
		for (int index0 = 0; index0 < 7; index0++) {
			crystal = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) index0).copy());
			if (!(crystal == ItemStack.EMPTY)) {
				break;
			}
		}
		if (OneiricconceptModBlocks.PRIMOGEM.get().asItem() == crystal.getItem() || BuiltInRegistries.ITEM.get(ResourceLocation.parse(((pgc + "zuishengduanpian")).toLowerCase(java.util.Locale.ENGLISH))) == crystal.getItem()
				|| BuiltInRegistries.ITEM.get(ResourceLocation.parse(((pgc + "disui")).toLowerCase(java.util.Locale.ENGLISH))) == crystal.getItem()
				|| BuiltInRegistries.ITEM.get(ResourceLocation.parse(((pgc + "yhjsl")).toLowerCase(java.util.Locale.ENGLISH))) == crystal.getItem()
				|| BuiltInRegistries.ITEM.get(ResourceLocation.parse(((pgc + "jlliang")).toLowerCase(java.util.Locale.ENGLISH))) == crystal.getItem()
				|| BuiltInRegistries.ITEM.get(ResourceLocation.parse(((pgc + "yuanshi")).toLowerCase(java.util.Locale.ENGLISH))) == crystal.getItem()) {
			crystal_power = 16000;
		} else if (OneiricconceptModItems.PHLOGISTON_CRYSTAL.get() == crystal.getItem() || BuiltInRegistries.ITEM.get(ResourceLocation.parse(((pgc + "zuishengkuai")).toLowerCase(java.util.Locale.ENGLISH))) == crystal.getItem()
				|| BuiltInRegistries.ITEM.get(ResourceLocation.parse(((pgc + "laoshi")).toLowerCase(java.util.Locale.ENGLISH))) == crystal.getItem() || OneiricconceptModItems.HONKAI_SLIVER.get() == crystal.getItem()
				|| BuiltInRegistries.ITEM.get(ResourceLocation.parse(((pgc + "chuangshijiejing")).toLowerCase(java.util.Locale.ENGLISH))) == crystal.getItem()) {
			crystal_power = 64000;
		} else if (OneiricconceptModBlocks.ELECTRO_METAL.get().asItem() == crystal.getItem() || BuiltInRegistries.ITEM.get(ResourceLocation.parse(((pgc + "yhjs")).toLowerCase(java.util.Locale.ENGLISH))) == crystal.getItem()) {
			crystal_power = 160000;
		} else if (OneiricconceptModItems.HONKAI_SHARD.get() == crystal.getItem() || BuiltInRegistries.ITEM.get(ResourceLocation.parse(((pgc + "zuishengzijing")).toLowerCase(java.util.Locale.ENGLISH))) == crystal.getItem()) {
			crystal_power = 1600000;
		} else if (crystal.is(ItemTags.create(ResourceLocation.parse("minecraft:logs")))) {
			crystal_power = 1600;
		} else {
			iscrystals = true;
		}
		if (!iscrystals) {
			CrystalgeneratorpowerProcedure.execute(world, x, y, z, crystal_power);
		}
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}
