package sapphiregaze.amethystitems.loottables;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import sapphiregaze.amethystitems.init.ItemsInit;

public class AmethystLootTableModifier {
    private static final Identifier ANCIENT_CITY_CHEST_ID = new Identifier("minecraft", "chests/ancient_city");

    public static void modifyLootTable() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, identifier, builder, lootTableSource) -> {
            if (ANCIENT_CITY_CHEST_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2F))
                        .with(ItemEntry.builder(ItemsInit.AMETHYST_HORSE_ARMOR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 1.0F)).build());
                builder.pool(poolBuilder.build());
            }
        });
    }
}
