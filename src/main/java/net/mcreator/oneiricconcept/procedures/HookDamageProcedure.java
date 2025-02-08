package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.OneiricconceptMod;

import java.util.Comparator;
import java.util.Calendar;

public class HookDamageProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity hookent = null;
		Entity Damageent = null;
		ItemStack itmstk = ItemStack.EMPTY;
		String debugtest = "";
		itmstk = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		if (!(itmstk.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("oneiricconcept:sharp_hook")))) != 0)) {
			itmstk = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
		}
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			debugtest = "\u4F7F\u7528\u7269\u54C1" + itmstk + "\u6709\u9644\u9B54\u00A75"
					+ (itmstk.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("oneiricconcept:sharp_hook")))) != 0) + "\u7B49\u7EA7\u00A7a"
					+ itmstk.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("oneiricconcept:sharp_hook"))));
			OneiricconceptMod.LOGGER.debug(debugtest);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(debugtest), false);
		}
		if (itmstk.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("oneiricconcept:sharp_hook")))) != 0) {
			while (true) {
				if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u7B49\u5F85\u94A9\u5B50" + Calendar.getInstance().getTime().toString())), false);
					OneiricconceptMod.LOGGER.debug(("\u7B49\u5F85\u94A9\u5B50" + Calendar.getInstance().getTime().toString()));
				}
				if (!world.getEntitiesOfClass(FishingHook.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
					hookent = (Entity) world.getEntitiesOfClass(FishingHook.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null);
					break;
				}
			}
			while (true) {
				if (hookent.isPassenger() || hookent.isInWaterOrBubble() || hookent.isInWall() || hookent.onGround()) {
					if (hookent.isPassenger()) {
						Damageent = hookent.getVehicle();
					}
					break;
				}
				if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u94A9\u5B50\u5224\u5B9A" + Calendar.getInstance().getTime().toString())), false);
					OneiricconceptMod.LOGGER.debug(("\u94A9\u5B50\u5224\u5B9A" + Calendar.getInstance().getTime().toString()));
				}
			}
			if ((Damageent.getType().is(EntityTypeTags.UNDEAD) || Damageent.getType().is(EntityTypeTags.AQUATIC)) && Damageent.isInWaterOrBubble()) {
				while (hookent.isPassenger()) {
					Damageent.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK), entity), (float) (5 * (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_HEALTHMULTIPLIER))
							* itmstk.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("oneiricconcept:sharp_hook"))))));
					if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
						OneiricconceptMod.LOGGER.debug(("\u94A9\u5B50\u4F24\u5BB3" + Calendar.getInstance().getTime().toString()));
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u94A9\u5B50\u4F24\u5BB3" + Calendar.getInstance().getTime().toString())), false);
					}
				}
			}
		}
	}
}
