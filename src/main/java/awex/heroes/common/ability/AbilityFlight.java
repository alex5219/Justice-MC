package awex.heroes.common.ability;

import awex.heroes.common.hero.villain.VillainLexLuthor;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fiskfille.core.FiskUtils;
import fiskfille.core.helper.VectorHelper;
import fiskfille.heroes.client.particle.SHParticleType;
import fiskfille.heroes.client.particle.SHParticlesClient;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.common.hero.*;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

public class AbilityFlight extends Ability<IAbility> {
    public AbilityFlight(int tier) {
        super(tier);
    }

    public void onUpdate(EntityLivingBase entity, Hero hero, IAbility instance, TickEvent.Phase phase) {
        if (phase == TickEvent.Phase.END) {
            if (entity.worldObj.isRemote && FiskUtils.proxy.isClientPlayer(entity) && entity instanceof EntityPlayer) {
                Minecraft mc = Minecraft.getMinecraft();
                EntityPlayer player = (EntityPlayer)entity;
                if (this != Ability.PROPELLED_FLIGHT) {
                    if (!player.capabilities.isFlying && !player.onGround) {
                        if (!player.isInWater() && player.dimension != 31 && player.motionY < 0.0D) {
                            player.motionY += 0.05999999865889549D;
                        }

                        player.moveFlying(player.moveStrafing, player.moveForward, 0.075F);
                        if (mc.gameSettings.keyBindJump.getIsKeyPressed()) {
                            player.motionY += player.dimension == 31 ? 0.10000000149011612D : 0.125D;
                        }

                        if (mc.gameSettings.keyBindSneak.getIsKeyPressed()) {
                            player.motionY -= player.dimension == 31 ? 0.10000000149011612D : 0.07500000298023224D;
                        }
                    }
                    if (this.applyMotion(entity) && entity.worldObj.isRemote) {
                        this.doParticles(entity);
                    }
                }
            }
            entity.fallDistance = 0.0F;
        }

    }

    public boolean applyMotion(EntityLivingBase entity) {
        boolean flying = (Boolean)SHData.JETPACKING.get(entity);
        boolean hovering = (Boolean)SHData.HOVERING.get(entity);
        if (flying && !hovering) {
            if (entity.motionY < 0.0D) {
                entity.motionY += 0.18000000715255737D;
            } else {
                entity.motionY += 0.11999999731779099D;
            }

            entity.moveFlying(entity.moveStrafing, entity.moveForward, 0.15F);
            return true;
        } else if (hovering) {
            float scale = (Float)SHData.SCALE.get(entity);
            float f = Math.max(scale, 1.0F);
            if (entity.motionY < (double)(-0.15F * f)) {
                entity.motionY += (double)(0.15F * f);
            } else {
                if (scale < 1.0F) {
                    scale = (1.0F - scale) / 2.0F;
                }

                entity.motionY = Math.sin((double)((float)entity.ticksExisted / 10.0F)) * 0.05000000074505806D * (double)scale;
            }

            return true;
        } else {
            return false;
        }
    }

    @SideOnly(Side.CLIENT)
    public void doParticles(EntityLivingBase entity) {
        Hero hero = SHHelper.getHero(entity);
        boolean clientPlayer = FiskUtils.proxy.isClientPlayer(entity);
        boolean firstPerson = clientPlayer && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0;
        float scale = (Float) SHData.SCALE.get(entity);
        if (!clientPlayer || !firstPerson || scale >= 1.0F) {
            Vec3 pos = VectorHelper.getPosition(entity, 1.0F).addVector(0.0D, VectorHelper.getOffset(entity), 0.0D);
            double d = Math.min(Math.sqrt((entity.prevPosX - entity.posX) * (entity.prevPosX - entity.posX) + (entity.prevPosZ - entity.posZ) * (entity.prevPosZ - entity.posZ)) * 2.0D, 1.0D);
            double d1 = d * (double)(Byte)SHData.FLIGHT_ANIMATION.get(entity);
            float yaw = entity.renderYawOffset;
            int side;
            Vec3 vec3;
            Vec3 vec31;
            int i;
            if (hero instanceof VillainLexLuthor) {
                boolean hovering = (Boolean)SHData.HOVERING.get(entity);
                Vec3 offsets;
                if (!firstPerson && !hovering) {
                    offsets = VectorHelper.multiply(Vec3.createVectorHelper(-0.4D, -0.81D, 0.0D), (double)scale);

                    for(side = 0; side < 2; ++side) {
                        offsets.xCoord *= -1.0D;
                        vec3 = VectorHelper.copy(pos);
                        vec31 = VectorHelper.copy(offsets);
                        vec31.rotateAroundX((float)Math.toRadians(-d1 * 60.0D));
                        vec31.rotateAroundY((float)Math.toRadians((double)(-yaw)));
                        vec3 = VectorHelper.add(vec3, vec31);

                        for(i = 0; i < 2; ++i) {
                            this.multiplyScale(SHParticlesClient.spawnParticleClient(SHParticleType.SHORT_FLAME, vec3.xCoord, vec3.yCoord, vec3.zCoord, (this.rand.nextDouble() - 0.5D) / 20.0D * (double)scale, (double)(-scale) * (hovering ? 0.1D : 0.25D), (this.rand.nextDouble() - 0.5D) / 20.0D * (double)scale), scale);
                        }
                    }
                }

                if (hovering) {
                    offsets = VectorHelper.multiply(Vec3.createVectorHelper(0.1D, -0.5D, -0.175D), (double)scale);

                    for(side = 0; side < 2; ++side) {
                        offsets.xCoord *= -1.0D;
                        vec3 = VectorHelper.copy(pos);
                        vec31 = VectorHelper.copy(offsets);
                        vec31.rotateAroundX((float)Math.toRadians(-d1 * 60.0D));
                        vec31.rotateAroundY((float)Math.toRadians((double)(-yaw)));
                        vec3 = VectorHelper.add(vec3, vec31);

                        for(i = 0; i < 2; ++i) {
                            this.multiplyScale(SHParticlesClient.spawnParticleClient(SHParticleType.SHORT_FLAME, vec3.xCoord, vec3.yCoord, vec3.zCoord, 0.0D, -0.1D * (double)scale, 0.0D), scale);
                        }
                    }
                }

                if (firstPerson) {
                    yaw = entity.rotationYaw;
                }

                offsets = VectorHelper.multiply(Vec3.createVectorHelper(0.15D, -1.62D, 0.0D), (double)scale);

                for(side = 0; side < 2; ++side) {
                    offsets.xCoord *= -1.0D;
                    vec3 = VectorHelper.copy(pos);
                    vec31 = VectorHelper.copy(offsets);
                    vec31.rotateAroundX((float)Math.toRadians(-d1 * 60.0D));
                    vec31.rotateAroundY((float)Math.toRadians((double)(-yaw)));
                    vec3 = VectorHelper.add(vec3, vec31);

                    for(i = 0; i < 2; ++i) {
                        this.multiplyScale(SHParticlesClient.spawnParticleClient(SHParticleType.SHORT_FLAME, vec3.xCoord, vec3.yCoord, vec3.zCoord, (this.rand.nextDouble() - 0.5D) / 20.0D * (double)scale, -0.25D * (double)scale, (this.rand.nextDouble() - 0.5D) / 20.0D * (double)scale), scale);
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    private void multiplyScale(EntityFX entity, float scale) {
        if (entity != null) {
            entity.multipleParticleScaleBy(scale);
        }

    }
}
