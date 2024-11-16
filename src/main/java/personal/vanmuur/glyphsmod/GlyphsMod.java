package personal.vanmuur.glyphsmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventBus;
import net.minecraftforge.eventbus.api.EventBusSubscriber;
import net.minecraftforge.network.NetworkConstants;
import net.minecraftforge.network.chat.MessageType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.core.registries.Registry;
import personal.vanmuur.glyphsmod.registry.ModBlocks;
import personal.vanmuur.glyphsmod.registry.ModItems;
import personal.vanmuur.glyphsmod.registry.ModTileEntities;

public class GlyphsMod {
    // Create a Deferred Register to hold Blocks, Items, and TileEntities
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "glyphsmod");
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "glyphsmod");
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister
            .create(ForgeRegistries.TILE_ENTITIES, "glyphsmod");

    // Register commonSetup method for modloading
    private static final Logger LOGGER = LogUtils.getLogger();

    public GlyphsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the items and blocks from the new registry package
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModTileEntities.TILE_ENTITIES.register(modEventBus);

        // Register the Deferred Register to the mod event bus
        MinecraftForge.EVENT_BUS.register(this);

        // Register the mod's setup process
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Register creative tabs
        GlyphsCreativeTabs.registerCreativeTabs();
    }
}
