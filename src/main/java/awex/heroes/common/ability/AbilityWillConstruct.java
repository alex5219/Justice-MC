package awex.heroes.common.ability;

import awex.heroes.client.gui.GuiConstruct;
import awex.heroes.common.hero.*;
import awex.heroes.common.hero.willcorp.*;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.hero.Hero;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;

public class AbilityWillConstruct extends Ability<IWill> {
    public AbilityWillConstruct(int tier) {
        super(tier);
    }
    @SideOnly(Side.CLIENT)
    public void onUpdate(EntityLivingBase entity, Hero hero, IWill instance, TickEvent.Phase phase) {
        if(instance.getConstructKey().isPressed()){
            if (entity.worldObj.isRemote) {
                if(hero instanceof HeroHalJordan || hero instanceof HeroKilowog || hero instanceof HeroJohnStewart || hero instanceof HeroGreenLantern || hero instanceof HeroJessicaCruz){
                    Minecraft.getMinecraft().displayGuiScreen(new GuiConstruct());
                }
            }
        }
    }
}