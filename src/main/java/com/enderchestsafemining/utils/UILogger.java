package com.enderchestsafemining.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class UILogger {

    /**
     * Sets an overlay message on the in-game HUD.
     *
     * @param message        The message to be displayed as an overlay.
     * @param useTranslation If true, the message will be translated using localization files,
     *                       otherwise, the raw string will be displayed.
     */
    public static void setOverlayMessage(String message, boolean useTranslation) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        Text text = useTranslation ? new TranslatableText(message) : new LiteralText(message);
        minecraftClient.inGameHud.setOverlayMessage(text, false);
    }

    /**
     * Adds a message to the in-game chat.
     *
     * @param message        The message to be added to the chat.
     * @param useTranslation If true, the message will be translated using localization files,
     *                       otherwise, the raw string will be displayed.
     */
    public static void addChatMessage(String message, boolean useTranslation) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        Text text = useTranslation ? new TranslatableText(message) : new LiteralText(message);
        minecraftClient.inGameHud.getChatHud().addMessage(text);
    }

}
