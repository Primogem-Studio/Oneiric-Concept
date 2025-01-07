package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class CloudHeartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		Entity ent = null;
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("mode")) {
			if (!(entity.isShiftKeyDown() && entity.onGround())) {
				if (1 < itemstack.getMaxDamage() - itemstack.getDamageValue()) {
					if (entity.isPassenger()) {
						ent = entity.getVehicle();
						x1 = ent.getX();
						y1 = ent.getY();
						z1 = ent.getZ();
					} else {
						ent = entity;
						x1 = x;
						y1 = y;
						z1 = z;
					}
					if ((world.getBlockState(BlockPos.containing(x1, y1 - 1, z1))).getBlock() == Blocks.AIR) {
						world.setBlock(BlockPos.containing(x1, y1 - 1, z1), OneiricconceptModBlocks.FLOATING_CLOUD.get().defaultBlockState(), 3);
						if (world instanceof ServerLevel _level) {
							itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
					}
				} else {
					{
						final String _tagName = "mode";
						final boolean _tagValue = false;
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
					}
					EnchantmentHelper.updateEnchantments(itemstack,
							mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING))));
				}
			}
		} else if (0 < itemstack.getDamageValue()) {
			if (world instanceof ServerLevel _level) {
				itemstack.hurtAndBreak(-1, _level, null, _stkprov -> {
				});
			}
		}
	}
}
