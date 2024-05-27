package net.rulft.blades_and_relics;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rulft.blades_and_relics.item.ModItems;
import net.rulft.blades_and_relics.world.entity.ModEntityType;
import org.slf4j.Logger;

@Mod(BladesAndRelics.MOD_ID)
public class BladesAndRelics {

    public static final String MOD_ID = "blades_and_relics";

    private static final Logger LOGGER = LogUtils.getLogger();

    public BladesAndRelics() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModEntityType.register(eventBus);


        eventBus.addListener(this::setup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("smh my balls - illuc 2006-2023");
    }
}
