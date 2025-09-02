package net.mcreator.oneiricconcept.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.oneiricconcept.procedures.SweetFlowerclimateProcedure;

public class SweetFlowersFeature extends SimpleBlockFeature {
	public SweetFlowersFeature() {
		super(SimpleBlockConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!SweetFlowerclimateProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}