package awex.heroes.common.entity;

import fiskfille.core.helper.FiskServerUtils;
import fiskfille.heroes.common.config.SHConfig;
import fiskfille.heroes.common.damagesource.ModDamageSources;
import fiskfille.heroes.common.entity.EntityCanaryCry;
import fiskfille.heroes.common.entity.EntityIcicle;
import fiskfille.heroes.common.entity.EntityThrownShield;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class EntityVibeWave extends EntityThrowable {
    public EntityVibeWave(World world) {
        super(world);
    }

    public EntityVibeWave(World world, EntityLivingBase entity) {
        super(world, entity);
        this.setSize(0.15F, 0.15F);
        this.setLocationAndAngles(entity.posX, entity.posY + (double)entity.getEyeHeight(), entity.posZ, entity.rotationYaw, entity.rotationPitch);
        this.posY -= 0.2D;
        this.ignoreFrustumCheck = true;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        float f = 0.4F;
        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F) * f);
        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F) * f);
        this.motionY = (double)(-MathHelper.sin((this.rotationPitch + this.func_70183_g()) / 180.0F * 3.1415927F) * f);
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, this.func_70182_d(), 1.0F);
    }

    public boolean isBurning() {
        return false;
    }

    protected float getGravityVelocity() {
        return 0.0F;
    }

    protected float func_70182_d() {
        return 1.0F;
    }

    public void onUpdate() {
        super.onUpdate();
        float radius = this.getRadius(0.0F);
        if (this.ticksExisted < this.getMaxTicksExisted() - 4) {
            AxisAlignedBB aabb = this.boundingBox.expand((double)radius, (double)radius, (double)radius);
            List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this.getThrower(), aabb);
            if (!this.worldObj.isRemote) {
                int minX = MathHelper.floor_double(aabb.minX);
                int maxX = MathHelper.floor_double(aabb.maxX + 1.0D);
                int minY = MathHelper.floor_double(aabb.minY);
                int maxY = MathHelper.floor_double(aabb.maxY + 1.0D);
                int minZ = MathHelper.floor_double(aabb.minZ);
                int maxZ = MathHelper.floor_double(aabb.maxZ + 1.0D);
                if (this.worldObj.checkChunksExist(minX, minY, minZ, maxX, maxY, maxZ)) {
                    for(int x = minX; x < maxX; ++x) {
                        for(int y = minY; y < maxY; ++y) {
                            for(int z = minZ; z < maxZ; ++z) {
                                Block block = this.worldObj.getBlock(x, y, z);
                                if ((!(this.getThrower() instanceof EntityPlayer) || ((EntityPlayer)this.getThrower()).canPlayerEdit(x, y, z, 0, (ItemStack)null)) && block.getMaterial() == Material.glass && this.rand.nextInt(10 * MathHelper.ceiling_double_int(this.getDistance((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D))) == 0) {
                                    this.worldObj.func_147480_a(x, y, z, true);
                                }
                            }
                        }
                    }
                }
            }

            Iterator var14 = list.iterator();

            while(var14.hasNext()) {
                Entity entity1 = (Entity)var14.next();
                if (!(entity1 instanceof EntityVibeWave)) {
                    boolean flag = false;
                    if (entity1 instanceof EntityThrownShield) {
                        EntityThrownShield shield = (EntityThrownShield)entity1;
                        if (!this.worldObj.isRemote) {
                            EntityItem entityitem = new EntityItem(this.worldObj);
                            entityitem.setLocationAndAngles(shield.posX, shield.posY, shield.posZ, 0.0F, 0.0F);
                            entityitem.setEntityItemStack(shield.getShieldItem());
                            this.worldObj.spawnEntityInWorld(entityitem);
                        }

                        shield.setDead();
                    }

                    if (entity1 instanceof EntityIcicle) {
                        ((EntityIcicle)entity1).shatter();
                    }

                    if (entity1 instanceof EntityLivingBase) {
                        EntityLivingBase entity = (EntityLivingBase)entity1;
                        if (!this.worldObj.isRemote && entity != this.getThrower()) {
                            entity.attackEntityFrom(ModDamageSources.causeSoundDamage(this.getThrower()), FiskServerUtils.interpolate(8.0F, 12.0F, (float)this.ticksExisted / (float)this.getMaxTicksExisted()));
                            flag = true;
                        }
                    } else {
                        flag = true;
                    }

                    if (flag) {
                        float mass = entity1.width * entity1.width * entity1.height;
                        float f = 0.0125F / MathHelper.sqrt_float(mass) * (1.0F - (float)this.ticksExisted / (float)this.getMaxTicksExisted());
                        entity1.motionX += (this.posX - this.prevPosX) * (double)f;
                        entity1.motionY += (this.posY - this.prevPosY) * (double)f;
                        entity1.motionZ += (this.posZ - this.prevPosZ) * (double)f;
                    }
                }
            }
        }

        if (this.ticksExisted >= this.getMaxTicksExisted()) {
            this.setDead();
        }

    }

    public float getRadius(float partialTicks) {
        float f = (float)this.ticksExisted + partialTicks;
        return Math.max(f / (4.0F + f * f / 20.0F) - 0.25F, 0.125F);
    }

    public float getOpacity(float partialTicks) {
        float ticks = (float)this.ticksExisted + partialTicks;
        int max = this.getMaxTicksExisted();
        return 0.2F * (1.0F - ticks / (float)max);
    }

    public int getMaxTicksExisted() {
        return 15;
    }

    protected void onImpact(MovingObjectPosition mop) {
        if (mop.entityHit == null) {
            this.setDead();
        }

    }
}

