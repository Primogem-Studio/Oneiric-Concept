
package net.mcreator.oneiricconcept.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.oneiricconcept.procedures.OpenFishingGuiProcedure;

public class WildernessRodItem extends FishingRodItem {
	public WildernessRodItem() {
		super(new Item.Properties().durability(160));
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(Items.STICK)).test(repairitem);
	}

	@Override
	public int getEnchantmentValue() {
		return 7;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		super.use(world, entity, hand);
		ItemStack itemstack = entity.getItemInHand(hand);
		OpenFishingGuiProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
	}
}
