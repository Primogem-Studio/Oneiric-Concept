
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
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OneiricconceptModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, OneiricconceptMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<PhlogistontankGuiMenu>> PHLOGISTONTANK_GUI = REGISTRY.register("phlogistontank_gui", () -> IMenuTypeExtension.create(PhlogistontankGuiMenu::new));
}
