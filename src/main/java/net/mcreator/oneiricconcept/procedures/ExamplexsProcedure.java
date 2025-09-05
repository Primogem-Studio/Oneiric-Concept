package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

public class ExamplexsProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (PGCcounterProcedure.execute(world, entity, false, 0, "exa")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Message"), false);
			PGCcounterProcedure.execute(world, entity, true, Mth.nextInt(RandomSource.create(), 1, 5) * 20, "exa");
		}
	}
}