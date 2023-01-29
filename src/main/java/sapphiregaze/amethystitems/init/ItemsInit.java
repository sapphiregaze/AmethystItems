package sapphiregaze.amethystitems.init;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;
import sapphiregaze.amethystitems.Amethystitems;
import sapphiregaze.amethystitems.items.AmethystHoe;
import sapphiregaze.amethystitems.materials.AmethystArmorMaterial;
import sapphiregaze.amethystitems.materials.AmethystToolMaterial;

public class ItemsInit {

    public static final Item AMETHYST_SWORD = new SwordItem(AmethystToolMaterial.AMETHYST,5,-2.4F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item AMETHYST_PICKAXE = new PickaxeItem(AmethystToolMaterial.AMETHYST, 1, -2.8f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item AMETHYST_AXE = new AxeItem(AmethystToolMaterial.AMETHYST, 5.0f, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item AMETHYST_SHOVEL = new ShovelItem(AmethystToolMaterial.AMETHYST, 1.5f, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item AMETHYST_HOE = new AmethystHoe(AmethystToolMaterial.AMETHYST, 0, 0.0F, new Item.Settings().group(ItemGroup.TOOLS));

    public static final Item AMETHYST_HELMET = new ArmorItem(AmethystArmorMaterial.AMETHYST, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item AMETHYST_CHESTPLATE = new ArmorItem(AmethystArmorMaterial.AMETHYST, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item AMETHYST_LEGGINGS = new ArmorItem(AmethystArmorMaterial.AMETHYST, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item AMETHYST_BOOTS = new ArmorItem(AmethystArmorMaterial.AMETHYST, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    public static final Item AMETHYST_HORSE_ARMOR = new HorseArmorItem(13, "amethyst", new Item.Settings().maxCount(1).group(ItemGroup.MISC));

    public static void init() {
        registerItem("amethyst_sword", AMETHYST_SWORD);
        registerItem("amethyst_pickaxe", AMETHYST_PICKAXE);
        registerItem("amethyst_axe", AMETHYST_AXE);
        registerItem("amethyst_shovel", AMETHYST_SHOVEL);
        registerItem("amethyst_hoe", AMETHYST_HOE);
        registerItem("amethyst_helmet", AMETHYST_HELMET);
        registerItem("amethyst_chestplate", AMETHYST_CHESTPLATE);
        registerItem("amethyst_leggings", AMETHYST_LEGGINGS);
        registerItem("amethyst_boots", AMETHYST_BOOTS);
        registerItem("amethyst_horse_armor", AMETHYST_HORSE_ARMOR);
    }

    private static void registerItem(String path, Item item) {
        Registry.register(Registry.ITEM, Amethystitems.ID(path), item);
    }
}
