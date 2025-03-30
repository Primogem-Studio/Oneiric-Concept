package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.functions.CommandFunction;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

import java.util.Optional;

public class ShatteringCutAatreeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sz = 0;
		double ent = 0;
		BlockState blok = Blocks.AIR.defaultBlockState();
		MaraRangeClearProcedure.execute(world, x, y, z, 67);
		sx = x;
		sz = z;
		blok = (world.getBlockState(BlockPos.containing(x, y, z)));
		if (!(blok.getBlock() == Blocks.END_GATEWAY)) {
			if (blok.getBlock() == OneiricconceptModBlocks.AMBROSIAL_ARBOR_LOG.get() || blok.getBlock() == OneiricconceptModBlocks.AMBROSIAL_ARBOR_LEAVE.get()) {
				blok = Blocks.AIR.defaultBlockState();
			}
			ClearArborProcedure.execute(world, x, y, z, blok);
		}
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
			if (world instanceof ServerLevel _level && _level.getServer() != null) {
				Optional<CommandFunction<CommandSourceStack>> _fopt = _level.getServer().getFunctions().get(ResourceLocation.parse("oneiricconcept:arbor_clear"));
				if (_fopt.isPresent())
					_level.getServer().getFunctions().execute(_fopt.get(), new CommandSourceStack(CommandSource.NULL, new Vec3(sx, y, sz), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null));
			}
			sx = x + Mth.nextInt(RandomSource.create(), -7, 7);
			sz = z + Mth.nextInt(RandomSource.create(), -7, 7);
		}
		OneiricconceptModVariables.MapVariables.get(world).skyshatteringlux = OneiricconceptModVariables.MapVariables.get(world).skyshatteringlux - 1;
		OneiricconceptModVariables.MapVariables.get(world).syncData(world);
		if (OneiricconceptModVariables.MapVariables.get(world).skyshatteringlux < 60) {
			DivineArrowProcedure.execute(world, x, y, z);
			OneiricconceptModVariables.MapVariables.get(world).skyshatteringlux = OneiricconceptModVariables.MapVariables.get(world).skyshatteringlux + 1;
			OneiricconceptModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
