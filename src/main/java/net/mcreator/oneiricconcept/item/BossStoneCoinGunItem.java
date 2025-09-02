package net.mcreator.oneiricconcept.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.oneiricconcept.procedures.MoraOnlineProcedure;
import net.mcreator.oneiricconcept.procedures.MoraLaunchProcedure;
import net.mcreator.oneiricconcept.entity.InvalidEntity;

public class BossStoneCoinGunItem extends Item {
	public BossStoneCoinGunItem() {
		super(new Item.Properties().stacksTo(1).fireResistant());
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 32;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = InteractionResultHolder.fail(entity.getItemInHand(hand));
		if (MoraOnlineProcedure.execute(entity))
			if (entity.getAbilities().instabuild || findAmmo(entity) != ItemStack.EMPTY) {
				ar = InteractionResultHolder.success(entity.getItemInHand(hand));
				entity.startUsingItem(hand);
			}
		return ar;
	}

	@Override
	public void onUseTick(Level world, LivingEntity entity, ItemStack itemstack, int count) {
		if (!world.isClientSide() && entity instanceof ServerPlayer player) {
			ItemStack stack = findAmmo(player);
			if (player.getAbilities().instabuild || stack != ItemStack.EMPTY) {
				InvalidEntity projectile = InvalidEntity.shoot(world, entity, world.getRandom());
				if (player.getAbilities().instabuild) {
					projectile.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
				} else {
					if (stack.isDamageableItem()) {
						if (world instanceof ServerLevel serverLevel)
							stack.hurtAndBreak(1, serverLevel, player, _stkprov -> {
							});
					} else {
						stack.shrink(1);
					}
				}
				MoraLaunchProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
			}
			entity.releaseUsingItem();
		}
	}

	private ItemStack findAmmo(Player player) {
		return new ItemStack(InvalidEntity.PROJECTILE_ITEM.getItem());
	}
}