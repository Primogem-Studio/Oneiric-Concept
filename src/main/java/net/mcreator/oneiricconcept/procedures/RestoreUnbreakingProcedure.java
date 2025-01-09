package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class RestoreUnbreakingProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		Entity ent = null;
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		if (0 < itemstack.getDamageValue()) {
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(-1, _level, null, _stkprov -> {
				});
			}
		}
	}
}
