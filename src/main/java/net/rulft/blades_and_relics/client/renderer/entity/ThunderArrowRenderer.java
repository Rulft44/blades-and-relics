package net.rulft.blades_and_relics.client.renderer.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.rulft.blades_and_relics.world.entity.projectile.FlameArrow;
import net.rulft.blades_and_relics.world.entity.projectile.ThunderArrow;

@OnlyIn(Dist.CLIENT)
public class ThunderArrowRenderer extends ArrowRenderer<ThunderArrow> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("blades_and_relics:textures/entity/thunder_arrow.png");

    public ThunderArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(ThunderArrow pEntity) {
        return TEXTURES;
    }
}
