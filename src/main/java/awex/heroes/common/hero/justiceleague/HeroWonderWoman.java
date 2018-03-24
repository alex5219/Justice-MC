package awex.heroes.common.hero.justiceleague;

import awex.heroes.common.ability.AbilityManager;
import awex.heroes.common.items.ItemLanternArmor;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class HeroWonderWoman extends Hero {
    public HeroWonderWoman() {
    }

    public void init() {
        this.helmet = new ItemLanternArmor(this, ItemHeroArmor.ArmorType.HEAD);
        this.chestplate = new ItemLanternArmor(this, ItemHeroArmor.ArmorType.TORSO);
        this.leggings = new ItemLanternArmor(this, ItemHeroArmor.ArmorType.LEGS);
        this.boots = new ItemLanternArmor(this, ItemHeroArmor.ArmorType.BOOTS);
    }

    public int getTier() {
        return 5;
    }

    public boolean isHidden() {
        return true;
    }
    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.NONE;
    }

    public float getDefaultScale(EntityPlayer player) {
        return 1.0F;
    }

    public boolean hasProperty(EntityLivingBase entity, Property property) {
        switch(property) {
            case MASK_TOGGLE:
                return false;
            case BREATHE_UNDERWATER:
                return true;
            case BREATHE_SPACE:
                return false;
            default:
                return super.hasProperty(entity, property);
        }
    }
    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, Ability.SUPERHUMAN_DURABILITY);
        abilities.add(this, AbilityManager.ENHANCED_AGILITY);
        abilities.add(this, Ability.HEALING_FACTOR);
        abilities.add(this, Ability.FLIGHT);
        abilities.add(this, AbilityManager.MAGICIMMUNITY);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 7.0D, 0);
        attributes.add(SHAttributes.SWORD_DAMAGE, 12.5D, 0);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 14.5D, 1);
    }

}

