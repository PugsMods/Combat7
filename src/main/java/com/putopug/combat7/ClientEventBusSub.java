package com.putopug.combat7;

import com.putopug.combat7.init.EntityRegHandler;
import com.putopug.combat7.objects.entities.HamsterRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/*
 * @author: PutoPug
 */
@Mod.EventBusSubscriber(modid = combat7.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventBusSub {

    public static void init(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityRegHandler.HAMSTER.get(), HamsterRenderer::new);
    }
}
