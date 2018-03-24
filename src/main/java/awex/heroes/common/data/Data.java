package awex.heroes.common.data;

import awex.heroes.common.ability.AbilityManager;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import cpw.mods.fml.relauncher.Side;
import fiskfille.core.helper.FiskPredicates;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.data.SHData;
import net.minecraft.entity.Entity;

import java.lang.reflect.Field;

public class Data<T> extends SHData{
    public static SHData<String> CONSTRUCT = new Data(AbilityManager.CONSTRUCT);
    public static SHData<Float> CONSTRUCT_TIMER = (new Data(0.0F, AbilityManager.CONSTRUCT)).setExempt(1);
    public static SHData<Boolean> CONSTRUCTING = (new Data(false, AbilityManager.CONSTRUCT)).setExempt(1);
    public static SHData<Byte> WILL_LEVEL = (new Data(0)).setExempt(12);
    public static SHData<Integer> WILL_LEVEL_TOTAL = (new Data(Integer.valueOf(0))).setExempt(12);
    public static SHData<Float> WILL_LEVEL_BAR = (new Data(0.0F)).setExempt(12);
    public static SHData<Boolean> GLIDING = new Data(false, Predicates.or(Ability.GLIDING, Ability.GLIDING_FLIGHT));
    public static SHData<Boolean> PREV_GLIDING = (new Data(false)).setExempt(44);
    public static SHData<Boolean> SHOOT = (new Data(false, FiskPredicates.ALIVE)).setExempt(1);
    public static SHData<Boolean> SUPERMAN_FLIGHT = (new Data(false, AbilityManager.SUPERMAN_FLIGHT)).setExempt(1);
    public static SHData<Boolean> CANFLY = (new Data(false));
    public static SHData<Boolean> FROST_BREATH = new Data<Boolean>(false).setExempt(RESET);
    //public static SHData<Boolean> PHASE = new Data<Boolean>(false).setExempt(RESET);
    //public static SHData<Double> PHASEY= new Data<Double>(255D).setExempt(RESET);

    protected Data(DataFactory<T> defaultVal, Predicate<Entity> p) {
        super(defaultVal, p);
    }

    protected Data(final T defaultVal, Predicate<Entity> p) {
        super(defaultVal, p);
    }

    protected Data(DataFactory<T> defaultVal) {
        super(defaultVal);
    }

    protected Data(T defaultVal) {
        super(defaultVal);
    }

    protected Data(Predicate<Entity> p) {
        super(p);
    }

    protected Data() {
        super();
    }


    protected Data revokePerms(Side side) {
        this.permissions &= ~(1 << side.ordinal());
        return this;
    }


    protected SHData revokePerms() {
        this.revokePerms(Side.CLIENT);
        this.revokePerms(Side.SERVER);
        return this;
    }
    public static void register() {
        for (Field field : Data.class.getFields()) {
            try {
                Object obj = field.get(null);

                if (Data.class.isInstance(obj)) {
                    ((Data) obj).init(field, "justicemc:" + field.getName());
                }
            }
            catch (Exception e) {
                if (!(e instanceof NullPointerException)) e.printStackTrace();
            }
        }
    }
}