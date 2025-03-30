package net.mcreator.oneiricconcept.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.oneiricconcept.world.inventory.CrystalgeneratorGUIMenu;
import net.mcreator.oneiricconcept.procedures.EnergybarProcedure;
import net.mcreator.oneiricconcept.procedures.EnergyTipProcedure;

import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class CrystalgeneratorGUIScreen extends AbstractContainerScreen<CrystalgeneratorGUIMenu> {
	private final static HashMap<String, Object> guistate = CrystalgeneratorGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CrystalgeneratorGUIScreen(CrystalgeneratorGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("oneiricconcept:textures/screens/crystalgenerator_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 146 && mouseX < leftPos + 170 && mouseY > topPos + 34 && mouseY < topPos + 58) {
			String hoverText = EnergyTipProcedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
		}
		if (mouseX > leftPos + 146 && mouseX < leftPos + 170 && mouseY > topPos + 10 && mouseY < topPos + 34) {
			String hoverText = EnergyTipProcedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
		}
		if (mouseX > leftPos + 146 && mouseX < leftPos + 170 && mouseY > topPos + 58 && mouseY < topPos + 82) {
			String hoverText = EnergyTipProcedure.execute(world, x, y, z);
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
		}
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("oneiricconcept:textures/screens/energybar.png"), this.leftPos + 160, this.topPos + 14, Mth.clamp((int) EnergybarProcedure.execute(world, x, y, z) * 8, 0, 128), 0, 8, 64, 136, 64);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
	}
}
