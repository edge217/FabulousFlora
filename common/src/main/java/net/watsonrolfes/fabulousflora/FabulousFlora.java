/*
 * Copyright (c) 2024 Edgeburn Media. All rights reserved.
 */

package net.watsonrolfes.fabulousflora;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.architectury.utils.Env;
import dev.architectury.utils.EnvExecutor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.watsonrolfes.fabulousflora.registry.FFBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FabulousFlora {
    public static final String MOD_ID = "fabulous_flora";
    private static final Logger log = LoggerFactory.getLogger(FabulousFlora.class);
    public static final DeferredRegister<ItemGroup> TABS = DeferredRegister.create(MOD_ID, RegistryKeys.ITEM_GROUP);
    public static final RegistrySupplier<ItemGroup> FF_CREATIVE_TAB = TABS.register("creative_tab",
            () -> CreativeTabRegistry.create(Text.translatable("itemGroup.fabulousFlora"),
                    () -> new ItemStack(FFBlocks.PURPLE_IRIS.get())));

    public static void init() {

        FFBlocks.register();
        TABS.register();

        EnvExecutor.runInEnv(Env.CLIENT, () -> FFClient::initClient);
    }

    @Environment(EnvType.CLIENT)
    public static class FFClient {
        @Environment(EnvType.CLIENT)
        public static void initClient() {
            ClientLifecycleEvent.CLIENT_STARTED.register(instance -> {
                FFBlocks.BLOCKS.forEach(block -> {
                    RenderTypeRegistry.register(RenderLayer.getCutout(), block);
                });
            });

        }
    }
}
