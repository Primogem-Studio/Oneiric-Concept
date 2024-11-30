package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class EndermiteSumProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.endermite.ambient")), SoundSource.HOSTILE, (float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5),
						(float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5));
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.endermite.ambient")), SoundSource.HOSTILE, (float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5),
						(float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5), false);
			}
		}
		for (int index0 = 0; index0 < 100; index0++) {
			OneiricconceptMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 9, 20), () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.endermite.ambient")), SoundSource.HOSTILE, (float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5),
								(float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.endermite.ambient")), SoundSource.HOSTILE, (float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5),
								(float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5), false);
					}
				}
			});
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = EntityType.ENDERMITE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
	}
}
