package awex.heroes.common.items.constructs;

import awex.heroes.common.hero.IConstruct;
import awex.heroes.common.items.ModItems;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

import static fiskfille.heroes.common.item.armor.ItemHeroArmor.hideStats;

public class ItemConstructTrident extends ItemConstruct implements IConstruct{

    public ItemConstructTrident() {
        super(ModItems.MEDIUM, "WillpowerTrident", 8);
    }
    public void registerIcons(IIconRegister iconRegister) {
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
        return new ItemStack(ModItems.willTrident);
    }

    public float getCost(){
        return 0.5f;
    }

    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean b) {
        if (!hideStats) {
            list.add(EnumChatFormatting.GRAY + "Cost: " + EnumChatFormatting.GREEN + this.getCost());
        } else {
            list.add(EnumChatFormatting.DARK_GRAY + StatCollector.translateToLocal("tooltip.moreInfo"));
        }
    }
}
