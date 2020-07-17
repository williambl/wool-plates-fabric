package com.williambl.woolplates;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class WoolPlates implements ModInitializer {

    public static final String MODID = "woolplates";

    private static final String[] COLORS = new String[] {
            "white",
            "orange",
            "magenta",
            "light_blue",
            "yellow",
            "lime",
            "pink",
            "gray",
            "light_gray",
            "cyan",
            "purple",
            "blue",
            "brown",
            "green",
            "red",
            "black"
    };

    @Override
    public void onInitialize() {
        AutoConfig.register(WoolPlatesConfig.class, Toml4jConfigSerializer::new);
        final List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < COLORS.length; i++) {
            blocks.add(new WoolPressurePlate(AbstractBlock.Settings.of(Material.WOOL).noCollision().strength(0.5f).sounds(BlockSoundGroup.WOOL)));
            Registry.register(Registry.BLOCK, new Identifier(MODID, "wool_plate_"+COLORS[i]), blocks.get(i));
            Registry.register(Registry.ITEM, new Identifier(MODID, "wool_plate_"+COLORS[i]), new BlockItem(blocks.get(i), new Item.Settings().group(ItemGroup.REDSTONE)));
        }
    }
}
