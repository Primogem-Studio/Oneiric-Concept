package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class PhlogistoncontrolleProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean flylgc = false;
		entity.getPersistentData().putBoolean("ocflyon", (!entity.getPersistentData().getBoolean("ocflyon")));
		if (entity instanceof Player _player) {
			_player.getAbilities().flying = (entity.getPersistentData().getBoolean("ocflyon"));
			_player.onUpdateAbilities();
		}
	}
}
