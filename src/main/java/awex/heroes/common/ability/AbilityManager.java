package awex.heroes.common.ability;

import awex.heroes.HeroesUnited;
import awex.heroes.common.hero.IWarpWave;
import awex.heroes.common.hero.IWill;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.hero.IAbility;
import fiskfille.heroes.common.hero.IAiming;

import java.lang.reflect.Field;

public class AbilityManager{
    public static final Ability<IWill> CONSTRUCT = new AbilityWillConstruct(5);
    public static final Ability<IAiming> WILL_BLAST = new AbilityWillpowerBeam(2);
    public static final Ability<IAbility> MAGICIMMUNITY = new AbilityMagicImmunity(5);
    public static final Ability<IAbility> SUPERMAN_FLIGHT = new AbilityFlight(5);
    public static final Ability<IWarpWave> WARP_WAVE = new AbilityWarpWave(3);
    public static final Ability<IAbility> BUFF = new AbilityBuffed(4);
    public static final Ability<IAbility> LEX_LUTHOR = new AbilityLexLuthor(4);
    public static final Ability<IAbility> LEX_FLIGHT = new AbilityFlight(4);
    public static final Ability<IAiming> SHAZAM = new AbilityShazam(4);
    public static final Ability<IAbility> SUPER_STRENGTH = new AbilitySuperStrength(5);
    public static final Ability<IAbility> ENHANCED_AGILITY = new AbilityEnhancedAgility(5);
    public static final Ability<IAbility> TENACITY = new AbilityTenacity(4);
    public static final Ability<IAiming> FEARTOXIN = new AbilityFearToxin(2);
    public static final Ability<IAbility> AQUAENHANCE = new AbilityAquaticEnhanced(4);
    //public static final Ability<IAbility> MAGIC = new AbilityMagic(4);
    //public static final Ability<IAbility> PHASING = new AbilityPhase(3);

    public AbilityManager(){
    }
    public static void register(){
        Field[] var0 = AbilityManager.class.getFields();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            Field field = var0[var2];
            if (field.getType() == Ability.class) {
                try {
                    Ability.register(HeroesUnited.MODID+":"+field.getName().toLowerCase(), (Ability) field.get((Object)null));
                } catch (Exception var5) {
                    var5.printStackTrace();
                }
            }
        }/**
        for (Hero hero : Hero.getSpeedsters()) {
            if (hero.getVersion() == ItemHeroArmor.ArmorVersion.DCTV || hero.getVersion() == ItemHeroArmor.ArmorVersion.DCEU || hero.getVersion() == ItemHeroArmor.ArmorVersion.DCAU || hero.getVersion() == ItemHeroArmor.ArmorVersion.COMICS) {
                ImmutableList.Builder builder = ImmutableList.builder();
                builder.addAll(hero.getAbilities());
                builder.add(PHASING);
                ImmutableList<AbilityManager> newList = builder.build();

                try {
                    Field f = Hero.class.getDeclaredField("abilities");
                    f.setAccessible(true);
                    f.set(hero, newList);
                    f.setAccessible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }*/
    }
}
