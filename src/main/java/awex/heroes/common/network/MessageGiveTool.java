package awex.heroes.common.network;

import awex.heroes.common.ability.AbilityManager;
import awex.heroes.common.hero.willcorp.*;
import awex.heroes.common.items.ModItems;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.helper.SHHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

public class MessageGiveTool implements IMessageHandler<MessageGiveTool, IMessage>, IMessage {
    private String construct;
    private Object WILL;
    public MessageGiveTool(String constructid) {
        this.construct = constructid;
    }

    public IMessage onMessage(MessageGiveTool message, MessageContext ctx)
    {
        EntityPlayer player = ctx.getServerHandler().playerEntity;
        if(AbilityManager.CONSTRUCT.isActive(player)) {
            Hero hero = SHHelper.getHero(player);
            if(hero instanceof HeroGreenLantern){
            }
                if (message.construct.isEmpty()) {
                    player.addChatComponentMessage(new ChatComponentText("You need to provide a construct name!"));
                }else if (message.construct.equalsIgnoreCase("axe")){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERAXE, 1));
                }else if (message.construct == 2){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERPICK, 1));
                }else if (message.construct == 3){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERHATCHET, 1));
                }else if (message.construct == 4){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERBROADSWORD, 1));
                }else if (message.construct == 5){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERMACE, 1));
                }else if (message.construct == 6){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.willKatana, 1));
                }else if (message.construct == 7){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERSTEAK, 1));
                }else if (message.construct == 8){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERSHEARS, 1));
                }else if (message.construct == 9){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERLIGHTER, 1));
                }else if (message.construct == 10){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERFLINTANDSTEEL, 1));
                }else if (message.construct == 11){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.willTrident, 1));
                }else if (message.construct == 12){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERWRENCH, 1));
                }else if (message.construct == 13){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERPADDLE, 1));
                }else if (message.construct == 14){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERBASEBALLBAT, 1));
                }else if (message.construct == 15){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERKNIFE, 1));
                }else if (message.construct == 16){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERKUKRI, 1));
                }else if (message.construct == 17){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERSCYTHE, 1));
                }else if (message.construct == 18){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERGOLFCLUB, 1));
                }else if (message.construct == 19){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERCROWBAR, 1));
                }else if (message.construct == 20){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERMACHETE, 1));
                }else if (message.construct == 21){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERLIGHTSABER, 1));
                }else if (message.construct == 22){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERHAMMER, 1));
                }else if (message.construct == 23){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERGUITAR, 1));
                }else if (message.construct == 24){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERSHIELD, 1));
                }else if (message.construct == 25){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERPAN, 1));
                }else if (message.construct == 26){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERBATTLEAXE, 1));
                }else if (message.construct == 27){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERPISTOL, 1));
                }else if (message.construct == 28){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERRIFLE, 1));
                }else if (message.construct == 29){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERTASER, 1));
                }else if (message.construct == 30){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERCHAINSAW, 1));
                }else if (message.construct == 31){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERSHOVEL, 1));
                }else if (message.construct == 32){
                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.WILLPOWERSPEAR, 1));
                }else{
                    player.addChatComponentMessage(new ChatComponentText("You need to provide a construct name!"));
                }
        }
        return null;
    }

    public void fromBytes(ByteBuf buf) {

    }

    public void toBytes(ByteBuf buf) {

    }
}