package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.component.DataComponents;

import net.mcreator.oneiricconcept.init.OneiricconceptModMobEffects;

import java.util.Comparator;

public class StardustbaseballerHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double Refinement = 0;
		double sz = 0;
		double sy = 0;
		double sx = 0;
		double range = 0;
		double MaxCharge = 0;
		double Charge = 0;
		double swordEnchant = 0;
		ItemStack hitItem = ItemStack.EMPTY;
		ItemStack sworditem = ItemStack.EMPTY;
		String Changetxt = "";
		hitItem = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		Refinement = GetDoubleNBTTagProcedure.execute(hitItem, "jing_lian");
		if (hitItem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Charged_L")) {
			{
				final String _tagName = "Charged_L";
				final boolean _tagValue = false;
				CustomData.update(DataComponents.CUSTOM_DATA, hitItem, tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(Refinement / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (IsEntityDamageProcedure.execute(world, sourceentity, entityiterator)) {
						entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK), sourceentity),
								(float) ((entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity3.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0) * 0.625));
					}
				}
			}
		}
		if (RandomProcedure.execute(world, 0.04 + Refinement * 0.01)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(OneiricconceptModMobEffects.TARGETOFFSET, 60, (int) (16 + Refinement * 4), false, false));
		}
	}
}
