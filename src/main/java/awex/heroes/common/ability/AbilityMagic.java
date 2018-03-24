package awex.heroes.common.ability;

import am2.playerextensions.ExtendedProperties;
import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import net.minecraft.entity.EntityLivingBase;

public class AbilityMagic extends Ability<IAbility> {
    private static int cooldown = 0;
    public AbilityMagic(int tier) {
        super(tier);
    }

    public void onUpdate(EntityLivingBase entity, Hero hero, IAbility instance, TickEvent.Phase phase) {
        super.onUpdate(entity, hero, instance, phase);
        if (phase == TickEvent.Phase.END) {
             if(entity.worldObj.isRemote){

             }else{
                 ExtendedProperties.For(entity).setCurrentMana(ExtendedProperties.For(entity).getCurrentMana() + 25.0F);
                 ExtendedProperties.For(entity).forceSync();
             }
        }
    }
}
