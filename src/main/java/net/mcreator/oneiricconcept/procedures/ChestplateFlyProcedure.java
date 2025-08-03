package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ChestplateFlyProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static boolean execute(LevelAccessor world, Entity entity) {
		return execute(null, world, entity);
	}

	private static boolean execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		boolean flylgc = false;
		if (!world.isClientSide()) {
			if ((BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()).toString()).contains("oneiricconcept:phlogiston_wing")) {
				entity.getPersistentData().putBoolean("ocfly", true);
			} else {
				entity.getPersistentData().putBoolean("ocfly", false);
			}
			flylgc = entity.getPersistentData().getBoolean("ocfly") && entity.getPersistentData().getBoolean("ocflyon");
			if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCFLY)) {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayfly = (flylgc || getEntityGameType(entity) == GameType.CREATIVE || getEntityGameType(entity) == GameType.SPECTATOR);
					_player.onUpdateAbilities();
				}
			}
		}
		return flylgc;
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