package net.mcreator.oneiricconcept.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.oneiricconcept.world.inventory.WhiteMoonlightAbsorberGUIMenu;
import net.mcreator.oneiricconcept.procedures.WhiteMoonlightAbsorbProcedure;
import net.mcreator.oneiricconcept.procedures.GetPhaseTextProcedure;
import net.mcreator.oneiricconcept.procedures.GetPhaseProcedure;
import net.mcreator.oneiricconcept.init.OneiricconceptModScreens;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class WhiteMoonlightAbsorberGUIScreen extends AbstractContainerScreen<WhiteMoonlightAbsorberGUIMenu> implements OneiricconceptModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public WhiteMoonlightAbsorberGUIScreen(WhiteMoonlightAbsorberGUIMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = ResourceLocation.parse("oneiricconcept:textures/screens/white_moonlight_absorber_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 76 && mouseX < leftPos + 100 && mouseY > topPos + 5 && mouseY < topPos + 29) {
			String hoverText = GetPhaseTextProcedure.execute(world, x, y, z);
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
		guiGraphics.blit(ResourceLocation.parse("oneiricconcept:textures/screens/phase.png"), this.leftPos + 84, this.topPos + 17, Mth.clamp((int) GetPhaseProcedure.execute(world) * 8, 0, 32), 0, 8, 8, 40, 8);
		guiGraphics.blit(ResourceLocation.parse("oneiricconcept:textures/screens/moonlight.png"), this.leftPos + 84, this.topPos + 29, Mth.clamp((int) WhiteMoonlightAbsorbProcedure.execute(world, x, y, z) * 8, 0, 240), 0, 8, 30, 248, 30);
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