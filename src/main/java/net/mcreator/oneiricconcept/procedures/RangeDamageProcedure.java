package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

import java.util.Comparator;

public class RangeDamageProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, double damage, double range) {
		if (damagesource == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(range / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				entityiterator.hurt(damagesource, (float) (damage * (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_HEALTHMULTIPLIER))));
			}
		}
	}
}