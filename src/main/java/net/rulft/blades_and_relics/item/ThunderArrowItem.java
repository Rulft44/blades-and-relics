package net.rulft.blades_and_relics.item;

import com.github.alexthe666.iceandfire.IafConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.rulft.blades_and_relics.world.entity.projectile.ThunderArrow;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class ThunderArrowItem extends ArrowItem {
    public final float damage;

    public ThunderArrowItem(Properties properties, float damage) {
        super(properties);
        this.damage = damage;
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        ThunderArrow arrow = new ThunderArrow(pShooter, pLevel, ModItems.THUNDER_ARROW.get());
        arrow.setBaseDamage(this.damage);
        return arrow;
    }

    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, @NotNull TooltipFlag flagIn) {
        tooltip.add((new TranslatableComponent("dragon_sword_lightning.hurt1")).withStyle(ChatFormatting.GREEN));
        if (IafConfig.dragonWeaponLightningAbility) {
            tooltip.add((new TranslatableComponent("dragon_sword_lightning.hurt2")).withStyle(ChatFormatting.DARK_PURPLE));
        }
    }
}
