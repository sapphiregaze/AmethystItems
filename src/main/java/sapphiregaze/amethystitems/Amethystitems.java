package sapphiregaze.amethystitems;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Amethystitems implements ModInitializer {
    public static final String MOD_ID = "AmethystItemsMod";

    public static final AmethystMaterial AMETHYST = new AmethystMaterial();
    public static final AmethystArmorMaterial AMETHYST_ARMOR = new AmethystArmorMaterial();

    public static final Item AMETHYST_SWORD = new SwordItem(AMETHYST,6,-2.4F,(new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item AMETHYST_PICKAXE = new PickaxeItem(AMETHYST, 1, -2.8f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item AMETHYST_AXE = new AxeItem(AMETHYST, 5.0f, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item AMETHYST_SHOVEL = new ShovelItem(AMETHYST, 1.5f, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item AMETHYST_HOE = new AmethystHoe(AMETHYST, 0, 0.0F, (new Item.Settings().group(ItemGroup.TOOLS)));

    Item AMETHYST_HELMET = new ArmorItem(AMETHYST_ARMOR, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item AMETHYST_CHESTPLATE = new ArmorItem(AMETHYST_ARMOR, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item AMETHYST_LEGGINGS = new ArmorItem(AMETHYST_ARMOR, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item AMETHYST_BOOTS = new ArmorItem(AMETHYST_ARMOR, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));

    public static final Item AMETHYST_HORSE_ARMOR = new HorseArmorItem(13, "amethyst", (new Item.Settings().maxCount(1).group(ItemGroup.MISC)));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_sword"), AMETHYST_SWORD);
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_pickaxe"), AMETHYST_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_axe"), AMETHYST_AXE);
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_shovel"), AMETHYST_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_hoe"), AMETHYST_HOE);
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_helmet"), AMETHYST_HELMET);
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_chestplate"), AMETHYST_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_leggings"), AMETHYST_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_boots"), AMETHYST_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_horse_armor"), AMETHYST_HORSE_ARMOR);
    }
}
