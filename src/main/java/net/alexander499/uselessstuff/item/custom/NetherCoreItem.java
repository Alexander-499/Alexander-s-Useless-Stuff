package net.alexander499.uselessstuff.item.custom;

import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class NetherCoreItem extends Item {
  public NetherCoreItem(Settings settings) {
    super(settings);
  }

  @Override
  public ActionResult useOnBlock(ItemUsageContext context) {
    World world = context.getWorld();
    BlockPos pos = context.getBlockPos();

    if (world.isClient) return ActionResult.SUCCESS; // Only execute on the server side

    // Define the radius
    int radius = 10;

    for (int x = -radius; x <= radius; x++) {
      for (int y = -radius; y <= radius; y++) {
        for (int z = -radius; z <= radius; z++) {
          BlockPos blockPos = pos.add(x, y, z);

          // Check if the block is not air
          if (!world.getBlockState(blockPos).isAir()) {
            world.setBlockState(blockPos, Blocks.NETHERRACK.getDefaultState()); // Transform to netherrack
          }
        }
      }
    }

    return ActionResult.SUCCESS; // Indicate successful use
  }

  @Override
  public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
    tooltip.add(Text.literal("Transforms nearby blocks into Netherrack."));
    tooltip.add(Text.literal("Right-click to activate!"));
  }
}
