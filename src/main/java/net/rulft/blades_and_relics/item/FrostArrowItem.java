package net.rulft.blades_and_relics.item;

import com.github.alexthe666.iceandfire.IafConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.rulft.blades_and_relics.world.entity.projectile.FrostArrow;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class FrostArrowItem extends ArrowItem {
    public final float damage;

    public FrostArrowItem(Properties properties, float damage) {
        super(properties);
        this.damage = damage;
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        FrostArrow arrow = new FrostArrow(pShooter, pLevel, ModItems.FROST_ARROW.get());
        arrow.setBaseDamage(this.damage);
        return arrow;
    }

    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, @NotNull TooltipFlag flagIn) {
        tooltip.add((new TranslatableComponent("dragon_sword_ice.hurt1")).withStyle(ChatFormatting.GREEN));
        if (IafConfig.dragonWeaponIceAbility) {
            tooltip.add((new TranslatableComponent("dragon_sword_ice.hurt2")).withStyle(ChatFormatting.AQUA));
        }
    }
}
