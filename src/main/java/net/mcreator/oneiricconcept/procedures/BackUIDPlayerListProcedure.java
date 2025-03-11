package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.util.List;
import java.util.ArrayList;

public class BackUIDPlayerListProcedure {
	public static ArrayList execute(LevelAccessor world) {
		List<Object> playerlist = new ArrayList<>();
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			playerlist.add(entityiterator);
		}
        ArrayList<Object> result = new ArrayList<>(playerlist);
        return result;
	}
}
