package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

import java.util.List;
import java.util.ArrayList;

public class Ly1TurnProcedure {
	public static void execute(LevelAccessor world, Direction direction, Vec3 targetV) {
		if (direction == null || targetV == null)
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
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((yAxis + "|\u00A7e" + xAxis)), false);
			}
		}
		for (int index0 = 0; index0 < 8; index0++) {
			if (xAxis >= 80) {
				xAxis = xAxis - 80;
			} else if (xAxis >= 40) {
				xAxis = xAxis - 40;
			} else if (xAxis >= 20) {
				xAxis = xAxis - 20;
			} else if (xAxis >= 10) {
				xAxis = xAxis - 10;
			} else if (xAxis >= 8) {
				xAxis = xAxis - 8;
			} else if (xAxis >= 4) {
				xAxis = xAxis - 4;
			} else if (xAxis >= 2) {
				xAxis = xAxis - 2;
			} else if (xAxis >= 1) {
				xAxis = xAxis - 1;
			}
		}
		for (int index1 = 0; index1 < 10; index1++) {
			if (yAxis >= 180) {
				yAxis = yAxis - 180;
			} else if (yAxis >= 90) {
				yAxis = yAxis - 90;
			} else if (yAxis >= 40) {
				yAxis = yAxis - 40;
			} else if (yAxis >= 30) {
				yAxis = yAxis - 30;
			} else if (yAxis >= 20) {
				yAxis = yAxis - 20;
			} else if (yAxis >= 10) {
				yAxis = yAxis - 10;
			} else if (yAxis >= 8) {
				yAxis = yAxis - 8;
			} else if (yAxis >= 4) {
				yAxis = yAxis - 4;
			} else if (yAxis >= 2) {
				yAxis = yAxis - 2;
			} else if (yAxis >= 1) {
				yAxis = yAxis - 1;
			}
		}
	}
}