package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
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

public class Geomarrowradiatorprocess0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack item, double mode, double nu, double xp) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _setstack = item.copy();
			_setstack.setCount((int) nu);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.lava.extinguish")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
		if (mode == 0) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, (x + 0.5), (y + 1.3), (z + 0.5), 5, 0.2, 0.2, 0.2, 0.07);
		} else if (mode == 1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, (x + 0.5), (y + 1.3), (z + 0.5), 5, 0.2, 0.2, 0.2, 0.07);
		}
		if (world instanceof ServerLevel _level)
			_level.addFreshEntity(new ExperienceOrb(_level, (entity.getX()), (entity.getY()), (entity.getZ()), (int) xp));
	}
}