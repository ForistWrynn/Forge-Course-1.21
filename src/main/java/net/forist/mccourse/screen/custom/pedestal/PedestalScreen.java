package net.forist.mccourse.screen.custom.pedestal;

import com.mojang.blaze3d.systems.RenderSystem;
import net.forist.mccourse.MCCourseMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class PedestalScreen extends AbstractContainerScreen<PedestalMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "textures/gui/pedestal/pedestal_gui.png");

    public PedestalScreen(PedestalMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        //Gets rid of Title and Inventory
        this.inventoryLabelY = 1000;
        this.titleLabelY = 1000;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int pMouseX, int pMouseY)
    {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F,1.0F,1.0F,1.0F);
        RenderSystem.setShaderTexture(0,GUI_TEXTURE);

        int x = (width - imageWidth)/2;
        int y = (height - imageHeight)/2;

        // imageWidth&Height = 256*256 (Size of image for gui)

        guiGraphics.blit(GUI_TEXTURE,x,y,0,0,imageWidth, imageHeight);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float delta) {
        renderBackground(guiGraphics, pMouseX,pMouseY,delta);
        super.render(guiGraphics, pMouseX, pMouseY, delta);
        renderTooltip(guiGraphics,pMouseX,pMouseY);
    }
}
