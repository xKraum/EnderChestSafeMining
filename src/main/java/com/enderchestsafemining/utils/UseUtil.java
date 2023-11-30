package com.enderchestsafemining.utils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;

public class UseUtil {

    /**
     * Checks if the player is currently performing a "use" action on a specific block.
     *
     * @param hitResult   The hit result indicating the target block.
     * @param player      The client player entity performing the action.
     * @param world       The client world in which the action is taking place.
     * @param targetBlock The target block to check against.
     * @return {@code true} if the player is doing use action on the specified block, otherwise {@code false}.
     */
    public static boolean isDoingUseOnBlock(HitResult hitResult, ClientPlayerEntity player,
                                            ClientWorld world, Block targetBlock) {
        if (hitResult != null && player != null && world != null && targetBlock != null) {
            boolean isTargetTypeBlock = hitResult.getType() == HitResult.Type.BLOCK;
            boolean isMainHandEmpty = player.getMainHandStack().isEmpty();

            if (isTargetTypeBlock && isMainHandEmpty) {
                BlockState blockState = world.getBlockState(new BlockPos(hitResult.getPos()));
                return blockState.isOf(targetBlock);
            }
        }

        return false;
    }

}
