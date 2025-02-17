package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EntityHurtProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		ItemStack sworditem = ItemStack.EMPTY;
		double swordEnchant = 0;
		double Charge = 0;
		double MaxCharge = 0;
		double range = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		String Changetxt = "";
		sworditem = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
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
					entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK), entity), (float) (swordEnchant * (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_DAMAGEMULTIPLIER))));
					DelayedDamageProcedure.execute(world, new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK), entity), entityiterator,
							(entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity15.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0)
									* (0.168 + swordEnchant * 0.052)
									+ (entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity16.getAttribute(Attributes.MAX_HEALTH).getValue() : 0)
											* (0.418 + swordEnchant * 0.132),
							40);
				}
				ParticleSweepProcedure.execute(world, sx, sy, sz, 20, 5, range * 2);
				{
					final String _tagName = "ShuhuCharge";
					final double _tagValue = 0;
					CustomData.update(DataComponents.CUSTOM_DATA, sworditem, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (("en").equals(Component.translatable("translation.oneiricconcept.check").getString())) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("oneiricconcept:shuhu_en")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("oneiricconcept:shuhu_en")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				} else if (("jp").equals(Component.translatable("translation.oneiricconcept.check").getString())) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("oneiricconcept:shuhu_jp")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("oneiricconcept:shuhu_jp")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				} else if (("kr").equals(Component.translatable("translation.oneiricconcept.check").getString())) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("oneiricconcept:shuhu_kr")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("oneiricconcept:shuhu_kr")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				} else {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("oneiricconcept:shuhu_cn")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("oneiricconcept:shuhu_cn")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(Changetxt), true);
		}
	}
}
