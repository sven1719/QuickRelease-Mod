package com.sven1719.quickrelease;

import net.minecraft.client.Minecraft;
import org.cobblemon.api.CobblemonAPI;
import org.cobblemon.api.pokemon.Pokemon;
import org.cobblemon.api.pokemon.PokemonSpecies;

import java.util.ArrayList;
import java.util.List;

public class QuickReleaseManager {

    private static final List<Pokemon> trashList = new ArrayList<>();

    public static void queueRelease() {
        Minecraft mc = Minecraft.getInstance();
        if (!(mc.screen instanceof MyPCGui pcGui)) return;

        trashList.clear();
        for (Pokemon p : pcGui.getPCPokemons()) {
            if (!p.isShiny() && !isLegendary(p.getSpecies())) {
                trashList.add(p);
            }
        }

        if (!trashList.isEmpty()) {
            mc.setScreen(new QuickReleaseGui(trashList, pcGui));
        }
    }

    public static void confirmRelease() {
        for (Pokemon p : trashList) {
            CobblemonAPI.releasePokemon(p);
        }
        Minecraft.getInstance().player.sendMessage(
            net.minecraft.network.chat.Component.literal("Released " + trashList.size() + " Pokémon!"),
            Minecraft.getInstance().player.getUUID()
        );
        trashList.clear();
    }

    public static void cancelRelease() {
        trashList.clear();
    }

    private static boolean isLegendary(PokemonSpecies species) {
        return species.isLegendary();
    }
}
