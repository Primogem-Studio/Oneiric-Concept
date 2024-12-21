package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SupportProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Direction wesn, double x2, double y2, double z2) {
		if (wesn == null)
			return false;
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		boolean support = false;
		x1 = x2;
		y1 = y2;
		z1 = z2;
		support = (world.getBlockState(BlockPos.containing(x1, y1, z1))).is(BlockTags.create(ResourceLocation.parse("minecraft:leaves")))
				|| world.getBlockState(BlockPos.containing(x1, y1, z1)).isFaceSturdy(world, BlockPos.containing(x1, y1, z1), (wesn.getOpposite()));
		if (!support) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
		return support;
	}
}
