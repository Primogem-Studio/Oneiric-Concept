package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.init.OneiricconceptModEntities;

public class BaryonPlaceProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (10 < (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.BARYON_SPAWN))) {
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, (int) Math.max(10, (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.BARYON_SPAWN)) / 10)); index0++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = OneiricconceptModEntities.BARYON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
		return RandomProcedure.execute(world, (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.BARYON_SPAWN)) / 10)
				&& (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("oneiricconcept:topblock")));
	}
}