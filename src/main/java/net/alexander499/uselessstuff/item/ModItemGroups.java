package net.alexander499.uselessstuff.item;

import net.alexander499.uselessstuff.AlexandersUselessStuff;
import net.alexander499.uselessstuff.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
  public static final ItemGroup ALEXANDERS_USELESS_STUFF_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(AlexandersUselessStuff.MOD_ID, "ruby"),
      FabricItemGroup.builder().displayName(Text.translatable("itemgroup.alexanders_useless_stuff"))
          .icon(() -> new ItemStack(ModItems.SAPPHIRE)).entries((displayContext, entries) -> {
            entries.add(ModItems.SAPPHIRE);
            entries.add(ModItems.PARCHMENT);
            entries.add(ModBlocks.CRATE);
            entries.add(ModItems.POCKET_WATCH);
            entries.add(ModBlocks.FEATHER_BLOCK);
            entries.add(ModItems.BAGUETTE);
            entries.add(ModItems.JUMP_FEATHER);
            entries.add(ModItems.MAGNET);
            entries.add(ModItems.NETHER_CORE);
          }).build());

  public static void registerItemGroups() {
    AlexandersUselessStuff.LOGGER.info("Registering Item Groups for " + AlexandersUselessStuff.MOD_ID);
  }
}