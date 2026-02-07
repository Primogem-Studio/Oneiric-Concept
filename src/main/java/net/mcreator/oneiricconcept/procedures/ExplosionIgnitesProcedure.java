package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class ExplosionIgnitesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double mode, double rang) {
		boolean found = false;
		BlockState block = Blocks.AIR.defaultBlockState();
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xyz = 0;
		double range = 0;
		double probability = 0;
		double rx = 0;
		double ry = 0;
		double rz = 0;
		if (mode == 0) {
			block = Blocks.FIRE.defaultBlockState();
		} else if (mode == 1) {
			block = Blocks.WATER.defaultBlockState();
		} else if (mode == 2) {
			block = Blocks.POWDER_SNOW.defaultBlockState();
		}
		range = rang;
		xyz = Math.round(0 - (range - 1) / 2);
		sx = xyz;
		for (int index0 = 0; index0 < (int) range; index0++) {
			sy = xyz;
			for (int index1 = 0; index1 < (int) range; index1++) {
				sz = xyz;
				for (int index2 = 0; index2 < (int) range; index2++) {
					rx = x + sx;
					ry = y + sy;
					rz = z + sz;
					if ((world.getBlockState(BlockPos.containing(rx, ry, rz))).canBeReplaced()) {
						if (RandomProcedure.execute(world, 0.5)) {
							probability = Mth.clamp(((range / 2) / new Vec3(x, y, z).distanceTo(new Vec3(rx, ry, rz)) - 1), 0, 1);
							if (RandomProcedure.execute(world, probability)) {
								if (mode == 3) {
									if (world instanceof Level _level) {
										BlockPos _bp = BlockPos.containing(rx, ry, rz);
										if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
											if (!_level.isClientSide())
												_level.levelEvent(2005, _bp, 0);
										}
									}
								} else {
									world.setBlock(BlockPos.containing(rx, ry, rz), block, 3);
									if (mode == 1) {
										{
											int _value = 1;
											BlockPos _pos = BlockPos.containing(rx, ry, rz);
											BlockState _bs = world.getBlockState(_pos);
											if (_bs.getBlock().getStateDefinition().getProperty("level") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
												world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
										}
									}
								}
							}
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}