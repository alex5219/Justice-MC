package awex.heroes.common.ability;

import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.core.FiskUtils;
import fiskfille.core.helper.FiskServerUtils;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.config.SHConfig;
import fiskfille.heroes.common.damagesource.ModDamageSources;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.common.entity.EntityHeatVision;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IHeatVision;
import fiskfille.heroes.common.weakness.WeaknessMetalSkin;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;

public class AbilityHeatVision extends Ability<IHeatVision> {
    public AbilityHeatVision(int tier) {
        super(tier);
    }

    public void onUpdate(EntityLivingBase entity, Hero hero, IHeatVision instance, TickEvent.Phase phase) {
        if (phase == TickEvent.Phase.END) {
            if (entity.worldObj.isRemote && (Float)SHData.SHOOTING_TIMER.get(entity) > 0.0F) {
                if(instance.getHeatVisionKey().getIsKeyPressed())
                entity.worldObj.spawnEntityInWorld(new EntityHeatVision(entity.worldObj, entity));
            }

            if ((Boolean)SHData.SHOOTING.get(entity)) {
                double range = 32.0D;
                MovingObjectPosition rayTrace = SHHelper.rayTrace(entity, range, 6, 1.0F);
                if (rayTrace != null) {
                    if (rayTrace.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && FiskServerUtils.canEntityEdit(entity, rayTrace, (ItemStack)null)) {
                        SHHelper.melt(entity.worldObj, rayTrace.blockX, rayTrace.blockY, rayTrace.blockZ, SHConfig.get().heatVisionGriefing ? 15 : 7);
                    } else if (rayTrace.entityHit != null) {
                        rayTrace.entityHit.attackEntityFrom(ModDamageSources.causeBurnDamage(entity), 7.0F);
                        if (rayTrace.entityHit instanceof EntityLivingBase) {
                            WeaknessMetalSkin.applyHeat((EntityLivingBase)rayTrace.entityHit, WeaknessMetalSkin.HeatSource.HEAT_VISION);
                        }
                    }
                }

                SHData.HEAT_VISION_LENGTH.setWithoutNotify(entity, rayTrace != null && rayTrace.hitInfo instanceof Double ? (Double)rayTrace.hitInfo : range);
            }

            if (entity.worldObj.isRemote && FiskUtils.proxy.isClientPlayer(entity)) {
                SHData.SHOOTING.set(entity, instance.getHeatVisionKey().getIsKeyPressed());
            }
        }

    }
}
