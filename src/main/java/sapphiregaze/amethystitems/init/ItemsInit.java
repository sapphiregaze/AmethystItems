package sapphiregaze.amethystitems.init;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;
import sapphiregaze.amethystitems.Amethystitems;
import sapphiregaze.amethystitems.items.AmethystHoe;
import sapphiregaze.amethystitems.materials.AmethystArmorMaterial;
import sapphiregaze.amethystitems.materials.AmethystToolMaterial;

public class ItemsInit {
    public static final AmethystToolMaterial AMETHYST = new AmethystToolMaterial();
    public static final AmethystArmorMaterial AMETHYST_ARMOR = new AmethystArmorMaterial();

    private static final Item.Settings COMBAT_SETTINGS = new Item.Settings().group(ItemGroup.COMBAT);
    private static final Item.Settings TOOL_SETTINGS = new Item.Settings().group(ItemGroup.TOOLS);

    public static final Item AMETHYST_SWORD = new SwordItem(AMETHYST,5,-2.4F, COMBAT_SETTINGS);
    public static final Item AMETHYST_PICKAXE = new PickaxeItem(AMETHYST, 1, -2.8f, TOOL_SETTINGS);
    public static final Item AMETHYST_AXE = new AxeItem(AMETHYST, 5.0f, -3.0f, TOOL_SETTINGS);
    public static final Item AMETHYST_SHOVEL = new ShovelItem(AMETHYST, 1.5f, -3.0f, TOOL_SETTINGS);
    public static final Item AMETHYST_HOE = new AmethystHoe(AMETHYST, 0, 0.0F, TOOL_SETTINGS);

    public static final Item AMETHYST_HELMET = new ArmorItem(AMETHYST_ARMOR, EquipmentSlot.HEAD, COMBAT_SETTINGS);
    public static final Item AMETHYST_CHESTPLATE = new ArmorItem(AMETHYST_ARMOR, EquipmentSlot.CHEST, COMBAT_SETTINGS);
    public static final Item AMETHYST_LEGGINGS = new ArmorItem(AMETHYST_ARMOR, EquipmentSlot.LEGS, COMBAT_SETTINGS);
    public static final Item AMETHYST_BOOTS = new ArmorItem(AMETHYST_ARMOR, EquipmentSlot.FEET, COMBAT_SETTINGS);

    public static final Item AMETHYST_HORSE_ARMOR = new HorseArmorItem(13, "amethyst", (new Item.Settings().maxCount(1).group(ItemGroup.MISC)));

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
