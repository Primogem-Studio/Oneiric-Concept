package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class LYProjToItemEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity target) {
		if (target == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SONIC_BOOM, x, y, z, 1, 0, 0, 0, 1);
		ItemStack stack = getItemFromProjectile(target);
		if (!stack.isEmpty()) {
			if (!target.level().isClientSide()) {
				ItemEntity itemEntity = new ItemEntity(target.level(), target.getX(), target.getY(), target.getZ(), stack);
				itemEntity.setDeltaMovement(new Vec3(0, 0, 0));
				target.level().addFreshEntity(itemEntity);
				target.discard();
			}
		} else {
			target.setDeltaMovement(new Vec3(0, 0, 0));
			target.getPersistentData().putBoolean("sTrident", true);
		}
	}

	private static ItemStack getItemFromProjectile(Entity target) {
		if (target instanceof AbstractArrow arrow)
			return arrow.getPickupItem();
		if (target instanceof ThrowableItemProjectile throwableItem)
			return throwableItem.getItem();
		if (target instanceof FireworkRocketEntity firework)
			return firework.getItem();
		return ItemStack.EMPTY;
	}
}
