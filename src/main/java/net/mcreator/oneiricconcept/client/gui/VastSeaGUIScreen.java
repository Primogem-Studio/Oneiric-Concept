package net.mcreator.oneiricconcept.client.gui;

import net.neoforged.neoforge.client.gui.widget.ExtendedSlider;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.oneiricconcept.world.inventory.VastSeaGUIMenu;
import net.mcreator.oneiricconcept.init.OneiricconceptModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class VastSeaGUIScreen extends AbstractContainerScreen<VastSeaGUIMenu> implements OneiricconceptModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Checkbox dolphin;
	private Checkbox fire;
	private ExtendedSlider conduit;
	private ExtendedSlider energy;

	public VastSeaGUIScreen(VastSeaGUIMenu container, Inventory inventory, Component text) {
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
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("dolphin")) {
				if (dolphin.selected() != logicState)
					dolphin.onPress();
			} else if (name.equals("fire")) {
				if (fire.selected() != logicState)
					fire.onPress();
			}
		}
		if (elementType == 2 && elementState instanceof Number n) {
			if (name.equals("conduit"))
				conduit.setValue(n.doubleValue());
			else if (name.equals("energy"))
				energy.setValue(n.doubleValue());
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("oneiricconcept:textures/screens/vast_sea_gui.png");

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
	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		return (this.getFocused() != null && this.isDragging() && button == 0) ? this.getFocused().mouseDragged(mouseX, mouseY, button, dragX, dragY) : super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		dolphin = Checkbox.builder(Component.translatable("gui.oneiricconcept.vast_sea_gui.dolphin"), this.font).pos(this.leftPos + 51, this.topPos + 81).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "dolphin", value, false);
		}).build();
		this.addRenderableWidget(dolphin);
		fire = Checkbox.builder(Component.translatable("gui.oneiricconcept.vast_sea_gui.fire"), this.font).pos(this.leftPos + 51, this.topPos + 107).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "fire", value, false);
		}).build();
		this.addRenderableWidget(fire);
		conduit = new ExtendedSlider(this.leftPos + 51, this.topPos + 20, 77, 20, Component.translatable("gui.oneiricconcept.vast_sea_gui.conduit_prefix"), Component.translatable("gui.oneiricconcept.vast_sea_gui.conduit_suffix"), 0, 5, 5, 1, 0,
				true) {
			@Override
			protected void applyValue() {
				if (!menuStateUpdateActive)
					menu.sendMenuStateUpdate(entity, 2, "conduit", this.getValue(), false);
			}
		};
		this.addRenderableWidget(conduit);
		if (!menuStateUpdateActive)
			menu.sendMenuStateUpdate(entity, 2, "conduit", conduit.getValue(), false);
		energy = new ExtendedSlider(this.leftPos + 51, this.topPos + 50, 72, 20, Component.translatable("gui.oneiricconcept.vast_sea_gui.energy_prefix"), Component.translatable("gui.oneiricconcept.vast_sea_gui.energy_suffix"), 0, 5, 3, 1, 0, true) {
			@Override
			protected void applyValue() {
				if (!menuStateUpdateActive)
					menu.sendMenuStateUpdate(entity, 2, "energy", this.getValue(), false);
			}
		};
		this.addRenderableWidget(energy);
		if (!menuStateUpdateActive)
			menu.sendMenuStateUpdate(entity, 2, "energy", energy.getValue(), false);
	}
}