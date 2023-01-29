package sapphiregaze.amethystitems.materials;

import com.google.common.base.Suppliers;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum AmethystArmorMaterial implements ArmorMaterial {
    AMETHYST("amethyst", 30, new int[]{3, 5, 7, 3}, new int[]{13, 15, 16, 11}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.5F, 0.1F, Items.AMETHYST_SHARD);

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int[] baseDurability;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredientSupplier;

    AmethystArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int[] baseDurability, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Item item) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.baseDurability = baseDurability;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = Suppliers.memoize(() -> Ingredient.ofItems(item));
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return this.baseDurability[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
