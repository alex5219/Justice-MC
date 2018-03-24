package awex.heroes.common.event;

import awex.heroes.client.gui.GuiInventory;
import awex.heroes.common.hero.justiceleague.HeroWonderWoman;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class ClientEventHandler {
    public ClientEventHandler() {
    }

    @SubscribeEvent
    public void onClick(EntityInteractEvent e){
        EntityPlayer player = e.entityPlayer;
        if(e.entityPlayer != null) {
            Hero hero = SHHelper.getHero(player);
            if (hero instanceof HeroWonderWoman) {
                if(e.entityPlayer.worldObj.isRemote)
                    if (e.target instanceof EntityPlayer) {
                        EntityPlayer target = (EntityPlayer) e.target;
                        player.addChatMessage(new ChatComponentText("Opening inventory of " + target.getDisplayName()));
                        Minecraft.getMinecraft().displayGuiScreen(new GuiInventory(target));
                    }
            }
        }
    }
}