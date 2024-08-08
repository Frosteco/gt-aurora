package com.frosteco.gt_aurora.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

import com.frosteco.gt_aurora.common.block.blocks.GT_AURORABlockStandardCasing;

import gregtech.common.blocks.MetaBlocks;

public final class GT_AURORAMetaBlocks {

    private GT_AURORAMetaBlocks() {}

    public static GT_AURORABlockStandardCasing STANDARD_CASING;

    public static void init() {
        STANDARD_CASING = new GT_AURORABlockStandardCasing();
        STANDARD_CASING.setRegistryName("standard_casing");
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(STANDARD_CASING);
    }

    @SuppressWarnings("null")
    @SideOnly(Side.CLIENT)
    private static void registerItemModel(@Nonnull Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            // noinspection DataFlowIssue
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            MetaBlocks.statePropertiesToString(state.getProperties())));
        }
    }

    @SuppressWarnings({ "unused", "unchecked" })
    private static <T extends Comparable<T>> String getPropertyName(@Nonnull IProperty<T> property,
                                                                             Comparable<?> value) {
        return property.getName((T) value);
    }
}
