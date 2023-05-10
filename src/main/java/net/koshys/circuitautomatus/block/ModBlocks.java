package net.koshys.circuitautomatus.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.koshys.circuitautomatus.CircutAutomatus;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block REDSTONE_VALIDATOR_BLOCK = registerBlock("redstone_validator",
            new Block(FabricBlockSettings.of(Material.DECORATION).breakInstantly().sounds(BlockSoundGroup.WOOD)),
            ItemGroups.REDSTONE);

    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(CircutAutomatus.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup group){

        Item item = Registry.register(Registries.ITEM, new Identifier(CircutAutomatus.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));

        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));

        return item;
    }

    public static void registerModBlocks(){
        CircutAutomatus.LOGGER.info("Registering blocks for " + CircutAutomatus.MOD_ID);
    }
}
