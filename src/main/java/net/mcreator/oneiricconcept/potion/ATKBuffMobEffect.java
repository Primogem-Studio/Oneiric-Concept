
package net.mcreator.oneiricconcept.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class ATKBuffMobEffect extends MobEffect {
	public ATKBuffMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13369345);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(OneiricconceptMod.MODID, "effect.atk_buff_0"), 0.01, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}
