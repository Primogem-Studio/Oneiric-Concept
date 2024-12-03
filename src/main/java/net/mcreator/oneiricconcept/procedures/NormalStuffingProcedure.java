package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.EntityTypeTags;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class NormalStuffingProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		return execute(null, world, x, y, z, entity);
	}

	private static boolean execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		double n1 = 0;
		Entity e1 = null;
		e1 = entity;
		n1 = 0.05;
		if (RouxiandiaoluoProcedure.execute(world, x, y, z, new ItemStack(OneiricconceptModItems.S_2TUFFING.get()), e1.getType().is(EntityTypeTags.UNDEAD), n1)) {
			return true;
		} else if (RouxiandiaoluoProcedure.execute(world, x, y, z, new ItemStack(OneiricconceptModItems.OY_STUFFING.get()), e1 instanceof Player, n1)) {
			return true;
		} else if (RouxiandiaoluoProcedure.execute(world, x, y, z, new ItemStack(OneiricconceptModItems.STUFFING.get()), e1.getType().is(EntityTypeTags.UNDEAD), n1)) {
			return true;
		}
		return false;
	}
}
