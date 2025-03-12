package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

import java.util.ArrayList;

public class BackUIDPlayerListProcedure {
    public static ArrayList<Player> execute(LevelAccessor world) {
        return new ArrayList<>(world.players());
    }
}
