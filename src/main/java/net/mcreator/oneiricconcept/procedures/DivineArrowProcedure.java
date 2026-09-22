package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModEntities;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;
import net.mcreator.oneiricconcept.entity.SkyShatteringLuxArrowEntity;

public class DivineArrowProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xyz = 0;
		double range = 0;
		boolean found = false;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 1200);
		if (world instanceof ServerLevel _level) {
			itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
			});
		}
		range = 33;
		xyz = Math.round(0 - (range - 1) / 2);
		sx = xyz;
		found = false;
		for (int _i1 = 0; _i1 < (int) range; _i1++) {
			if (found) {
				break;
			}
			sy = xyz;
			for (int _i2 = 0; _i2 < (int) range; _i2++) {
				if (found) {
					break;
				}
				sz = xyz;
				for (int _i3 = 0; _i3 < (int) range; _i3++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == OneiricconceptModBlocks.AMBROSIAL_ARBOR_LEAVE.get()
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == OneiricconceptModBlocks.AMBROSIAL_ARBOR_LOG.get()) {
						found = true;
						break;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		sx = xyz;
		if (found) {
			for (int _i1 = 0; _i1 < (int) range; _i1++) {
				sz = xyz;
				for (int _i2 = 0; _i2 < (int) range; _i2++) {
					if ((index3 + 1) % 3 == 0 && (index4 + 1) % 3 == 0) {
						if (world instanceof ServerLevel projectileLevel) {
							Projectile _entityToSpawn = initArrowProjectile(new SkyShatteringLuxArrowEntity(OneiricconceptModEntities.SKY_SHATTERING_LUX_ARROW.get(), 0, 0, 0, projectileLevel, createArrowWeaponItemStack(projectileLevel, 1, (byte) 0)),
									entity, 5, true, false, false, AbstractArrow.Pickup.DISALLOWED);
							_entityToSpawn.setPos((x + sx), 280, (z + sz));
							_entityToSpawn.shoot(0, (-1), 0, 5, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					sz = sz + 1;
				}
				sx = sx + 1;
			}
		}
	}

	private static AbstractArrow initArrowProjectile(AbstractArrow entityToSpawn, Entity shooter, float damage, boolean silent, boolean fire, boolean particles, AbstractArrow.Pickup pickup) {
		entityToSpawn.setOwner(shooter);
		entityToSpawn.setBaseDamage(damage);
		if (silent)
			entityToSpawn.setSilent(true);
		if (fire)
			entityToSpawn.igniteForSeconds(100);
		if (particles)
			entityToSpawn.setCritArrow(true);
		entityToSpawn.pickup = pickup;
		return entityToSpawn;
	}

	private static ItemStack createArrowWeaponItemStack(Level level, int knockback, byte piercing) {
		ItemStack weapon = new ItemStack(Items.ARROW);
		if (knockback > 0)
			weapon.enchant(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), knockback);
		if (piercing > 0)
			weapon.enchant(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING), piercing);
		return weapon;
	}
}