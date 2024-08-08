package com.frosteco.gt_aurora.common.metatileentities.multiblock;

import javax.annotation.Nonnull;

import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

import com.frosteco.gt_aurora.api.recipes.GT_AURORARecipeMaps;
import com.frosteco.gt_aurora.api.render.GT_AURORATextures;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.RelativeDirection;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.*;
import gregtech.common.metatileentities.MetaTileEntities;

public class MetaTileEntityQuantumStringDeterminator extends RecipeMapMultiblockController {

    public MetaTileEntityQuantumStringDeterminator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GT_AURORARecipeMaps.INFINITY_EXTRACTOR_RECIPES);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.DOWN, RelativeDirection.FRONT)
                .aisle("###", "I##", "IXS", "#SS", "###")
                .aisle("BB#", "###", "CNO", "#NG", "#V#").setRepeatable(1, 4)
                .aisle("BB#", "###", "CNF", "#NG", "#V#").setRepeatable(0, 1)
                .aisle("GG#", "EGG", "EMS", "#SS", "###")
                .where('S', getCasingState(0).or(autoAbilities(true, false)))
                .where('C', heatingCoils())
                .where('B', frames(Materials.Steel))
                .where('M', metaTileEntities(MetaTileEntities.MUFFLER_HATCH))
                .where('O', metaTileEntities(MetaTileEntities.ITEM_EXPORT_BUS[GTValues.ULV]))
                .where('F', abilities(MultiblockAbility.EXPORT_FLUIDS))
                .where('I', getCasingState(0).or(abilities(MultiblockAbility.IMPORT_ITEMS).setPreviewCount(1)))
                .where('E', getCasingState(0).or(abilities(MultiblockAbility.INPUT_ENERGY).setPreviewCount(2)))
                .where('V', states(Blocks.BEDROCK.getDefaultState()))
                .where('X', selfPredicate())
                .where('N', air())
                .where('#', any())
                .build();
    }
    
    @Nonnull
    protected static TraceabilityPredicate getCasingState(int id)
    {
        if (id == 0) {
            BlockMetalCasing casing = MetaBlocks.METAL_CASING;
            if (casing != null) {
                BlockMetalCasing.MetalCasingType type = BlockMetalCasing.MetalCasingType.STEEL_SOLID;
                if (type != null) {
                    return states(casing.getState(type));
                }
            }
        }
        // Returns a default state to avoid null pointer exceptions
        return states(Blocks.AIR.getDefaultState());
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @Override
    protected @Nonnull OrientedOverlayRenderer getFrontOverlay() {
        return GT_AURORATextures.QUANTUM_STRING_DETERMINATOR_OVERLAY;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return false;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityQuantumStringDeterminator(this.metaTileEntityId);
    }
}
