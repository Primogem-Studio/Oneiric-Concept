package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class RIPHomeRunProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double itemmode = 0;
		if (entity.isShiftKeyDown()
				&& !(entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
								(entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE) ? _livingEntity1.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getValue() : 0))),
								ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getType() == HitResult.Type.BLOCK)) {
			WeaponclickProcedure.execute(world, x, y, z, entity, itemstack, true, 100);
		}
	}
}