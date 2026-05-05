package net.mcreator.oneiricconcept.procedures;

import org.checkerframework.checker.units.qual.min;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class AuspiciouscropsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction dire, boolean main, double min) {
		if (dire == null)
			return;
		BlockState farmblock = Blocks.AIR.defaultBlockState();
		double xx = 0;
		double zz = 0;
		double yy = 0;
		String tstxt = "";
		tstxt = "" + Mth.nextInt(RandomSource.create(), 100, 999);
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			OneiricconceptMod.LOGGER.info((tstxt + "\u88AB\u8C03\u7528\uFF0C\u65B9\u5411" + dire));
		}
		xx = x;
		zz = z;
		if (dire == Direction.NORTH) {
			zz = z - 1;
		} else if (dire == Direction.EAST) {
			xx = x + 1;
		} else if (dire == Direction.SOUTH) {
			zz = z + 1;
		} else if (dire == Direction.WEST) {
			xx = x - 1;
		}
		yy = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xx, (int) zz) - 1;
		farmblock = (world.getBlockState(BlockPos.containing(xx, yy, zz)));
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			OneiricconceptMod.LOGGER.info((tstxt + "" + farmblock));
		}
		if ((world.getBlockState(BlockPos.containing(xx, yy + 1, zz))).canBeReplaced() && (farmblock.is(BlockTags.create(ResourceLocation.parse("minecraft:grass_blocks"))) || farmblock.is(BlockTags.create(ResourceLocation.parse("minecraft:sand")))
				|| farmblock.is(BlockTags.create(ResourceLocation.parse("minecraft:dirt"))))) {
			world.setBlock(BlockPos.containing(xx, yy, zz), Blocks.FARMLAND.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(xx, yy + 1, zz), Blocks.WHEAT.defaultBlockState(), 3);
			{
				int _value = 7;
				BlockPos _pos = BlockPos.containing(xx, yy + 1, zz);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			{
				int _value = 7;
				BlockPos _pos = BlockPos.containing(xx, yy, zz);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("moisture") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			if (!(dire == Direction.UP) && RandomProcedure.execute(world, 0.3) || 0 < min) {
				AuspiciouscropsProcedure.execute(world, xx, y, zz, dire, main, min - 1);
				if (main) {
					AuspiciouscropsProcedure.execute(world, xx, y, zz, dire.getCounterClockWise(Direction.Axis.Y), false, min - 1);
				}
			}
		}
	}
}