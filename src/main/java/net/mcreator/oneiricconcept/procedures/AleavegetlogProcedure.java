package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class AleavegetlogProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double range = 0;
		double xyz = 0;
		range = 13;
		xyz = Math.round(0 - (range - 1) / 2);
		sx = xyz;
		found = false;
		for (int _i1 = 0; _i1 < (int) range; _i1++) {
			sy = xyz;
			for (int _i2 = 0; _i2 < (int) range; _i2++) {
				sz = xyz;
				for (int _i3 = 0; _i3 < (int) range; _i3++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == OneiricconceptModBlocks.AMBROSIAL_ARBOR_LOG.get()) {
						found = true;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (!found) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = OneiricconceptModBlocks.AMBROSIAL_ARBOR_LOG.get().defaultBlockState();
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
		OutfireProcedure.execute(world, x, y, z);
	}
}