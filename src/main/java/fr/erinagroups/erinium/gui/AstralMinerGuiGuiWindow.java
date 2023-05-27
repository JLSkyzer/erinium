
package fr.erinagroups.erinium.gui;

import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;
import net.minecraft.util.text.StringTextComponent;
import java.text.DecimalFormat;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class AstralMinerGuiGuiWindow extends ContainerScreen<AstralMinerGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = AstralMinerGuiGui.guistate;
	private String tooltipText = "";

	public AstralMinerGuiGuiWindow(AstralMinerGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("erinium:textures/screens/astral_miner_gui.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		AtomicInteger _retval = new AtomicInteger(0);
		TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
		_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
		// Définir le format souhaité
		DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
		// Formater le nombre avec le format spécifié
		String formattedNumber = decimalFormat.format(_retval.get());
		
		if (isMouseOverEnergy(mouseX, mouseY)) {
            tooltipText = "§a" + formattedNumber + " / 500,000";
        } else {
            tooltipText = "";
            }
        if (!tooltipText.isEmpty()) {
            renderTooltip(ms, new StringTextComponent(tooltipText), mouseX, mouseY);
        }
	}
	private boolean isMouseOverEnergy(int mouseX, int mouseY) {
        return mouseX >= this.guiLeft + 132 && mouseY >= this.guiTop + 7 && mouseX < this.guiLeft + 132 + 32 && mouseY < this.guiTop + 7 + 64;
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		AtomicInteger _retval = new AtomicInteger(0);
		TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
		_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
		double barre = 0.000128 * _retval.get();
		int posY = this.guiTop + 7 + (64 - (int) barre); // Calculer la position en inversant la croissance


		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("erinium:textures/screens/energy_bar_empty.png"));
		this.blit(ms, this.guiLeft + 132, this.guiTop + 7, 0, 0, 32, 64, 32, 64);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("erinium:textures/screens/energy_bar_fill.png"));
		this.blit(ms, this.guiLeft + 132, posY, 0, 0, 32, (int) barre, 32, 64);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		TileEntity tileEntity = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
		double percent = tileEntity.getTileData().getDouble("percent");
		DecimalFormat percentFormat = new DecimalFormat("###.##");
		String percentString = percentFormat.format(percent);
		
		this.font.drawString(ms, "Astral Miner", 2, 3, -16777216);
		this.font.drawString(ms, "§2" + percentString + "%", 78, 43, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
	}
}
