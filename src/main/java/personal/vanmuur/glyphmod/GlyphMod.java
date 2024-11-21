package personal.vanmuur.glyphmod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import personal.vanmuur.glyphmod.registry.ModBlockEntities;
import personal.vanmuur.glyphmod.registry.ModBlocks;
import personal.vanmuur.glyphmod.registry.ModItems;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GlyphMod.MOD_ID)
public class GlyphMod {
    public static final String MOD_ID = "glyphmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Very Important Comment
    public GlyphMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // ModVillagers.register(modEventBus);
        // ModPaintings.register(modEventBus);

        // ModConfiguredFeatures.register(modEventBus);
        // ModPlacedFeatures.register(modEventBus);

        // ModFluids.register(modEventBus);
        // ModFluidTypes.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        // ModMenuTypes.register(modEventBus);

        // ModRecipes.register(modEventBus);
        // ModEntityTypes.register(modEventBus);

        // ModLootModifiers.register(modEventBus);

        // GeckoLib.initialize();

//         modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
//         event.enqueueWork(() -> {
//             SpawnPlacements.register(ModEntityTypes.CHOMPER.get(),
//                     SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
//                     Monster::checkMonsterSpawnRules);
//
//             ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.JASMINE.getId(), ModBlocks.POTTED_JASMINE);
//
//             ModMessages.register();
//             ModVillagers.registerPOIs();
//         });
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    // @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    // public static class ClientModEvents {
    //     @SubscribeEvent
    //     public static void onClientSetup(FMLClientSetupEvent event) {
    //         ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SOAP_WATER.get(), RenderType.translucent());
    //         ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SOAP_WATER.get(), RenderType.translucent());

    //         MenuScreens.register(ModMenuTypes.GEM_INFUSING_STATION_MENU.get(), GemInfusingStationScreen::new);

    //         EntityRenderers.register(ModEntityTypes.CHOMPER.get(), ChomperRenderer::new);
    //     }
    // }
}
