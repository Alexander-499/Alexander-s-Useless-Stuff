package net.alexander499.uselessstuff.item.custom;

import net.alexander499.uselessstuff.screen.ParchmentScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ParchmentItem extends Item {
  public ParchmentItem(Settings settings) {
    super(settings);
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    ItemStack stack = user.getStackInHand(hand);

    if (world.isClient) {
      MinecraftClient.getInstance().setScreen(new ParchmentScreen(stack));
    }

    return new TypedActionResult<>(ActionResult.SUCCESS, stack);
  }

  @Override
  public void appendTooltip(ItemStack stack, World world, java.util.List<Text> tooltip, TooltipContext context) {
    NbtCompound nbt = stack.getNbt();
    if (nbt != null && nbt.contains("message")) {
      tooltip.add(Text.literal("Note: " + nbt.getString("message")));
    } else {
      tooltip.add(Text.literal("Right-click to write a note."));
    }
  }
}

