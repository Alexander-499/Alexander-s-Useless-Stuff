package net.alexander499.uselessstuff.block;

import net.alexander499.uselessstuff.AlexandersUselessStuff;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
  public static final Block CRATE = registerBlock("crate",
      new Block(FabricBlockSettings.copyOf(Blocks.BARREL)));
  public static final Block FEATHER_BLOCK = registerBlock("feather_block",
      new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));

  private static Block registerBlock(String name, Block block) {
    registerBlockItem(name, block);
    return Registry.register(Registries.BLOCK, Identifier.of(AlexandersUselessStuff.MOD_ID, name), block);
  };

  private static Item registerBlockItem(String name, Block block) {
    return Registry.register(Registries.ITEM, Identifier.of(AlexandersUselessStuff.MOD_ID, name),
        new BlockItem(block, new FabricItemSettings()));
  };

  public static void registerModBlocks() {
    AlexandersUselessStuff.LOGGER.info("Registering ModBlocks for " + AlexandersUselessStuff.MOD_ID);
  }
}