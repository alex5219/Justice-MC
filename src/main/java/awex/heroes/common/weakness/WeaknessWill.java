package awex.heroes.common.weakness;

import awex.heroes.common.damagesource.IExtendedDamage;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.weakness.Weakness;
import net.minecraft.entity.EntityLivingBase;

public class WeaknessWill extends Weakness {
    public WeaknessWill() {
    }

    public float damageTaken(EntityLivingBase entity, EntityLivingBase attacker, Hero hero, net.minecraft.util.DamageSource source, float amount, float originalAmount) {
        amount = super.damageTaken(entity, attacker, hero, source, amount, originalAmount);
        if (IExtendedDamage.DamageType.WILL.isPresent(source)) {
            amount *= 2.5F;
        }

        return amount;
    }
}
