package com.jdawg3636.icbm.common.event;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * Separate Event Handler for Mod's Own Events
 * Keeps stuff like blast behavior separate from core functionality such as registration
 */
public class ICBMEvents {

    @SubscribeEvent
    public static void onBlast(BlastEvent event) {
        // Based on net.minecraft.world.Explosion.doExplosionB(boolean spawnParticles)

        // Sound
        event.getBlastWorld().playSound(event.getBlastPosition().getX(), event.getBlastPosition().getY(), event.getBlastPosition().getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 4.0F, (1.0F + (event.getBlastWorld().rand.nextFloat() - event.getBlastWorld().rand.nextFloat()) * 0.2F) * 0.7F, false);
        // Particles
        event.getBlastWorld().addParticle(ParticleTypes.EXPLOSION_EMITTER, event.getBlastPosition().getX(), event.getBlastPosition().getY(), event.getBlastPosition().getZ(), 1.0D, 0.0D, 0.0D);
    }

    @SubscribeEvent
    public static void onBlastIncendiary(BlastEvent.Incendiary event) {
        // Copied (with slight modifications) from old icbm.content.blast.BlastFire
        // Would like to clean this up a bit if possible
        if (!event.getBlastWorld().isRemote) {

            int radius = (int) 6; //TODO Figure out the correct (original) value for this is

            for (int x = 0; x < radius; ++x) {
                for (int y = 0; y < radius; ++y) {
                    for (int z = 0; z < radius; ++z) {

                        if (x == 0 || x == radius - 1 || y == 0 || y == radius - 1 || z == 0 || z == radius - 1) {

                            double xStep = x / (radius - 1.0F) * 2.0F - 1.0F;
                            double yStep = y / (radius - 1.0F) * 2.0F - 1.0F;
                            double zStep = z / (radius - 1.0F) * 2.0F - 1.0F;
                            double diagonalDistance = Math.sqrt(xStep * xStep + yStep * yStep + zStep * zStep);
                            xStep /= diagonalDistance;
                            yStep /= diagonalDistance;
                            zStep /= diagonalDistance;
                            float var14 = radius * (0.7F + event.getBlastWorld().rand.nextFloat() * 0.6F);
                            double var15 = event.getBlastPosition().getX();
                            double var17 = event.getBlastPosition().getY();
                            double var19 = event.getBlastPosition().getZ();

                            for (float var21 = 0.3F; var14 > 0.0F; var14 -= var21 * 0.75F) {

                                BlockPos targetPosition = new BlockPos(var15, var17, var19);
                                double distanceFromCenter = Math.sqrt(event.getBlastPosition().distanceSq(targetPosition));
                                BlockState blockState = event.getBlastWorld().getBlockState(targetPosition);
                                Block block = blockState.getBlock();

                                if (!block.isAir(blockState, event.getBlastWorld(), targetPosition))
                                    var14 -= (block.getExplosionResistance() + 0.3F) * var21;

                                if (var14 > 0.0F) {

                                    // Set fire by chance and distance
                                    double chance = radius - (Math.random() * distanceFromCenter);

                                    if (chance > distanceFromCenter * 0.55) {

                                        boolean canReplace = blockState.getMaterial().isReplaceable() || block.isAir(blockState, event.getBlastWorld(), targetPosition);

                                        if (canReplace)
                                            event.getBlastWorld().setBlockState(targetPosition, Blocks.FIRE.getDefaultState());
                                        else if (block == Blocks.ICE) {
                                            event.getBlastWorld().setBlockState(targetPosition, Blocks.WATER.getDefaultState());
                                            event.getBlastWorld().neighborChanged(targetPosition, Blocks.WATER, targetPosition);
                                        }

                                    }

                                }

                                var15 += xStep * var21;
                                var17 += yStep * var21;
                                var19 += zStep * var21;

                            }
                        }
                    }
                }
            }
        }

    }

}
