package net.mcreator.oneiricconcept.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class SustenanceanchorHealthProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double health = 0;
		double maxhealth = 0;
		double rehealth = 0;
		double Magnification = 0;
		double hreserve = 0;
		String txt = "";
		String hre = "";
		txt = "";
		health = entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
		maxhealth = entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1;
		hreserve = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "healthreserve");
		if (ModList.get().isLoaded("genshincraft")) {
			Magnification = 32;
		} else {
			Magnification = 1;
		}
		if (health / maxhealth < 0.35) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) (0.35 * maxhealth));
			txt = Component.translatable("translation.oneiricconcept.sustenance").getString();
		}
		if (hreserve < 200 * Magnification && health < maxhealth) {
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
		hreserve = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "healthreserve");
		if (hreserve < 200 * Magnification) {
			hre = "\u00A72" + new java.text.DecimalFormat("##.##").format(200 * Magnification - hreserve);
		} else {
			hre = "\u00A74" + new java.text.DecimalFormat("##.##").format(200 * Magnification - hreserve);
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((txt + "" + Component.translatable("translation.oneiricconcept.sustenance2").getString() + hre)), true);
	}
}
