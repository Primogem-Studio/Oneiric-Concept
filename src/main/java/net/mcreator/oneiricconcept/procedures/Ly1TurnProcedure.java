package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;

public class Ly1TurnProcedure {
	public static void execute(LevelAccessor world, Direction direction, Vec3 targetV) {
		if (direction == null || targetV == null)
			return;
		double directionFix = 0;
		if (direction == Direction.WEST) {
			directionFix = 270;
		} else if (direction == Direction.SOUTH) {
			directionFix = 180;
		} else if (direction == Direction.EAST) {
			directionFix = 90;
		}
		if (world instanceof ServerLevel _level) {
			_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((Math.floor((((new Object() {
				public double get(Vec3 vec3) {
					return Math.toDegrees(Math.acos(vec3.multiply(1.0D, 0.0D, 1.0D).normalize().z())) * (vec3.x() >= 0.0D ? -1.0D : 1.0D);
				}
			}).get(targetV) + 720) - directionFix) % 360) + "|\u00A7e" + (new Object() {
				public double get(Vec3 vec3) {
					return Math.toDegrees(Math.acos(vec3.multiply(1.0D, 0.0D, 1.0D).normalize().z())) * (vec3.x() >= 0.0D ? -1.0D : 1.0D);
				}
			}).get(targetV))), false);
		}
	}
}