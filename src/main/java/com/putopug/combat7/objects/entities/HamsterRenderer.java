package com.putopug.combat7.objects.entities;

import com.putopug.combat7.combat7;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

/*
 * @author: PutoPug
 */
public class HamsterRenderer extends MobRenderer<HamsterEntity, HamsterModel> {
    public HamsterRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HamsterModel(),0.3F);
    }

    @Override
    public ResourceLocation getEntityTexture(HamsterEntity entity) {
        return new ResourceLocation(combat7.MOD_ID,"textures/entity/hamster.png");
    }
}
