package net.mcreator.oneiricconcept.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.oneiricconcept.world.inventory.GUIcelebratoryxiaolanternMenu;
import net.mcreator.oneiricconcept.procedures.IsTextWhiteProcedure;
import net.mcreator.oneiricconcept.procedures.IsTextBrownProcedure;
import net.mcreator.oneiricconcept.procedures.GetPlaceInformationProcedure;
import net.mcreator.oneiricconcept.procedures.GetLantern3Procedure;
import net.mcreator.oneiricconcept.procedures.GetLantern2Procedure;
import net.mcreator.oneiricconcept.procedures.GetLantern1Procedure;
import net.mcreator.oneiricconcept.procedures.GetLantarnBackGrandProcedure;
import net.mcreator.oneiricconcept.init.OneiricconceptModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class GUIcelebratoryxiaolanternScreen extends AbstractContainerScreen<GUIcelebratoryxiaolanternMenu> implements OneiricconceptModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public GUIcelebratoryxiaolanternScreen(GUIcelebratoryxiaolanternMenu container, Inventory inventory, Component text) {
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
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		if (IsTextBrownProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, GetLantern1Procedure.execute(world, x, y, z), 234, 59, -8101827, false);
		if (IsTextBrownProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, GetLantern2Procedure.execute(world, x, y, z), 234, 79, -8101827, false);
		if (IsTextBrownProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, GetLantern3Procedure.execute(world, x, y, z), 234, 98, -8101827, false);
		if (IsTextWhiteProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, GetLantern1Procedure.execute(world, x, y, z), 166, 79, -395036, false);
		if (IsTextWhiteProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, GetLantern2Procedure.execute(world, x, y, z), 167, 98, -395036, false);
		if (IsTextWhiteProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, GetLantern3Procedure.execute(world, x, y, z), 168, 116, -395036, false);
		guiGraphics.drawString(this.font, GetPlaceInformationProcedure.execute(world, x, y, z, entity), 199, 216, -395036, false);
	}

	@Override
	public void init() {
		super.init();
	}
}