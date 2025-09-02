package net.mcreator.oneiricconcept.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.procedures.BrilliantValorProcedure;
import net.mcreator.oneiricconcept.procedures.BrilliantValorBuffProcedure;
import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

import java.util.List;

public class SwordOfBrilliantValorItem extends SwordItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 100;
		}

		@Override
		public float getSpeed() {
			return 4f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_IRON_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 30;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(new ItemStack(OneiricconceptModItems.MEMORY_BUBBLE.get()));
		}
	};

	public SwordOfBrilliantValorItem() {
		super(TOOL_TIER, new Item.Properties().attributes(SwordItem.createAttributes(TOOL_TIER, 3f, 2f)).fireResistant());
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		BrilliantValorProcedure.execute(world, entity);
		return ar;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.oneiricconcept.sword_of_brilliant_valor.description_0"));
		list.add(Component.translatable("item.oneiricconcept.sword_of_brilliant_valor.description_1"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			BrilliantValorBuffProcedure.execute(world, entity);
	}
}