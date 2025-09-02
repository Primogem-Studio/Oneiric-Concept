package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class CrystalgeneratorpowerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double power) {
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("time", (world.getLevelData().getGameTime()));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		new Object() {
			void timedLoop(int timedloopiterator, int timedlooptotal, int ticks) {
				if (world instanceof ILevelExtension _ext) {
					IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
					if (_entityStorage != null)
						_entityStorage.receiveEnergy((int) power, false);
				}
				final int tick2 = ticks;
				OneiricconceptMod.queueServerWork(tick2, () -> {
					if (timedlooptotal > timedloopiterator + 1) {
						timedLoop(timedloopiterator + 1, timedlooptotal, tick2);
					}
				});
			}
		}.timedLoop(0, 100, 1);
		OneiricconceptMod.queueServerWork(100, () -> {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("running", false);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			CrystalgeneratoritemProcedure.execute(world, x, y, z);
		});
	}
}