package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class BowvideoProcedure {
	public static void execute(Entity entity, double amount) {
		if (entity == null)
			return;
		double newAmount = 0;
		double percent = 0;
		if ((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).getItem() == OneiricconceptModItems.MORA_BOW.get()) {
			percent = (entity instanceof LivingEntity _entUseTicks2 ? _entUseTicks2.getTicksUsingItem() : 0) / 20d;
			if (percent > 1d) {
				percent = 1d;
			} else {
				percent = percent * percent;
			}
		}
		newAmount = amount * (1 - percent * 0.15);
		newModifier = newAmount;
	}

	private static double newModifier;

	@EventBusSubscriber
	public static class FovUpdateEventClass {
		@SubscribeEvent
		public static void onFOVUpdateEvent(ComputeFovModifierEvent event) {
			Entity entity = event.getPlayer();
			double amount = event.getFovModifier();
			execute(entity, amount);
			event.setNewFovModifier((float) newModifier);
		}
	}
}