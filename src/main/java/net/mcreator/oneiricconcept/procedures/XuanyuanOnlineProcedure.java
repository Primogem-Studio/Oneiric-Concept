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
		return (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(OneiricconceptModItems.LEGION_PSEUDO_CORE.get())) : false)
				|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(OneiricconceptModItems.XUANYUAN_SWORD.get())) : false) || getEntityGameType(entity) == GameType.CREATIVE;
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
