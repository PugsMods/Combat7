package com.putopug.combat7.objects.entities.pug;

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
public class PugModel extends EntityModel<PugEntity> {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer face;
    private final ModelRenderer ears;
    private final ModelRenderer ear_right;
    private final ModelRenderer cube_r1;
    private final ModelRenderer ear_left;
    private final ModelRenderer cube_r2;
    private final ModelRenderer snout;
    private final ModelRenderer tongue;
    private final ModelRenderer cube_r3;
    private final ModelRenderer torso;
    private final ModelRenderer tail;
    private final ModelRenderer bone;
    private final ModelRenderer cube_r4;
    private final ModelRenderer bone2;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer bone3;
    private final ModelRenderer legs;
    private final ModelRenderer leg_front_right;
    private final ModelRenderer leg_front_left;
    private final ModelRenderer leg_back_right;
    private final ModelRenderer leg_back_left;
    public PugModel() {
        textureWidth = 64;
        textureHeight = 64;
        body = new ModelRenderer(this);
        body.setRotationPoint(0.5F, 24.5F, -5.0F);
        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(head);
        face = new ModelRenderer(this);
        face.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(face);
        face.setTextureOffset(0, 20).addBox(-4.0F, -15.0F, -6.0F, 7.0F, 7.0F, 7.0F, 0.0F, false);
        ears = new ModelRenderer(this);
        ears.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(ears);
        ear_right = new ModelRenderer(this);
        ear_right.setRotationPoint(0.0F, 0.0F, 0.0F);
        ears.addChild(ear_right);
        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(-4.0F, -14.0F, -2.75F);
        ear_right.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0F, 0.2618F);
        cube_r1.setTextureOffset(33, 20).addBox(-0.75F, -0.75F, -1.5F, 1.0F, 4.0F, 4.0F, 0.0F, false);
        ear_left = new ModelRenderer(this);
        ear_left.setRotationPoint(0.0F, 0.0F, 0.0F);
        ears.addChild(ear_left);
        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(3.0F, -14.0F, -2.75F);
        ear_left.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, -0.2618F);
        cube_r2.setTextureOffset(0, 34).addBox(-0.25F, -0.75F, -1.5F, 1.0F, 4.0F, 4.0F, 0.0F, false);
        snout = new ModelRenderer(this);
        snout.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(snout);
        snout.setTextureOffset(0, 7).addBox(-3.0F, -12.0F, -7.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);
        tongue = new ModelRenderer(this);
        tongue.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(tongue);
        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(0.9F, -8.8114F, -7.446F);
        tongue.addChild(cube_r3);
        setRotationAngle(cube_r3, 1.0908F, 0.0F, 0.0F);
        cube_r3.setTextureOffset(6, 0).addBox(-1.0F, 0.25F, -1.75F, 2.0F, 0.0F, 3.0F, 0.0F, false);
        torso = new ModelRenderer(this);
        torso.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(torso);
        torso.setTextureOffset(0, 0).addBox(-4.5F, -11.5F, -1.0F, 8.0F, 7.0F, 13.0F, 0.0F, false);
        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(tail);
        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        tail.addChild(bone);
        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(-0.5F, -11.5F, 12.5F);
        bone.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.2618F, 0.0F, 0.0F);
        cube_r4.setTextureOffset(0, 20).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
        tail.addChild(bone2);
        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-2.0165F, -11.9857F, 8.7378F);
        bone2.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, 0.9599F, 0.0F);
        cube_r5.setTextureOffset(0, 24).addBox(-0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(-1.0F, -12.5F, 10.5F);
        bone2.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.1745F, 0.2618F, 0.0F);
        cube_r6.setTextureOffset(29, 7).addBox(-0.5F, -0.25F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
        tail.addChild(bone3);
        legs = new ModelRenderer(this);
        legs.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(legs);
        leg_front_right = new ModelRenderer(this);
        leg_front_right.setRotationPoint(0.0F, 0.0F, 0.0F);
        legs.addChild(leg_front_right);
        leg_front_right.setTextureOffset(28, 28).addBox(-4.25F, -4.5F, -0.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
        leg_front_left = new ModelRenderer(this);
        leg_front_left.setRotationPoint(0.0F, 0.0F, 0.0F);
        legs.addChild(leg_front_left);
        leg_front_left.setTextureOffset(29, 0).addBox(0.25F, -4.5F, -0.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
        leg_back_right = new ModelRenderer(this);
        leg_back_right.setRotationPoint(0.0F, 0.0F, 0.0F);
        legs.addChild(leg_back_right);
        leg_back_right.setTextureOffset(21, 20).addBox(-4.25F, -4.5F, 8.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
        leg_back_left = new ModelRenderer(this);
        leg_back_left.setRotationPoint(0.0F, 0.0F, 0.0F);
        legs.addChild(leg_back_left);
        leg_back_left.setTextureOffset(0, 0).addBox(0.25F, -4.5F, 8.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(PugEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
                       float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
