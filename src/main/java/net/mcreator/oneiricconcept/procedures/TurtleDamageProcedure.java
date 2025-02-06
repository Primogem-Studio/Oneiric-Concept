package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.entity.CrystalTurtleEntity;

public class TurtleDamageProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (damagesource == null || entity == null || sourceentity == null)
			return false;
		ItemStack items = ItemStack.EMPTY;
		double Times = 0;
		Times = entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_ShrinkingShellTime) : 0;
		if (!(entity instanceof CrystalTurtleEntity _datEntL1 && _datEntL1.getEntityData().get(CrystalTurtleEntity.DATA_IsCrystallized))) {
			items = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:ysjsj")));
			items.setCount((int) RandomintProcedure.execute(5, 1));
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, items);
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (entity instanceof CrystalTurtleEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CrystalTurtleEntity.DATA_crystal, 1200);
			if (entity instanceof CrystalTurtleEntity _datEntSetL)
				_datEntSetL.getEntityData().set(CrystalTurtleEntity.DATA_IsCrystallized, true);
			if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u6C34\u6676\u65F6\u95F4\uFF1A\u00A7b" + (entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_crystal) : 0)
							+ "\u00A7r\u7F29\u58F3\u65F6\u95F4\uFF1A\u00A79" + (entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_ShrinkingShellTime) : 0))), false);
			}
			return Times <= 0;
		}
		if (entity instanceof CrystalTurtleEntity _datEntSetI)
			_datEntSetI.getEntityData().set(CrystalTurtleEntity.DATA_ShrinkingShellTime, (int) Math.max(Math.min(1200, Times + 600), 600));
		if (entity instanceof CrystalTurtleEntity _datEntSetL)
			_datEntSetL.getEntityData().set(CrystalTurtleEntity.DATA_IsShrinking, true);
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u6C34\u6676\u65F6\u95F4\uFF1A\u00A7b" + (entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_crystal) : 0)
						+ "\u00A7r\u7F29\u58F3\u65F6\u95F4\uFF1A\u00A79" + (entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_ShrinkingShellTime) : 0))), false);
		}
		return !ShrinkingShellSuoKeProcedure.execute(entity) || damagesource.is(DamageTypes.GENERIC_KILL) || damagesource.is(DamageTypes.FELL_OUT_OF_WORLD);
	}
}
