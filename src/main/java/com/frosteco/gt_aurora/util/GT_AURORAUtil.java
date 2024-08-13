package com.frosteco.gt_aurora.util;

import net.minecraft.util.ResourceLocation;

public final class GT_AURORAUtil
{
    public static ResourceLocation gt_auroraId(String name)
    {
        return new ResourceLocation(Reference.MOD_ID, name);
    }
        private GT_AURORAUtil() {}
}