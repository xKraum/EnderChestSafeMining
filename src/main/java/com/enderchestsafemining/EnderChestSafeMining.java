package com.enderchestsafemining;

import com.enderchestsafemining.utils.UILogger;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnderChestSafeMining implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("enderchest-safe-mining");
    private static boolean active = true;

    public static boolean isSafeMiningEnabled() {
        return active;
    }

    public static void toggleSafeMiningChecker() {
        active = !active;
        String keyMessage = active ? "enderchestsafemining.toggle.on" : "enderchestsafemining.toggle.off";
        UILogger.setOverlayMessage(keyMessage, true);
    }

    @Override
    public void onInitialize() {
        LOGGER.info("EnderChestSafeMining loaded.");
    }

}