package net.alexander499.uselessstuff.item.custom;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.SwordItem;

public class BaguetteItem extends SwordItem {

  public BaguetteItem(Item.Settings settings) {
    super(new BaguetteToolMaterial(), 3, -2.4F, settings
        .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).build()).maxCount(1));
  }

  @Override
  public boolean hasGlint(ItemStack stack) {
    return false;
  }
}
