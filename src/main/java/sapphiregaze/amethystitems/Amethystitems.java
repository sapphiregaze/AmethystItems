package sapphiregaze.amethystitems;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Amethystitems implements ModInitializer {
    public static final String MOD_ID = "AmethystItemsMod";
    public static final AmethystMaterial AMETHYST = new AmethystMaterial();
    public static final Item AMETHYST_SWORD = new SwordItem(AMETHYST,6,-2.4F,(new Item.Settings().group(ItemGroup.COMBAT)));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("amethyst_items", "amethyst_sword"), AMETHYST_SWORD);
    }
}
