package personal.vanmuur.glyphsmod.registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import personal.vanmuur.glyphsmod.tileentities.GlyphEnergyTileEntity;
import personal.vanmuur.glyphsmod.tileentities.GlyphStorageTileEntity;

public class ModTileEntities {
    // Register Tile Entities
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = GlyphsMod.TILE_ENTITIES;

    public static final RegistryObject<BlockEntityType<GlyphEnergyTileEntity>> GLYPH_ENERGY = TILE_ENTITIES
            .register("glyph_energy",
                    () -> BlockEntityType.Builder
                            .of(GlyphEnergyTileEntity::new, ModBlocks.ENERGY_GLYPH.get())
                            .build(null));

    public static final RegistryObject<BlockEntityType<GlyphStorageTileEntity>> GLYPH_STORAGE = TILE_ENTITIES
            .register("glyph_storage",
                    () -> BlockEntityType.Builder
                            .of(GlyphStorageTileEntity::new, ModBlocks.GLYPH_WALL.get())
                            .build(null));
}
