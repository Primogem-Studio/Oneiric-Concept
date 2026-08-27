package net.mcreator.oneiricconcept.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.oneiricconcept.world.inventory.JanusGUIMenu;
import net.mcreator.oneiricconcept.procedures.IsJanusDataProcedure;
import net.mcreator.oneiricconcept.procedures.GetJanusDataProcedure;
import net.mcreator.oneiricconcept.procedures.AntiIsJanusDataProcedure;
import net.mcreator.oneiricconcept.network.JanusGUIButtonMessage;
import net.mcreator.oneiricconcept.init.OneiricconceptModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class JanusGUIScreen extends AbstractContainerScreen<JanusGUIMenu> implements OneiricconceptModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_quickly_traverse;

	public JanusGUIScreen(JanusGUIMenu container, Inventory inventory, Component text) {
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

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (AntiIsJanusDataProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 9 && mouseX < leftPos + 33 && mouseY > topPos + 53 && mouseY < topPos + 77) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.oneiricconcept.janus_gui.tooltip_use_your_phone_to_aim_the_crossh"), mouseX, mouseY);
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
		guiGraphics.blit(ResourceLocation.parse("oneiricconcept:textures/screens/janusgui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 166, 176, 166);
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
		guiGraphics.drawString(this.font, GetJanusDataProcedure.execute(world, x, y, z), 35, 17, -12829636, false);
		if (AntiIsJanusDataProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, Component.translatable("gui.oneiricconcept.janus_gui.label_empty"), 18, 59, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_quickly_traverse = Button.builder(Component.translatable("gui.oneiricconcept.janus_gui.button_quickly_traverse"), e -> {
			int x = JanusGUIScreen.this.x;
			int y = JanusGUIScreen.this.y;
			if (IsJanusDataProcedure.execute(world, x, y, z)) {
				PacketDistributor.sendToServer(new JanusGUIButtonMessage(0, x, y, z));
				JanusGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 36, this.topPos + 51, 108, 20).build();
		this.addRenderableWidget(button_quickly_traverse);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.button_quickly_traverse.visible = IsJanusDataProcedure.execute(world, x, y, z);
	}
}