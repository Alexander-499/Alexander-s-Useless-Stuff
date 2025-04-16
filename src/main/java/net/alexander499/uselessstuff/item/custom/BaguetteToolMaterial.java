package net.alexander499.uselessstuff.item.custom;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.Items;

public class BaguetteToolMaterial implements ToolMaterial {
  @Override public int getDurability() { return 64; } // Optional
  @Override public float getMiningSpeedMultiplier() { return 1.0F; }
  @Override public float getAttackDamage() { return 2.0F; } // Added to the SwordItem's attackDamage
  @Override public int getMiningLevel() { return 0; }
  @Override public int getEnchantability() { return 5; }
  @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(Items.BREAD); }
}
