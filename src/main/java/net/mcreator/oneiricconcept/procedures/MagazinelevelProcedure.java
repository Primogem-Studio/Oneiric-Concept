package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

public class MagazinelevelProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return InteractionResult.PASS;
		ItemStack bulletitem = ItemStack.EMPTY;
		double nu = 0;
		String Primogem = "";
		String level = "";
		String name = "";
		String mora1 = "";
		String mora2 = "";
		String mora3 = "";
		String bullename = "";
		boolean itemlogic = false;
		level = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("level");
		bulletitem = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
		bullename = BuiltInRegistries.ITEM.getKey(bulletitem.getItem()).toString();
		Primogem = "primogemcraft:";
		mora1 = Primogem + "mmola_01";
		mora2 = Primogem + "jinzhimola";
		mora3 = Primogem + "mljnb";
		if ((bullename).equals(mora1) || (bullename).equals(mora2) || (bullename).equals(mora3)) {
			if (!((level).equals(mora1) || (level).equals(mora2) || (level).equals(mora3))) {
				level = bullename;
				{
					final String _tagName = "level";
					final String _tagValue = level;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
				}
				name = itemstack.getDisplayName().getString();
				if ((level).equals(mora1)) {
					name = name + "\u2666";
					nu = 1;
				} else if ((level).equals(mora2)) {
					name = "\u00A7b" + name + "\u2666\u2666";
					nu = 2;
				} else {
					name = "\u00A76" + name + "\u2666\u2666\u2666";
					nu = 3;
				}
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(name));
				{
					final String _tagName = "textures";
					final double _tagValue = nu;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				bulletitem.shrink(1);
				itemstack.setDamageValue((int) (itemstack.getMaxDamage() - 1));
				return InteractionResult.SUCCESS;
			}
			bulletitem.shrink(1);
			if ((bullename).equals(level) && 0 < itemstack.getDamageValue()) {
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(-1, _level, null, _stkprov -> {
					});
				}
			} else {
				bulletitem = (bulletitem.copy());
				bulletitem.setCount(1);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, bulletitem);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
		return InteractionResult.SUCCESS;
	}
}
