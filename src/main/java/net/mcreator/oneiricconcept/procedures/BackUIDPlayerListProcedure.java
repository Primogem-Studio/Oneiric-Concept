package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import java.util.List;
import java.util.ArrayList;

public class BackUIDPlayerListProcedure {
	public static ArrayList execute(LevelAccessor world) {
		List<Object> playerlist = new ArrayList<>();
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.END);
			if (world != null) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					playerlist.add(entityiterator);
				}
			}
			world = _worldorig;
		}
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.NETHER);
			if (world != null) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					playerlist.add(entityiterator);
				}
			}
			world = _worldorig;
		}
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.OVERWORLD);
			if (world != null) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					playerlist.add(entityiterator);
				}
			}
			world = _worldorig;
		}
		return new ArrayList<>(world.players());
	}
}
