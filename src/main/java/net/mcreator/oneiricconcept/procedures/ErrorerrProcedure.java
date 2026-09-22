package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class ErrorerrProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double tim = 0;
		for (int _i1 = 0; _i1 < 6; _i1++) {
			OneiricconceptMod.queueServerWork((int) tim, () -> {
				BlockparticeProcedure.execute(world, x, y, z, Blocks.BARRIER.defaultBlockState(), false, 0.5, 0.5, 0.5, 1, 0.01, "@p");
			});
			tim = 3 + tim;
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("oneiricconcept:mmm")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("oneiricconcept:mmm")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
	}
}