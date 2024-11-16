package personal.vanmuur.glyphsmod.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import personal.vanmuur.glyphsmod.blocks.EnergyGlyphBlock;
import personal.vanmuur.glyphsmod.blocks.GlyphWallBlock;
import personal.vanmuur.glyphsmod.blocks.GlyphContainerBlock;

public class ModBlocks {
    // Register the Energy Glyph Block and Glyph Wall Block
    public static final DeferredRegister<Block> BLOCKS = GlyphsMod.BLOCKS;

    // Energy Glyph Block
    public static final RegistryObject<Block> ENERGY_GLYPH = BLOCKS.register("energy_glyph",
            () -> new EnergyGlyphBlock(BlockBehaviour.Properties.of(Material.STONE)));

    // Glyph Wall Block
    public static final RegistryObject<Block> GLYPH_WALL = BLOCKS.register("glyph_wall",
            () -> new GlyphWallBlock(BlockBehaviour.Properties.of(Material.STONE)));

    // Glyph Container Block
    public static final RegistryObject<Block> GLYPH_CONTAINER = BLOCKS.register("glyph_container",
            () -> new GlyphContainerBlock(BlockBehaviour.Properties.of(Material.STONE)));

    // Add blocks to creative tab
    public static void addToCreativeTabs() {
        CreativeModeTabs.BUILDING_BLOCKS.addTab("glyphsmod", () -> ModBlocks.BLOCKS.getEntries());
    }
}
