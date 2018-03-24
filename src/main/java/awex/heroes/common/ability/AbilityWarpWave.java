package awex.heroes.common.ability;

import awex.heroes.common.entity.EntityVibeWave;
import awex.heroes.common.hero.IWarpWave;
import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.core.FiskUtils;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.common.entity.EntityCanaryCry;
import fiskfille.heroes.common.hero.Hero;
import net.minecraft.entity.EntityLivingBase;

public class AbilityWarpWave extends Ability<IWarpWave> {
    public AbilityWarpWave(int tier) {
        super(tier);
    }

    public void onUpdate(EntityLivingBase entity, Hero hero, IWarpWave instance, TickEvent.Phase phase) {
        if (phase == TickEvent.Phase.END) {
            if (!entity.worldObj.isRemote && (Boolean) SHData.SHOOTING.get(entity)) {
                entity.worldObj.spawnEntityInWorld(new EntityVibeWave(entity.worldObj, entity));
            }

            if (entity.worldObj.isRemote && FiskUtils.proxy.isClientPlayer(entity)) {
                SHData.SHOOTING.set(entity, instance.getWarpWaveKey().getIsKeyPressed());
            }
        }

    }
}
