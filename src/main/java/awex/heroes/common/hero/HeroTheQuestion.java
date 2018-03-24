package awex.heroes.common.hero;

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

public class HeroTheQuestion extends Hero{
    public HeroTheQuestion() {
    }

    public void init() {
        this.helmet = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.HEAD);
        this.chestplate = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.CHESTPIECE);
        this.leggings = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.LEGS);
        this.boots = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.BOOTS);
    }

    public int getTier() {
        return 2;
    }

    public boolean isHidden() {
        return false;
    }
    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.NONE;
    }

    public float getDefaultScale(EntityPlayer player) {
        return 1.00F;
    }

    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, AbilityManager.ENHANCED_AGILITY);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 8.50D, 0);
        attributes.add(SHAttributes.SWORD_DAMAGE, -2.0D, 0);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 2.0D, 1);
        attributes.add(SHAttributes.JUMP_HEIGHT, 2.0D, 0);
    }
}