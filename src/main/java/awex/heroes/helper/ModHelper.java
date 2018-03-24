package awex.heroes.helper;

import awex.heroes.common.hero.IWill;
import fiskfille.core.helper.FiskServerUtils;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ModHelper extends SHHelper{
    public ModHelper() {
    }

    public static boolean isWill(EntityLivingBase entity) {
        return getHero(entity) instanceof IWill;
    }

}

