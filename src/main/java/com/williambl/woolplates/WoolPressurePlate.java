package com.williambl.woolplates;

import net.minecraft.block.PressurePlateBlock;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class WoolPressurePlate extends PressurePlateBlock {
    protected WoolPressurePlate(Settings settings) {
        super(ActivationRule.EVERYTHING, settings);
    }

    @Override
    public void onLandedUpon(World world, BlockPos pos, Entity entity, float distance) {
        super.onLandedUpon(world, pos, entity, distance * 0.8f);
    }

    @Override
    protected void playDepressSound(IWorld world, BlockPos pos) {
        world.playSound(null, pos, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3f, 0.8f);
    }

    @Override
    protected void playPressSound(IWorld world, BlockPos pos) {
        world.playSound(null, pos, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3f, 0.8f);
    }
}
