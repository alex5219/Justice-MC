package awex.heroes.common.ability;

import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import net.minecraft.entity.EntityLivingBase;

public class AbilityBuffed extends Ability<IAbility> {
    public AbilityBuffed(int tier) {
        super(tier);
    }

    public void onUpdate(EntityLivingBase entity, Hero hero, IAbility instance, TickEvent.Phase phase) {
        super.onUpdate(entity, hero, instance, phase);
        if (phase == TickEvent.Phase.END && entity.getHealth() < entity.getMaxHealth() && (Short) SHData.TIME_SINCE_DAMAGED.get(entity) > 80) {
            entity.heal(1.0F);
        }
    }
}
