package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class ParticleSweepProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double cycle, double nu, double rangge) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SWEEP_ATTACK, x, y, z, (int) nu, (rangge / 7), (rangge / 7), (rangge / 7), 1);
		if (cycle > 0) {
			OneiricconceptMod.queueServerWork(1, () -> {
				ParticleSweepProcedure.execute(world, x, y, z, cycle - 1, nu, rangge);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.sweep")), SoundSource.PLAYERS, (float) Mth.nextDouble(RandomSource.create(), 0.1, 1),
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 2));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.sweep")), SoundSource.PLAYERS, (float) Mth.nextDouble(RandomSource.create(), 0.1, 1),
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 2), false);
					}
				}
			});
		} else {
			OneiricconceptMod.queueServerWork(20, () -> {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.RAID_OMEN, x, y, z, 1000, (rangge / 4), (rangge / 4), (rangge / 4), 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 300, (rangge / 4), (rangge / 4), (rangge / 4), 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CRIMSON_SPORE, x, y, z, 1600, (rangge / 4), (rangge / 4), (rangge / 4), 0.3);
				for (int index0 = 0; index0 < 30; index0++) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.sweep")), SoundSource.PLAYERS, 20, 2);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.sweep")), SoundSource.PLAYERS, 20, 2, false);
						}
					}
				}
				for (int index1 = 0; index1 < 5; index1++) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grindstone.use")), SoundSource.PLAYERS, 10, 2);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grindstone.use")), SoundSource.PLAYERS, 10, 2, false);
						}
					}
				}
			});
		}
	}
}
