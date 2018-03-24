package awex.heroes.client.render.entity;

import awex.heroes.common.data.Data;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

import java.util.Iterator;
import java.util.List;

public class ModEntityRenderer extends EntityRenderer
{
    private final Minecraft mc;

    public ModEntityRenderer(Minecraft mc) {
        super(mc, mc.getResourceManager());
        this.mc = mc;
    }

    public void updateCameraAndRender(float partialTick) {
    }
}
