package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class GeomarrowRadiatorProcessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double repeat = 0;
		ItemStack i1 = ItemStack.EMPTY;
		i1 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == OneiricconceptModItems.SAUSAGE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(OneiricconceptModItems.SAUSAGE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, (x + 0.5), (y + 1.3), (z + 0.5), 5, 0.2, 0.2, 0.2, 0.07);
			if (world instanceof ServerLevel _level)
				_level.addFreshEntity(new ExperienceOrb(_level, (entity.getX()), (entity.getY()), (entity.getZ()), 2));
			Geomarrowradiatorprocess0Procedure.execute(entity, new ItemStack(OneiricconceptModItems.BELOBOG_SAUSAGE.get()));
		} else if (i1.getItem() == Items.WHEAT_SEEDS && i1.getCount() >= 8) {
			i1.shrink(8);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, (x + 0.5), (y + 1.3), (z + 0.5), 5, 0.2, 0.2, 0.2, 0.07);
			if (world instanceof ServerLevel _level)
				_level.addFreshEntity(new ExperienceOrb(_level, (entity.getX()), (entity.getY()), (entity.getZ()), 2));
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(OneiricconceptModItems.WAFFLE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			Geomarrowradiatorprocess0Procedure.execute(entity, new ItemStack(OneiricconceptModItems.WAFFLE.get()));
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == OneiricconceptModBlocks.THE_ANOTHER_WORLD_SAPLING.get().asItem()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(OneiricconceptModBlocks.THE_ANOTHER_WORLD_SAPLING.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, (x + 0.5), (y + 1.3), (z + 0.5), 5, 0.2, 0.2, 0.2, 0.07);
			if (world instanceof ServerLevel _level)
				_level.addFreshEntity(new ExperienceOrb(_level, (entity.getX()), (entity.getY()), (entity.getZ()), 2));
			Geomarrowradiatorprocess0Procedure.execute(entity, new ItemStack(OneiricconceptModItems.PRIMOGEM_WAFFLE.get()));
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == OneiricconceptModBlocks.CLOUD.get().asItem()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, (x + 0.5), (y + 1.3), (z + 0.5), 5, 0.2, 0.2, 0.2, 0.07);
			if (world instanceof ServerLevel _level)
				_level.addFreshEntity(new ExperienceOrb(_level, (entity.getX()), (entity.getY()), (entity.getZ()), 5));
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(OneiricconceptModItems.SKY_WAFFLE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(OneiricconceptModBlocks.CLOUD.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if (true) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, (x + 0.5), (y + 1.3), (z + 0.5), 5, 0.2, 0.2, 0.2, 0.07);
			if (world instanceof ServerLevel _level)
				_level.addFreshEntity(new ExperienceOrb(_level, (entity.getX()), (entity.getY()), (entity.getZ()), 5));
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(OneiricconceptModItems.B_2ELOBOG_SAUSAGE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(OneiricconceptModItems.S_2AUSAGE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
	}
}
