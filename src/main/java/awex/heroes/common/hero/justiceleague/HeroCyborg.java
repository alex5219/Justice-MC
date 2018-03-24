package awex.heroes.common.hero.justiceleague;

import awex.heroes.common.ability.AbilityManager;
import awex.heroes.common.items.ItemJusticeArmor;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IHovering;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import fiskfille.heroes.common.keybinds.SHKeyBinds;
import fiskfille.heroes.common.weakness.Weakness;
import net.minecraft.item.ItemStack;

public class HeroCyborg extends Hero implements IHovering {
    public HeroCyborg() {
    }

    public void init() {
        this.helmet = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.HELMET);
        this.chestplate = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.CHESTPLATE);
        this.leggings = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.LEGGINGS);
        this.boots = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.BOOTS);
    }

    public int getTier() {
        return 4;
    }

    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.NONE;
    }

    public SHKeyBinding getHoverKey() {
        return SHKeyBinds.ABILITY_1;
    }

    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, Ability.FIRE_IMMUNITY);
        abilities.add(this, Ability.SUPERHUMAN_DURABILITY);
        abilities.add(this, AbilityManager.ENHANCED_AGILITY);
        abilities.add(this, AbilityManager.BUFF);
        abilities.add(this, Ability.PROPELLED_FLIGHT);
        abilities.add(this, Ability.HOVER);
        abilities.add(this, Weakness.METAL_SKIN);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 0.7D, 1);
        attributes.add(SHAttributes.SWORD_DAMAGE, 2.0D, 0);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 6.0D, 0);
    }
}
