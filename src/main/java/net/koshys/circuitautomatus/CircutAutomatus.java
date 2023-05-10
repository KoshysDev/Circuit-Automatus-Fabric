package net.koshys.circuitautomatus;

import net.fabricmc.api.ModInitializer;

import net.koshys.circuitautomatus.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CircutAutomatus implements ModInitializer {

    public static final String MOD_ID = "circuitautomatus";

    public static final Logger LOGGER = LoggerFactory.getLogger("circuitautomatus");

    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
    }
}