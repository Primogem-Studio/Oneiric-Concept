package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import java.util.ArrayList;
import java.util.List;

public class BackUIDPlayerListProcedure {
    public static ArrayList<Object> execute(LevelAccessor world) {
        List<Object> playerlist = new ArrayList<>();
        List<Object> lst = new ArrayList<>();
        for (Entity entityiterator : new ArrayList<>(world.players())) {
            playerlist.add(entityiterator);
        }
        ArrayList<Object> result = new ArrayList<>(playerlist);
        return result;
    }
}