package personal.vanmuur.glyphmod.registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import personal.vanmuur.glyphmod.GlyphMod;
import personal.vanmuur.glyphmod.entity.WrittenSandstoneEntity;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GlyphMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<WrittenSandstoneEntity>> WRITTEN_SANDSTONE_ENTITY =
        BLOCK_ENTITIES.register("written_sandstone", () ->
            BlockEntityType.Builder.of(WrittenSandstoneEntity::new,
                ModBlocks.WRITTEN_SANDSTONE.get()).build(null)
        );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
