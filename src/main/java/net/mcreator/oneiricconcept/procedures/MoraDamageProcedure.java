package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class MoraDamageProcedure {
	public static void execute(LevelAccessor world) {
		if (world instanceof ServerLevel _level) {
			new ItemStack(OneiricconceptModItems.MORA_MAGAZINE.get()).hurtAndBreak(1, _level, null, _stkprov -> {
			});
		}
	}
}
