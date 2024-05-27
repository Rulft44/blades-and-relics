package net.rulft.blades_and_relics.client.renderer.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.rulft.blades_and_relics.world.entity.projectile.FlameArrow;

@OnlyIn(Dist.CLIENT)
public class FlameArrowRenderer extends ArrowRenderer<FlameArrow> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("blades_and_relics:textures/entity/flame_arrow.png");

    public FlameArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(FlameArrow pEntity) {
        return TEXTURES;
    }
}
