package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.ItemFishedEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OcRodFishProcedure {
	@SubscribeEvent
	public static void onPlayerFishItem(ItemFishedEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("oneiricconcept:rod"))) && RandomProcedure.execute(world, 0.3)) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(
						(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("oneiricconcept:fish"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}