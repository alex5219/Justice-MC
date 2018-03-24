package awex.heroes.common.ability;

import awex.heroes.HeroesUnited;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class AbilityMagicImmunity extends Ability {
    public AbilityMagicImmunity(int tier) {
        super(tier);
    }

    public boolean canTakeDamage(EntityLivingBase entity, EntityLivingBase attacker, Hero hero, IAbility instance, DamageSource source, float amount) {
        if(HeroesUnited.isMagic){
            if (source.damageType.equalsIgnoreCase("am2.darkNexus") ||
                source.damageType.equalsIgnoreCase("am2.fire") ||
                source.damageType.equalsIgnoreCase("am2.frost") ||
                source.damageType.equalsIgnoreCase("am2.holy") ||
                source.damageType.equalsIgnoreCase("am2.lightning") ||
                source.damageType.equalsIgnoreCase("am2.backfire") ||
                source.damageType.equalsIgnoreCase("am2.wind") ||
                source.damageType.equalsIgnoreCase("am2.wtfboom") && this.isActive(entity)){
             return false;
            } else {
              return super.canTakeDamage(entity, attacker, hero, instance, source, amount);
            }
        }
        return true;
    }
}
