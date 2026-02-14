package net.mcreator.oneiricconcept.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class DelightProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (ModList.get().isLoaded("farmersdelight")) {
			Entity _ent1 = entity;
			if (!_ent1.level().isClientSide() && _ent1.getServer() != null)
				_ent1.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent1.position(), _ent1.getRotationVector(), _ent1.level() instanceof ServerLevel ? (ServerLevel) _ent1.level() : null, 2,
						_ent1.getName().getString(), _ent1.getDisplayName(), _ent1.level().getServer(), _ent1), "/effect give @p farmersdelight:nourishment 300 0 false");
			Entity _ent2 = entity;
			if (!_ent2.level().isClientSide() && _ent2.getServer() != null)
				_ent2.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent2.position(), _ent2.getRotationVector(), _ent2.level() instanceof ServerLevel ? (ServerLevel) _ent2.level() : null, 2,
						_ent2.getName().getString(), _ent2.getDisplayName(), _ent2.level().getServer(), _ent2), "/effect give @p farmersdelight:comfort 300 0 false");
		}
		BlbgBuffProcedure.execute(entity);
		Health100Procedure.execute(entity, 0.1);
	}
}