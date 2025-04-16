package net.alexander499.uselessstuff;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ClientInit implements ClientModInitializer {
  private boolean isZooming = false;
  private double previousFov = 70.0;

  @Override
  public void onInitializeClient() {
    AlexandersUselessStuff.zoomKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        "key.alexanders-useless-stuff.zoom",
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_R,
        "category.alexanders_useless_stuff"
    ));

    ClientTickEvents.END_CLIENT_TICK.register(client -> {
      if (AlexandersUselessStuff.zoomKey.isPressed()) {
        if (!isZooming) {
          previousFov = client.options.getFov().getValue();
          client.options.getFov().setValue(30);
          isZooming = true;
        }
      } else if (isZooming) {
        client.options.getFov().setValue((int) Math.round(previousFov));
        isZooming = false;
      }
    });
  }
}
