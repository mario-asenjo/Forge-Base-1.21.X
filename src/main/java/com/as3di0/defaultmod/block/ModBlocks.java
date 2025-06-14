package com.as3di0.defaultmod.block;

import com.as3di0.defaultmod.DefaultMod;
import com.as3di0.defaultmod.item.ModItems;
import com.nimbusds.jose.util.Resource;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DefaultMod.MOD_ID);

    public static final RegistryObject<Block> MARIANITE_BLOCK = registrerBlock("marianite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DefaultMod.MOD_ID, "marianite_block")))
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.ANCIENT_DEBRIS)
            ));

    public static final RegistryObject<Block> MARIANITE_ORE_BLOCK = registrerBlock("marianite_ore_block",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DefaultMod.MOD_ID, "marianite_ore_block")))
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST_CLUSTER)));

    public static final RegistryObject<Block> MARIANITE_DEEPSLATE_ORE = registrerBlock("marianite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DefaultMod.MOD_ID, "marianite_deepslate_ore")))
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.CANDLE))
            );

    private static <T extends Block> RegistryObject<T> registrerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DefaultMod.MOD_ID, name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
