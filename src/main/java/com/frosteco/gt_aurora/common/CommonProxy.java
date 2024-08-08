package com.frosteco.gt_aurora.common;

import java.util.Objects;
import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import com.frosteco.gt_aurora.GT_AURORAContent;
import com.frosteco.gt_aurora.common.block.GT_AURORAMetaBlocks;

import gregtech.api.block.VariantItemBlock;

@Mod.EventBusSubscriber(modid = "gt_aurora")
public class CommonProxy {

    public void registerItemRenderer(Item item, int meta, String id) {}
    
    public void preLoad() {}

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        GT_AURORAContent.log("Registering blocks...");
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(GT_AURORAMetaBlocks.STANDARD_CASING);
    }
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        GT_AURORAContent.log("Registering Items...");
        IForgeRegistry<Item> registry = event.getRegistry();

        registry.register(createItemBlock(GT_AURORAMetaBlocks.STANDARD_CASING, VariantItemBlock::new));
    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }
}