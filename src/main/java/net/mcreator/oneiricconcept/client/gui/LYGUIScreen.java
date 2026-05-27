package net.mcreator.oneiricconcept.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.oneiricconcept.world.inventory.LYGUIMenu;
import net.mcreator.oneiricconcept.init.OneiricconceptModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class LYGUIScreen extends AbstractContainerScreen<LYGUIMenu> implements OneiricconceptModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Checkbox isProj;
	private Checkbox isPlayProj;
	private Checkbox isTnt;
	private Checkbox isMob;

	public LYGUIScreen(LYGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 280;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("isProj")) {
				if (isProj.selected() != logicState)
					isProj.onPress();
			} else if (name.equals("isPlayProj")) {
				if (isPlayProj.selected() != logicState)
					isPlayProj.onPress();
			} else if (name.equals("isTnt")) {
				if (isTnt.selected() != logicState)
					isTnt.onPress();
			} else if (name.equals("isMob")) {
				if (isMob.selected() != logicState)
					isMob.onPress();
			}
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
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
		isProj = Checkbox.builder(Component.translatable("gui.oneiricconcept.lygui.isProj"), this.font).pos(this.leftPos + 16, this.topPos + 15).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "isProj", value, false);
		}).build();
		this.addRenderableWidget(isProj);
		isPlayProj = Checkbox.builder(Component.translatable("gui.oneiricconcept.lygui.isPlayProj"), this.font).pos(this.leftPos + 16, this.topPos + 54).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "isPlayProj", value, false);
		}).build();
		this.addRenderableWidget(isPlayProj);
		isTnt = Checkbox.builder(Component.translatable("gui.oneiricconcept.lygui.isTnt"), this.font).pos(this.leftPos + 16, this.topPos + 92).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "isTnt", value, false);
		}).build();
		this.addRenderableWidget(isTnt);
		isMob = Checkbox.builder(Component.translatable("gui.oneiricconcept.lygui.isMob"), this.font).pos(this.leftPos + 16, this.topPos + 130).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "isMob", value, false);
		}).build();
		this.addRenderableWidget(isMob);
	}
}