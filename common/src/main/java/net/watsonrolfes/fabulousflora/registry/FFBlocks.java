/*
 * Copyright (c) 2024 Edgeburn Media. All rights reserved.
 */

package net.watsonrolfes.fabulousflora.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.watsonrolfes.fabulousflora.FabulousFlora;

import java.util.function.Supplier;

import static net.watsonrolfes.fabulousflora.FabulousFlora.MOD_ID;

public class FFBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, RegistryKeys.BLOCK);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(MOD_ID, RegistryKeys.ITEM);
    public static final RegistrySupplier<Block> BLACK_ORCHID = BLOCKS.register("black_orchid", createFlowerBlock("black_orchid"));
    public static final RegistrySupplier<Block> BLUE_CHRYSANTHEMUM = BLOCKS.register("blue_chrysanthemum", createFlowerBlock("blue_chrysanthemum"));
    public static final RegistrySupplier<Block> BROWN_HYDRANGEA = BLOCKS.register("brown_hydrangea", createFlowerBlock("brown_hydrangea"));
    public static final RegistrySupplier<Block> CYAN_POPPY = BLOCKS.register("cyan_poppy", createFlowerBlock("cyan_poppy"));
    public static final RegistrySupplier<Block> GLOW_CALLA_LILY = BLOCKS.register("glow_calla_lily", createFlowerBlock("glow_calla_lily"));
    public static final RegistrySupplier<Block> GRAY_MOGRA = BLOCKS.register("gray_mogra", createFlowerBlock("gray_mogra"));
    public static final RegistrySupplier<Block> GREEN_ASTAR = BLOCKS.register("green_astar", createFlowerBlock("green_astar"));
    public static final RegistrySupplier<Block> LIGHT_BLUE_ROSE = BLOCKS.register("light_blue_rose", createFlowerBlock("light_blue_rose"));
    public static final RegistrySupplier<Block> LIGHT_GRAY_MORNING_GLORY = BLOCKS.register("light_gray_morning_glory", createFlowerBlock("light_gray_morning_glory"));
    public static final RegistrySupplier<Block> LIME_TUBEROSE = BLOCKS.register("lime_tuberose", createFlowerBlock("lime_tuberose"));
    public static final RegistrySupplier<Block> MAGENTA_SWEETPEA = BLOCKS.register("magenta_sweetpea", createFlowerBlock("magenta_sweetpea"));
    public static final RegistrySupplier<Block> ORANGE_TULIP = BLOCKS.register("orange_tulip", createFlowerBlock("orange_tulip"));
    public static final RegistrySupplier<Block> PINK_CHERRY_BLOSSOM = BLOCKS.register("pink_cherry_blossom", createFlowerBlock("pink_cherry_blossom"));
    public static final RegistrySupplier<Block> PURPLE_IRIS = BLOCKS.register("purple_iris", createFlowerBlock("purple_iris"));
    public static final RegistrySupplier<Block> RED_ARUM_LILY = BLOCKS.register("red_arum_lily", createFlowerBlock("red_arum_lily"));
    public static final RegistrySupplier<Block> WHITE_LAVENDER = BLOCKS.register("white_lavender", createFlowerBlock("white_lavender"));
    public static final RegistrySupplier<Block> YELLOW_BELL = BLOCKS.register("yellow_bell", createFlowerBlock("yellow_bell"));




    public static void register() {
        BLOCKS.register();
        BLOCKS.forEach(blockRegistrySupplier -> {
            Block block = blockRegistrySupplier.get();
            BLOCK_ITEMS.register(blockRegistrySupplier.getIdAsString().replace("fabulous_flora:",""), createBlockItem(block));
        });
        BLOCK_ITEMS.register();
    }

    protected static Supplier<FlowerBlock> createFlowerBlock(String id) {
        if (id.equals("glow_calla_lily")) { // little hacky but It Works™
            return () -> new FlowerBlock(SuspiciousStewEffectsComponent.DEFAULT, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).luminance(value -> 5).emissiveLighting((state, world, pos) -> true));
        }
        return () -> new FlowerBlock(SuspiciousStewEffectsComponent.DEFAULT, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY));
    }

    protected static Supplier<BlockItem> createBlockItem(Block block) {
        return () -> new BlockItem(block,new Item.Settings().arch$tab(FabulousFlora.FF_CREATIVE_TAB));
    }
}
