package net.alexander499.uselessstuff;

import net.alexander499.uselessstuff.block.ModBlocks;
import net.alexander499.uselessstuff.item.ModItemGroups;
import net.alexander499.uselessstuff.item.ModItems;
import net.alexander499.uselessstuff.item.custom.MagnetItem;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlexandersUselessStuff implements ModInitializer {
	public static final String MOD_ID = "alexanders-useless-stuff";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static KeyBinding zoomKey;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
			if (entity instanceof CowEntity) {
				entity.setFireTicks(20);
				serverWorld.createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 5, World.ExplosionSourceType.TNT);
			}
		});

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		MagnetItem.ModSounds.registerSounds();
	}
}