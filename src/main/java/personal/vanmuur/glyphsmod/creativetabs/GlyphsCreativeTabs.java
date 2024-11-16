package personal.vanmuur.glyphsmod.creativetabs;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import personal.vanmuur.glyphsmod.registry.ModBlocks;
import personal.vanmuur.glyphsmod.registry.ModItems;

public class GlyphsCreativeTabs {

    // Create a Deferred Register for Creative Tabs
    public static final CreativeModeTab GLYPHS_TAB = CreativeModeTabs.BUILDING_BLOCKS.addModTab("glyphsmod",
            () -> ModBlocks.BLOCKS.getEntries());

    public static void registerCreativeTabs() {
        // Register blocks and items in the creative tab
        CreativeModeTabs.BUILDING_BLOCKS.addTab(GlyphsMod.MODID, () -> ModBlocks.BLOCKS.getEntries());
        CreativeModeTabs.BUILDING_BLOCKS.addTab(GlyphsMod.MODID, () -> ModItems.ITEMS.getEntries());
    }
}
