package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

import java.util.Comparator;

public class SustenanceanchorHealthProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String txt = "";
		String hre = "";
		boolean fight = false;
		double health = 0;
		double maxhealth = 0;
		double rehealth = 0;
		double Magnification = 0;
		double hreserve = 0;
		double sav = 0;
		if (!world.isClientSide()) {
			txt = "";
			health = entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
			maxhealth = entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1;
			hreserve = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "healthreserve");
			Magnification = (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_HEALTHMULTIPLIER));
			sav = 200 * Magnification;
			fight = false;
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(13 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entity == (entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
						fight = true;
					}
				}
			}
			if (fight) {
				txt = Component.translatable("translation.oneiricconcept.fight").getString();
			}
			if (!fight) {
				if (health / maxhealth < 0.35) {
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (0.35 * maxhealth));
					txt = Component.translatable("translation.oneiricconcept.sustenance").getString();
				}
				if (hreserve < sav && health < maxhealth) {
					rehealth = maxhealth - health;
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble("healthreserve", (hreserve + rehealth));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) maxhealth);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HEART, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 20, 0.2, 0.4, 0.2, 0.1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.levelup")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.levelup")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				}
			} else {
				ErrorerrProcedure.execute(world, x + 0.5, y + 0.5, z + 0.5);
			}
			hreserve = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "healthreserve");
			if (hreserve < sav) {
				hre = "\u00A72" + new java.text.DecimalFormat("##.##").format(sav - hreserve);
			} else {
				hre = "\u00A74" + new java.text.DecimalFormat("##.##").format(sav - hreserve);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((txt + "" + Component.translatable("translation.oneiricconcept.sustenance2").getString() + hre)), true);
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}
