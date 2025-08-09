
package net.mcreator.oneiricconcept.item.extension;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.Direction;

import net.mcreator.oneiricconcept.procedures.TntPlaceProcedure;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class AntimatterbombItemExtension {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> DispenserBlock.registerBehavior(OneiricconceptModBlocks.ENGINEERINGANTIMATTERBOMBBLOCK.get().asItem(), new OptionalDispenseItemBehavior() {
			public ItemStack execute(BlockSource blockSource, ItemStack stack) {
				ItemStack itemstack = stack.copy();
				Level world = blockSource.level();
				Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
				int x = blockSource.pos().getX();
				int y = blockSource.pos().getY();
				int z = blockSource.pos().getZ();
				this.setSuccess(TntPlaceProcedure.execute(world, x, y, z, direction));
				if (this.isSuccess())
					itemstack.shrink(1);
				return itemstack;
			}
		}));
	}
}
