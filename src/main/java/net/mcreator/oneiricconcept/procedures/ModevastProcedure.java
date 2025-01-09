package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

public class ModevastProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double itemmode = 0;
		if (entity.isShiftKeyDown()
				&& !(entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
								(entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE) ? _livingEntity1.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getValue() : 0))),
								ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getType() == HitResult.Type.BLOCK)) {
			itemmode = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("mode");
			if (itemmode < 3) {
				itemmode = itemmode + 1;
				itemstack.set(DataComponents.CUSTOM_NAME,
						Component.literal((new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH)))).getDisplayName().getString())));
			} else {
				itemmode = 0;
			}
			{
				final String _tagName = "mode";
				final double _tagValue = itemmode;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
	}
}
