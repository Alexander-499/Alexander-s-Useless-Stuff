package net.alexander499.uselessstuff.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class JumpFeatherItem extends Item {
  public JumpFeatherItem(Settings settings) {
    super(settings);
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    ItemStack stack = user.getStackInHand(hand);

    if (!world.isClient) {
      user.setVelocity(user.getVelocity().x, 1.0, user.getVelocity().z);
      user.velocityModified = true;

      // Optional cooldown
      user.getItemCooldownManager().set(this, 40); // 2 seconds
    }

    return TypedActionResult.success(stack, world.isClient());
  }
}
