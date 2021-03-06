package com.github.shynixn.petblocks.sponge.logic.business.helper;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.item.ItemType;

public enum CompatibilityItemType {
    AIR(0, "air"),
    STONE(1, "stone"),
    GRASS(2, "grass"),
    DIRT(3, "dirt"),
    COBBLESTONE(4, "cobblestone"),
    WOOD(5, "planks"),
    SAPLING(6, "sapling"),
    BEDROCK(7, "bedrock"),
    WATER(8, "flowing_water"),
    STATIONARY_WATER(9, "water"),
    LAVA(10, "flowing_lava"),
    STATIONARY_LAVA(11, "lava"),
    SAND(12, "sand"),
    GRAVEL(13, "gravel"),
    GOLD_ORE(14, "gold_ore"),
    IRON_ORE(15, "iron_ore"),
    COAL_ORE(16, "coal_ore"),
    LOG(17, "log"),
    LEAVES(18, "leaves"),
    SPONGE(19, "sponge"),
    GLASS(20, "glass"),
    LAPIS_ORE(21, "lapis_ore"),
    LAPIS_BLOCK(22, "lapis_block"),
    DISPENSER(23, "dispenser"),
    SANDSTONE(24, "sandstone"),
    NOTE_BLOCK(25, "noteblock"),
    BED_BLOCK(26, "bed"),
    POWERED_RAIL(27, "golden_rail"),
    DETECTOR_RAIL(28, "detector_rail"),
    PISTON_STICKY_BASE(29, "sticky_piston"),
    WEB(30, "web"),
    LONG_GRASS(31, "tallgrass"),
    DEAD_BUSH(32, "deadbush"),
    PISTON_BASE(33, "piston"),
    PISTON_EXTENSION(34, "piston_head"),
    WOOL(35, "wool"),
    YELLOW_FLOWER(37, "yellow_flower"),
    RED_ROSE(38, "red_flower"),
    BROWN_MUSHROOM(39, "brown_mushroom"),
    RED_MUSHROOM(40, "red_mushroom"),
    GOLD_BLOCK(41, "gold_block"),
    IRON_BLOCK(42, "iron_block"),
    DOUBLE_STEP(43, "double_stone_slab"),
    STEP(44, "stone_slab"),
    BRICK(45, "brick_block"),
    TNT(46, "tnt"),
    BOOKSHELF(47, "bookshelf"),
    MOSSY_COBBLESTONE(48, "mossy_cobblestone"),
    OBSIDIAN(49, "obsidian"),
    TORCH(50, "torch"),
    FIRE(51, "fire"),
    MOB_SPAWNER(52, "mob_spawner"),
    WOOD_STAIRS(53, "oak_stairs"),
    CHEST(54, "chest"),
    REDSTONE_WIRE(55, "redstone_wire"),
    DIAMOND_ORE(56, "diamond_ore"),
    DIAMOND_BLOCK(57, "diamond_block"),
    WORKBENCH(58, "crafting_table"),
    CROPS(59, "wheat"),
    SOIL(60, "farmland"),
    FURNACE(61, "furnace"),
    BURNING_FURNACE(62, "lit_furnace"),
    SIGN_POST(63, "standing_sign"),
    WOODEN_DOOR(64, "wooden_door"),
    LADDER(65, "ladder"),
    RAILS(66, "rail"),
    COBBLESTONE_STAIRS(67, "stone_stairs"),
    WALL_SIGN(68, "wall_sign"),
    LEVER(69, "lever"),
    STONE_PLATE(70, "stone_pressure_plate"),
    IRON_DOOR_BLOCK(71, "iron_door"),
    WOOD_PLATE(72, "wooden_pressure_plate"),
    REDSTONE_ORE(73, "redstone_ore"),
    GLOWING_REDSTONE_ORE(74, "lit_redstone_ore"),
    REDSTONE_TORCH_OFF(75, "unlit_redstone_torch"),
    REDSTONE_TORCH_ON(76, "redstone_torch"),
    STONE_BUTTON(77, "stone_button"),
    SNOW(78, "snow_layer"),
    ICE(79, "ice"),
    SNOW_BLOCK(80, "snow"),
    CACTUS(81, "cactus"),
    CLAY(82, "clay"),
    SUGAR_CANE_BLOCK(83, "reeds"),
    JUKEBOX(84, "jukebox"),
    FENCE(85, "fence"),
    PUMPKIN(86, "pumpkin"),
    NETHERRACK(87, "netherrack"),
    SOUL_SAND(88, "soul_sand"),
    GLOWSTONE(89, "glowstone"),
    PORTAL(90, "portal"),
    JACK_O_LANTERN(91, "lit_pumpkin"),
    CAKE_BLOCK(92, "cake"),
    DIODE_BLOCK_OFF(93, "unpowered_repeater"),
    DIODE_BLOCK_ON(94, "powered_repeater"),
    STAINED_GLASS(95, "stained_glass"),
    TRAP_DOOR(96, "trapdoor"),
    MONSTER_EGGS(97, "monster_egg"),
    SMOOTH_BRICK(98, "stonebrick"),
    HUGE_MUSHROOM_1(99, "brown_mushroom_block"),
    HUGE_MUSHROOM_2(100, "red_mushroom_block"),
    IRON_FENCE(101, "iron_bars"),
    THIN_GLASS(102, "glass_pane"),
    MELON_BLOCK(103, "melon_block"),
    PUMPKIN_STEM(104, "pumpkin_stem"),
    MELON_STEM(105, "melon_stem"),
    VINE(106, "vine"),
    FENCE_GATE(107, "fence_gate"),
    BRICK_STAIRS(108, "brick_stairs"),
    SMOOTH_STAIRS(109, "stone_brick_stairs"),
    MYCEL(110, "mycelium"),
    WATER_LILY(111, "waterlily"),
    NETHER_BRICK(112, "nether_brick"),
    NETHER_FENCE(113, "nether_brick_fence"),
    NETHER_BRICK_STAIRS(114, "nether_brick_stairs"),
    NETHER_WARTS(115, "nether_wart"),
    ENCHANTMENT_TABLE(116, "enchanting_table"),
    BREWING_STAND(117, "brewing_stand"),
    CAULDRON(118, "cauldron"),
    ENDER_PORTAL(119, "end_portal"),
    ENDER_PORTAL_FRAME(120, "end_portal_frame"),
    ENDER_STONE(121, "end_stone"),
    DRAGON_EGG(122, "dragon_egg"),
    REDSTONE_LAMP_OFF(123, "redstone_lamp"),
    REDSTONE_LAMP_ON(124, "lit_redstone_lamp"),
    WOOD_DOUBLE_STEP(125, "double_wooden_slab"),
    WOOD_STEP(126, "wooden_slab"),
    COCOA(127, "cocoa"),
    SANDSTONE_STAIRS(128, "sandstone_stairs"),
    EMERALD_ORE(129, "emerald_ore"),
    ENDER_CHEST(130, "ender_chest"),
    TRIPWIRE_HOOK(131, "tripwire_hook"),
    TRIPWIRE(132, "tripwire_hook"),
    EMERALD_BLOCK(133, "emerald_block"),
    SPRUCE_WOOD_STAIRS(134, "spruce_stairs"),
    BIRCH_WOOD_STAIRS(135, "birch_stairs"),
    JUNGLE_WOOD_STAIRS(136, "jungle_stairs"),
    COMMAND(137, "command_block"),
    BEACON(138, "beacon"),
    COBBLE_WALL(139, "cobblestone_wall"),
    FLOWER_POT(140, "flower_pot"),
    CARROT(141, "carrots"),
    POTATO(142, "potatoes"),
    WOOD_BUTTON(143, "wooden_button"),
    SKULL(144, "skull"),
    ANVIL(145, "anvil"),
    TRAPPED_CHEST(146, "trapped_chest"),
    GOLD_PLATE(147, "light_weighted_pressure_plate"),
    IRON_PLATE(148, "heavy_weighted_pressure_plate"),
    REDSTONE_COMPARATOR_OFF(149, "unpowered_comparator"),
    REDSTONE_COMPARATOR_ON(150, "powered_comparator"),
    DAYLIGHT_DETECTOR(151, "daylight_detector"),
    REDSTONE_BLOCK(152, "redstone_block"),
    QUARTZ_ORE(153, "quartz_ore"),
    HOPPER(154, "hopper"),
    QUARTZ_BLOCK(155, "quartz_block"),
    QUARTZ_STAIRS(156, "quartz_stairs"),
    ACTIVATOR_RAIL(157, "activator_rail"),
    DROPPER(158, "dropper"),
    STAINED_CLAY(159, "stained_hardened_clay"),
    STAINED_GLASS_PANE(160, "stained_glass_pane"),
    LEAVES_2(161, "leaves2"),
    LOG_2(162, "log2"),
    ACACIA_STAIRS(163, "acacia_stairs"),
    DARK_OAK_STAIRS(164, "dark_oak_stairs"),
    SLIME_BLOCK(165, "slime"),
    BARRIER(166, "barrier"),
    IRON_TRAPDOOR(167, "iron_trapdoor"),
    PRISMARINE(168, "prismarine"),
    SEA_LANTERN(169, "sea_lantern"),
    HAY_BLOCK(170, "hay_block"),
    CARPET(171, "carpet"),
    HARD_CLAY(172, "hardened_clay"),
    COAL_BLOCK(173, "coal_block"),
    PACKED_ICE(174, "packed_ice"),
    DOUBLE_PLANT(175, "double_plant"),
    STANDING_BANNER(176, "standing_banner"),
    WALL_BANNER(177, "wall_banner"),
    DAYLIGHT_DETECTOR_INVERTED(178, "daylight_detector_inverted"),
    RED_SANDSTONE(179, "red_sandstone"),
    RED_SANDSTONE_STAIRS(180, "red_sandstone_stairs"),
    DOUBLE_STONE_SLAB2(181, "double_stone_slab2"),
    STONE_SLAB2(182, "stone_slab2"),
    SPRUCE_FENCE_GATE(183, "spruce_fence_gate"),
    BIRCH_FENCE_GATE(184, "birch_fence_gate"),
    JUNGLE_FENCE_GATE(185, "jungle_fence_gate"),
    DARK_OAK_FENCE_GATE(186, "dark_oak_fence_gate"),
    ACACIA_FENCE_GATE(187, "acacia_fence_gate"),
    SPRUCE_FENCE(188, "spruce_fence"),
    BIRCH_FENCE(189, "birch_fence"),
    JUNGLE_FENCE(190, "jungle_fence"),
    DARK_OAK_FENCE(191, "dark_oak_fence"),
    ACACIA_FENCE(192, "acacia_fence"),
    SPRUCE_DOOR(193, "spruce_door"),
    BIRCH_DOOR(194, "birch_door"),
    JUNGLE_DOOR(195, "jungle_door"),
    ACACIA_DOOR(196, "acacia_door"),
    DARK_OAK_DOOR(197, "dark_oak_door"),
    END_ROD(198, "end_rod"),
    CHORUS_PLANT(199, "chorus_plant"),
    CHORUS_FLOWER(200, "chorus_flower"),
    PURPUR_BLOCK(201, "purpur_block"),
    PURPUR_PILLAR(202, "purpur_pillar"),
    PURPUR_STAIRS(203, "purpur_stairs"),
    PURPUR_DOUBLE_SLAB(204, "purpur_double_slab"),
    PURPUR_SLAB(205, "purpur_slab"),
    END_BRICKS(206, "end_bricks"),
    BEETROOT_BLOCK(207, "beetroots"),
    GRASS_PATH(208, "grass_path"),
    END_GATEWAY(209, "end_gateway"),
    COMMAND_REPEATING(210, "repeating_command_block"),
    COMMAND_CHAIN(211, "chain_command_block"),
    FROSTED_ICE(212, "frosted_ice"),
    MAGMA(213, "magma"),
    NETHER_WART_BLOCK(214, "nether_wart_block"),
    RED_NETHER_BRICK(215, "red_nether_brick"),
    BONE_BLOCK(216, "bone_block"),
    STRUCTURE_VOID(217, "structure_void"),
    OBSERVER(218, "observer"),
    WHITE_SHULKER_BOX(219, "white_shulker_box"),
    ORANGE_SHULKER_BOX(220, "orange_shulker_box"),
    MAGENTA_SHULKER_BOX(221, "magenta_shulker_box"),
    LIGHT_BLUE_SHULKER_BOX(222, "light_blue_shulker_box"),
    YELLOW_SHULKER_BOX(223, "yellow_shulker_box"),
    LIME_SHULKER_BOX(224, "lime_shulker_box"),
    PINK_SHULKER_BOX(225, "pink_shulker_box"),
    GRAY_SHULKER_BOX(226, "gray_shulker_box"),
    SILVER_SHULKER_BOX(227, "silver_shulker_box"),
    CYAN_SHULKER_BOX(228, "cyan_shulker_box"),
    PURPLE_SHULKER_BOX(229, "purple_shulker_box"),
    BLUE_SHULKER_BOX(230, "blue_shulker_box"),
    BROWN_SHULKER_BOX(231, "brown_shulker_box"),
    GREEN_SHULKER_BOX(232, "green_shulker_box"),
    RED_SHULKER_BOX(233, "red_shulker_box"),
    BLACK_SHULKER_BOX(234, "black_shulker_box"),
    WHITE_GLAZED_TERRACOTTA(235, "white_glazed_terracotta"),
    ORANGE_GLAZED_TERRACOTTA(236, "orange_glazed_terracotta"),
    MAGENTA_GLAZED_TERRACOTTA(237, "magenta_glazed_terracotta"),
    LIGHT_BLUE_GLAZED_TERRACOTTA(238, "light_blue_glazed_terracotta"),
    YELLOW_GLAZED_TERRACOTTA(239, "yellow_glazed_terracotta"),
    LIME_GLAZED_TERRACOTTA(240, "lime_glazed_terracotta"),
    PINK_GLAZED_TERRACOTTA(241, "pink_glazed_terracotta"),
    GRAY_GLAZED_TERRACOTTA(242, "gray_glazed_terracotta"),
    SILVER_GLAZED_TERRACOTTA(243, "light_gray_glazed_terracotta"),
    CYAN_GLAZED_TERRACOTTA(244, "cyan_glazed_terracotta"),
    PURPLE_GLAZED_TERRACOTTA(245, "purple_glazed_terracotta"),
    BLUE_GLAZED_TERRACOTTA(246, "blue_glazed_terracotta"),
    BROWN_GLAZED_TERRACOTTA(247, "brown_glazed_terracotta"),
    GREEN_GLAZED_TERRACOTTA(248, "green_glazed_terracotta"),
    RED_GLAZED_TERRACOTTA(249, "red_glazed_terracotta"),
    BLACK_GLAZED_TERRACOTTA(250, "black_glazed_terracotta"),
    CONCRETE(251, "concrete"),
    CONCRETE_POWDER(252, "concrete_powder"),
    STRUCTURE_BLOCK(255, "structure_block"),
    IRON_SPADE(256, "iron_shovel"),
    IRON_PICKAXE(257, "iron_pickaxe"),
    IRON_AXE(258, "iron_axe"),
    FLINT_AND_STEEL(259, "flint_and_steel"),
    APPLE(260, "apple"),
    BOW(261, "bow"),
    ARROW(262, "arrow"),
    COAL(263, "coal"),
    DIAMOND(264, "diamond"),
    IRON_INGOT(265, "iron_ingot"),
    GOLD_INGOT(266, "gold_ingot"),
    IRON_SWORD(267, "iron_sword"),
    WOOD_SWORD(268, "wooden_sword"),
    WOOD_SPADE(269, "wooden_shovel"),
    WOOD_PICKAXE(270, "wooden_pickaxe"),
    WOOD_AXE(271, "wooden_axe"),
    STONE_SWORD(272, "stone_sword"),
    STONE_SPADE(273, "stone_shovel"),
    STONE_PICKAXE(274, "stone_pickaxe"),
    STONE_AXE(275, "stone_axe"),
    DIAMOND_SWORD(276, "diamond_sword"),
    DIAMOND_SPADE(277, "diamond_shovel"),
    DIAMOND_PICKAXE(278, "diamond_pickaxe"),
    DIAMOND_AXE(279, "diamond_axe"),
    STICK(280, "stick"),
    BOWL(281, "bowl"),
    MUSHROOM_SOUP(282, "mushroom_stew"),
    GOLD_SWORD(283, "golden_sword"),
    GOLD_SPADE(284, "golden_shovel"),
    GOLD_PICKAXE(285, "golden_pickaxe"),
    GOLD_AXE(286, "golden_axe"),
    STRING(287, "string"),
    FEATHER(288, "feather"),
    SULPHUR(289, "gunpowder"),
    WOOD_HOE(290, "wooden_hoe"),
    STONE_HOE(291, "stone_hoe"),
    IRON_HOE(292, "iron_hoe"),
    DIAMOND_HOE(293, "diamond_hoe"),
    GOLD_HOE(294, "golden_hoe"),
    SEEDS(295, "wheat_seeds"),
    WHEAT(296, "wheat"),
    BREAD(297, "bread"),
    LEATHER_HELMET(298, "leather_helmet"),
    LEATHER_CHESTPLATE(299, "leather_chestplate"),
    LEATHER_LEGGINGS(300, "leather_leggings"),
    LEATHER_BOOTS(301, "leather_boots"),
    CHAINMAIL_HELMET(302, "chainmail_helmet"),
    CHAINMAIL_CHESTPLATE(303, "chainmail_chestplate"),
    CHAINMAIL_LEGGINGS(304, "chainmail_leggings"),
    CHAINMAIL_BOOTS(305, "chainmail_boots"),
    IRON_HELMET(306, "iron_helmet"),
    IRON_CHESTPLATE(307, "iron_chestplate"),
    IRON_LEGGINGS(308, "iron_leggings"),
    IRON_BOOTS(309, "iron_boots"),
    DIAMOND_HELMET(310, "diamond_helmet"),
    DIAMOND_CHESTPLATE(311, "diamond_chestplate"),
    DIAMOND_LEGGINGS(312, "diamond_leggings"),
    DIAMOND_BOOTS(313, "diamond_boots"),
    GOLD_HELMET(314, "golden_helmet"),
    GOLD_CHESTPLATE(315, "golden_chestplate"),
    GOLD_LEGGINGS(316, "golden_leggings"),
    GOLD_BOOTS(317, "golden_boots"),
    FLINT(318, "flint"),
    PORK(319, "porkchop"),
    GRILLED_PORK(320, "cooked_porkchop"),
    PAINTING(321, "painting"),
    GOLDEN_APPLE(322, "golden_apple"),
    SIGN(323, "sign"),
    WOOD_DOOR(324, "wooden_door"),
    BUCKET(325, "bucket"),
    WATER_BUCKET(326, "water_bucket"),
    LAVA_BUCKET(327, "lava_bucket"),
    MINECART(328, "minecart"),
    SADDLE(329, "saddle"),
    IRON_DOOR(330, "iron_door"),
    REDSTONE(331, "redstone"),
    SNOW_BALL(332, "snowball"),
    BOAT(333, "boat"),
    LEATHER(334, "leather"),
    MILK_BUCKET(335, "milk_bucket"),
    CLAY_BRICK(336, "brick"),
    CLAY_BALL(337, "clay_ball"),
    SUGAR_CANE(338, "reeds"),
    PAPER(339, "paper"),
    BOOK(340, "book"),
    SLIME_BALL(341, "slime_ball"),
    STORAGE_MINECART(342, "chest_minecart"),
    POWERED_MINECART(343, "furnace_minecart"),
    EGG(344, "egg"),
    COMPASS(345, "compass"),
    FISHING_ROD(346, "fishing_rod"),
    WATCH(347, "clock"),
    GLOWSTONE_DUST(348, "glowstone_dust"),
    RAW_FISH(349, "fish"),
    COOKED_FISH(350, "cooked_fish"),
    INK_SACK(351, "dye"),
    BONE(352, "bone"),
    SUGAR(353, "sugar"),
    CAKE(354, "cake"),
    BED(355, "bed"),
    DIODE(356, "repeater"),
    COOKIE(357, "cookie"),
    MAP(358, "filled_map"),
    SHEARS(359, "shears"),
    MELON(360, "melon"),
    PUMPKIN_SEEDS(361, "pumpkin_seeds"),
    MELON_SEEDS(362, "melon_seeds"),
    RAW_BEEF(363, "beef"),
    COOKED_BEEF(364, "cooked_beef"),
    RAW_CHICKEN(365, "chicken"),
    COOKED_CHICKEN(366, "cooked_chicken"),
    ROTTEN_FLESH(367, "rotten_flesh"),
    ENDER_PEARL(368, "ender_pearl"),
    BLAZE_ROD(369, "blaze_rod"),
    GHAST_TEAR(370, "ghast_tear"),
    GOLD_NUGGET(371, "gold_nugget"),
    NETHER_STALK(372, "nether_wart"),
    POTION(373, "potion"),
    GLASS_BOTTLE(374, "glass_bottle"),
    SPIDER_EYE(375, "spider_eye"),
    FERMENTED_SPIDER_EYE(376, "fermented_spider_eye"),
    BLAZE_POWDER(377, "blaze_powder"),
    MAGMA_CREAM(378, "magma_cream"),
    BREWING_STAND_ITEM(379, "brewing_stand"),
    CAULDRON_ITEM(380, "cauldron"),
    EYE_OF_ENDER(381, "ender_eye"),
    SPECKLED_MELON(382, "speckled_melon"),
    EXP_BOTTLE(384, "experience_bottle"),
    FIREBALL(385, "fire_charge"),
    BOOK_AND_QUILL(386, "writable_book"),
    WRITTEN_BOOK(387, "written_book"),
    EMERALD(388, "emerald"),
    ITEM_FRAME(389, "item_frame"),
    FLOWER_POT_ITEM(390, "flower_pot"),
    CARROT_ITEM(391, "carrot"),
    POTATO_ITEM(392, "potato"),
    BAKED_POTATO(393, "baked_potato"),
    POISONOUS_POTATO(394, "poisonous_potato"),
    EMPTY_MAP(395, "map"),
    GOLDEN_CARROT(396, "golden_carrot"),
    SKULL_ITEM(397, "skull"),
    CARROT_STICK(398, "carrot_on_a_stick"),
    NETHER_STAR(399, "nether_star"),
    PUMPKIN_PIE(400, "pumpkin_pie"),
    FIREWORK(401, "fireworks"),
    FIREWORK_CHARGE(402, "firework_charge"),
    ENCHANTED_BOOK(403, "enchanted_book"),
    REDSTONE_COMPARATOR(404, "comparator"),
    NETHER_BRICK_ITEM(405, "netherbrick"),
    QUARTZ(406, "quartz"),
    EXPLOSIVE_MINECART(407, "tnt_minecart"),
    HOPPER_MINECART(408, "hopper_minecart"),
    PRISMARINE_SHARD(409, "prismarine_shard"),
    PRISMARINE_CRYSTALS(410, "prismarine_crystals"),
    RABBIT(411, "rabbit"),
    COOKED_RABBIT(412, "cooked_rabbit"),
    RABBIT_STEW(413, "rabbit_stew"),
    RABBIT_FOOT(414, "rabbit_foot"),
    RABBIT_HIDE(415, "rabbit_hide"),
    ARMOR_STAND(416, "armor_stand"),
    IRON_BARDING(417, "iron_horse_armor"),
    GOLD_BARDING(418, "golden_horse_armor"),
    DIAMOND_BARDING(419, "diamond_horse_armor"),
    LEASH(420, "lead"),
    NAME_TAG(421, "name_tag"),
    COMMAND_MINECART(422, "command_block_minecart"),
    MUTTON(423, "mutton"),
    COOKED_MUTTON(424, "cooked_mutton"),
    BANNER(425, "banner"),
    SPRUCE_DOOR_ITEM(427, "spruce_door"),
    BIRCH_DOOR_ITEM(428, "birch_door"),
    JUNGLE_DOOR_ITEM(429, "jungle_door"),
    ACACIA_DOOR_ITEM(430, "acacia_door"),
    DARK_OAK_DOOR_ITEM(431, "dark_oak_door"),
    CHORUS_FRUIT(432, "chorus_fruit"),
    CHORUS_FRUIT_POPPED(433, "popped_chorus_fruit"),
    BEETROOT(434, "beetroot"),
    BEETROOT_SEEDS(435, "beetroot_seeds"),
    BEETROOT_SOUP(436, "beetroot_soup"),
    DRAGONS_BREATH(437, "dragon_breath"),
    SPLASH_POTION(438, "splash_potion"),
    SPECTRAL_ARROW(439, "spectral_arrow"),
    TIPPED_ARROW(440, "tipped_arrow"),
    LINGERING_POTION(441, "lingering_potion"),
    SHIELD(442, "shield"),
    ELYTRA(443, "elytra"),
    BOAT_SPRUCE(444, "spruce_boat"),
    BOAT_BIRCH(445, "birch_boat"),
    BOAT_JUNGLE(446, "jungle_boat"),
    BOAT_ACACIA(447, "acacia_boat"),
    BOAT_DARK_OAK(448, "dark_oak_boat"),
    TOTEM(449, "totem_of_undying"),
    SHULKER_SHELL(450, "shulker_shell"),
    IRON_NUGGET(452, "iron_nugget"),
    GOLD_RECORD(2256, "record_13"),
    GREEN_RECORD(2257, "record_cat"),
    RECORD_3(2258, "record_blocks"),
    RECORD_4(2259, "record_chirp"),
    RECORD_5(2260, "record_far"),
    RECORD_6(2261, "record_mall"),
    RECORD_7(2262, "record_mellohi"),
    RECORD_8(2263, "record_stal"),
    RECORD_9(2264, "record_strad"),
    RECORD_10(2265, "record_ward"),
    RECORD_11(2266, "record_11"),
    RECORD_12(2267, "record_wait");

