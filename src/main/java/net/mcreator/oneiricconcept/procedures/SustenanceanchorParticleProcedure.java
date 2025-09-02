package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class SustenanceanchorParticleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double a = 0;
		double b = 0;
		double Magnification = 0;
		double healthre = 0;
		Magnification = (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_HEALTHMULTIPLIER));
		healthre = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "healthreserve");
		if (0 < healthre) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("healthreserve", (healthre - 2 * Magnification));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		for (int index0 = 0; index0 < 10; index0++) {
			a = a + 2;
			OneiricconceptMod.queueServerWork((int) a, () -> {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + 0.5), (y + 0.45), (z + 0.5), 1, 0.05, 0.05, 0.05, 0.1);
			});
		}
		for (int index1 = 0; index1 < 2; index1++) {
			b = b + 10;
			OneiricconceptMod.queueServerWork((int) b, () -> {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y - 0.7), (z + 0.5), 1, 0.2, 0.05, 0.2, 0.01);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FIREWORK, (x + 0.5), (y - 0.5), (z + 0.5), 1, 0.2, 0.2, 0.2, 0.01);
			});
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}