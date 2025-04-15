package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.OneiricconceptMod;

import javax.annotation.Nullable;

import java.util.Comparator;

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
		String Changetxt = "";
		ItemStack sworditem = ItemStack.EMPTY;
		ItemStack hitItem = ItemStack.EMPTY;
		double swordEnchant = 0;
		double Charge = 0;
		double MaxCharge = 0;
		double range = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double Refinement = 0;
		sworditem = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		hitItem = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		Refinement = GetDoubleNBTTagProcedure.execute(hitItem, "jing_lian");
		if (sworditem.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("oneiricconcept:shuhu_gift")))) != 0) {
			swordEnchant = sworditem.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("oneiricconcept:shuhu_gift"))));
			Charge = sworditem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ShuhuCharge") + 1;
			range = 5 + swordEnchant * 2;
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
				{
					final Vec3 _center = new Vec3(sx, sy, sz);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(range / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (IsEntityDamageProcedure.execute(world, entity, entityiterator)) {
							OneiricconceptMod.queueServerWork(1, () -> {
								entityiterator.hurt(ElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK), entity), true, false, true, true, 6, 1),
										(world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_DAMAGEMULTIPLIER)));
							});
							DelayedDamageProcedure.execute(world, ElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK), entity), true, false, true, true, 6, 1), entityiterator,
									(entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity17.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0)
											* (0.2 + swordEnchant * 0.068)
											+ (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity18.getAttribute(Attributes.MAX_HEALTH).getValue() : 0)
													* (0.33 + swordEnchant * 0.07),
									40);
						}
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
		if ((BuiltInRegistries.ITEM.getKey(hitItem.getItem()).toString()).equals("oneiricconcept:stardust_baseballer") && hitItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Charged_R")) {
			if (event instanceof LivingIncomingDamageEvent _hurt) {
				_hurt.setAmount((float) (amount * (3 + Refinement * 0.75)));
			}
			{
				final String _tagName = "textures";
				final double _tagValue = 0;
				CustomData.update(DataComponents.CUSTOM_DATA, hitItem, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "Charged_R";
				final boolean _tagValue = false;
				CustomData.update(DataComponents.CUSTOM_DATA, hitItem, tag -> tag.putBoolean(_tagName, _tagValue));
			}
		}
	}
}
