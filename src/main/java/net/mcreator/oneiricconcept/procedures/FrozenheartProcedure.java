package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class FrozenheartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		Entity ent = null;
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		String itmtag = "";
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 0, false, false));
		if (entity.isPassenger()) {
			ent = entity.getVehicle();
			x1 = ent.getX();
			y1 = ent.getY();
			z1 = ent.getZ();
		} else {
			ent = entity;
			x1 = x;
			y1 = y;
			z1 = z;
		}
		itmtag = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("ice");
		if (!(itmtag).equals("off") && !ent.isInWaterOrBubble() && ent.onGround()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x1, y1, z1), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("fill ~-10 ~-1 ~-10 ~10 ~-1 ~10 " + itmtag + " replace minecraft:water"));
		}
	}
}