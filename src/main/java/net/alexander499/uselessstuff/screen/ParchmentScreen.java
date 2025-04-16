package net.alexander499.uselessstuff.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class ParchmentScreen extends Screen {
  private final ItemStack stack;
  private TextFieldWidget textField;
  private ButtonWidget confirmButton;
  private ButtonWidget cancelButton;

  public ParchmentScreen(ItemStack stack) {
    super(Text.of("Write on Parchment"));
    this.stack = stack;
  }

  @Override
  protected void init() {
    int centerX = this.width / 2;
    int centerY = this.height / 2;

    // Create text input field
    textField = new TextFieldWidget(this.textRenderer, centerX - 100, centerY - 40, 200, 20, Text.of("Write here"));
    textField.setMaxLength(256);
    textField.setPlaceholder(Text.of("Type your message..."));

    // Load previous message if it exists
    if (stack.hasNbt() && stack.getNbt().contains("ParchmentMessage")) {
      textField.setText(stack.getNbt().getString("ParchmentMessage"));
    }

    this.addSelectableChild(textField);
    this.setInitialFocus(textField);

    // Confirm button
    confirmButton = ButtonWidget.builder(Text.of("Confirm"), button -> {
      String message = textField.getText();
      if (!message.isBlank()) {
        stack.getOrCreateNbt().putString("ParchmentMessage", message);
      }
      MinecraftClient.getInstance().setScreen(null);
    }).dimensions(centerX - 100, centerY, 95, 20).build();
    this.addDrawableChild(confirmButton);

    // Cancel button
    cancelButton = ButtonWidget.builder(Text.of("Cancel"), button -> {
      MinecraftClient.getInstance().setScreen(null);
    }).dimensions(centerX + 5, centerY, 95, 20).build();
    this.addDrawableChild(cancelButton);
  }

  @Override
  public void render(DrawContext context, int mouseX, int mouseY, float delta) {
    this.renderBackground(context);
    textField.render(context, mouseX, mouseY, delta);
    super.render(context, mouseX, mouseY, delta);
  }

  @Override
  public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
    if (keyCode == 256) { // ESC
      MinecraftClient.getInstance().setScreen(null);
      return true;
    }
    return textField.keyPressed(keyCode, scanCode, modifiers) || super.keyPressed(keyCode, scanCode, modifiers);
  }
}