package awex.heroes.common.ability;

import awex.heroes.common.data.Data;
import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.common.data.effect.Effect;
import fiskfille.heroes.common.data.effect.StatusEffect;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;

public class AbilityPhase extends Ability<IAbility> {

    public AbilityPhase(int tier) {
        super(tier);
    }
/**
    public void onUpdate(EntityLivingBase entity, Hero hero, IAbility instance, TickEvent.Phase phase) {
        if (phase == TickEvent.Phase.END) {
            if (!hero.hasAbility(AbilityManager.PHASING)) return;
            if (!SHHelper.isSpeedster(entity)) return;
            if (!((SHData.SPEED.get(entity) + 1) > 0)) return;
            EntityPlayer ep = (EntityPlayer) entity;
            if (!StatusEffect.has(entity, Effect.PHASE_SUPPRESSANT) && Data.PHASE.get(entity) && (SHData.SPEED.get(entity) + 1) >= 7) {
                int blockX = MathHelper.floor_double(ep.posX);
                int blockY = MathHelper.floor_double(ep.posY - 0.2D - ep.yOffset);
                int blockZ = MathHelper.floor_double(ep.posZ);
                if (!ep.onGround || ep.worldObj.isAirBlock(blockX, blockY, blockZ) || ep.capabilities.isFlying) {
                    return;
                }
                Data.PHASEY.set(ep, ep.motionY);
                ep.noClip = true;
                ep.motionY = 0.0D;
                ep.onGround = true;
                return;
            } else if (!Data.PHASE.get(ep) && SHHelper.isSpeedster(ep) && ep.onGround && ep.noClip && Data.PHASEY.get(ep) != 999D) {
                ep.noClip = false;
                ep.onGround = true;
                ep.motionY = Data.PHASEY.get(ep);
                return;
            }
        }
    }

    public boolean renderIcon(EntityPlayer player) {
        return (SHData.SPEED.get(player) + 1) >= 7;
    }

    public boolean isActive(EntityLivingBase entity) {
        return !StatusEffect.has(entity, Effect.PHASE_SUPPRESSANT) && Data.PHASE.get(entity) && (SHData.SPEED.get(entity) + 1) >= 7 && entity.onGround && !entity.worldObj.isAirBlock(MathHelper.floor_double(entity.posX), MathHelper.floor_double(entity.posY - 0.2D - entity.yOffset), MathHelper.floor_double(entity.posZ)) && !((EntityPlayer)entity).capabilities.isFlying;
    }

    public int getX() {
        return 55;
    }

    public int getY() {
        return 0;
    }

    public boolean canTakeDamage(EntityLivingBase entity, EntityLivingBase attacker, Hero hero, IAbility instance, DamageSource source, float amount) {
        if (source == DamageSource.inWall && Data.PHASE.get(entity) && isActive(entity)) {
            return false;
        }
        return super.canTakeDamage(entity, attacker, hero, instance, source, amount);
    }*/
}