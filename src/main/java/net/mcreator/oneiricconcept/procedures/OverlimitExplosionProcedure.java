package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class OverlimitExplosionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double elvl) {
		double lvl = 0;
		double Inventorynu = 0;
		lvl = elvl;
		Inventorynu = lvl / 5;
		if (0 < lvl) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, (float) lvl, Level.ExplosionInteraction.BLOCK);
			for (int index0 = 0; index0 < (int) (Math.ceil(lvl) / 5); index0++) {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, (x + Mth.nextDouble(RandomSource.create(), 0 - Inventorynu, Inventorynu)), (y + Mth.nextDouble(RandomSource.create(), 0 - Inventorynu, Inventorynu)),
							(z + Mth.nextDouble(RandomSource.create(), 0 - Inventorynu, Inventorynu)), (float) lvl, Level.ExplosionInteraction.BLOCK);
			}
			ExplosionIgnitesProcedure.execute(world, x, y, z, 15 + lvl / 1.6);
		}
	}
}
