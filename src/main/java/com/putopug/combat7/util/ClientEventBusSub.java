package com.putopug.combat7.util;

import com.putopug.combat7.combat7;
import com.putopug.combat7.gui.ItomeScreen;
import com.putopug.combat7.init.ContainerRegHandler;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

//
//@author PutoPug
//
@Mod.EventBusSubscriber(modid = combat7.MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ClientEventBusSub {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        ScreenManager.registerFactory(ContainerRegHandler.ITOME_CONTAINER_TYPE.get(), ItomeScreen::new);
    }
}
