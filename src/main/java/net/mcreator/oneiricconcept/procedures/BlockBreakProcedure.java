package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BlockBreakProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		ItemStack item = ItemStack.EMPTY;
		ItemStack tool = ItemStack.EMPTY;
		tool = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		if (tool.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:ignisaureliae")))) {
			item = (new ItemStack(blockstate.getBlock()));
			if (world instanceof Level _level4 && _level4.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(item), _level4).isPresent()) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (!(item.getItem() == OneiricconceptModBlocks.AMBROSIAL_ARBOR_LOG.get().asItem())) {
					item = (world instanceof Level _lvlSmeltResult
							? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(item), _lvlSmeltResult).map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy())
									.orElse(ItemStack.EMPTY)
							: ItemStack.EMPTY);
				} else {
					item = new ItemStack(OneiricconceptModBlocks.AMBROSIAL_ARBOR_LOG.get());
				}
			} else {
				item = new ItemStack(Blocks.AIR);
			}
		} else if (RandomProcedure.execute(world, 0.1) && !(tool.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH)) != 0)
				&& blockstate.is(BlockTags.create(ResourceLocation.parse("c:ice_blocks")))) {
			item = new ItemStack(OneiricconceptModItems.SOLID_WATER.get());
			item.grow((int) RandomintProcedure.execute(3, 0));
		}
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, item);
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
	}
}
