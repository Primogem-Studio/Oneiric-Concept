package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class XuanyuanitemmessageProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity itement) {
		if (entity == null || itement == null)
			return;
		Entity arrowentity = null;
		OneiricconceptMod.queueServerWork(60, () -> {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("item.oneiricconcept.xuanyuan_arrow").getString() + "\uFF1A" + itement)), false);
		});
	}
}