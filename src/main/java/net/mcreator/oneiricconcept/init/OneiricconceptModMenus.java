/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.oneiricconcept.world.inventory.WhiteMoonlightAbsorberGUIMenu;
import net.mcreator.oneiricconcept.world.inventory.PhlogistontankGuiMenu;
import net.mcreator.oneiricconcept.world.inventory.NestGUIMenu;
import net.mcreator.oneiricconcept.world.inventory.LibGuiMenu;
import net.mcreator.oneiricconcept.world.inventory.GUIcelebratoryxiaolanternMenu;
import net.mcreator.oneiricconcept.world.inventory.GUIcelebratoryxiaolanternEditMenu;
import net.mcreator.oneiricconcept.world.inventory.FishingMenu;
import net.mcreator.oneiricconcept.world.inventory.CrystalgeneratorGUIMenu;
import net.mcreator.oneiricconcept.network.MenuStateUpdateMessage;
import net.mcreator.oneiricconcept.OneiricconceptMod;

import java.util.Map;

public class OneiricconceptModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, OneiricconceptMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<PhlogistontankGuiMenu>> PHLOGISTONTANK_GUI = REGISTRY.register("phlogistontank_gui", () -> IMenuTypeExtension.create(PhlogistontankGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FishingMenu>> FISHING = REGISTRY.register("fishing", () -> IMenuTypeExtension.create(FishingMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LibGuiMenu>> LIB_GUI = REGISTRY.register("lib_gui", () -> IMenuTypeExtension.create(LibGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CrystalgeneratorGUIMenu>> CRYSTALGENERATOR_GUI = REGISTRY.register("crystalgenerator_gui", () -> IMenuTypeExtension.create(CrystalgeneratorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<NestGUIMenu>> NEST_GUI = REGISTRY.register("nest_gui", () -> IMenuTypeExtension.create(NestGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<WhiteMoonlightAbsorberGUIMenu>> WHITE_MOONLIGHT_ABSORBER_GUI = REGISTRY.register("white_moonlight_absorber_gui", () -> IMenuTypeExtension.create(WhiteMoonlightAbsorberGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GUIcelebratoryxiaolanternMenu>> GU_ICELEBRATORYXIAOLANTERN = REGISTRY.register("gu_icelebratoryxiaolantern", () -> IMenuTypeExtension.create(GUIcelebratoryxiaolanternMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GUIcelebratoryxiaolanternEditMenu>> GU_ICELEBRATORYXIAOLANTERN_EDIT = REGISTRY.register("gu_icelebratoryxiaolantern_edit",
			() -> IMenuTypeExtension.create(GUIcelebratoryxiaolanternEditMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof OneiricconceptModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}