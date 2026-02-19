package com.sven1719.quickrelease;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("quickrelease")
public class QuickReleaseMod {
    public QuickReleaseMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        QuickReleaseKeyHandler.registerKey();
    }
}
