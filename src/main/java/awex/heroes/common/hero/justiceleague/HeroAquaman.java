package awex.heroes.common.hero.justiceleague;

import awex.heroes.common.ability.AbilityManager;
import awex.heroes.common.items.ItemJusticeArmor;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class HeroAquaman extends Hero{
    public void init() {
        this.chestplate = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.TORSO);
        this.leggings = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.PANTS);
        this.boots = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.BOOTS);
    }

    public int getTier() {
        return 4;
    }

    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.NONE;
    }

    public boolean hasProperty(EntityLivingBase entity, Hero.Property property) {
        switch(property) {
            case BREATHE_UNDERWATER:
                return true;
            default:
                return super.hasProperty(entity, property);
        }
    }
    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, Ability.SUPERHUMAN_DURABILITY);
        abilities.add(this, AbilityManager.SUPER_STRENGTH);
        abilities.add(this, AbilityManager.AQUAENHANCE);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 6.50D, 0);
        attributes.add(SHAttributes.SWORD_DAMAGE, 2.0D, 0);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 4.0D, 1);
    }
}
