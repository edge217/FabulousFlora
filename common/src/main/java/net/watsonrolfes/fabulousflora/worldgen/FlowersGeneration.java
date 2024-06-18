/*
 * Copyright (c) 2024 Edgeburn Media. All rights reserved.
 */

package net.watsonrolfes.fabulousflora.worldgen;

import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.registry.level.biome.BiomeModifications;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;

import static net.watsonrolfes.fabulousflora.FabulousFlora.MOD_ID;

// Not working on NeoForge, I believe this is a known issue https://github.com/architectury/architectury-api/issues/480

public class FlowersGeneration {
    public static void init() {
        LifecycleEvent.SETUP.register(() -> {
            BiomeModifications.addProperties((ctx, mutable) -> {
                if (ctx.hasTag(BiomeTags.IS_OVERWORLD)) {
                    mutable.getGenerationProperties().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID,"flower_gen")));
                }
            });
        });
    }
}
