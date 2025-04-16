package net.alexander499.uselessstuff.item.custom;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class MagnetItem extends Item {
  public static class ModSounds {
    public static final Identifier MAGNET_PULL_ID = new Identifier("alexanders-useless-stuff", "magnet_pull");
    public static SoundEvent MAGNET_PULL = SoundEvent.of(MAGNET_PULL_ID);

    public static void registerSounds() {
      Registry.register(Registries.SOUND_EVENT, MAGNET_PULL_ID, MAGNET_PULL);
    }
  }

  public MagnetItem(Settings settings) {
    super(settings);
  }

  @Override
  public void inventoryTick(ItemStack stack, World world, net.minecraft.entity.Entity entity, int slot, boolean selected) {
    if (world.isClient || !(entity instanceof PlayerEntity player)) return;

    ItemStack mainHand = player.getMainHandStack();
    ItemStack offHand = player.getOffHandStack();

    // Only activate when held in hand
    if (!mainHand.isOf(this) && !offHand.isOf(this)) return;

    double radius = 8.0;
    Vec3d playerPos = player.getPos();

    List<ItemEntity> nearbyItems = world.getEntitiesByClass(ItemEntity.class, player.getBoundingBox().expand(radius),
        item -> !item.cannotPickup() && !item.isRemoved());

    for (ItemEntity item : nearbyItems) {
      Vec3d direction = playerPos.subtract(item.getPos()).normalize().multiply(0.5);
      item.setVelocity(item.getVelocity().add(direction));

      // Play sound at the player's location
      world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.MAGNET_PULL, player.getSoundCategory(), 1.0F, 1.0F);
    }
  }
}