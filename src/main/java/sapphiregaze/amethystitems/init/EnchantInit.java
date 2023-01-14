package sapphiregaze.amethystitems.init;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import sapphiregaze.amethystitems.enchantment.TransposeEnchantment;

public class EnchantInit {
    public static Enchantment TRANSPOSE;

    public static void Init()
    {
        TRANSPOSE = new TransposeEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.WEAPON,
                new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }
}
