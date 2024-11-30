
package net.mcreator.oneiricconcept.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;
import net.mcreator.oneiricconcept.init.OneiricconceptModFluids;
import net.mcreator.oneiricconcept.init.OneiricconceptModFluidTypes;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public abstract class MemoriaFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> OneiricconceptModFluidTypes.MEMORIA_TYPE.get(), () -> OneiricconceptModFluids.MEMORIA.get(), () -> OneiricconceptModFluids.FLOWING_MEMORIA.get())
			.explosionResistance(100f).tickRate(1).slopeFindDistance(3).bucket(() -> OneiricconceptModItems.MEMORIA_BUCKET.get()).block(() -> (LiquidBlock) OneiricconceptModBlocks.MEMORIA.get());

	private MemoriaFluid() {
		super(PROPERTIES);
	}

	public static class Source extends MemoriaFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MemoriaFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
