package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModEntities;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;
import net.mcreator.oneiricconcept.entity.SkyShatteringLuxArrowEntity;

public class DivineArrowProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xyz = 0;
		double range = 0;
		range = 33;
		xyz = Math.round(0 - (range - 1) / 2);
		sx = xyz;
		found = false;
		for (int index0 = 0; index0 < (int) range; index0++) {
			if (found) {
				break;
			}
			sy = xyz;
			for (int index1 = 0; index1 < (int) range; index1++) {
				if (found) {
					break;
				}
				sz = xyz;
				for (int index2 = 0; index2 < (int) range; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == OneiricconceptModBlocks.AMBROSIAL_ARBOR_LEAVE.get()
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == OneiricconceptModBlocks.AMBROSIAL_ARBOR_LOG.get()) {
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
									AbstractArrow entityToSpawn = new SkyShatteringLuxArrowEntity(OneiricconceptModEntities.SKY_SHATTERING_LUX_ARROW.get(), level) {
										@Override
										public byte getPierceLevel() {
											return piercing;
										}

										@Override
										protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
											if (knockback > 0) {
												double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
												Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
												if (vec3.lengthSqr() > 0.0) {
													livingEntity.push(vec3.x, 0.1, vec3.z);
												}
											}
										}
									};
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 5, 1, (byte) 0);
							_entityToSpawn.setPos((x + sx), 280, (z + sz));
							_entityToSpawn.shoot(0, (-1), 0, 2, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
						for (int index3 = 0; index3 < Mth.nextInt(RandomSource.create(), 1, 3); index3++) {
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
										AbstractArrow entityToSpawn = new SkyShatteringLuxArrowEntity(OneiricconceptModEntities.SKY_SHATTERING_LUX_ARROW.get(), level) {
											@Override
											public byte getPierceLevel() {
												return piercing;
											}

											@Override
											protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
												if (knockback > 0) {
													double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
													Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
													if (vec3.lengthSqr() > 0.0) {
														livingEntity.push(vec3.x, 0.1, vec3.z);
													}
												}
											}
										};
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, 5, 1, (byte) 0);
								_entityToSpawn.setPos((x + sx + Mth.nextDouble(RandomSource.create(), -2, 2)), 280, (z + sz + Mth.nextDouble(RandomSource.create(), -2, 2)));
								_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -0.1, 0.6)), (-1), (Mth.nextDouble(RandomSource.create(), -0.1, 0.4)), (float) Mth.nextDouble(RandomSource.create(), 1, 3), (float) 0.1);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						found = true;
						break;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}
