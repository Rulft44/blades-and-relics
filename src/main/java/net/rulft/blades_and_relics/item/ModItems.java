package net.rulft.blades_and_relics.item;

import com.github.alexthe666.iceandfire.IceAndFire;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rulft.blades_and_relics.BladesAndRelics;

import static com.github.alexthe666.iceandfire.item.IafItemRegistry.DRAGONBONE_TOOL_MATERIAL;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BladesAndRelics.MOD_ID);


    public static final RegistryObject<Item> FANG_SWORD = ITEMS.register("fang_sword", ()
            -> new FangSword(DRAGONBONE_TOOL_MATERIAL, 2, -2.4F, (new Item.Properties()).tab(IceAndFire.TAB_ITEMS)));
    public static final RegistryObject<Item> DRAGON_FANG = ITEMS.register("dragon_fang", ()
            -> new Item(new Item.Properties().tab(IceAndFire.TAB_ITEMS).stacksTo(1)));

    public static final RegistryObject<Item> FROST_ARROW = ITEMS.register("frost_arrow", ()
            -> new FrostArrowItem(new Item.Properties().tab(IceAndFire.TAB_ITEMS), 4f));
    public static final RegistryObject<Item> FLAME_ARROW = ITEMS.register("flame_arrow", ()
            -> new FlameArrowItem(new Item.Properties().tab(IceAndFire.TAB_ITEMS), 4f));
    public static final RegistryObject<Item> THUNDER_ARROW = ITEMS.register("thunder_arrow", ()
            -> new ThunderArrowItem(new Item.Properties().tab(IceAndFire.TAB_ITEMS), 4f));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}