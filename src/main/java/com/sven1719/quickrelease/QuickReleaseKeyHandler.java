package com.sven1719.quickrelease;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import org.lwjgl.glfw.GLFW;

public class QuickReleaseKeyHandler {

    private static KeyMapping quickReleaseKey;

    public static void registerKey() {
        quickReleaseKey = new KeyMapping(
            "key.quickrelease",
            KeyConflictContext.IN_GAME,
            GLFW.GLFW_KEY_R,
            "key.categories.cobblemon"
        );
        MinecraftForge.EVENT_BUS.register(new QuickReleaseKeyHandler());
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        if (quickReleaseKey.isDown()) {
            QuickReleaseManager.queueRelease();
        }
    }
}
