package net.alexander499.uselessstuff.item;

import net.alexander499.uselessstuff.AlexandersUselessStuff;
import net.alexander499.uselessstuff.item.custom.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
  public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings()));
  public static final Item PARCHMENT = registerItem("parchment", new ParchmentItem(new Item.Settings()));
  public static final Item POCKET_WATCH = registerItem("pocket_watch", new PocketWatchItem(new Item.Settings().maxCount(1)));
  public static final Item BAGUETTE = registerItem("baguette", new BaguetteItem(new Item.Settings().maxCount(1)));
  public static final Item JUMP_FEATHER = registerItem("jump_feather", new JumpFeatherItem(new Item.Settings().maxCount(1)));
  public static final Item MAGNET = registerItem("magnet", new MagnetItem(new Item.Settings().maxCount(1)));
  public static final Item NETHER_CORE = registerItem("nether_core", new NetherCoreItem(new Item.Settings().maxCount(1)));

  private static Item registerItem(String name, Item item) {
    return Registry.register(Registries.ITEM, Identifier.of(AlexandersUselessStuff.MOD_ID, name), item);
  }

  public static void registerModItems() {
    AlexandersUselessStuff.LOGGER.info("Registering Mod Items for " + AlexandersUselessStuff.MOD_ID);
  }
}