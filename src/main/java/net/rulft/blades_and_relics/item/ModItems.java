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


    public static final RegistryObject<Item> FANG_SWORD = ITEMS.register("fang_sword", () -> new FangSword(DRAGONBONE_TOOL_MATERIAL, 3, -2.4F, (new Item.Properties()).tab(IceAndFire.TAB_ITEMS)));
    public static final RegistryObject<Item> DRAGON_FANG = ITEMS.register("dragon_fang", () -> new Item(new Item.Properties().tab(IceAndFire.TAB_ITEMS).stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}