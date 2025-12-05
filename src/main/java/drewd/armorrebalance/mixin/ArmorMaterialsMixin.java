package drewd.armorrebalance.mixin;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EquipmentType.class)
public class ArmorMaterialsMixin {
    @Shadow
    private int baseMaxDamage;

    @Inject(method = "getMaxDamage", at = @At("HEAD"), cancellable = true)
    public void getMaxDamageInject(int multiplier,CallbackInfoReturnable<Integer> cir) {

        switch (multiplier){
            case 5:
                // LEATHER
                cir.setReturnValue(10*this.baseMaxDamage);
                break;
            case 11:
                // COPPER
                cir.setReturnValue(15*this.baseMaxDamage);
                break;
            case 15:
                // CHAIN / IRON
                cir.setReturnValue(20*this.baseMaxDamage);
                break;
            case 7:
                // GOLD
                cir.setReturnValue(7*this.baseMaxDamage);
                break;
            case 33:
                // DIAMOND
                cir.setReturnValue(35*this.baseMaxDamage);
                break;
            case 25:
                // TURTLE SCUTE
                cir.setReturnValue(25*this.baseMaxDamage);
                break;
            case 37:
                // NETHERITE
                cir.setReturnValue(40*this.baseMaxDamage);
                break;
            case 4:
                // ARMADILLO SCUTE
                cir.setReturnValue(4*this.baseMaxDamage);
                break;
        }
    }
}