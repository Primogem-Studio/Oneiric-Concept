package net.mcreator.oneiricconcept.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.oneiricconcept.world.inventory.LibGuiMenu;
import net.mcreator.oneiricconcept.procedures.IsUUIDTrueProcedure;
import net.mcreator.oneiricconcept.procedures.IsUUIDFalseProcedure;
import net.mcreator.oneiricconcept.procedures.GetplayerpositionProcedure;
import net.mcreator.oneiricconcept.procedures.GetPlayerNameProcedure;
import net.mcreator.oneiricconcept.procedures.GetPlayerEntityProcedure;
import net.mcreator.oneiricconcept.network.LibGuiButtonMessage;
import net.mcreator.oneiricconcept.init.OneiricconceptModScreens;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class LibGuiScreen extends AbstractContainerScreen<LibGuiMenu> implements OneiricconceptModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_empty;
	Button button_empty1;
	Button button_getuid;

	public LibGuiScreen(LibGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("oneiricconcept:textures/screens/lib_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (GetPlayerEntityProcedure.execute(world, entity) instanceof LivingEntity livingEntity) {
			if (IsUUIDTrueProcedure.execute(world, entity))
				OneiricconceptModScreens.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 87, this.topPos + 114, 42, 0f, 0, livingEntity);
		}
		boolean customTooltipShown = false;
		if (IsUUIDTrueProcedure.execute(world, entity))
			if (mouseX > leftPos + 63 && mouseX < leftPos + 87 && mouseY > topPos + 90 && mouseY < topPos + 114) {
				String hoverText = GetplayerpositionProcedure.execute(world, entity);
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (IsUUIDTrueProcedure.execute(world, entity))
			if (mouseX > leftPos + 87 && mouseX < leftPos + 111 && mouseY > topPos + 90 && mouseY < topPos + 114) {
				String hoverText = GetplayerpositionProcedure.execute(world, entity);
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (IsUUIDTrueProcedure.execute(world, entity))
			if (mouseX > leftPos + 63 && mouseX < leftPos + 87 && mouseY > topPos + 66 && mouseY < topPos + 90) {
				String hoverText = GetplayerpositionProcedure.execute(world, entity);
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (IsUUIDTrueProcedure.execute(world, entity))
			if (mouseX > leftPos + 87 && mouseX < leftPos + 111 && mouseY > topPos + 66 && mouseY < topPos + 90) {
				String hoverText = GetplayerpositionProcedure.execute(world, entity);
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (IsUUIDTrueProcedure.execute(world, entity))
			if (mouseX > leftPos + 63 && mouseX < leftPos + 87 && mouseY > topPos + 42 && mouseY < topPos + 66) {
				String hoverText = GetplayerpositionProcedure.execute(world, entity);
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (IsUUIDTrueProcedure.execute(world, entity))
			if (mouseX > leftPos + 87 && mouseX < leftPos + 111 && mouseY > topPos + 42 && mouseY < topPos + 66) {
				String hoverText = GetplayerpositionProcedure.execute(world, entity);
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
		guiGraphics.drawString(this.font, GetPlayerNameProcedure.execute(world, entity), 11, 115, -13408513, false);
		if (IsUUIDFalseProcedure.execute(world, entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.oneiricconcept.lib_gui.label_no_signal"), 64, 71, -52480, false);
		if (IsUUIDFalseProcedure.execute(world, entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.oneiricconcept.lib_gui.label_player_not_connected"), 64, 52, -26368, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.oneiricconcept.lib_gui.button_empty"), e -> {
			int x = LibGuiScreen.this.x;
			int y = LibGuiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LibGuiButtonMessage(0, x, y, z));
				LibGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 13, this.topPos + 132, 30, 20).build();
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.oneiricconcept.lib_gui.button_empty1"), e -> {
			int x = LibGuiScreen.this.x;
			int y = LibGuiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LibGuiButtonMessage(1, x, y, z));
				LibGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 71, this.topPos + 132, 30, 20).build();
		this.addRenderableWidget(button_empty1);
		button_getuid = Button.builder(Component.translatable("gui.oneiricconcept.lib_gui.button_getuid"), e -> {
			int x = LibGuiScreen.this.x;
			int y = LibGuiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LibGuiButtonMessage(2, x, y, z));
				LibGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 106, this.topPos + 132, 56, 20).build();
		this.addRenderableWidget(button_getuid);
	}
}