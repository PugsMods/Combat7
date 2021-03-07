package com.putopug.combat7.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.putopug.combat7.combat7;
import com.putopug.combat7.gui.container.ItomeContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//
//@author PutoPug
//
@OnlyIn(Dist.CLIENT)
public class ItomeScreen extends ContainerScreen<ItomeContainer> {
    private static final ResourceLocation ITOME_UI = new ResourceLocation(combat7.MOD_ID,"textures/gui/itome_ui.png");
    public ItomeScreen(ItomeContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.guiLeft = 0;
        this.guiTop= 0;
        this.xSize=176;
        this.ySize=166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int mx, int my) {
        this.font.func_243248_b(matrixStack, this.playerInventory.getDisplayName(),(float) this.playerInventoryTitleX,(float) this.playerInventoryTitleY,4210752);
        RenderSystem.color4f(1f,1f,1f,1f);
        this.minecraft.textureManager.bindTexture(ITOME_UI);
        int x = (this.width - this.xSize) /2;
        int y = (this.height - this.ySize) /2;
        this.blit(matrixStack,x,y,0,0,this.xSize,this.ySize);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack,mouseX,mouseY);
    }
}
