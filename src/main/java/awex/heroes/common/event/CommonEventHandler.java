package awex.heroes.common.event;

import awex.heroes.client.render.entity.EntityTestDummy;
import awex.heroes.common.data.Data;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

public class CommonEventHandler {
    @SubscribeEvent
    public void onPlayerLeftClick(LivingAttackEvent event) {
        if(event.entity.worldObj.isRemote){
        if(event.source == null || !(event.entity instanceof EntityTestDummy))
            return;
        if(!event.source.damageType.equals("player"))
            return;
        if(!(event.source.getEntity() instanceof EntityPlayer))
            return;
        EntityPlayer player = (EntityPlayer) event.source.getEntity();
        if(player.isSneaking() && player.getCurrentEquippedItem() == null)
            ((EntityTestDummy)event.entity).dismantle();
        }
    }
/**
    @SubscribeEvent
    public void onJump(LivingEvent.LivingJumpEvent e) {
        Entity entity = e.entity;
        if (entity instanceof EntityPlayer) {
            EntityPlayer EntityPlayer = (EntityPlayer) entity;
            if (SHHelper.getHero(EntityPlayer) == null)
                return;
            if (!SHHelper.isSpeedster(EntityPlayer))
                return;
            if (Data.PHASE.get(EntityPlayer)) {
                EntityPlayer.motionY = 0;
            }
        }
    }*/
}
