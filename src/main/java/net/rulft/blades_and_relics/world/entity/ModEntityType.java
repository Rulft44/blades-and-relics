package net.rulft.blades_and_relics.world.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rulft.blades_and_relics.BladesAndRelics;
import net.rulft.blades_and_relics.world.entity.projectile.FlameArrow;
import net.rulft.blades_and_relics.world.entity.projectile.FrostArrow;
import net.rulft.blades_and_relics.world.entity.projectile.ThunderArrow;

public class ModEntityType {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, BladesAndRelics.MOD_ID);

    //public static final EntityType<Arrow> ARROW = register("arrow", EntityType.Builder.of(Arrow::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20));

    public static final RegistryObject<EntityType<FrostArrow>> FROST_ARROW =  ENTITIES.register("frost_arrow", ()
            -> EntityType.Builder.<FrostArrow>of(FrostArrow::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(BladesAndRelics.MOD_ID, "frost_arrow").toString()));

    public static final RegistryObject<EntityType<FlameArrow>> FLAME_ARROW =  ENTITIES.register("flame_arrow", ()
            -> EntityType.Builder.<FlameArrow>of(FlameArrow::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(BladesAndRelics.MOD_ID, "flame_arrow").toString()));

    public static final RegistryObject<EntityType<ThunderArrow>> THUNDER_ARROW =  ENTITIES.register("thunder_arrow", ()
            -> EntityType.Builder.<ThunderArrow>of(ThunderArrow::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(BladesAndRelics.MOD_ID, "thunder_arrow").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
