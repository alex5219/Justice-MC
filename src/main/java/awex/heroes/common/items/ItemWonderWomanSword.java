package awex.heroes.common.items;

import awex.heroes.common.hero.justiceleague.HeroWonderWoman;
import cpw.mods.fml.common.Optional;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.helper.SHHelper;
import mods.battlegear2.api.IAllowItem;
import mods.battlegear2.api.IOffhandWield;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

@Optional.InterfaceList({@Optional.Interface(
        modid = "battlegear2",
        iface = "mods.battlegear2.api.IOffhandWield"
), @Optional.Interface(
        modid = "battlegear2",
        iface = "mods.battlegear2.api.IAllowItem"
)})
public class ItemWonderWomanSword extends ItemSword implements IOffhandWield, IAllowItem {
    public ItemWonderWomanSword(ToolMaterial material, String name, int durability) {
        super(material);
        this.setUnlocalizedName(name);
        this.setMaxDamage(durability);
        this.setMaxStackSize(1);
        this.setCreativeTab(null);
    }
    public void registerIcons(IIconRegister iconRegister) {
    }
    public boolean isOffhandWieldable(ItemStack itemstack, EntityPlayer player) {
        return false;
    }

    public boolean allowOffhand(ItemStack main, ItemStack off) {
        return false;
    }

    public void onUpdate(ItemStack ItemStack, World World, Entity Entity, int par4, boolean par5){
        if(Entity instanceof EntityLivingBase){
            if(Entity instanceof EntityPlayer){

                Hero hero = SHHelper.getHero((EntityLivingBase) Entity);
                if(hero instanceof HeroWonderWoman){
                    //
                }else{
                    //ItemStack.getItem().setMaxStackSize(-1);
                }
            }
        }
    }
}
