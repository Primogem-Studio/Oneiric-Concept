package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.oneiricconcept.init.OneiricconceptModMobEffects;
import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EntityDeadProcedure {
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
		e1 = entity;
		if (e1 instanceof Player) {
			i1 = new ItemStack(OneiricconceptModItems.OY_STUFFING.get());
			{
				final String _tagName = "entitysname";
				final String _tagValue = (entity.getDisplayName().getString());
				CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putString(_tagName, _tagValue));
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, i1);
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(OneiricconceptModMobEffects.B_2SAUSAGE)) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("oneiricconcept:diseasename_gastriccancer"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		}
		if (RandomProcedure.execute(world, 0.1)) {
			if (e1.getType().is(EntityTypeTags.UNDEAD)) {
				i1 = new ItemStack(OneiricconceptModItems.S_2TUFFING.get());
			} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("c:human")))) {
				i1 = new ItemStack(OneiricconceptModItems.OY_STUFFING.get());
				{
					final String _tagName = "entitysname";
					final String _tagValue = (entity.getDisplayName().getString());
					CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putString(_tagName, _tagValue));
				}
			} else if (entity.getType().is(EntityTypeTags.AQUATIC) && !entity.getPersistentData().getBoolean("fishheart")) {
				if (RandomProcedure.execute(world, 0.1)) {
					i1 = new ItemStack(OneiricconceptModItems.HEARTOFTHEFISH.get());
				} else {
					i1 = new ItemStack(OneiricconceptModItems.FISH.get());
				}
			} else if (entity instanceof EnderMan || entity instanceof Endermite || entity instanceof Shulker) {
				i1 = new ItemStack(OneiricconceptModItems.VIRTUAL_PARTICLE.get());
			} else if (entity instanceof Slime) {
				i1 = new ItemStack(OneiricconceptModItems.SOLID_WATER.get());
			} else if (entity instanceof MagmaCube) {
				i1 = new ItemStack(OneiricconceptModItems.PHLOGISTON.get());
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
