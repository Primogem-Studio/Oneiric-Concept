package net.mcreator.oneiricconcept.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.oneiricconcept.world.inventory.GUIcelebratoryxiaolanternEditMenu;
import net.mcreator.oneiricconcept.init.OneiricconceptModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class GUIcelebratoryxiaolanternEditScreen extends AbstractContainerScreen<GUIcelebratoryxiaolanternEditMenu> implements OneiricconceptModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	EditBox frist;
	EditBox second;

	public GUIcelebratoryxiaolanternEditScreen(GUIcelebratoryxiaolanternEditMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 216;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("frist"))
				frist.setValue(stringState);
			else if (name.equals("second"))
				second.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		frist.render(guiGraphics, mouseX, mouseY, partialTicks);
		second.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(ResourceLocation.parse("oneiricconcept:textures/screens/celebratory1.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 400, 216, 2400, 216);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (frist.isFocused())
			return frist.keyPressed(key, b, c);
		if (second.isFocused())
			return second.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String fristValue = frist.getValue();
		String secondValue = second.getValue();
		super.resize(minecraft, width, height);
		frist.setValue(fristValue);
		second.setValue(secondValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		frist = new EditBox(this.font, this.leftPos + 195, this.topPos + 46, 118, 18, Component.translatable("gui.oneiricconcept.gu_icelebratoryxiaolantern_edit.frist"));
		frist.setMaxLength(8192);
		frist.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "frist", content, false);
		});
		this.addWidget(this.frist);
		second = new EditBox(this.font, this.leftPos + 195, this.topPos + 70, 118, 18, Component.translatable("gui.oneiricconcept.gu_icelebratoryxiaolantern_edit.second"));
		second.setMaxLength(8192);
		second.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "second", content, false);
		});
		this.addWidget(this.second);
	}
}