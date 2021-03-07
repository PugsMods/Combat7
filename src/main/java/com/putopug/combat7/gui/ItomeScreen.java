package com.putopug.combat7.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
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
    private static final ResourceLocation ITOME_UI = new ResourceLocation(combat7.MOD_ID,"textures/gui/itome.png");
    public ItomeScreen(ItomeContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {

    }
}
