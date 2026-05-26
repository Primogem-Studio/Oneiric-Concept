package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
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
		double dx = 0;
		double dz = 0;
		double scope = 0;
		Entity target = null;
		Entity playr = null;
		String UUIDstr = "";
		if (1600 < getEnergyStored(world, BlockPos.containing(x, y - 1, z), null)) {
			UUIDstr = getBlockNBTString(world, BlockPos.containing(x, y, z), "tgtUUID");
			scope = 64;
			{
				final Vec3 _center = new Vec3(x, (y + scope / 2), z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(scope / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if ((((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player || entityiterator instanceof Mob)
							&& entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("minecraft:fall_damage_immune"))) || entityiterator instanceof Projectile) && !UUIDstr.contains(entityiterator.getStringUUID())) {
						target = entityiterator;
						fire = true;
					}
				}
			}
			if ((world.getLevelData().getGameTime()) % 10 == 0) {
				UUIDstr = "";
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
				if (target instanceof Projectile) {
					if (!target.level().isClientSide())
						target.discard();
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putString("tgtUUID", (UUIDstr + "/" + target.getStringUUID()));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
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

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}