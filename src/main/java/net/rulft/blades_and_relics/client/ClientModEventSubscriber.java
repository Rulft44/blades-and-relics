package net.rulft.blades_and_relics.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rulft.blades_and_relics.BladesAndRelics;
import net.rulft.blades_and_relics.client.renderer.entity.FlameArrowRenderer;
import net.rulft.blades_and_relics.client.renderer.entity.FrostArrowRenderer;
import net.rulft.blades_and_relics.client.renderer.entity.ThunderArrowRenderer;
import net.rulft.blades_and_relics.world.entity.ModEntityType;

@Mod.EventBusSubscriber(modid = BladesAndRelics.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntityType.FROST_ARROW.get(), FrostArrowRenderer::new);
        event.registerEntityRenderer(ModEntityType.FLAME_ARROW.get(), FlameArrowRenderer::new);
        event.registerEntityRenderer(ModEntityType.THUNDER_ARROW.get(), ThunderArrowRenderer::new);
    }
}
