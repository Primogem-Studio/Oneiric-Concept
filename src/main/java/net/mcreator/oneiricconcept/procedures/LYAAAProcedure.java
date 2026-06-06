package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.vehicle.MinecartTNT;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.Comparator;
import java.util.ArrayList;

public class LYAAAProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean fire = false;
		String UUIDstr = "";
		Entity target = null;
		Entity playr = null;
		Entity owner = null;
		double scope = 0;
		double distance = 0;
		double distanceEnt = 0;
		distance = 100;
		if (1600 < getEnergyStored(world, BlockPos.containing(x, y - 1, z), null)) {
			scope = 64;
			{
				final Vec3 _center = new Vec3(x, (y + scope / 2), z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(scope / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof Projectile) {
						owner = ((net.minecraft.world.entity.projectile.Projectile) entityiterator).getOwner();
					}
					if ((getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isTnt") && (entityiterator instanceof MinecartTNT || entityiterator instanceof PrimedTnt)
							|| getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isMob") && ((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player || entityiterator instanceof Mob)
									&& entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:fall_damage_immune")))
							|| getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isProj") && entityiterator instanceof Projectile
									&& (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "isPlayProj") || !(owner instanceof Player || owner == null)))
							&& !((entityiterator instanceof LivingEntity _livEnt ? _livEnt.hurtTime : 0) != 0) && entityiterator.isAlive() && !entityiterator.onGround()) {
						distanceEnt = new Vec3(x, y, z).distanceTo(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())));
						if (distanceEnt < distance) {
							distance = distanceEnt;
							target = entityiterator;
							fire = true;
						}
					}
				}
			}
			if (fire) {
				playr = findEntityInWorldRange(world, Player.class, x, y, z, 64);
				if (playr == null) {
					for (Entity entityiterator : new ArrayList<>(world.players())) {
						playr = entityiterator;
					}
				}
				LaserhurtProcedure.execute(world, x + 0.5, y + 0.5, z + 0.5, playr, target, 20);
				if (world instanceof ILevelExtension _ext) {
					IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y - 1, z), null);
					if (_entityStorage != null)
						_entityStorage.extractEnergy(1600, false);
				}
				if (target instanceof Projectile || target instanceof PrimedTnt) {
					if (!target.level().isClientSide())
						target.discard();
				}
			}
		}
	}

	public static int getEnergyStored(LevelAccessor level, BlockPos pos, Direction direction) {
		if (level instanceof ILevelExtension levelExtension) {
			IEnergyStorage energyStorage = levelExtension.getCapability(Capabilities.EnergyStorage.BLOCK, pos, direction);
			if (energyStorage != null)
				return energyStorage.getEnergyStored();
		}
		return 0;
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}