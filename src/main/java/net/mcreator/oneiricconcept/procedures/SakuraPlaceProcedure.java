package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.registries.Registries;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.init.OneiricconceptModEntities;
import net.mcreator.oneiricconcept.entity.XuanyuanQ2Entity;
import net.mcreator.oneiricconcept.OneiricconceptMod;

import java.util.Comparator;

public class SakuraPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack items = ItemStack.EMPTY;
		double xx = 0;
		double zz = 0;
		double rang = 0;
		double cyc = 0;
		if (entity.isShiftKeyDown()) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 2000);
			rang = 32;
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(33 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entity instanceof Mob) {
						SakuraTreeProcedure.execute(world, entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), entity);
					}
				}
			}
			for (int index0 = 0; index0 < (int) (100 - cyc); index0++) {
				xx = x + Mth.nextInt(RandomSource.create(), (int) (0 - rang), (int) rang);
				zz = z + Mth.nextInt(RandomSource.create(), (int) (0 - rang), (int) rang);
				SakuraTreeProcedure.execute(world, xx, y, zz, entity);
			}
			OneiricconceptMod.queueServerWork(40, () -> {
				ItemTpProcedure.execute(world, x, y, z, entity, 64);
			});
		} else {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 1200);
			for (int index1 = 0; index1 < 10; index1++) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = initArrowProjectile(new XuanyuanQ2Entity(OneiricconceptModEntities.XUANYUAN_Q_2.get(), 0, 0, 0, projectileLevel, createArrowWeaponItemStack(projectileLevel, 1, (byte) 10)), entity,
								(world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_DAMAGEMULTIPLIER)) * 5, true, false, false, AbstractArrow.Pickup.DISALLOWED);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 10);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
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