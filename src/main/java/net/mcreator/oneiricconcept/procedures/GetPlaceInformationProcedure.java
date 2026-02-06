package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class GetPlaceInformationProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		String year = "";
		String moon = "";
		String day = "";
		year = getBlockNBTString(world, BlockPos.containing(x, y, z), "year");
		moon = getBlockNBTString(world, BlockPos.containing(x, y, z), "moon");
		day = getBlockNBTString(world, BlockPos.containing(x, y, z), "day");
		return ((Component.translatable("translation.oneiricconcept.check").getString()).equals("cn") ? year + "\u5E74" + moon + "\u6708" + day + "\u65E5" : moon + "/" + day + "/" + year) + ""
				+ Component.translatable("translation.oneiricconcept.from").getString() + entity.getDisplayName().getString();
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}
}