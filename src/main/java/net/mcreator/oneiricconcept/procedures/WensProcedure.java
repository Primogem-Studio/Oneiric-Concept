package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class WensProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double y2) {
		Direction wsen = Direction.NORTH;
		double y1 = 0;
		y1 = y2;
		if (-45 < y1 && y1 < 45) {
			wsen = Direction.SOUTH;
		} else if (45 < y1 && y1 < 135) {
			wsen = Direction.WEST;
		} else if (-135 < y1 && y1 < -45) {
			wsen = Direction.EAST;
		} else {
			wsen = Direction.NORTH;
		}
		{
			Direction _dir = wsen;
			BlockPos _pos = BlockPos.containing(x, y + 2, z);
			BlockState _bs = world.getBlockState(_pos);
			Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
			if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
				world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
			} else {
				_property = _bs.getBlock().getStateDefinition().getProperty("axis");
				if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
					world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
			}
		}
	}
}
