package com.sven1719.quickrelease;

import net.minecraft.client.gui.components.Button;
import org.cobblemon.api.pokemon.Pokemon;
import net.minecraft.client.Minecraft;

public class PokemonIconButton extends Button {

    private final Pokemon pokemon;
    private final Minecraft mc = Minecraft.getInstance();

    public PokemonIconButton(int x, int y, Pokemon pokemon) {
        super(x, y, 32, 32, net.minecraft.network.chat.Component.literal(""), b -> {});
        this.pokemon = pokemon;
    }

    @Override
    public void renderButton(net.minecraft.client.gui.GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        super.renderButton(graphics, mouseX, mouseY, partialTicks);
        mc.getTextureManager().bind(pokemon.getSpecies().getSprite());
        graphics.blit(this.x, this.y, 32, 32, 0, 0, 32, 32, 32, 32);
    }
}
