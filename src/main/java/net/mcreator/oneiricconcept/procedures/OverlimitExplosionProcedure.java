package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

public class OverlimitExplosionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double elvl) {
		double lvl = 0;
		double Inventorynu = 0;
		lvl = elvl;
		Inventorynu = lvl / 4;
		if (0 < lvl) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, (float) Math.min(100, lvl), Level.ExplosionInteraction.BLOCK);
			for (int index0 = 0; index0 < (int) Math.max(1, Math.ceil(lvl - 9)); index0++) {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, (x + Mth.nextDouble(RandomSource.create(), 0 - Inventorynu, Inventorynu)), (y + Mth.nextDouble(RandomSource.create(), 0 - Inventorynu, Inventorynu)),
							(z + Mth.nextDouble(RandomSource.create(), 0 - Inventorynu, Inventorynu)), (float) Math.min(100, lvl), Level.ExplosionInteraction.BLOCK);
			}
			ExplosionIgnitesProcedure.execute(world, x, y, z, 0, Math.min(333, 15 + lvl * 2));
		}
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("lvl:" + lvl + "minlvl\u00A7a:" + Math.min(100, lvl) + "\u00A7rfire:" + (15 + lvl / 1.6) + "\u00A76minfire:\u00A7e" + Math.min(333, 15 + lvl / 1.6))), false);
		}
	}
}