/*
 * Copyright (c) 2024 Edgeburn Media. All rights reserved.
 */

package net.watsonrolfes.fabulousflora.fabric;

import net.fabricmc.api.ModInitializer;

import net.watsonrolfes.fabulousflora.FabulousFlora;

public final class FabulousFloraFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        FabulousFlora.init();
    }
}
