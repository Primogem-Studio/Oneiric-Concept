package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

public class TraverseBackPacProcedure {
	public static ItemStack execute(LevelAccessor world, Entity entity, ItemStack items, String itemtag) {
		if (entity == null || itemtag == null)
			return ItemStack.EMPTY;
		ItemStack zpitem = ItemStack.EMPTY;
		double index1 = 0;
		String msg = "";
		msg = "\u83B7\u53D6\u7684\u7269\u54C1\u4E3A\u00A76" + items + "\n" + "\u83B7\u53D6\u7684tag\u4E3A\u00A76" + itemtag;
		for (int index0 = 0; index0 < 37; index0++) {
			index1 = index0 - 1;
			zpitem = (index0 == 0
					? (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)
					: (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1 ? _modHandler1.getStackInSlot((int) index1).copy() : ItemStack.EMPTY));
			if (zpitem.getItem() == items.getItem() || zpitem.is(ItemTags.create(ResourceLocation.parse((itemtag).toLowerCase(java.util.Locale.ENGLISH))))) {
				if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
					msg = "\u5728\u00A76" + index0 + "\u00A7r\u6B21\u540E\u8DF3\u51FA\u5FAA\u73AF\uFF0C\u69FD\u4F4D\u4E3A" + index1;
				}
				break;
			}
			if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
				msg = msg + "\n" + "\u69FD\u4F4D" + index1 + "\u7269\u54C1\u4FE1\u606F\u4E3A" + zpitem;
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((msg + "\n" + "\u8FD4\u56DE\u5185\u5BB9\u4E3A\uFF1A\u00A76" + zpitem)), false);
		}
		return zpitem;
	}
}