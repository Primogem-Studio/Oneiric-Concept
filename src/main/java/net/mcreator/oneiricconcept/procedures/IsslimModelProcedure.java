package net.mcreator.oneiricconcept.procedures;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.world.entity.Entity;

public class IsslimModelProcedure {
    public static boolean execute(Entity entity) {
        if (entity instanceof AbstractClientPlayer player) {
            return player.getSkin().model() == PlayerSkin.Model.SLIM;
        }
        return false;
    }
}