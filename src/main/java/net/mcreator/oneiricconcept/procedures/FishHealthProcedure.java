package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.functions.CommandFunction;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

import java.util.Optional;
import java.util.List;
import java.util.Comparator;

public class FishHealthProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack fishitem = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (world instanceof ServerLevel _level && _level.getServer() != null) {
				Optional<CommandFunction<CommandSourceStack>> _fopt = _level.getServer().getFunctions().get(ResourceLocation.parse("oneiricconcept:fishs"));
				if (_fopt.isPresent())
					_level.getServer().getFunctions().execute(_fopt.get(),
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null));
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.BUBBLE, (entity.getX()), (entity.getY()), (entity.getZ()), 3, 0.5, 0.5, 0.5, 0.5);
			{
				final Vec3 _center = new Vec3(x, (y + 3), z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getPersistentData().getBoolean("fishheart")) {
						if (RandomProcedure.execute(world, 0.9)) {
							if (!entityiterator.level().isClientSide())
								entityiterator.discard();
						}
						entityiterator.push((Mth.nextDouble(RandomSource.create(), -3, 3)), (Mth.nextDouble(RandomSource.create(), 0, 1)), (Mth.nextDouble(RandomSource.create(), -3, 3)));
					}
				}
			}
			fishitem = new ItemStack(
					(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("minecraft:fishes"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
			if (!(OneiricconceptModItems.HEARTOFTHEFISH.get() == fishitem.getItem())) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = fishitem.copy();
					_setstack.setCount((int) RandomintProcedure.execute(world, fishitem.getMaxStackSize(), 1));
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
			if (!world.isClientSide() && world.getServer() != null) {
				for (ItemStack itemstackiterator : world.getServer().reloadableRegistries()
						.getLootTable(
								ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse(((RandomProcedure.execute(world, 0.8) ? "minecraft:gameplay/fishing/fish" : "minecraft:gameplay/fishing/junk")).toLowerCase(java.util.Locale.ENGLISH))))
						.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = itemstackiterator.copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
			if (RandomProcedure.execute(world, 0.3)) {
				if (!world.isClientSide() && world.getServer() != null) {
					for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse("minecraft:gameplay/fishing/treasure")))
							.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
						if (itemstackiterator.isEnchanted() || itemstackiterator.getItem() == Items.ENCHANTED_BOOK) {
							if (entity instanceof Player _player)
								_player.getCooldowns().addCooldown(itemstack.getItem(), 140);
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = itemstackiterator.copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				}
			}
		}
	}
}
