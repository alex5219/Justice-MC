package awex.heroes.common.hero;

import awex.heroes.HeroesUnited;
import awex.heroes.common.hero.justiceleague.*;
import awex.heroes.common.hero.villain.*;
import awex.heroes.common.hero.willcorp.*;
import fiskfille.heroes.common.hero.Hero;

import java.lang.reflect.Field;

public class HeroRegistry {
    public static final Hero HAL_JORDAN = new HeroHalJordan();
    public static final Hero HAL_JORDAN_HAIR = new HeroHalJordanHair();
    public static final Hero JOHN_STEWART = new HeroJohnStewart();
    public static final Hero JESSICA_CRUZ = new HeroJessicaCruz();
    public static final Hero GREEN_LANTERN = new HeroGreenLantern();
    public static final Hero KILOWOG = new HeroKilowog();
    public static final Hero SUPERMAN = new HeroSuperman();
    public static final Hero BATMAN = new HeroBatman();
    public static final Hero WONDER_WOMAN = new HeroWonderWoman();
    public static final Hero GREEN_ARROW_COMICS = new HeroGreenArrowComics();
    public static final Hero BLACK_CANARY_COMICS = new HeroBlackCanaryComics();
    public static final Hero VIBE = new HeroVibe();
    public static final Hero THE_QUESTION = new HeroTheQuestion();
    public static final Hero CYBORG = new HeroCyborg();
    public static final Hero SHAZAM = new HeroShazam();
    public static final Hero ROBIN = new HeroRobin();
    public static final Hero AQUAMAN = new HeroAquaman();
    // Villains
    public static final Hero LEX_LUTHOR = new VillainLexLuthor();
    public static final Hero DARKSEID = new VillainDarkseid();
    public static final Hero DEATHSTROKE = new VillainDeathstroke();
    public static final Hero DOOMSDAY = new VillainDoomsday();
    public static final Hero GRUNDY = new VillainGrundy();
    public static final Hero JOKER = new VillainJoker();
    public HeroRegistry(){

    }
    public static void register() {
        Field[] var0 = HeroRegistry.class.getFields();
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
