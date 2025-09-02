package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class XuanyuanOnlineProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return hasEntityInInventory(entity, new ItemStack(OneiricconceptModItems.LEGION_PSEUDO_CORE.get())) || hasEntityInInventory(entity, new ItemStack(OneiricconceptModItems.XUANYUAN_SWORD.get())) || getEntityGameType(entity) == GameType.CREATIVE;
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}