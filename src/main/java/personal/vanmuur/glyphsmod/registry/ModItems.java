package personal.vanmuur.glyphsmod.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import personal.vanmuur.glyphsmod.items.GlyphItem;

public class ModItems {
    // Register Glyph Items
    public static final DeferredRegister<Item> ITEMS = GlyphsMod.ITEMS;

    public static final RegistryObject<Item> GLYPH_ITEM = ITEMS.register("glyph_item",
            () -> new GlyphItem(new Item.Properties()));

    // Add items to creative tab
    public static void addToCreativeTabs() {
        CreativeModeTabs.BUILDING_BLOCKS.addTab("glyphsmod", () -> ModItems.ITEMS.getEntries());
    }
}
