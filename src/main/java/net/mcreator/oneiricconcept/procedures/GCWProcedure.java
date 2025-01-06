package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GCWProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCINITIALLOAD) && ModList.get().isLoaded("genshincraft")) {
			world.getLevelData().getGameRules().getRule(OneiricconceptModGameRules.OC_DAMAGEMULTIPLIER).set((int) 3.2, world.getServer());
			world.getLevelData().getGameRules().getRule(OneiricconceptModGameRules.OC_HEALTHMULTIPLIER).set(32, world.getServer());
		} else if (!world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCINITIALLOAD)
				&& ((world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_HEALTHMULTIPLIER)) < 3.2 || (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_DAMAGEMULTIPLIER)) < 32)
				&& ModList.get().isLoaded("genshincraft")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("translation.oneiricconcept.Configurationreminder").getString())), false);
		}
		world.getLevelData().getGameRules().getRule(OneiricconceptModGameRules.OCINITIALLOAD).set(false, world.getServer());
	}
}
