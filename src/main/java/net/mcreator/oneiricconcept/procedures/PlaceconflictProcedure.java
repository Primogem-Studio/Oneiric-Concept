package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

public class PlaceconflictProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, double maxx, double maxy, double maxz, double minx, double miny, double minz, double y2) {
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
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A7b" + y1 + wsen)), false);
		}
		if (wsen == Direction.SOUTH) {
			return PlacexyzProcedure.execute(world, x, y, z, maxx, maxy, maxz, minx, miny, minz);
		}
		if (wsen == Direction.WEST) {
			return PlacexyzProcedure.execute(world, x, y, z, minz, maxy, maxx, maxz, miny, minx);
		}
		if (wsen == Direction.EAST) {
			return PlacexyzProcedure.execute(world, x, y, z, maxz, maxy, minx, minz, miny, maxx);
		}
		return PlacexyzProcedure.execute(world, x, y, z, minx, maxy, minz, maxx, miny, maxz);
	}
}
