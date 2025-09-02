package net.mcreator.oneiricconcept.world.features;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.oneiricconcept.world.features.configurations.StructureFeatureConfiguration;
import net.mcreator.oneiricconcept.procedures.IsBoughProcedure;

public class PlaceNestFeature extends StructureFeature {
	public PlaceNestFeature() {
		super(StructureFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!IsBoughProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}