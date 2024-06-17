/*
 * Copyright (c) 2024 Edgeburn Media. All rights reserved.
 */

package net.watsonrolfes.fabulousflora.neoforge;

import net.neoforged.fml.common.Mod;

import net.watsonrolfes.fabulousflora.FabulousFlora;

@Mod(FabulousFlora.MOD_ID)
public final class FabulousFloraNeoForge {
    public FabulousFloraNeoForge() {
        // Run our common setup.
        FabulousFlora.init();
    }
}
