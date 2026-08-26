package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.ArrayList;

public class Ly1TurnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Vec3 targetV) {
		if (world == null || direction == null || targetV == null)
			return;
		double directionFix = 0;
		double xAxis = 0;
		double yAxis = 0;
		List<Object> xAList = new ArrayList<>();
		if (direction == Direction.WEST) {
			directionFix = 270;
		} else if (direction == Direction.SOUTH) {
			directionFix = 180;
		} else if (direction == Direction.EAST) {
			directionFix = 90;
		}
		xAxis = 5 - Math.floor(-Math.toDegrees(Math.asin(targetV.normalize().y())));
		yAxis = Math.floor((((new Object() {
			public double get(Vec3 vec3) {
				return Math.toDegrees(Math.acos(vec3.multiply(1.0D, 0.0D, 1.0D).normalize().z())) * (vec3.x() >= 0.0D ? -1.0D : 1.0D);
			}
		}).get(targetV) + 720) - directionFix) % 360);
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("ly1Pitch", xAxis);
				_blockEntity.getPersistentData().putDouble("ly1Yaw", yAxis);
				_blockEntity.setChanged();
				BlockState _bs = world.getBlockState(_bp);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}
