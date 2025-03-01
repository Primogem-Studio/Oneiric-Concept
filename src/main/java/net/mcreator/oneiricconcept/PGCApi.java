package net.mcreator.oneiricconcept;

import net.hackermdch.pgc.network.WishInfoConfiguration;
import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

import static net.mcreator.oneiricconcept.OneiricconceptMod.MODID;

public class PGCApi {
    public static PrimogemcraftModVariables.PlayerVariables getPlayerVariables(Entity entity) {
        if (entity instanceof ServerPlayer player) return player.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
        return new PrimogemcraftModVariables.PlayerVariables();
    }

    static void init() {
        WishInfoConfiguration.addRare(ResourceLocation.fromNamespaceAndPath(MODID, "r"));
        WishInfoConfiguration.addSuperRare(ResourceLocation.fromNamespaceAndPath(MODID, "sr"));
        WishInfoConfiguration.addSuperSuperRare(ResourceLocation.fromNamespaceAndPath(MODID, "ssr"));
    }
}
