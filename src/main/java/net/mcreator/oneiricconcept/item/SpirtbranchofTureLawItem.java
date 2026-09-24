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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.procedures.TureLawProcedure;
import net.mcreator.oneiricconcept.procedures.SakuraPlaceProcedure;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.mcreator.oneiricconcept.PGCApi;
import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.per.primogemcraft.system.weapon.WishWeapon;
import net.per.primogemcraft.system.weapon.WeaponModifier;
import net.per.primogemcraft.system.weapon.WeaponDescription;
import net.per.primogemcraft.system.weapon.WeaponAttributes;
import net.per.primogemcraft.system.weapon.WeaponType;
import net.per.primogemcraft.system.weapon.WishWeaponTooltips;
import net.per.primogemcraft.system.wish.WishTooltips;
import static net.per.primogemcraft.system.wish.WishReports.number;

public class SpirtbranchofTureLawItem extends SwordItem implements WishWeapon {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 23426;
		}

		@Override
		public float getSpeed() {
			return 42f;
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
			return 42;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(new ItemStack(OneiricconceptModBlocks.AMBROSIAL_ARBOR_LOG.get()));
		}
	};

	public SpirtbranchofTureLawItem() {
		super(TOOL_TIER, new Item.Properties().attributes(SwordItem.createAttributes(TOOL_TIER, 8f, 1f)).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		TureLawProcedure.execute(entity, sourceentity);
		return retval;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		SakuraPlaceProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
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
		var player = WishTooltips.viewer();
		var refinement = PGCApi.refinementBonus(player, stack) + 1;
		var descriptions = new ArrayList<WeaponDescription>();
		descriptions.add(WeaponDescription.of("passive_effect", "passive"));
		if (player != null && player.hasPermissions(4)) descriptions.add(WeaponDescription.note("operator"));
		descriptions.add(WeaponDescription.of("right_click_effect", "right_click", number(10 * refinement, ChatFormatting.AQUA),
				number(Math.max(0, 1200 - 100 * refinement) / 20, ChatFormatting.AQUA)));
		Component damage = Component.literal("?").withStyle(ChatFormatting.AQUA);
		if (player != null) {
			var attack = player.getAttributeValue(Attributes.ATTACK_DAMAGE);
			var healthMultiplier = player.level().getGameRules().getInt(OneiricconceptModGameRules.OC_HEALTHMULTIPLIER);
			damage = number((attack * 1.2 + 10 * healthMultiplier) * (refinement + 1), ChatFormatting.AQUA);
		}
		descriptions.add(WeaponDescription.of("sneak_use", "sneak_use", damage,
				number(Math.max(0, 2000 - 200 * refinement) / 20, ChatFormatting.AQUA)));
		return descriptions;
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
		super.inventoryTick(stack, level, entity, slot, selected);
		if (!level.isClientSide() && entity instanceof Player player)
			WeaponAttributes.refreshPassive(stack, player, slot);
	}
}
