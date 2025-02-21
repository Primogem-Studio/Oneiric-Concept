package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class AntimatterLegionLootProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		ItemStack itmsstk = ItemStack.EMPTY;
		double EquilibriumLevel = 0;
		if (sourceentity instanceof Player) {
			EquilibriumLevel = sourceentity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).jun_heng / 5;
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + EquilibriumLevel)), false);
			if (0 < EquilibriumLevel) {
				for (int index0 = 0; index0 < (int) EquilibriumLevel; index0++) {
					if (RandomProcedure.execute(world, 0.2 * EquilibriumLevel)) {
						itmsstk = (RandomProcedure.execute(world, 0.1 * EquilibriumLevel) ? new ItemStack(OneiricconceptModItems.CONQUEROR_S_WILL.get()) : new ItemStack(OneiricconceptModItems.USURPER_S_SCHEME.get()));
					} else {
						itmsstk = new ItemStack(OneiricconceptModItems.THIEF_S_INSTINCT.get());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itmsstk);
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
