package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.init.OneiricconceptModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CamoAtkProcedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
		execute(event, event.getOriginalAboutToBeSetTarget(), event.getEntity());
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(OneiricconceptModMobEffects.CAMO)) {
			if (sourceentity instanceof Mob _entity1)
				_entity1.setTarget(null);
		}
	}
}