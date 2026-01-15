package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

public class SkipingProcedure {
	public static double execute(LevelAccessor world, Entity entity, ItemStack itemstack, double index, double times, String tagname) {
		if (entity == null || tagname == null)
			return 0;
		double ktime = 0;
		double index1 = 0;
		ktime = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble(tagname);
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u5728\u683C\uFF1A" + index + "\u6709\u53EF\u8DF3\u8FC7\u7269\u54C1\u65F6\u95F4\u4E3A\uFF1A" + ktime)), false);
		}
		while (ktime < times) {
			ktime = ktime + 1200;
			{
				final String _tagName = tagname;
				final double _tagValue = ktime;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			index1 = index1 + itemstack.getCount();
		}
		{
			final String _tagName = tagname;
			final double _tagValue = times;
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
		}
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
			ItemStack _setstack = itemstack.copy();
			_setstack.setCount(itemstack.getCount());
			_modHandler.setStackInSlot((int) index, _setstack);
		}
		return index1;
	}
}