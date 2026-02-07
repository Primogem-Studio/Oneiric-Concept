package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BoomBlossomsBoomProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (world.getBlockFloorHeight(BlockPos.containing(x, y - 1, z)) > 0) {
			world.setBlock(BlockPos.containing(x, y, z), blockstate, 3);
			ExplodeBoomBlossomsProcedure.execute(world, x, y, z, blockstate);
		} else {
			ExplodeBoomBlossomsNoLoadProcedure.execute(world, x, y, z, blockstate);
		}
	}
}