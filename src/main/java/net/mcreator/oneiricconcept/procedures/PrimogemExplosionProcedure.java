package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class PrimogemExplosionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String tsttxxt = "";
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xyz = 0;
		double range = 0;
		double probability = 0;
		boolean found = false;
		range = 25;
		xyz = Math.round(0 - (range - 1) / 2);
		sx = xyz;
		found = false;
		for (int index0 = 0; index0 < (int) range; index0++) {
			sy = xyz;
			for (int index1 = 0; index1 < (int) range; index1++) {
				sz = xyz;
				for (int index2 = 0; index2 < (int) range; index2++) {
					probability = Mth.clamp((Math.max(0, Math.round(range / 2) - new Vec3(x, y, z).distanceTo(new Vec3((x + sx), (y + sy), (z + sz)))) / range), 0, 1);
					tsttxxt = tsttxxt + "\n" + probability;
					if (RandomProcedure.execute(world, probability)) {
						{
							BlockPos _bp = BlockPos.containing(x + sx, y + sy, z + sz);
							BlockState _bs = BuiltInRegistries.BLOCK.get(ResourceLocation.parse("primogemcraft:yuanshikuangshi")).defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(tsttxxt), false);
	}
}
