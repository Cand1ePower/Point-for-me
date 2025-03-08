package cdpw.pfm.item;

import cdpw.pfm.PointForMe;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item CDPW = registerItems("cp", new Item(new Item.Settings()));
    private static Item registerItems(String id, Item item){
        return Registry.register(Registries.ITEM,Identifier.of(PointForMe.MOD_ID, id), item);
    }
    private static void addItemToIG(FabricItemGroupEntries fabricItemGroupEntries){
        fabricItemGroupEntries.add(CDPW);
    }
    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIG);
        PointForMe.LOGGER.info("Registering Mod Items for " + PointForMe.MOD_ID);
    }
}
