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

    public static boolean damageFlag = false;
    public static float currentCooldown = 0f;

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
        if (damageFlag) {
            user.heal(0.1F * level * currentCooldown); // Heal amount of damage contributed by enchantment exactly
            target.playSound(SoundEvents.BLOCK_AMETHYST_CLUSTER_HIT, 1.0F, 1.0F);
            damageFlag = false;
        }
        super.onTargetDamaged(user, target, level);
    }

    public static float contributeDamage(int level) {
        damageFlag = true;
        return Utility.percentChance(25 * level) ? 0.1F * level : 0F;
    }

}
