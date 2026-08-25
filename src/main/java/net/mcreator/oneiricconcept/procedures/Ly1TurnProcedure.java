package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

public class Ly1TurnProcedure {
	public static void execute(LevelAccessor world, Vec3 targetV) {
		if (targetV == null)
			return;
		if (world instanceof ServerLevel _level) {
			_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + Math.floor(((new Object() {
				public double get(Vec3 vec3) {
					return Math.toDegrees(Math.acos(vec3.multiply(1.0D, 0.0D, 1.0D).normalize().z())) * (vec3.x() >= 0.0D ? -1.0D : 1.0D);
				}
			}).get(targetV) + 360) % 360))), false);
		}
	}
}