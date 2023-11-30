package com.enderchestsafemining.mixin;

import com.enderchestsafemining.EnderChestSafeMining;
import com.enderchestsafemining.utils.EnderChestChecker;
import com.enderchestsafemining.utils.UILogger;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public abstract class ClientPlayerInteractionManagerMixin {

    @Final
    @Shadow
    private MinecraftClient client;

    @Inject(at = @At("HEAD"), method = "attackBlock", cancellable = true)
    private void enderchestsafemining_preventBreakingEnderChest(BlockPos pos, Direction direction,
                                                                CallbackInfoReturnable<Boolean> cir) {
        // Prevents breaking an Ender Chest if it won't drop the Ender Chest item.
        if (EnderChestSafeMining.isSafeMiningEnabled()) {
            boolean isTargetEnderChest = false;

            if (this.client.world != null) {
                BlockState blockState = this.client.world.getBlockState(pos);
                isTargetEnderChest = EnderChestChecker.isTargetEnderChest(blockState);
            }

            if (isTargetEnderChest && this.client.player != null) {
                boolean willEnderChestDropItem = EnderChestChecker.willDropEnderChest(this.client.player);

                if (!willEnderChestDropItem) {
                    UILogger.setOverlayMessage("enderchestsafemining.action.prevented", true);
                    cir.cancel();
                }
            }
        }
    }

}