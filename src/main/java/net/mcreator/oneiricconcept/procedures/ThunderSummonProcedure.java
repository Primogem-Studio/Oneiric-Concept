package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

import java.util.Comparator;

public class ThunderSummonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double lvl = 0;
		if (world instanceof ServerLevel _level) {
			LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
			entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
			entityToSpawn.setVisualOnly(true);
			_level.addFreshEntity(entityToSpawn);
		}
		lvl = (world.getLevelData().isThundering() ? 2 : 1) * ((world.getFluidState(BlockPos.containing(x, y, z)).createLegacyBlock()).getBlock() instanceof LiquidBlock ? 2 : 1);
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((4 + lvl) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (!(entityiterator instanceof ItemEntity)) {
					entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.LIGHTNING_BOLT)), (float) (6 * (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_DAMAGEMULTIPLIER)) * lvl
							* (entityiterator.getType().is(EntityTypeTags.AQUATIC) ? 2 : 1) * (entityiterator.isInWaterRainOrBubble() ? 3 : 1)));
				}
			}
		}
	}
}