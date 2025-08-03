package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class OyProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String name = "";
		name = OynameProcedure.execute(itemstack);
		if (itemstack.getItem() == OneiricconceptModItems.OY_STUFFING.get()) {
			if (RandomProcedure.execute(world, 0.3)) {
				BebuffplusProcedure.execute(world, entity);
			}
			Health100Procedure.execute(entity, 0.1);
		} else if (itemstack.getItem() == OneiricconceptModItems.OY_DUMPLING.get()) {
			if (RandomProcedure.execute(world, 0.3)) {
				DebuffProcedure.execute(entity);
			}
			Health100Procedure.execute(entity, 0.2);
		} else {
			Health100Procedure.execute(entity, 0.3);
		}
		if (!(name).isEmpty()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((name + "" + Component.translatable("translation.oneiricconcept.tastes").getString())), false);
		}
	}
}