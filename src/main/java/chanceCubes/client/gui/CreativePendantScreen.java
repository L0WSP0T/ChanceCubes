package chanceCubes.client.gui;

import chanceCubes.CCubesCore;
import chanceCubes.containers.CreativePendantContainer;
import chanceCubes.network.CCubesPacketHandler;
import chanceCubes.network.PacketCreativePendant;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CreativePendantScreen extends AbstractContainerScreen<CreativePendantContainer>
{
	private static final ResourceLocation GUI_BG = new ResourceLocation(CCubesCore.MODID, "textures/gui/container/gui_creative_pendant.png");

	private int chanceValue = 0;

	public CreativePendantScreen(CreativePendantContainer pendantContainer, Inventory inv, Component component)
	{
		super(pendantContainer, inv, component);
	}

	@Override
	protected void init()
	{
		super.init();
		int halfWidth = this.width / 2;
		int halfHeight = (this.height / 2);
		this.addRenderableWidget(new Button(halfWidth - 40, halfHeight - 60, 20, 20, new TextComponent("-1"), p_onPress_1_ -> this.changeChanceValue(-1)));
		this.addRenderableWidget(new Button(halfWidth + 15, halfHeight - 60, 20, 20, new TextComponent("+1"), p_onPress_1_ -> this.changeChanceValue(1)));
		this.addRenderableWidget(new Button(halfWidth - 60, halfHeight - 60, 20, 20, new TextComponent("-5"), p_onPress_1_ -> this.changeChanceValue(-5)));
		this.addRenderableWidget(new Button(halfWidth + 35, halfHeight - 60, 20, 20, new TextComponent("+5"), p_onPress_1_ -> this.changeChanceValue(5)));
		this.addRenderableWidget(new Button(halfWidth - 80, halfHeight - 60, 20, 20, new TextComponent("-10"), p_onPress_1_ -> this.changeChanceValue(-10)));
		this.addRenderableWidget(new Button(halfWidth + 55, halfHeight - 60, 20, 20, new TextComponent("+10"), p_onPress_1_ -> this.changeChanceValue(10)));
		this.addRenderableWidget(new Button(halfWidth + 12, halfHeight - 35, 70, 20, new TextComponent("Set Chance"), p_onPress_1_ -> CCubesPacketHandler.CHANNEL.sendToServer(new PacketCreativePendant(this.chanceValue))));
	}

	public void changeChanceValue(int amount)
	{
		this.chanceValue += amount;
		if(this.chanceValue > 100)
			this.chanceValue = 100;
		if(this.chanceValue < -100)
			this.chanceValue = -100;
	}

	@Override
	protected void renderBg(PoseStack poseStack, float p_97788_, int p_97789_, int p_97790_)
	{
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, GUI_BG);
		int i = (this.width - this.imageWidth) / 2;
		int j = (this.height - this.imageHeight) / 2;
		this.blit(poseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int p_97936_, int p_97937_)
	{
		drawString(poseStack, this.font, "Chance Value", 50, 5, 0);
		String cValue = String.valueOf(this.chanceValue);
		drawString(poseStack, this.font, cValue, (88 - (cValue.length() * 3)), 27, 0);
	}

	@Override
	public void render(PoseStack poseStack, int p_97922_, int p_97923_, float p_97924_)
	{
		this.renderBackground(poseStack);
		super.render(poseStack, p_97922_, p_97923_, p_97924_);
		this.renderTooltip(poseStack, p_97922_, p_97923_);
	}
}
