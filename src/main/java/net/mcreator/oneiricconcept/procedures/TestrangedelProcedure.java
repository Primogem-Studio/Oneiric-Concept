package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.commands.functions.CommandFunction;
import net.minecraft.commands.CommandSourceStack;

import java.util.Optional;
import java.util.List;
import java.util.Comparator;

public class TestrangedelProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double mode = 0;
		mode = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("textures");
		if (0 < mode) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof Player)) {
						TestDeleteProcedure.execute(world, x, z, entityiterator, entity);
					}
				}
			}
		} else {
			if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.LUCK))
				_livingEntity4.getAttribute(Attributes.LUCK).setBaseValue(51522);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					Optional<CommandFunction<CommandSourceStack>> _fopt = _ent.getServer().getFunctions().get(ResourceLocation.parse("oneiricconcept:debug"));
					if (_fopt.isPresent())
						_ent.getServer().getFunctions().execute(_fopt.get(), _ent.createCommandSourceStack());
				}
			}
		}
	}
}
