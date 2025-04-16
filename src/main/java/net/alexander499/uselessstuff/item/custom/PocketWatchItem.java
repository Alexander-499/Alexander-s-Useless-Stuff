package net.alexander499.uselessstuff.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class PocketWatchItem extends Item {
  public PocketWatchItem(Settings settings) {
    super(settings);
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    if (!world.isClient) {
      long time = world.getTimeOfDay() % 24000;

      int hours = (int)((time / 1000 + 6) % 24);
      int minutes = (int)((time % 1000) * 60 / 1000);

      String timeText = String.format("§b[Pocket Watch]§r The time is %02d:%02d", hours, minutes);
      user.sendMessage(Text.literal(timeText), false);
    }

    return TypedActionResult.success(user.getStackInHand(hand));
  }
}
