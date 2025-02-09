package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

public class PlacexyzProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, double maxx, double maxy, double maxz, double minx, double miny, double minz) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xyz = 0;
		double range = 0;
		String debugtst = "";
		sx = minx;
		for (int index0 = 0; index0 < (int) (Math.abs(maxx - minx) + 1); index0++) {
			sy = miny;
			for (int index1 = 0; index1 < (int) (Math.abs(maxy - miny) + 1); index1++) {
				sz = minz;
				for (int index2 = 0; index2 < (int) (Math.abs(maxz - minz) + 1); index2++) {
					if (!(sx == 0 && sy == 0 && sz == 0 || (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.AIR)) {
						found = true;
						if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
							debugtst = (debugtst + "\u00A7r\u65B9\u5757\uFF1A\u00A7c" + world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)) + "\u00A7r\u4F4D\u7F6E\uFF1A\u00A7c") + ""
									+ ("x:" + (x + sx) + "\uFF0Cy:" + (y + sy) + "\uFF0Cz:" + (z + sz));
						}
					} else {
						if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
							debugtst = (debugtst + "\u00A7r\u65B9\u5757\uFF1A\u00A7a" + world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)) + "\u00A7r\u4F4D\u7F6E\uFF1A\u00A7a") + ""
									+ ("x:" + (x + sx) + "\uFF0Cy:" + (y + sy) + "\uFF0Cz:" + (z + sz));
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList()
						.broadcastSystemMessage(
								Component.literal((("\u00A7dmin|x:" + minx + "\uFF0Cy:" + miny + "\uFF0Cz:" + minz) + "" + ("\u00A76max|x:" + maxx + "\uFF0Cy:" + maxy + "\uFF0Cz:" + maxz) + ("\u00A72x\u6267\u884C\u6B21\u6570\uFF1A\u00A73"
										+ (Math.abs(maxx - minx) + 1) + "\u00A72y\u6267\u884C\u6B21\u6570\uFF1A\u00A73" + (Math.abs(maxy - miny) + 1) + "\u00A72z\u6267\u884C\u6B21\u6570\uFF1A\u00A73" + (Math.abs(maxz - minz) + 1)) + debugtst)),
								false);
		}
		return found;
	}
}
