package com.putopug.combat7;

import com.putopug.combat7.init.blocks.BlockRegistryHandler;
import com.putopug.combat7.init.items.ItemRegistryHandler;
import com.putopug.combat7.init.items.ArmRegHandler;
import com.putopug.combat7.init.items.ToolRegistryHandler;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

@Mod("combat7")
/*
Author : PutoPug
 */

public class combat7
{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "combat7";
    public static combat7 instance;

    public combat7()
    {
        //Item Registring
        ItemRegistryHandler.init();
        ToolRegistryHandler.init();
        BlockRegistryHandler.init();
        ArmRegHandler.init();


        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        instance = this;
    }
    public void PrintDebugInfo()
    {
        LOGGER.warn("COMBAT LOGGER IS CURRENTLY IN ALPHA, BUGS MAY ARISE..");
        LOGGER.debug("Combat7 Version:");
        LOGGER.debug("Combat7 McVersion:");
        LOGGER.debug("Combat7 JEI Support Version:");
        LOGGER.debug("JEI MC Version:");
        LOGGER.debug("Combat7 Compilation Time:");
        LOGGER.debug("--GPU Info--");
        LOGGER.debug("GPU Vendor:");

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        //ComposterBlock.registerCompostable(100, Blocks.DIAMOND_BLOCK);
        // some preinit code
       //PrintDebugInfo();

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client

    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
