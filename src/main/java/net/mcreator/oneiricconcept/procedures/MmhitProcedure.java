package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class MmhitProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.isClientSide())
			Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(OneiricconceptModItems.MMMHIT.get()));
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FALL)), 1);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u628A\u4F60\u8BBE\u5907\u7838\u4E86\uFF01"), true);
	}
}