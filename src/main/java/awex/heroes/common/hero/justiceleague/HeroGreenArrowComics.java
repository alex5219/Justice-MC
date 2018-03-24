package awex.heroes.common.hero.justiceleague;

import awex.heroes.common.items.ItemJusticeArmor;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.IArchery;
import fiskfille.heroes.common.item.armor.ItemGreenArrowArmor;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import net.minecraft.item.ItemStack;

public class HeroGreenArrowComics extends IArchery.Impl {
    public HeroGreenArrowComics() {
    }

    public void init() {
        this.helmet = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.MASK);
        this.chestplate = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.CHESTPIECE);
        this.leggings = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.PANTS);
        this.boots = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.BOOTS);
    }

    public boolean isHidden() {
        return false;
    }
    public int getTier() {
        return 4;
    }

    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.COMICS;
    }

    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, Ability.ENHANCED_REFLEXES);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 5.5D, 0);
        attributes.add(SHAttributes.SWORD_DAMAGE, 4.5D, 0);
        attributes.add(SHAttributes.BOW_DRAWBACK, 0.65D, 1);
        attributes.add(SHAttributes.ARROW_DAMAGE, 0.25D, 1);
        attributes.add(SHAttributes.FALL_RESISTANCE, 7.5D, 0);
        attributes.add(SHAttributes.SPRINT_SPEED, 0.15D, 1);
        attributes.add(SHAttributes.JUMP_HEIGHT, 1.25D, 0);
    }
}

