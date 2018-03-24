package awex.heroes.common.ability;

import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.damagesource.ModDamageSources;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAiming;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class AbilityShazam extends Ability<IAiming> {
    AbilityShazam(int tier) {
        super(tier);
    }

    public void onUpdate(EntityLivingBase entity, Hero hero, IAiming instance, TickEvent.Phase phase) {
        if (phase == TickEvent.Phase.END && SHData.AIMING.get(entity)) {
            double range = 30.0D;
            MovingObjectPosition rayTrace = SHHelper.rayTrace(entity, range, 6, 1.0F);
            if (rayTrace != null) {
                World world = entity.worldObj;
                if (!world.isRemote) {
                    world.spawnEntityInWorld(new EntityLightningBolt(world, rayTrace.blockX, rayTrace.blockY, rayTrace.blockZ));
                }else{
                    world.addWeatherEffect(new EntityLightningBolt(world, rayTrace.blockX, rayTrace.blockY, rayTrace.blockY));
                }
            }
        }
    }

    public float damageDealt(EntityLivingBase entity, EntityLivingBase target, Hero hero, IAiming instance, DamageSource source, float amount, float originalAmount) {
        return super.damageDealt(entity, target, hero, instance, source, amount, originalAmount);
    }
}
