package net.rulft.blades_and_relics.client.renderer.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.rulft.blades_and_relics.world.entity.projectile.FrostArrow;

@OnlyIn(Dist.CLIENT)
public class FrostArrowRenderer extends ArrowRenderer<FrostArrow> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("blades_and_relics:textures/entity/frost_arrow.png");

    public FrostArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(FrostArrow pEntity) {
        return TEXTURES;
    }
}
