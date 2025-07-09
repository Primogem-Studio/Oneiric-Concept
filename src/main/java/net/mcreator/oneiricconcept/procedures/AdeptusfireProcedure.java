package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.LlamaSpit;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModEntities;
import net.mcreator.oneiricconcept.entity.XuanyuanSwordQEntity;
import net.mcreator.oneiricconcept.entity.SkyShatteringLuxArrowEntity;
import net.mcreator.oneiricconcept.entity.ExplosiveEntity;

public class AdeptusfireProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double itemmode = 0;
		itemmode = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("mode");
		if (itemmode == 0) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = initArrowProjectile(new XuanyuanSwordQEntity(OneiricconceptModEntities.XUANYUAN_SWORD_Q.get(), 0, 0, 0, projectileLevel, createArrowWeaponItemStack(projectileLevel, 1, (byte) 5)), entity, 1000, true,
							false, false, AbstractArrow.Pickup.DISALLOWED);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 13, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		} else if (itemmode == 1) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = initArrowProjectile(new SkyShatteringLuxArrowEntity(OneiricconceptModEntities.SKY_SHATTERING_LUX_ARROW.get(), 0, 0, 0, projectileLevel, createArrowWeaponItemStack(projectileLevel, 1, (byte) 32768)),
							entity, 8192, true, false, false, AbstractArrow.Pickup.DISALLOWED);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 13, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		} else if (itemmode == 2) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = initArrowProjectile(new ExplosiveEntity(OneiricconceptModEntities.EXPLOSIVE.get(), 0, 0, 0, projectileLevel, createArrowWeaponItemStack(projectileLevel, 1, (byte) 5)), entity, 5, true, false, false,
							AbstractArrow.Pickup.DISALLOWED);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 7, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		} else if (itemmode == 3) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = OneiricconceptModEntities.ENGINEERING_ANTIMATTER_BOMB.get().spawn(_level,
						new BlockPos(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(160)), ClipContext.Block.VISUAL, ClipContext.Fluid.ANY, entity)).getBlockPos().getX(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(160)), ClipContext.Block.VISUAL, ClipContext.Fluid.ANY, entity)).getBlockPos().getY(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(160)), ClipContext.Block.VISUAL, ClipContext.Fluid.ANY, entity)).getBlockPos().getZ()),
						MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else if (itemmode == 4) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = initProjectileProperties(new LlamaSpit(EntityType.LLAMA_SPIT, projectileLevel), entity, Vec3.ZERO);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 7, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
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

	private static Projectile initProjectileProperties(Projectile entityToSpawn, Entity shooter, Vec3 acceleration) {
		entityToSpawn.setOwner(shooter);
		if (!Vec3.ZERO.equals(acceleration)) {
			entityToSpawn.setDeltaMovement(acceleration);
			entityToSpawn.hasImpulse = true;
		}
		return entityToSpawn;
	}
}
