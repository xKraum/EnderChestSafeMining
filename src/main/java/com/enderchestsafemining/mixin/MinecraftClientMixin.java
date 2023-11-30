package com.enderchestsafemining.mixin;

import com.enderchestsafemining.EnderChestSafeMining;
import com.enderchestsafemining.utils.UseUtil;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.hit.HitResult;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Shadow
    @Nullable
    public ClientWorld world;
    @Shadow
    @Nullable
    public ClientPlayerEntity player;
    @Shadow
    @Nullable
    public HitResult crosshairTarget;

    @Inject(method = "doItemUse", at = @At(value = "HEAD"))
    private void enderchestsafemining_switchEnderChestCheckerStatus(CallbackInfo ci) {
        // Toggle checker status if a player, while sneaking, performs a use action on an Ender Chest.
        if (player != null && player.isSneaking()) {
            boolean isDoingUseOnEnderChest = UseUtil.isDoingUseOnBlock(
                    this.crosshairTarget, this.player, this.world, Blocks.ENDER_CHEST);

            if (isDoingUseOnEnderChest) {
                EnderChestSafeMining.toggleSafeMiningChecker();
            }
        }
    }

}