    private final int id;

    private final String minecraftId;

    CompatibilityItemType(int id, String minecraftId) {
        this.id = id;
        this.minecraftId = minecraftId;
    }

    public int getId() {
        return this.id;
    }

    public String getMinecraftId() {
        return this.minecraftId;
    }

    public String getFullMinecraftId()
    {
        return "minecraft:" + this.minecraftId;
    }

    public ItemType getItemType() {
        return Sponge.getGame().getRegistry().getType(ItemType.class, this.getMinecraftId()).get();
    }

    public BlockType getBlockType() {
        return Sponge.getGame().getRegistry().getType(BlockType.class, this.getMinecraftId()).get();
    }

    public static CompatibilityItemType getFromName(String name) {
        for (final CompatibilityItemType compatibilityItemType : values()) {
            if (compatibilityItemType.name().equalsIgnoreCase(name)) {
                return compatibilityItemType;
            }
        }
        return null;
    }

    public static CompatibilityItemType getFromItemType(ItemType itemType) {
        for (final CompatibilityItemType compatibilityItemType : values()) {
            if (itemType.getId().equalsIgnoreCase(compatibilityItemType.getFullMinecraftId())) {
                return compatibilityItemType;
            }
        }
        return null;
    }

    public static CompatibilityItemType getFromId(int id) {
        for (final CompatibilityItemType compatibilityItemType : values()) {
            if (compatibilityItemType.id == id) {
                return compatibilityItemType;
            }
        }
        return null;
    }
}