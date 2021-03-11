package com.putopug.combat7;

import com.putopug.combat7.init.*;
import com.putopug.combat7.world.biome.BiomeDummyHolder;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

@Mod("combat7")
@Mod.EventBusSubscriber(modid = combat7.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

//
//@author PutoPug
//
public class combat7
{
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("combat7", "combat7"),
            () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "combat7";
    public static combat7 instance;

    public combat7()
    {  elements = new Combat7Stuff();
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(new Combat7FMLBusEvents(this));
        //Register mod items, blocks, biomes
        ItemRegistryHandler.init();
        ToolRegistryHandler.init();
        BlockRegistryHandler.init();
        ArmRegHandler.init();
        BiomeDummyHolder.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

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
        elements.getElements().forEach(element -> element.init(event));
       //PrintDebugInfo();
       //BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(combat7.MOD_ID, "funky_land")), 2));
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        elements.getElements().forEach(element -> element.clientLoad(event));

    }

    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            LOGGER.info("Registering Combat7");
        }
    }
    public Combat7Stuff elements;

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(elements.getBlocks().stream().map(Supplier::get).toArray(Block[]::new));
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(elements.getItems().stream().map(Supplier::get).toArray(Item[]::new));
    }

    private static class Combat7FMLBusEvents {
        private final combat7 parent;
        Combat7FMLBusEvents(combat7 parent) {
            this.parent = parent;
        }
        @SubscribeEvent
        public void onServerStarting(FMLServerStartingEvent event) {

        }
    }

}
