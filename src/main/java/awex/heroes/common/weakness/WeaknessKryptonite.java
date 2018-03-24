package awex.heroes.common.weakness;

import awex.heroes.common.blocks.ModBlocks;
import awex.heroes.common.items.ModItems;
import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.weakness.Weakness;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class WeaknessKryptonite extends Weakness {
    public WeaknessKryptonite() {
        super(new Ability[0]);
    }

    public void onUpdate(EntityLivingBase entity, Hero hero, TickEvent.Phase phase, boolean hasWeakness) {
        if (phase == TickEvent.Phase.END && hasWeakness && !entity.worldObj.isRemote) {
            final World world = entity.worldObj;
            int radius = 8;
            int x = MathHelper.floor_double(entity.posX);
            int y = MathHelper.floor_double(entity.boundingBox.minY);
            int z = MathHelper.floor_double(entity.posZ);
            AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1)).expand((double)radius, (double)radius, (double)radius);
            boolean flag = checkKryptonite(aabb, world);
            boolean flag1 = hasKryptonite(entity);

            if (flag || flag1) {
                entity.addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 1));
                entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 3));
                entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 3));
                entity.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 100, 3));
                entity.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 1));
                entity.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));
            }
        }
    }
    public boolean hasKryptonite(EntityLivingBase player){
        if(player.getHeldItem() == new ItemStack(ModItems.kryptonite)){
            return true;
        }else{
            return false;
        }
    }
    public boolean checkKryptonite(AxisAlignedBB aabb, World world) {
        int i = MathHelper.floor_double(aabb.minX);
        int j = MathHelper.floor_double(aabb.maxX + 1.0D);
        int k = MathHelper.floor_double(aabb.minY);
        int l = MathHelper.floor_double(aabb.maxY + 1.0D);
        int i1 = MathHelper.floor_double(aabb.minZ);
        int j1 = MathHelper.floor_double(aabb.maxZ + 1.0D);

        if (world.checkChunksExist(i, k, i1, j, l, j1)) {
            for (int k1 = i; k1 < j; ++k1) {
                for (int l1 = k; l1 < l; ++l1) {
                    for (int i2 = i1; i2 < j1; ++i2) {
                        Block block = world.getBlock(k1, l1, i2);
                        if (block == ModBlocks.kryptoniteOre) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

