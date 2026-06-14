package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.oneiricconcept.init.OneiricconceptModMenus;

public class VastseaCheckProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack vastsea = ItemStack.EMPTY;
		vastsea = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		{
			final String _tagName = "dolphin";
			final boolean _tagValue = ((entity instanceof Player _entity1 && _entity1.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu1) && _menu1.getMenuState(1, "dolphin", false));
			CustomData.update(DataComponents.CUSTOM_DATA, vastsea, tag -> tag.putBoolean(_tagName, _tagValue));
		}
		{
			final String _tagName = "fire";
			final boolean _tagValue = ((entity instanceof Player _entity3 && _entity3.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu3) && _menu3.getMenuState(1, "fire", false));
			CustomData.update(DataComponents.CUSTOM_DATA, vastsea, tag -> tag.putBoolean(_tagName, _tagValue));
		}
		{
			final String _tagName = "energy";
			final double _tagValue = ((entity instanceof Player _entity5 && _entity5.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu5) ? _menu5.getMenuState(2, "energy", 0.0) : 0.0);
			CustomData.update(DataComponents.CUSTOM_DATA, vastsea, tag -> tag.putDouble(_tagName, _tagValue));
		}
		{
			final String _tagName = "conduit";
			final double _tagValue = ((entity instanceof Player _entity7 && _entity7.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu7) ? _menu7.getMenuState(2, "conduit", 0.0) : 0.0);
			CustomData.update(DataComponents.CUSTOM_DATA, vastsea, tag -> tag.putDouble(_tagName, _tagValue));
		}
	}
}