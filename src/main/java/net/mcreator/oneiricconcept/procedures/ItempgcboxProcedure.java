package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class ItempgcboxProcedure {
	public static ItemStack execute(LevelAccessor world, double x, double y, double z) {
		ItemStack i1 = ItemStack.EMPTY;
		String s1 = "";
		String s2 = "";
		String s3 = "";
		s1 = new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "item");
		s2 = "c:curio/normal/";
		s3 = "primogemcraft:";
		if ((s3 + "shenmilihe").equals(s1)) {
			if (!world.isClientSide()) {
				i1 = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("pgc:lihe_1"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
			}
		} else if ((s3 + "qhzlh").equals(s1)) {
			i1 = LiheshuxhsProcedure.execute(world, s3 + "blocks/zllh_01").copy();
		} else if ((s3 + "qhzllh_2").equals(s1)) {
			i1 = LiheshuxhsProcedure.execute(world, s3 + "blocks/zllh_02").copy();
		} else if ((s3 + "q_qu_hang_zhoullh").equals(s1)) {
			i1 = LiheshuxhsProcedure.execute(world, s3 + "blocks/zllh_03").copy();
		} else if ((s3 + "qhzllh_4").equals(s1)) {
			i1 = LiheshuxhsProcedure.execute(world, s3 + "entities/zllh_4zlp").copy();
		} else if ((s3 + "qwlhs").equals(s1)) {
			i1 = Liheshuxhs2Procedure.execute(s2 + "s").copy();
		} else if ((s3 + "qwlha").equals(s1)) {
			i1 = Liheshuxhs2Procedure.execute(s2 + "a").copy();
		} else if ((s3 + "qwlhb").equals(s1)) {
			i1 = Liheshuxhs2Procedure.execute(s2 + "b").copy();
		} else {
			i1 = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse((s1).toLowerCase(java.util.Locale.ENGLISH)))).copy();
		}
		{
			BlockPos _pos = BlockPos.containing(x, y, z);
			Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
			world.destroyBlock(_pos, false);
		}
		return i1;
	}
}
