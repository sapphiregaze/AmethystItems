package sapphiregaze.amethystitems;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Amethystitems implements ModInitializer {
    public static final String MOD_ID = "AmethystItemsMod";
    public static final AmethystMaterial AMETHYST = new AmethystMaterial();
    public static final Item AMETHYST_SWORD = new SwordItem(AMETHYST,6,-2.4F,(new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item AMETHYST_PICKAXE = new PickaxeItem(AMETHYST, 1, -2.8f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item AMETHYST_AXE = new AxeItem(AMETHYST, 5.0f, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item AMETHYST_SHOVEL = new ShovelItem(AMETHYST, 1.5f, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));
    //public static final Item AMETHYST_HOE = new HoeItem(AMETHYST, -3, 0.0f, new Item.Settings().group(ItemGroup.TOOLS));


    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_sword"), AMETHYST_SWORD);
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_pickaxe"), AMETHYST_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_axe"), AMETHYST_AXE);
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_shovel"), AMETHYST_SHOVEL);
        //Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_hoe"), AMETHYST_HOE);
    }
}
