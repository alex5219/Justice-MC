package awex.heroes.common.ability;

import awex.heroes.common.hero.justiceleague.HeroSuperman;
import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;

import java.util.Iterator;
import java.util.List;

public class AbilityLexLuthor extends Ability<IAbility> {
    public AbilityLexLuthor(int tier) {
        super(tier);
    }

    public void onUpdate(EntityLivingBase entity, Hero hero, IAbility instance, TickEvent.Phase phase) {
        super.onUpdate(entity, hero, instance, phase);
        if (phase == TickEvent.Phase.END) {
            if(entity instanceof EntityPlayer){
                EntityPlayer player = (EntityPlayer) entity;
                List entities = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(player.posX - 5, player.posY - 5, player.posZ - 5, player.posX + 7, player.posY + 7, player.posZ + 7));
                if (entities != null && !entities.isEmpty()) {
                    Iterator iterator = entities.iterator();
                    EntityLivingBase ent;
                    while (iterator.hasNext()) {
                        ent = (EntityLivingBase) iterator.next();
                        if(ent instanceof EntityPlayer){
                            EntityPlayer enti = (EntityPlayer) ent;
                            if (SHHelper.isHero(enti)){
                                Hero ehero = SHHelper.getHero(enti);
                                if(ehero instanceof HeroSuperman){
                                    enti.addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 0));
                                    enti.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0));
                                    enti.addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0));
                                    enti.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 100, 0));
                                    enti.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 0));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}