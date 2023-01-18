package sapphiregaze.amethystitems.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import sapphiregaze.amethystitems.enchantment.TransposeEnchantment;
import sapphiregaze.amethystitems.init.EnchantInit;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(method = "attack",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;resetLastAttackedTicks()V"),
            locals = LocalCapture.CAPTURE_FAILSOFT)
    private void getCooldownProgress(Entity target, CallbackInfo ci, float f, float g, float h) {
        if (TransposeEnchantment.damageFlag)
            TransposeEnchantment.currentCooldown = h;
    }

    @ModifyVariable(method = "attack", at = @At(value = "STORE"), ordinal = 1)
    private float addTransposeDamage(float value) {
        PlayerEntity pe = (PlayerEntity) (Object) this;
        int level = EnchantmentHelper.getLevel(EnchantInit.TRANSPOSE, pe.getMainHandStack());
        if (level > 0)
            value += TransposeEnchantment.contributeDamage(level);
        return value;
    }
}
