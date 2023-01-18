package sapphiregaze.amethystitems.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import sapphiregaze.amethystitems.init.EnchantInit;
import sapphiregaze.amethystitems.util.Utility;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @ModifyVariable(method = "attack", at = @At(value = "STORE"), ordinal = 1)
    private float addTransposeDamage(float value) {
        PlayerEntity playerEntity = (PlayerEntity) (Object) this;

        int transposeChanceBase = 20;
        float transposeHeathBase = 0.1F;
        int level = EnchantmentHelper.getLevel(EnchantInit.TRANSPOSE, playerEntity.getMainHandStack());

        if (level > 0 && Utility.percentChance(transposeChanceBase * level)) {
            value += transposeHeathBase * level;
            playerEntity.heal(transposeHeathBase * level * playerEntity.getAttackCooldownProgress(0.5f));
            System.out.println("You've been healed " + transposeHeathBase * level * playerEntity.getAttackCooldownProgress(0.5f));
            playerEntity.playSound(SoundEvents.BLOCK_AMETHYST_CLUSTER_HIT, 1.0F, 1.0F);
        }

        return value;
    }
}
