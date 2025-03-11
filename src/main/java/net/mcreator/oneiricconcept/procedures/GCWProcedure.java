package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;
import net.mcreator.oneiricconcept.init.OneiricconceptModItems;
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
		{
			OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
			_vars.ListOrder = 0;
			_vars.syncPlayerVariables(entity);
		}
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCINITIALLOAD) && ModList.get().isLoaded("genshincraft")) {
			world.getLevelData().getGameRules().getRule(OneiricconceptModGameRules.OC_DAMAGEMULTIPLIER).set(4, world.getServer());
			world.getLevelData().getGameRules().getRule(OneiricconceptModGameRules.OC_HEALTHMULTIPLIER).set(32, world.getServer());
		} else if (!world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCINITIALLOAD)
				&& ((world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_DAMAGEMULTIPLIER)) < 4 || (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_HEALTHMULTIPLIER)) < 32)
				&& ModList.get().isLoaded("genshincraft")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("translation.oneiricconcept.Configurationreminder").getString())), false);
		}
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(OneiricconceptModItems.ADEPTUSTOOL.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(OneiricconceptModItems.ADEPTUS_GUN.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		world.getLevelData().getGameRules().getRule(OneiricconceptModGameRules.OCINITIALLOAD).set(false, world.getServer());
	}
}
