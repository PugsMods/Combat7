package com.putopug.combat7.objects.entities.hamster;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

/*
 * @author: PutoPug
 */
// Made with Blockbench 3.8.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
public class HamsterModel extends EntityModel<HamsterEntity> {
    private final ModelRenderer bone;

    public HamsterModel() {
        textureWidth = 32;
        textureHeight = 32;

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 23.0F, 0.0F);
        bone.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, 0.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
        bone.setTextureOffset(4, 14).addBox(2.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(0, 14).addBox(-1.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(13, 13).addBox(2.0F, 0.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(12, 2).addBox(-1.0F, 0.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(11, 7).addBox(-0.5F, -2.775F, -3.5F, 3.0F, 2.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(12, 0).addBox(-1.0F, -5.75F, -2.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(0, 2).addBox(2.0F, -5.75F, -2.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(0, 0).addBox(0.5F, -1.25F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(0, 7).addBox(-1.0F, -4.75F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(HamsterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bone.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
