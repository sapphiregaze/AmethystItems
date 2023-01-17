package sapphiregaze.amethystitems.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.MendingEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.registry.Registry;
import sapphiregaze.amethystitems.Amethystitems;
import sapphiregaze.amethystitems.init.ItemsInit;
import sapphiregaze.amethystitems.util.Utility;

public class TransposeEnchantment extends Enchantment {
    public TransposeEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
        Registry.register(Registry.ENCHANTMENT, Amethystitems.ID("transpose"), this);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return super.isAcceptableItem(stack) && ((SwordItem) stack.getItem()).getMaterial() == ItemsInit.AMETHYST;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof MendingEnchantment);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        switch (level) {
            case 1 -> {
                if (Utility.percentChance(25)) {
                    user.heal(user.getHealth() + 0.1F);
                    target.damage(user.getRecentDamageSource(), 0.1F);
                }
            }
            case 2 -> {
                if (Utility.percentChance(50)) {
                    user.heal(user.getHealth() + 0.2F);
                    target.damage(user.getRecentDamageSource(), 0.2F);
                }
            }
            case 3 -> {
                if (Utility.percentChance(75)) {
                    user.heal(user.getHealth() + 0.3F);
                    target.damage(user.getRecentDamageSource(), 0.3F);
                }
            }
        }
        target.playSound(SoundEvents.BLOCK_AMETHYST_CLUSTER_HIT, 1.0F, 1.0F);
        super.onTargetDamaged(user, target, level);
    }
}
