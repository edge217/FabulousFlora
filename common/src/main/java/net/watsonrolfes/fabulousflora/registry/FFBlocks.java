/*
 * Copyright (c) 2024 Edgeburn Media. All rights reserved.
 */

package net.watsonrolfes.fabulousflora.registry;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.watsonrolfes.fabulousflora.FabulousFlora;

import java.util.function.Supplier;

import static net.watsonrolfes.fabulousflora.FabulousFlora.FF_CREATIVE_TAB;
import static net.watsonrolfes.fabulousflora.FabulousFlora.MOD_ID;

public class FFBlocks {
    public static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));
    public static final Registrar<Block> BLOCKS = MANAGER.get().get(RegistryKeys.BLOCK);
    public static final Registrar<Item> BLOCK_ITEMS = MANAGER.get().get(RegistryKeys.ITEM);
    public static final Supplier<Block> PURPLE_IRIS = createFlowerBlock("purple_iris");
    public static final Supplier<Block> BLACK_ORCHID = createFlowerBlock("black_orchid");
    public static final Supplier<Block> BLUE_CHRYSANTHEMUM = createFlowerBlock("blue_chrysanthemum");
    public static final Supplier<Block> BROWN_HYDRANGEA = createFlowerBlock("brown_hydrangea");
    public static final Supplier<Block> CYAN_POPPY = createFlowerBlock("cyan_poppy");
    public static final Supplier<Block> GLOW_CALLA_LILY = createFlowerBlock("glow_calla_lily");
    public static final Supplier<Block> GRAY_MOGRA = createFlowerBlock("gray_mogra");
    public static final Supplier<Block> GREEN_ASTAR = createFlowerBlock("green_astar");
    public static final Supplier<Block> LIGHT_BLUE_ROSE = createFlowerBlock("light_blue_rose");
    public static final Supplier<Block> LIGHT_GRAY_MORNING_GLORY = createFlowerBlock("light_gray_morning_glory");
    public static final Supplier<Block> LIME_TUBEROSE = createFlowerBlock("lime_tuberose");
    public static final Supplier<Block> MAGENTA_SWEETPEA = createFlowerBlock("magenta_sweetpea");
    public static final Supplier<Block> ORANGE_TULIP = createFlowerBlock("orange_tulip");
    public static final Supplier<Block> PINK_CHERRY_BLOSSOM = createFlowerBlock("pink_cherry_blossom");
    public static final Supplier<Block> RED_ARUM_LILY = createFlowerBlock("red_arum_lily");
    public static final Supplier<Block> WHITE_LAVENDER = createFlowerBlock("white_lavender");
    public static final Supplier<Block> YELLOW_BELL = createFlowerBlock("yellow_bell");



    protected static void make(String id, Supplier<Block> block) {
        final Identifier identifier = Identifier.of(MOD_ID, id);
        BLOCKS.register(identifier, block);
        BLOCK_ITEMS.register(identifier, () -> new BlockItem(block.get(),new Item.Settings().arch$tab(FF_CREATIVE_TAB)));
    }

    public static void register() {
        make("red_arum_lily", RED_ARUM_LILY);
        make("orange_tulip", ORANGE_TULIP);
        make("yellow_bell", YELLOW_BELL);
        make("lime_tuberose", LIME_TUBEROSE);
        make("green_astar", GREEN_ASTAR);
        make("cyan_poppy", CYAN_POPPY); // Cyan can be considered as a part of blue
        make("light_blue_rose", LIGHT_BLUE_ROSE);
        make("blue_chrysanthemum", BLUE_CHRYSANTHEMUM);
        make("purple_iris", PURPLE_IRIS); // Violet
        make("magenta_sweetpea", MAGENTA_SWEETPEA); // Magenta as a variant of purple/violet
        make("pink_cherry_blossom", PINK_CHERRY_BLOSSOM); // Pink as a light shade of red/purple
        make("black_orchid", BLACK_ORCHID); // Black, Gray and White can be categorized as neutral
        make("gray_mogra", GRAY_MOGRA);
        make("white_lavender", WHITE_LAVENDER);
        make("brown_hydrangea", BROWN_HYDRANGEA);
        make("glow_calla_lily", GLOW_CALLA_LILY); // Glow could imply white or light
        make("light_gray_morning_glory", LIGHT_GRAY_MORNING_GLORY);
    }

    protected static Supplier<Block> createFlowerBlock(String id) {
        if (id.equals("glow_calla_lily")) { // little hacky but It Works™
            return Suppliers.memoize(() -> new FlowerBlock(SuspiciousStewEffectsComponent.DEFAULT, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY).luminance(value -> 5).emissiveLighting((state, world, pos) -> true)));
        }
        return Suppliers.memoize(() -> new FlowerBlock(SuspiciousStewEffectsComponent.DEFAULT, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));
    }

    protected static Supplier<BlockItem> createBlockItem(Block block) {
        return () -> new BlockItem(block,new Item.Settings().arch$tab(FabulousFlora.FF_CREATIVE_TAB));
    }
}
