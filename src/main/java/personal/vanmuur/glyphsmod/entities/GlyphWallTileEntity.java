package personal.vanmuur.glyphsmod.tileentities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import personal.vanmuur.glyphsmod.registry.ModTileEntities;

public class GlyphWallTileEntity extends BlockEntity {
    private String[] glyphs = new String[9]; // Example of a 3x3 grid for glyphs

    public GlyphWallTileEntity(BlockEntityType<?> tileEntityTypeIn) {
        super(ModTileEntities.GLYPH_WALL.get());
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        super.save(tag);
        // Save the glyphs array to NBT
        tag.putStringArray("glyphs", glyphs);
        return tag;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        // Load the glyphs array from NBT
        if (tag.contains("glyphs", 9)) {
            glyphs = tag.getStringArray("glyphs");
        }
    }

    public void paintGlyph(Item item) {
        // In this example, we just put a dummy string based on the item
        String glyph = item == Items.PAPER ? "glyph_paper" : "empty";

        // For simplicity, we'll paint in the first available spot (you can change this)
        for (int i = 0; i < glyphs.length; i++) {
            if (glyphs[i] == null || glyphs[i].isEmpty()) {
                glyphs[i] = glyph;
                break;
            }
        }

        setChanged(); // Notify that the tile entity has changed
    }

    public String[] getGlyphs() {
        return glyphs;
    }
}
