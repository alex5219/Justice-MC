package awex.heroes.common.weakness;

import awex.heroes.HeroesUnited;
import fiskfille.heroes.common.weakness.Weakness;

import java.lang.reflect.Field;

public class WeaknessManager{
    public static final Weakness RAGE = new WeaknessRage();
    public static final Weakness GREED = new WeaknessGreed();
    public static final Weakness FEAR = new WeaknessFear();
    public static final Weakness WILL = new WeaknessWill();
    public static final Weakness HOPE = new WeaknessHope();
    public static final Weakness COMPASSION = new WeaknessCompassion();
    public static final Weakness LOVE = new WeaknessLove();
    public static final Weakness DEATH = new WeaknessDeath();
    public static final Weakness LIFE = new WeaknessLife();
    public static final Weakness KRYPTONITE = new WeaknessKryptonite();

    public WeaknessManager(){

    }
    static {
        Field[] var0 = WeaknessManager.class.getFields();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            Field field = var0[var2];
            if (field.getType() == Weakness.class) {
                try {
                    Weakness.register(HeroesUnited.MODID+":"+field.getName().toLowerCase(), (Weakness) field.get((Object)null));
                } catch (Exception var5) {
                    var5.printStackTrace();
                }
            }
        }

    }
}
