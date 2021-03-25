package com.putopug.combat7.objects.entities.pug;

import com.putopug.combat7.combat7;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

/*
 * @author: PutoPug
 */
public class PugRenderer extends MobRenderer<PugEntity, PugModel> {
    public PugRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PugModel(), 0.3F);
    }

    @Override
    public ResourceLocation getEntityTexture(PugEntity entity) {
        return new ResourceLocation(combat7.MOD_ID, "textures/entity/pug.png");
    }
}
