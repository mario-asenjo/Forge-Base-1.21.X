package com.as3di0.defaultmod.item;

import com.as3di0.defaultmod.DefaultMod;
import com.as3di0.defaultmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DefaultMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MARIANITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("marianite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MARIANITE_INGOT.get()))
                    .title(Component.translatable("creativetab.defaultmod.marianite_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MARIANITE_ORE.get());
                        output.accept(ModItems.MARIANITE_INGOT.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MARIANITE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("marianite_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MARIANITE_ORE_BLOCK.get()))
                    .withTabsBefore(MARIANITE_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.defaultmod.marianite_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.MARIANITE_BLOCK.get());
                        output.accept(ModBlocks.MARIANITE_ORE_BLOCK.get());
                        output.accept(ModBlocks.MARIANITE_DEEPSLATE_ORE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
