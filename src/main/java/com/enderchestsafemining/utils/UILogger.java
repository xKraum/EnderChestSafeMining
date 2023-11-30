package com.enderchestsafemining.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class UILogger {

    /**
     * Sets an overlay message on the in-game HUD.
     *
     * @param message The message to be displayed as an overlay.
     */
    public static void setOverlayMessage(String message) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        Text text = new LiteralText(message);
        minecraftClient.inGameHud.setOverlayMessage(text, false);
    }

    /**
     * Adds a message to the in-game chat.
     *
     * @param message The message to be added to the chat.
     */
    public static void addChatMessage(String message) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        Text text = new LiteralText(message);
        minecraftClient.inGameHud.getChatHud().addMessage(text);
    }

}
