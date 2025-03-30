
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.oneiricconcept.world.inventory.PhlogistontankGuiMenu;
import net.mcreator.oneiricconcept.world.inventory.LibGuiMenu;
import net.mcreator.oneiricconcept.world.inventory.FishingMenu;
import net.mcreator.oneiricconcept.world.inventory.CrystalgeneratorGUIMenu;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OneiricconceptModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, OneiricconceptMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<PhlogistontankGuiMenu>> PHLOGISTONTANK_GUI = REGISTRY.register("phlogistontank_gui", () -> IMenuTypeExtension.create(PhlogistontankGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FishingMenu>> FISHING = REGISTRY.register("fishing", () -> IMenuTypeExtension.create(FishingMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LibGuiMenu>> LIB_GUI = REGISTRY.register("lib_gui", () -> IMenuTypeExtension.create(LibGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CrystalgeneratorGUIMenu>> CRYSTALGENERATOR_GUI = REGISTRY.register("crystalgenerator_gui", () -> IMenuTypeExtension.create(CrystalgeneratorGUIMenu::new));
}
