package com.frosteco.gt_aurora.common.block.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

import gregtech.api.block.VariantBlock;

public class GT_AURORABlockStandardCasing extends VariantBlock<GT_AURORABlockStandardCasing.CasingType> {

    public GT_AURORABlockStandardCasing() {
        super(Material.IRON);
        setUnlocalizedName("standard_casing");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 4);
        setDefaultState(getState(CasingType.THERMOSTABLE_CERAMIC));
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos,
                                    @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum CasingType implements IStringSerializable {

        THERMOSTABLE_CERAMIC("thermostable_ceramic"),
        PRESSURE_CASING("high_pressure_casing"),
        UNSTABLE_HYPERSTATIC_CASING("unstable_hyperstatic_casing");

        private final String name;

        CasingType(String name) {
            this.name = name;
        }

        @Override
        public @Nonnull String getName() {
            return this.name;
        }
    }
}
