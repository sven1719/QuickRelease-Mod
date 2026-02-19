package com.sven1719.quickrelease;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.cobblemon.api.pokemon.Pokemon;
import java.util.List;

public class QuickReleaseGui extends Screen {

    private final List<Pokemon> trashList;
    private final Screen previousScreen;

    protected QuickReleaseGui(List<Pokemon> trashList, Screen previousScreen) {
        super(Component.literal("Confirm Release"));
        this.trashList = trashList;
        this.previousScreen = previousScreen;
    }

    @Override
    protected void init() {
        int xStart = this.width / 2 - 100;
        int yStart = this.height / 2 - 50;
        int columns = 5;
        int index = 0;

        for (Pokemon p : trashList) {
            int x = xStart + (index % columns) * 40;
            int y = yStart + (index / columns) * 40;
            this.addRenderableWidget(new PokemonIconButton(x, y, p));
            index++;
        }

        this.addRenderableWidget(new net.minecraft.client.gui.components.Button(
            this.width/2 - 60, this.height - 40, 50, 20,
            Component.literal("Confirm"),
            b -> {
                QuickReleaseManager.confirmRelease();
                minecraft.setScreen(previousScreen);
            }
        ));

        this.addRenderableWidget(new net.minecraft.client.gui.components.Button(
            this.width/2 + 10, this.height - 40, 50, 20,
            Component.literal("Cancel"),
            b -> {
                QuickReleaseManager.cancelRelease();
                minecraft.setScreen(previousScreen);
            }
        ));
    }
}
