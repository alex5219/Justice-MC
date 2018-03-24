package awex.heroes.common.ability;

import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class AbilityEnhancedAgility extends Ability<IAbility> {
    public AbilityEnhancedAgility(int tier) {
        super(tier);
    }

    public void onUpdate(EntityLivingBase entity, Hero hero, IAbility instance, TickEvent.Phase phase) {
        super.onUpdate(entity, hero, instance, phase);
        if (phase == TickEvent.Phase.END) {
            entity.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1, 1, true));
        }
    }
}