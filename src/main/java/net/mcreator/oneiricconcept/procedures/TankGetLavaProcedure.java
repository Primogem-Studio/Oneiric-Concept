package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class TankGetLavaProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String txtstr = "";
		double nulav = 0;
		nulav = Math.floor(getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) / 100);
		for (int index0 = 0; index0 < (int) nulav; index0++) {
			txtstr = txtstr + "|";
		}
		txtstr = txtstr + "\u00A78";
		for (int index1 = 0; index1 < (int) (100 - nulav); index1++) {
			txtstr = txtstr + "|";
		}
		txtstr = Component.translatable("block.minecraft.lava").getString() + "\uFF1A" + txtstr;
		return txtstr;
	}

	private static int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank, Direction direction) {
		if (level instanceof ILevelExtension levelExtension) {
			IFluidHandler fluidHandler = levelExtension.getCapability(Capabilities.FluidHandler.BLOCK, pos, direction);
			if (fluidHandler != null)
				return fluidHandler.getFluidInTank(tank).getAmount();
		}
		return 0;
	}
}