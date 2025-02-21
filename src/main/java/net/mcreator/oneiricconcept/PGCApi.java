package net.mcreator.oneiricconcept;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class PGCApi {
    public static PrimogemcraftModVariables.PlayerVariables getPlayerVariables(Entity entity) {
        if (entity instanceof ServerPlayer player) return player.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
        return new PrimogemcraftModVariables.PlayerVariables();
    }
}
