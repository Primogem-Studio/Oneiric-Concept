package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

public class IscrystalsProcedure {
	public static boolean execute(LevelAccessor world, ItemStack itemstack) {
		double pow = 0;
		pow = CrystalgeneratorListProcedure.execute(itemstack);
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u7269\u54C1 " + itemstack + "\u7684\u80FD\u91CF\u503C\u4E3A" + pow)), false);
		}
		return pow <= 0;
	}
}
