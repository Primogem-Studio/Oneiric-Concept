package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.entity.CrystalTurtleEntity;

public class TurtleDamageProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (damagesource == null || entity == null || sourceentity == null)
			return false;
		ItemStack items = ItemStack.EMPTY;
		double Times = 0;
		double timeste = 0;
		boolean Damagetyplgc = false;
		Times = entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_ShrinkingShellTime) : 0;
		timeste = Math.max(Math.min(1200, Times + 600), 600);
		Damagetyplgc = damagesource.is(DamageTypes.FELL_OUT_OF_WORLD) || damagesource.is(DamageTypes.GENERIC_KILL);
		if (!(entity instanceof CrystalTurtleEntity _datEntL3 && _datEntL3.getEntityData().get(CrystalTurtleEntity.DATA_IsCrystallized))) {
			items = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:ysjsj")));
			items.setCount((int) RandomintProcedure.execute(5, 1));
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, items);
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_cluster.break")), SoundSource.NEUTRAL, 3, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_cluster.break")), SoundSource.NEUTRAL, 3, 1, false);
				}
			}
			if (entity instanceof CrystalTurtleEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CrystalTurtleEntity.DATA_crystal, 24000);
			if (entity instanceof CrystalTurtleEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CrystalTurtleEntity.DATA_IsCrystallized, true);
			if (entity instanceof CrystalTurtleEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CrystalTurtleEntity.DATA_ShrinkingShellTime, (int) timeste);
			if (entity instanceof CrystalTurtleEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CrystalTurtleEntity.DATA_IsShrinking, true);
			if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u6C34\u6676\u65F6\u95F4\uFF1A\u00A7b" + (entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_crystal) : 0)
							+ "\u00A7r\u7F29\u58F3\u65F6\u95F4\uFF1A\u00A79" + (entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_ShrinkingShellTime) : 0)
							+ "\u00A7r\u4F24\u5BB3\u903B\u8F91\uFF1A\u00A7a" + Damagetyplgc + "\u00A7r\u4F24\u5BB3\uFF1A\u00A74" + damagesource)), false);
			}
			return Times <= 0 || Damagetyplgc;
		}
		if (entity instanceof CrystalTurtleEntity _datEntSetI)
			_datEntSetI.getEntityData().set(CrystalTurtleEntity.DATA_ShrinkingShellTime, (int) timeste);
		if (entity instanceof CrystalTurtleEntity _datEntSetL)
			_datEntSetL.getEntityData().set(CrystalTurtleEntity.DATA_IsShrinking, true);
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u6C34\u6676\u65F6\u95F4\uFF1A\u00A7b" + (entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_crystal) : 0)
						+ "\u00A7r\u7F29\u58F3\u65F6\u95F4\uFF1A\u00A79" + (entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_ShrinkingShellTime) : 0)
						+ "\u00A7r\u4F24\u5BB3\u903B\u8F91\uFF1A\u00A7a" + Damagetyplgc + "\u00A7r\u4F24\u5BB3\uFF1A\u00A74" + damagesource)), false);
		}
		return Damagetyplgc || !ShrinkingShellSuoKeProcedure.execute(entity);
	}
}
