package com.frosteco.gt_aurora.client;

import com.frosteco.gt_aurora.common.item.GT_AURORAItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class GT_AURORACreativeTab extends CreativeTabs {
    public GT_AURORACreativeTab()
    {
       super("gt_aurora");
    }

    public ItemStack getTabIconItem()
    {
        return new ItemStack(GT_AURORAItems.HYPERCONDUCTING_ANTISCHRABIDIC_CIRCUIT);
    }
}