package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EntityHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double swordEnchant = 0;
		double Charge = 0;
		double MaxCharge = 0;
		double range = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		String Changetxt = "";
		ItemStack sworditem = ItemStack.EMPTY;
		ItemStack hitItem = ItemStack.EMPTY;
		sworditem = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		hitItem = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		if (sworditem.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("oneiricconcept:shuhu_gift")))) != 0) {
			swordEnchant = sworditem.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("oneiricconcept:shuhu_gift"))));
			Charge = sworditem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ShuhuCharge") + 1;
			range = 5 + swordEnchant;
			sx = sourceentity.getX();
			sy = sourceentity.getY();
			sz = sourceentity.getZ();
			{
				final String _tagName = "ShuhuCharge";
				final double _tagValue = Charge;
				CustomData.update(DataComponents.CUSTOM_DATA, sworditem, tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (swordEnchant < 5) {
				MaxCharge = 5;
			} else {
				MaxCharge = 4;
			}
			Changetxt = "\u00A72";
			for (int index0 = 0; index0 < (int) Charge; index0++) {
				Changetxt = Changetxt + "\u25C6";
			}
			Changetxt = Changetxt + "\u00A7r";
			for (int index1 = 0; index1 < (int) (MaxCharge - Charge); index1++) {
				Changetxt = Changetxt + "\u25C7";
			}
			if (Charge >= MaxCharge) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * swordEnchant * 0.5 + (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)));
				Changetxt = Component.translatable("translation.oneiricconcept.shuhu").getString();
				for (Entity entityiterator : world.getEntities(entity, new AABB((sx + range), (sy + range), (sz + range), (sx - range), (sy - range), (sz - range)))) {
					if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.FRIENDSHIP_MODE) && entityiterator instanceof Player || entity == (entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)
							|| entityiterator instanceof Monster) {
						entityiterator.hurt(ElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK), entity), true, false, true, true, 6, 1), (float) swordEnchant);
						DelayedDamageProcedure.execute(world, ElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK), entity), true, false, true, true, 6, 1), entityiterator,
								(entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity20.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0)
										* (0.168 + swordEnchant * 0.052)
										+ (entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity21.getAttribute(Attributes.MAX_HEALTH).getValue() : 0)
												* (0.418 + swordEnchant * 0.132),
								40);
					}
				}
				ParticleSweepProcedure.execute(world, sx, sy, sz, 20, 5, range * 2);
				{
					final String _tagName = "ShuhuCharge";
					final double _tagValue = 0;
					CustomData.update(DataComponents.CUSTOM_DATA, sworditem, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(Changetxt), true);
		}
		if (hitItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("FarewellHit")) {
			if (event instanceof LivingIncomingDamageEvent _hurt) {
				_hurt.setAmount((float) (amount * (3 + hitItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian") * 0.75)));
			}
			{
				final String _tagName = "FarewellHit";
				final boolean _tagValue = false;
				CustomData.update(DataComponents.CUSTOM_DATA, hitItem, tag -> tag.putBoolean(_tagName, _tagValue));
			}
		}
	}
}
