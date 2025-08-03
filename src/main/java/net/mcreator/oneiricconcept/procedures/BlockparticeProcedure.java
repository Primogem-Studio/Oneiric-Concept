package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class BlockparticeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blocks, boolean fce, double dx, double dy, double dz, double nu, double spd, String atsele) {
		if (atsele == null)
			return;
		String force = "";
		if (fce) {
			force = " force ";
		} else {
			force = " normal ";
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("/particle minecraft:block_marker{block_state: \"" + "" + BuiltInRegistries.BLOCK.getKey(blocks.getBlock()).toString() + "\"} ~ ~ ~ " + dx + " " + dy + " " + dz + " " + spd + " " + Math.round(nu) + force + atsele));
	}
}