package awex.heroes.client;
import awex.heroes.common.data.Data;
import fiskfille.core.helper.FiskServerUtils;
import fiskfille.heroes.FiskHeroes;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.common.event.ClientEventHandler;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.ModItems;
import fiskfille.heroes.helper.SHHelper;
import mods.battlegear2.client.utils.BattlegearRenderHelper;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

import java.util.Iterator;

public class ModelHelper {
    public ModelHelper() {
    }

    public static void renderBipedPre(ModelBiped model, Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GL11.glPushMatrix();
        if (FiskHeroes.isBattlegearLoaded) {
            BattlegearRenderHelper.moveOffHandArm(entity, model, f5);
        }

        if (entity instanceof EntityPlayer) {
            ClientEventHandler.setupPlayerRotation((EntityPlayer)entity);
        }

        setRotationAngles(model, f, f1, f2, f3, f4, f5, entity);
    }

    public static void renderBipedPost(ModelBiped model, Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GL11.glPopMatrix();
    }

    public static void setRotationAngles(ModelBiped model, float f, float f1, float f2, float f3, float f4, float f5, Entity entity1) {
        ItemStack heldItem;
        Hero hero;
        float f6;
        float t;
        if (entity1 instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)entity1;
            heldItem = player.getHeldItem();
            hero = SHHelper.getHero(player);
            if (player.experience == -0.0085F) {
                ModelRenderer modelRenderer;
                for(Iterator var22 = model.boxList.iterator(); var22.hasNext(); modelRenderer.rotateAngleZ = 0.0F) {
                    modelRenderer = (ModelRenderer)var22.next();
                    modelRenderer.rotateAngleX = 0.0F;
                    modelRenderer.rotateAngleY = 0.0F;
                }

                return;
            }
        }

        if (entity1 instanceof EntityLivingBase) {
            EntityLivingBase entity = (EntityLivingBase)entity1;
            heldItem = entity.getHeldItem();
            hero = SHHelper.getHero(entity);

            float f7;
            float f9;
            if ((Integer)Data.TICKS_GLIDING.get(entity) > 4 && entity instanceof EntityPlayer) {
                t = (Float)SHData.AIMING_TIMER.interpolate(entity);
                f7 = MathHelper.wrapAngleTo180_float(f3) / 57.295776F;
                if (heldItem != null && heldItem.getItem() == ModItems.chronosRifle) {
                    f6 = Math.min(MathHelper.wrapAngleTo180_float(f4) / 57.295776F, 0.6F);
                    f9 = Math.abs(f7) / 1.5707964F;
                    model.bipedRightArm.rotationPointX += t * 1.0F;
                    model.bipedRightArm.rotateAngleX += t * (0.1F + f6);
                    model.bipedRightArm.rotateAngleY += t * (0.4F + f7 - f6 * 0.25F);
                    model.bipedRightArm.rotationPointZ += t * (1.5F + Math.min(f7 * 4.0F, 0.0F) * (1.0F - f9) - f9 * 2.0F);
                    model.bipedLeftArm.rotationPointX -= t * (1.5F + Math.max(f7, -0.5F));
                    model.bipedLeftArm.rotationPointZ -= t * (0.5F + Math.max(f7, -0.5F));
                    model.bipedLeftArm.rotationPointY = 2.0F + t;
                    model.bipedLeftArm.rotateAngleX -= t * (0.5F - f6 * 1.3F + Math.min(f6 + 1.0F, 0.0F));
                    model.bipedLeftArm.rotateAngleY += t * (0.4F + Math.min(f7, 0.5F) * 1.25F - f6 * 0.25F + 0.4F * Math.min(f6, 0.0F));
                    model.bipedLeftArm.rotateAngleZ += t * (0.2F + Math.max(f6, 0.0F) + Math.min(f6, 0.0F) * 0.7F);
                } else {
                    model.bipedRightArm.rotateAngleX = FiskServerUtils.interpolate(model.bipedRightArm.rotateAngleX, model.bipedHead.rotateAngleX - 1.5707964F, t);
                    model.bipedRightArm.rotateAngleY = FiskServerUtils.interpolate(model.bipedRightArm.rotateAngleY, f7, t);
                    model.bipedRightArm.rotateAngleZ = FiskServerUtils.interpolate(model.bipedRightArm.rotateAngleZ, model.bipedHead.rotateAngleZ, t);
                }
            }
        }
    }

    public static float getLimbSwingDegree(ModelBiped model, float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)entity;
            if ((Integer)Data.TICKS_GLIDING.get(player) > 4) {
                float f7 = (float)(Integer)Data.TICKS_GLIDING.get(player) + ClientEventHandler.renderTick;
                float f8 = 1.0F - MathHelper.clamp_float(f7 * f7 / 100.0F, 0.0F, 1.0F);
                f1 *= f8;
            }
        }

        return f1;
    }
}
