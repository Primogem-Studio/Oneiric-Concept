package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class TankExplosionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double lvl = 0;
		double Inventorynu = 0;
		lvl = new Object() {
			public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
				if (level instanceof ILevelExtension _ext) {
					IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
					if (_fluidHandler != null)
						return _fluidHandler.getFluidInTank(tank).getAmount();
				}
				return 0;
			}
		}.getFluidTankLevel(world, BlockPos.containing(x, y, z), 1) / 2000;
		lvl = lvl + (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "lavasnu")) / 80;
		lvl = 3;
		for (int index0 = 0; index0 < 9; index0++) {
			lvl = lvl + new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					if (world instanceof ILevelExtension _ext) {
						IItemHandler _itemHandler = _ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(slotid).getCount();
					}
					return 0;
				}
			}.getAmount(world, BlockPos.containing(x, y, z), (int) Inventorynu);
			Inventorynu = Inventorynu + 1;
		}
		Inventorynu = lvl / 5;
		for (int index1 = 0; index1 < (int) (Math.ceil(lvl) / 5); index1++) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, (float) lvl, Level.ExplosionInteraction.BLOCK);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (x + Mth.nextDouble(RandomSource.create(), 0 - Inventorynu, Inventorynu)), (y + Mth.nextDouble(RandomSource.create(), 0 - Inventorynu, Inventorynu)),
						(z + Mth.nextDouble(RandomSource.create(), 0 - Inventorynu, Inventorynu)), (float) lvl, Level.ExplosionInteraction.BLOCK);
		}
		ExplosionIgnitesProcedure.execute(world, x, y, z, lvl / 1.8);
	}
}
