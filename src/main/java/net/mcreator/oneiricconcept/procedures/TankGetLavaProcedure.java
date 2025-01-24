package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class TankGetLavaProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String txtstr = "";
		double nulav = 0;
		nulav = Math.floor(new Object() {
			public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
				if (level instanceof ILevelExtension _ext) {
					IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, pos, null);
					if (_fluidHandler != null)
						return _fluidHandler.getFluidInTank(tank).getAmount();
				}
				return 0;
			}
		}.getFluidTankLevel(world, BlockPos.containing(x, y, z), 1) / 100);
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
}
