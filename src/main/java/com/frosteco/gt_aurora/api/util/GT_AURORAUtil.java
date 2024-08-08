package com.frosteco.gt_aurora.api.util;

import java.util.Arrays;
import java.util.OptionalDouble;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.util.RelativeDirection;

public final class GT_AURORAUtil {

    public static ResourceLocation gt_auroraId(String name) {
        return new ResourceLocation("gt_aurora", name);
    }

    /**
     * Returns a BlockPos offset from the controller by the given values
     *
     * @param controller the controller whose position we should reference
     * @param x          Positive is controller left, Negative is controller right
     * @param y          Positive is controller up, Negative is controller down
     * @param z          Positive is controller front, Negative is controller back
     * @return Offset BlockPos
     */
    public static BlockPos bbHelper(MultiblockControllerBase controller, int x, int y, int z) {
        EnumFacing frontFacing = controller.getFrontFacing();
        EnumFacing upwardsFacing = controller.getUpwardsFacing();
        boolean isFlipped = controller.isFlipped();

        return controller.getPos()
                .offset(RelativeDirection.FRONT.getRelativeFacing(frontFacing, upwardsFacing, isFlipped), z)
                .offset(RelativeDirection.LEFT.getRelativeFacing(frontFacing, upwardsFacing, isFlipped), x)
                .offset(RelativeDirection.UP.getRelativeFacing(frontFacing, upwardsFacing, isFlipped), y);
    }

    public static int filteredPos(BlockPos pos, EnumFacing facing) {
        return filteredPos(pos, facing.getAxis()) * facing.getAxisDirection().getOffset();
    }

    public static int filteredPos(BlockPos pos, EnumFacing.Axis axis) {
        if (axis == null) {
            throw new IllegalArgumentException("Axis cannot be null");
        }

        switch (axis) {
            case Y:
                return pos.getY();
            case X:
                return pos.getX();
            default:
                return pos.getZ();
        }
    }

    public static double geometricMean(double... numbers) {
        OptionalDouble total = Arrays.stream(numbers).reduce((a, b) -> a * b);
        if (total.isPresent()) {
            return Math.pow(total.getAsDouble(), 1D / numbers.length);
        } else return 0;
    }

    public static double pythagoreanAverage(double... numbers) {
        double sum = 0;
        for (double d : numbers) {
            sum += Math.pow(d, 2);
        }
        return Math.pow(sum, 0.5);
    }

    public static int truncateLong(long number) {
        return (int) Math.min(Integer.MAX_VALUE, number);
    }
}
