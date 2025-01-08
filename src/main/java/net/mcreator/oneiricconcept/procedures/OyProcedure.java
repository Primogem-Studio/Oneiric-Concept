package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class OyProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String name = "";
		if (Math.random() < 0.3) {
			if (itemstack.getItem() == OneiricconceptModItems.OY_STUFFING.get()) {
				ZiRanProcedure.execute(entity);
			} else if (itemstack.getItem() == OneiricconceptModItems.OY_DUMPLING.get()) {
				ZiRanLoseProcedure.execute(entity);
			}
		}
		name = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("die");
		if (!(name).isEmpty()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((name + "" + Component.translatable("translation.oneiricconcept.tastes").getString())), true);
		}
		Health100Procedure.execute(entity, 0.3);
	}
}
