package net.rulft.blades_and_relics.world.entity.projectile;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.entity.EntityFireDragon;
import com.github.alexthe666.iceandfire.entity.props.FrozenProperties;
import com.github.alexthe666.iceandfire.enums.EnumParticles;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.ForgeEventFactory;
import net.rulft.blades_and_relics.item.ModItems;
import net.rulft.blades_and_relics.world.entity.ModEntityType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class FrostArrow extends AbstractArrow {
    private final Item referenceItem;

    public FrostArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.FROST_ARROW.get();
    }

    public FrostArrow(LivingEntity shooter, Level level, Item referenceItem) {
        super(ModEntityType.FROST_ARROW.get(), shooter, level);
        this.referenceItem = referenceItem;
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }

    protected void damageShield(Player player, float damage) {
        if (damage >= 3.0F && player.getUseItem().getItem().canPerformAction(player.getUseItem(), ToolActions.SHIELD_BLOCK)) {
            ItemStack copyBeforeUse = player.getUseItem().copy();
            int i = 1 + Mth.floor(damage);
            player.getUseItem().hurtAndBreak(i, player, (p_213360_0_) -> {
                p_213360_0_.broadcastBreakEvent(EquipmentSlot.CHEST);
            });
            if (player.getUseItem().isEmpty()) {
                InteractionHand Hand = player.getUsedItemHand();
                ForgeEventFactory.onPlayerDestroyItem(player, copyBeforeUse, Hand);
                if (Hand == InteractionHand.MAIN_HAND) {
                    this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                } else {
                    this.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                }

                player.stopUsingItem();
                this.playSound(SoundEvents.SHIELD_BREAK, 0.8F, 0.8F + this.level.random.nextFloat() * 0.4F);
            }
        }

    }

    public void tick() {
        super.tick();
        if (this.level.isClientSide && !this.inGround) {
            double d0 = this.random.nextGaussian() * 0.02;
            double d1 = this.random.nextGaussian() * 0.02;
            double d2 = this.random.nextGaussian() * 0.02;
            double d3 = 10.0;
            double xRatio = this.getDeltaMovement().x * (double)this.getBbHeight();
            double zRatio = this.getDeltaMovement().z * (double)this.getBbHeight();
            IceAndFire.PROXY.spawnParticle(EnumParticles.Snowflake, this.getX() + xRatio + (double)(this.random.nextFloat() * this.getBbWidth() * 1.0F) - (double)this.getBbWidth() - d0 * 10.0, this.getY() + (double)(this.random.nextFloat() * this.getBbHeight()) - d1 * 10.0, this.getZ() + zRatio + (double)(this.random.nextFloat() * this.getBbWidth() * 1.0F) - (double)this.getBbWidth() - d2 * 10.0, 0.1, 1.0, 0.1);
            IceAndFire.PROXY.spawnParticle(EnumParticles.DragonIce, this.getX() + xRatio + (double)(this.random.nextFloat() * this.getBbWidth() * 1.0F) - (double)this.getBbWidth() - d0 * 10.0, this.getY() + (double)(this.random.nextFloat() * this.getBbHeight()) - d1 * 10.0, this.getZ() + zRatio + (double)(this.random.nextFloat() * this.getBbWidth() * 1.0F) - (double)this.getBbWidth() - d2 * 10.0, 0.1, 1.0, 0.1);
        }

    }

    protected void doPostHurtEffects(@NotNull LivingEntity target) {
        Entity attacker = this.getOwner();

        if (target instanceof Player) {
            this.damageShield((Player)target, (float)this.getBaseDamage());
        }

        if (target instanceof EntityFireDragon) {
            target.hurt(DamageSource.DROWN, 13.5F);
        }

        FrozenProperties.setFrozenFor(target, 200);
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2));
        target.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100, 2));
        target.knockback(1.0, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());

    }
}
