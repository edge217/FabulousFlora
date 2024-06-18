/*
 * Copyright (c) 2024 Edgeburn Media. All rights reserved.
 */

const fs = require("fs");

let flowers = [
  "black_orchid",
  "blue_chrysanthemum",
  "brown_hydrangea",
  "cyan_poppy",
  "glow_calla_lily",
  "gray_mogra",
  "green_astar",
  "light_blue_rose",
  "light_gray_morning_glory",
  "lime_tuberose",
  "magenta_sweetpea",
  "orange_tulip",
  "pink_cherry_blossom",
  "purple_iris",
  "red_arum_lily",
  "white_lavender",
  "yellow_bell",
];

const projectPath = process.env.PROJECT_ROOT;

const modelsPath = `${projectPath}/common/src/main/resources/assets/fabulous_flora/models`;
const blockStatesPath = `${projectPath}/common/src/main/resources/assets/fabulous_flora/blockstates`;
const lootTablesPath = `${projectPath}/common/src/main/resources/data/fabulous_flora/loot_table/blocks`;

for (let flower of flowers) {
  const blockModel = {
    parent: "minecraft:block/cross",
    textures: {
      cross: `fabulous_flora:block/${flower}`,
    },
  };
  fs.writeFileSync(
    `${modelsPath}/block/${flower}.json`,
    JSON.stringify(blockModel),
  );

  const itemModel = {
    parent: "minecraft:item/generated",
    textures: {
      layer0: `fabulous_flora:block/${flower}`,
    },
  };
  fs.writeFileSync(
    `${modelsPath}/item/${flower}.json`,
    JSON.stringify(itemModel),
  );

  const blockstate = {
    variants: {
      "": {
        model: `fabulous_flora:block/${flower}`,
      },
    },
  };
  fs.writeFileSync(
    `${blockStatesPath}/${flower}.json`,
    JSON.stringify(blockstate),
  );

  const lootTable = {
    type: "minecraft:block",
    pools: [
      {
        rolls: 1,
        bonus_rolls: 0,
        entries: [
          {
            type: "minecraft:item",
            name: `fabulous_flora:${flower}`,
          },
        ],
        conditions: [
          {
            condition: "minecraft:survives_explosion",
          },
        ],
      },
    ],
  };
  fs.writeFileSync(
    `${lootTablesPath}/${flower}.json`,
    JSON.stringify(lootTable),
  );
}
