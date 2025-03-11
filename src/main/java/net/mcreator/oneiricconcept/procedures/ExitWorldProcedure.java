package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.world.inventory.LibGuiMenu;
import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

import javax.annotation.Nullable;

import java.util.ArrayList;

@EventBusSubscriber
public class ExitWorldProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			{
				OneiricconceptModVariables.PlayerVariables _vars = entityiterator.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
				_vars.ListOrder = 0;
				_vars.syncPlayerVariables(entityiterator);
			}
			if (entityiterator instanceof Player _plr0 && _plr0.containerMenu instanceof LibGuiMenu) {
				if (entityiterator instanceof Player _player)
					_player.closeContainer();
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + "" + Component.translatable("translation.oneiricconcept.exitworld").getString())), true);
			}
		}
	}
}
