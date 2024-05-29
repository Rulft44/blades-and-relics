package net.rulft.blades_and_relics.world.entity.projectile;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.entity.EntityFireDragon;
import com.github.alexthe666.iceandfire.entity.EntityIceDragon;
import com.github.alexthe666.iceandfire.enums.EnumParticles;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.ForgeEventFactory;
import net.rulft.blades_and_relics.item.ModItems;
import net.rulft.blades_and_relics.world.entity.ModEntityType;
import org.jetbrains.annotations.NotNull;

public class ThunderArrow extends AbstractArrow {
    private final Item referenceItem;

    public ThunderArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.THUNDER_ARROW.get();
    }

    public ThunderArrow(LivingEntity shooter, Level level, Item referenceItem) {
        super(ModEntityType.THUNDER_ARROW.get(), shooter, level);
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

    protected void doPostHurtEffects(@NotNull LivingEntity target) {
        Entity attacker = this.getOwner();

        boolean flag = true;
        if (attacker instanceof Player && (double)((Player) attacker).attackAnim > 0.2) {
            flag = false;
        }

        if (!attacker.level.isClientSide && flag) {
            LightningBolt lightningboltentity = (LightningBolt)EntityType.LIGHTNING_BOLT.create(target.level);
            lightningboltentity.moveTo(target.position());
            if (!target.level.isClientSide) {
                target.level.addFreshEntity(lightningboltentity);
            }
        }

        if (target instanceof EntityFireDragon || target instanceof EntityIceDragon) {
            target.hurt(DamageSource.LIGHTNING_BOLT, 9.5F);
        }

        target.knockback(1.0, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
    }
}
