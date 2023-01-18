package sapphiregaze.amethystitems;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sapphiregaze.amethystitems.init.EnchantInit;
import sapphiregaze.amethystitems.init.ItemsInit;
import sapphiregaze.amethystitems.loottables.AmethystLootTableModifier;

public class Amethystitems implements ModInitializer {
    public static final String MOD_ID = "amethyst_items";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier ID(String Path) {
        return new Identifier(MOD_ID, Path);
    }

    @Override
    public void onInitialize() {
        ItemsInit.init();
        EnchantInit.init();
        AmethystLootTableModifier.modifyLootTable();
    }
}
