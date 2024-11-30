package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class EndermiteSumProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.endermite.ambient")), SoundSource.HOSTILE, (float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5),
						(float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5));
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.endermite.ambient")), SoundSource.HOSTILE, (float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5),
						(float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5), false);
			}
		}
		for (int index0 = 0; index0 < 100; index0++) {
			OneiricconceptMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 9, 20), () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.endermite.ambient")), SoundSource.HOSTILE, (float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5),
								(float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.endermite.ambient")), SoundSource.HOSTILE, (float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5),
								(float) Mth.nextDouble(RandomSource.create(), 0.5, 1.5), false);
					}
				}
			});
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"/summon minecraft:endermite ~ ~ ~ {CustomName:\"\u5047\u86F0\u866B\",CustomNameVisible:1b,NoAI:1b}");
	}
}
