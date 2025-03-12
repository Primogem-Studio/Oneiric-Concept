package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class TankGetphlogistonProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String txtstr = "";
		String timecolor = "";
		double nulav = 0;
		double colornu = 0;
		nulav = Math.floor(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lavasnu") / 10);
		for (int index0 = 0; index0 < (int) nulav; index0++) {
			colornu = colornu + 1;
			if (nulav - 0 <= colornu) {
				timecolor = "\u00A7a|";
			} else if (nulav - 3 <= colornu) {
				timecolor = "\u00A7e|";
			} else if (nulav - 5 <= colornu) {
				timecolor = "\u00A76|";
			} else if (nulav - 9 <= colornu) {
				timecolor = "\u00A7c|";
			} else {
				timecolor = "|";
			}
			txtstr = txtstr + "" + timecolor;
		}
		txtstr = txtstr + "\u00A78";
		for (int index1 = 0; index1 < (int) (100 - nulav); index1++) {
			txtstr = txtstr + "|";
		}
		txtstr = Component.translatable("item.oneiricconcept.phlogiston").getString() + "\uFF1A" + txtstr;
		return txtstr;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}
