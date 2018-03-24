package awex.heroes.common.items;

import awex.heroes.HeroesUnited;
import awex.heroes.common.items.constructs.ItemConstruct;
import fiskfille.heroes.common.hero.Hero;

import java.lang.reflect.Field;

public class ConstructRegistry {
    public static final ItemConstruct HAL_JORDAN = new ConstructAxe();
    public ConstructRegistry(){

    }
    public static void register() {
        Field[] var0 = ConstructRegistry.class.getFields();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            Field field = var0[var2];
            if (field.getType() == Hero.class) {
                try {
                    Hero.register(HeroesUnited.MODID+":"+field.getName().toLowerCase(), (Hero) field.get((Object)null));
                } catch (Exception var5) {
                    var5.printStackTrace();
                }
            }
        }

    }
}
