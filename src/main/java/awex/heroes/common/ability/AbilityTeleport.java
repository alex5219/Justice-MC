package awex.heroes.common.ability;

import awex.heroes.common.hero.IWarpWave;
import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.core.FiskUtils;
import fiskfille.core.helper.FiskServerUtils;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class AbilityTeleport extends Ability<IAbility> {
    public AbilityTeleport(int tier) {
        super(tier);
    }

    public void onUpdate(EntityLivingBase entity, Hero hero, IWarpWave instance, TickEvent.Phase phase) {
        if (phase == TickEvent.Phase.END) {
            if (!entity.worldObj.isRemote && (Boolean) SHData.SHOOTING.get(entity)) {
                entity.worldObj.spawnEntityInWorld(new EntityEnderPearl(entity.worldObj, entity));
                //Double x = entity.getLook(1)
                //EnderTeleportEvent event = new EnderTeleportEvent(entity, x, this.posY, this.posZ, 15.0F);
            }

            if (entity.worldObj.isRemote && FiskUtils.proxy.isClientPlayer(entity)) {
                SHData.SHOOTING.set(entity, instance.getWarpWaveKey().getIsKeyPressed());
            }
        }
    }
}