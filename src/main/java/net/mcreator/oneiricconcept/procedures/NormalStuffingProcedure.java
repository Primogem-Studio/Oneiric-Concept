package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.server.level.ServerLevel;

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

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity e1 = null;
		ItemStack i1 = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			e1 = entity;
			if (Math.random() < 0.1) {
				if (e1.getType().is(EntityTypeTags.UNDEAD)) {
					i1 = new ItemStack(OneiricconceptModItems.S_2TUFFING.get());
				} else if (e1 instanceof Player) {
					i1 = new ItemStack(OneiricconceptModItems.OY_STUFFING.get());
				} else {
					i1 = new ItemStack(OneiricconceptModItems.STUFFING.get());
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, i1);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
