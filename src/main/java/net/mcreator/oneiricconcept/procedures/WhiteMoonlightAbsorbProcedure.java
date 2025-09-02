package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class WhiteMoonlightAbsorbProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		ItemStack output = ItemStack.EMPTY;
		ItemStack input = ItemStack.EMPTY;
		OneiricconceptMod.LOGGER.info(IsNightProcedure.execute(world));
		OneiricconceptMod.LOGGER.info(world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_overworld"))));
		OneiricconceptMod.LOGGER.info(!(world.getLevelData().isRaining() || world.getLevelData().isThundering()));
		OneiricconceptMod.LOGGER.info(world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z)));
		if (IsNightProcedure.execute(world) && world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_overworld")))
				&& !(world.getLevelData().isRaining() || world.getLevelData().isThundering()) && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y + 1, z))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("moonlight", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "moonlight") + GetPhaseProcedure.execute(world)));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			OneiricconceptMod.LOGGER.info(new java.text.DecimalFormat("##.##").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "moonlight")));
			if (30 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "moonlight") && 1 <= itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount()) {
				input = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy());
				if (Items.NETHERITE_INGOT == input.getItem()) {
					output = new ItemStack(OneiricconceptModBlocks.THEANOTHERWORLDMOONINGOT.get());
				} else if (OneiricconceptModItems.MILK.get() == input.getItem()) {
					output = new ItemStack(OneiricconceptModItems.DREAMY_CONE.get());
				} else if (Blocks.DEEPSLATE_REDSTONE_ORE.asItem() == input.getItem()) {
					output = (RandomProcedure.execute(world, 0.5) ? new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:ranyuanduanpian"))) : new ItemStack(OneiricconceptModItems.MOLTEN_METAL.get()));
				} else if (Blocks.DEEPSLATE_GOLD_ORE.asItem() == input.getItem()) {
					output = (RandomProcedure.execute(world, 0.5) ? new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:jianlaoduanpian"))) : new ItemStack(Items.RAW_GOLD));
				} else if (Blocks.AMETHYST_BLOCK.asItem() == input.getItem()) {
					output = (RandomProcedure.execute(world, 0.5) ? new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:zuishengduanpian"))) : new ItemStack(OneiricconceptModItems.VIRTUAL_PARTICLE.get()));
				} else if (Blocks.DEEPSLATE_LAPIS_ORE.asItem() == input.getItem()) {
					output = (RandomProcedure.execute(world, 0.5) ? new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:dijingduanpian"))) : new ItemStack(OneiricconceptModItems.MEMORY_BUBBLE.get()));
				} else if (OneiricconceptModBlocks.THE_ANOTHER_WORLD_SAPLING.get().asItem() == input.getItem()) {
					output = (RandomProcedure.execute(world, 0.5) ? new ItemStack(OneiricconceptModItems.PRIMOGEMFRUIT.get()) : new ItemStack(OneiricconceptModItems.PRIMOGEM_WAFFLE.get()));
				} else if (OneiricconceptModItems.ENERGY_DRINK.get() == input.getItem()) {
					output = new ItemStack(OneiricconceptModItems.ENERGY_DRINK_SUGAR_FREE.get());
				} else if (Items.BOOK == input.getItem()) {
					output = new ItemStack(OneiricconceptModItems.TREE_BARKOF_ERUDITION.get());
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("moonlight", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (0 == itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() || output.getItem() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem()) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = output.copy();
						_setstack.setCount(1 + itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount());
						_itemHandlerModifiable.setStackInSlot(1, _setstack);
					}
				} else if (0 == itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() || output.getItem() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = output.copy();
						_setstack.setCount(1 + itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount());
						_itemHandlerModifiable.setStackInSlot(2, _setstack);
					}
				} else {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 1), (z + 0.5), output);
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
		return getBlockNBTNumber(world, BlockPos.containing(x, y, z), "moonlight");
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
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