package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

public class ExtractStartProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double sx = 0;
		double sz = 0;
		double maxy = 0;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (getEntityGameType(entity) == GameType.CREATIVE || world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG) ? 10 : 3600));
		sx = -20;
		for (int index0 = 0; index0 < 41; index0++) {
			sz = -20;
			for (int index1 = 0; index1 < 41; index1++) {
				maxy = Math.max(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (x + sx), (int) (z + sz)), maxy);
				sz = sz + 1;
			}
			sx = sx + 1;
		}
		ExtractWoodProcedure.execute(world, x, maxy, z, entity);
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