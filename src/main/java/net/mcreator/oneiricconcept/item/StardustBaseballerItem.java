package net.mcreator.oneiricconcept.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.procedures.StardustbaseballerHurtProcedure;
import net.mcreator.oneiricconcept.procedures.RIPHomeRunProcedure;
import net.mcreator.oneiricconcept.procedures.IsChargedProcedure;
import net.mcreator.oneiricconcept.procedures.BlowoutFarewellHitProcedure;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.mcreator.oneiricconcept.PGCApi;
import net.per.primogemcraft.system.weapon.WishWeapon;
import net.per.primogemcraft.system.weapon.WeaponModifier;
import net.per.primogemcraft.system.weapon.WeaponDescription;
import net.per.primogemcraft.system.weapon.WeaponAttributes;
import net.per.primogemcraft.system.weapon.WeaponType;
import net.per.primogemcraft.system.weapon.WishWeaponTooltips;
import net.per.primogemcraft.system.wish.WishTooltips;
import static net.per.primogemcraft.system.wish.WishReports.number;

public class StardustBaseballerItem extends Item implements WishWeapon {
	public StardustBaseballerItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC)
				.attributes(ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 12, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
						.add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.4, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build()));
	}

	@Override
	public int getEnchantmentValue() {
		return 22;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return IsChargedProcedure.execute(itemstack);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable(WeaponType.of(itemstack).labelKey()));
		list.addAll(WishWeaponTooltips.lines(itemstack.getDescriptionId(), descriptions(itemstack)));
	}

	@Override
	public List<WeaponModifier> passives() {
		// Combat passives are applied by the existing attack procedures.
		return List.of();
	}

	@Override
	public List<WeaponDescription> descriptions(ItemStack stack) {
		var bonus = PGCApi.refinementBonus(WishTooltips.viewer(), stack);
		return List.of(
				WeaponDescription.of("passive_effect", "passive", number(4 + bonus, ChatFormatting.AQUA), number(16 + bonus * 4, ChatFormatting.AQUA)),
				WeaponDescription.of("sneak_use", "sneak_use", number(300 + bonus * 75, ChatFormatting.AQUA), number(600 * (1 - 0.1 * bonus) / 20, ChatFormatting.AQUA)),
				WeaponDescription.of("sneak_swing", "sneak_swing", number(4 + bonus, ChatFormatting.AQUA), number(100 * (1 - 0.1 * bonus) / 20, ChatFormatting.AQUA)));
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
		super.inventoryTick(stack, level, entity, slot, selected);
		if (!level.isClientSide() && entity instanceof Player player)
			WeaponAttributes.refreshPassive(stack, player, slot);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		BlowoutFarewellHitProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		StardustbaseballerHurtProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity);
		return retval;
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
		boolean retval = super.onEntitySwing(itemstack, entity, hand);
		RIPHomeRunProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		return retval;
	}
}
