package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class GeomarrowRadiatorProcessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double repeat = 0;
		ItemStack i1 = ItemStack.EMPTY;
		ItemStack i2 = ItemStack.EMPTY;
		i1 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
		if (i1.getItem() == OneiricconceptModItems.OY_DUMPLING.get()) {
			i2 = new ItemStack(OneiricconceptModItems.GRILLED_OY_DUMPLING.get()).copy();
			{
				final String _tagName = "die";
				final String _tagValue = (i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("die"));
				CustomData.update(DataComponents.CUSTOM_DATA, i2, tag -> tag.putString(_tagName, _tagValue));
			}
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity, i2, 1, 1, 2);
		} else if (i1.getItem() == Items.ROTTEN_FLESH) {
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity, new ItemStack(Items.LEATHER), 1, 1, 2);
		}
		if (i1.getItem() == OneiricconceptModItems.SAUSAGE.get()) {
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity, new ItemStack(OneiricconceptModItems.BELOBOG_SAUSAGE.get()), 0, 1, 2);
		} else if (i1.getItem() == Items.WHEAT_SEEDS && i1.getCount() >= 8) {
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity, new ItemStack(OneiricconceptModItems.WAFFLE.get()), 0, 1, 2);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(7);
		} else if (i1.getItem() == OneiricconceptModBlocks.THE_ANOTHER_WORLD_SAPLING.get().asItem()) {
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity, new ItemStack(OneiricconceptModItems.PRIMOGEM_WAFFLE.get()), 0, 1, 5);
		} else if (i1.getItem() == OneiricconceptModBlocks.CLOUD.get().asItem()) {
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity, new ItemStack(OneiricconceptModItems.SKY_WAFFLE.get()), 0, 1, 5);
		} else if (i1.getItem() == OneiricconceptModItems.S_2AUSAGE.get()) {
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity, new ItemStack(OneiricconceptModItems.B_2ELOBOG_SAUSAGE.get()), 1, 1, 1);
		} else if (i1.getItem() == OneiricconceptModItems.PUBLIC_CLAMOR.get() && i1.getCount() >= 7) {
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity, new ItemStack(OneiricconceptModItems.OY_STUFFING.get()), 1, 1, 20);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(6);
		} else if (i1.getItem() == (PotionContents.createItemStack(Items.POTION, Potions.WATER)).getItem()) {
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity, new ItemStack(OneiricconceptModItems.SALT.get()), 0, 1, 1);
		} else if (world instanceof Level _level19 && _level19.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(i1), _level19).isPresent()) {
			Geomarrowradiatorprocess0Procedure.execute(world, x, y, z, entity,
					(world instanceof Level _lvlSmeltResult
							? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(i1), _lvlSmeltResult).map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy())
									.orElse(ItemStack.EMPTY)
							: ItemStack.EMPTY),
					0, 1, 1);
		}
	}
}
