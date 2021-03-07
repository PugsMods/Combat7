package com.putopug.combat7.init;

import com.putopug.combat7.combat7;
import com.putopug.combat7.gui.container.ItomeContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerRegHandler {

	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister
			.create(ForgeRegistries.CONTAINERS, combat7.MOD_ID);

	public static final RegistryObject<ContainerType<ItomeContainer>> ITOME_CONTAINER_TYPE = CONTAINER_TYPES
			.register("display_case", () -> IForgeContainerType.create(ItomeContainer::new));

}