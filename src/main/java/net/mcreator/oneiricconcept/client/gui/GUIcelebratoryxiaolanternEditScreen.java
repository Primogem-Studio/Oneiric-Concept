package net.mcreator.oneiricconcept.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.oneiricconcept.world.inventory.GUIcelebratoryxiaolanternEditMenu;
import net.mcreator.oneiricconcept.procedures.GetLantarnBackGrandProcedure;
import net.mcreator.oneiricconcept.network.GUIcelebratoryxiaolanternEditButtonMessage;
import net.mcreator.oneiricconcept.init.OneiricconceptModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class GUIcelebratoryxiaolanternEditScreen extends AbstractContainerScreen<GUIcelebratoryxiaolanternEditMenu> implements OneiricconceptModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	EditBox first;
	EditBox second;
	EditBox third;
	Button button_empty;
	Button button_empty1;
	Button button_save;

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
			if (name.equals("first"))
				first.setValue(stringState);
			else if (name.equals("second"))
				second.setValue(stringState);
			else if (name.equals("third"))
				third.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		first.render(guiGraphics, mouseX, mouseY, partialTicks);
		second.render(guiGraphics, mouseX, mouseY, partialTicks);
		third.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(ResourceLocation.parse("oneiricconcept:textures/screens/celebratory1.png"), this.leftPos + 0, this.topPos + 0, Mth.clamp((int) GetLantarnBackGrandProcedure.execute(world, x, y, z, entity) * 400, 0, 2000), 0, 400, 216, 2400,
				216);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (first.isFocused())
			return first.keyPressed(key, b, c);
		if (second.isFocused())
			return second.keyPressed(key, b, c);
		if (third.isFocused())
			return third.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String firstValue = first.getValue();
		String secondValue = second.getValue();
		String thirdValue = third.getValue();
		super.resize(minecraft, width, height);
		first.setValue(firstValue);
		second.setValue(secondValue);
		third.setValue(thirdValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.oneiricconcept.gu_icelebratoryxiaolantern_edit.label_switch_background_image"), 190, 19, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		first = new EditBox(this.font, this.leftPos + 195, this.topPos + 46, 118, 18, Component.translatable("gui.oneiricconcept.gu_icelebratoryxiaolantern_edit.first"));
		first.setMaxLength(8192);
		first.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "first", content, false);
		});
		this.addWidget(this.first);
		second = new EditBox(this.font, this.leftPos + 195, this.topPos + 70, 118, 18, Component.translatable("gui.oneiricconcept.gu_icelebratoryxiaolantern_edit.second"));
		second.setMaxLength(8192);
		second.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "second", content, false);
		});
		this.addWidget(this.second);
		third = new EditBox(this.font, this.leftPos + 195, this.topPos + 94, 118, 18, Component.translatable("gui.oneiricconcept.gu_icelebratoryxiaolantern_edit.third"));
		third.setMaxLength(8192);
		third.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "third", content, false);
		});
		this.addWidget(this.third);
		button_empty = Button.builder(Component.translatable("gui.oneiricconcept.gu_icelebratoryxiaolantern_edit.button_empty"), e -> {
			int x = GUIcelebratoryxiaolanternEditScreen.this.x;
			int y = GUIcelebratoryxiaolanternEditScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new GUIcelebratoryxiaolanternEditButtonMessage(0, x, y, z));
				GUIcelebratoryxiaolanternEditButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 315, this.topPos + 15, 30, 20).build();
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.oneiricconcept.gu_icelebratoryxiaolantern_edit.button_empty1"), e -> {
			int x = GUIcelebratoryxiaolanternEditScreen.this.x;
			int y = GUIcelebratoryxiaolanternEditScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new GUIcelebratoryxiaolanternEditButtonMessage(1, x, y, z));
				GUIcelebratoryxiaolanternEditButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 347, this.topPos + 15, 30, 20).build();
		this.addRenderableWidget(button_empty1);
		button_save = Button.builder(Component.translatable("gui.oneiricconcept.gu_icelebratoryxiaolantern_edit.button_save"), e -> {
			int x = GUIcelebratoryxiaolanternEditScreen.this.x;
			int y = GUIcelebratoryxiaolanternEditScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new GUIcelebratoryxiaolanternEditButtonMessage(2, x, y, z));
				GUIcelebratoryxiaolanternEditButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 331, this.topPos + 177, 46, 20).build();
		this.addRenderableWidget(button_save);
	}
}