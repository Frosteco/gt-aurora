package com.frosteco.gt_aurora.common.metatileentities;

import static com.frosteco.gt_aurora.api.util.GT_AURORAUtil.gt_auroraId;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

import com.frosteco.gt_aurora.common.metatileentities.multiblock.*;

public final class GT_AURORAMetaTileEntities {

    public static MetaTileEntityQuantumStringDeterminator QUANTUM_STRING_DETERMINATOR;


    private GT_AURORAMetaTileEntities() {}

    public static void init() {
        QUANTUM_STRING_DETERMINATOR = registerMetaTileEntity(6000,
                new MetaTileEntityQuantumStringDeterminator(gt_auroraId("quantum_string_determinator")));
    }
}
