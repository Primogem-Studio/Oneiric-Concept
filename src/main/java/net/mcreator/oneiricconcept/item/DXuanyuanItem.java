package net.mcreator.oneiricconcept.item;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;

import net.mcreator.oneiricconcept.procedures.XuanyuanLaunchProcedure;
import net.mcreator.oneiricconcept.procedures.IgnisAureliaeSwordProcedure;
import net.mcreator.oneiricconcept.procedures.HonkaiParticleProcedure;
import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class DXuanyuanItem extends SwordItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 2800;
		}

		@Override
		public float getSpeed() {
			return 10f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 28;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(new ItemStack(OneiricconceptModItems.HONKAI_SLIVER.get()));
		}
	};

	public DXuanyuanItem() {
		super(TOOL_TIER, new Item.Properties().attributes(SwordItem.createAttributes(TOOL_TIER, 27f, -1f)).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		IgnisAureliaeSwordProcedure.execute(entity);
		return retval;
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
		boolean retval = super.onEntitySwing(itemstack, entity, hand);
		XuanyuanLaunchProcedure.execute(entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		HonkaiParticleProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ());
	}
}