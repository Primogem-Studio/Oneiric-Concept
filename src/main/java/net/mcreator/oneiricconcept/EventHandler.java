package net.mcreator.oneiricconcept;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;
import net.mcreator.oneiricconcept.init.OneiricconceptModFluidTypes;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry.InteractionInformation;

import static net.mcreator.oneiricconcept.OneiricconceptMod.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class EventHandler {
    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            FluidInteractionRegistry.addInteraction(NeoForgeMod.WATER_TYPE.value(), new InteractionInformation(OneiricconceptModFluidTypes.MEMORIA_TYPE.value(), OneiricconceptModBlocks.CLOUD.value().defaultBlockState()));
            FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new InteractionInformation(OneiricconceptModFluidTypes.MEMORIA_TYPE.value(), Blocks.SAND.defaultBlockState()));
        });
    }
}
