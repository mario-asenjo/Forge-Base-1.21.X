package com.as3di0.defaultmod.item;

import com.as3di0.defaultmod.DefaultMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DefaultMod.MODID);

    public static final RegistryObject<Item> MARIANITEINGOT = ITEMS.register("marianite-ingot",
            () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(
                            Registries.ITEM,
                            ResourceLocation.fromNamespaceAndPath(DefaultMod.MODID, "marianite-ingot")
                    ))
            )
    );

    public static final RegistryObject<Item> MARIANITEORE = ITEMS.register("marianite-ore",
            () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(
                            Registries.ITEM,
                            ResourceLocation.fromNamespaceAndPath(DefaultMod.MODID, "marianite-ore")
                    ))
            )
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
