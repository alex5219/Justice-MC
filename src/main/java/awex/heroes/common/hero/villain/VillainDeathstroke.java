package awex.heroes.common.hero.villain;

import awex.heroes.common.ability.AbilityManager;
import awex.heroes.common.items.ItemJusticeArmor;
import com.google.common.collect.ImmutableList;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import net.minecraft.item.ItemStack;

import java.util.List;

public class VillainDeathstroke extends Hero {
    public VillainDeathstroke() {
    }

    public void init() {
        this.helmet = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.MASK);
        this.chestplate = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.CHESTPLATE);
        this.leggings = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.LEGGINGS);
        this.boots = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.BOOTS);
    }

    public int getTier() {
        return 3;
    }

    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.NONE;
    }

    public List getEquipment() {
        return ImmutableList.of(awex.heroes.common.items.ModItems.deathstrokesSword);
    }

    public void getAbilities(IAbilityContainer abilities) {
        super.getAbilities(abilities);
        abilities.add(this, AbilityManager.SUPER_STRENGTH);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 5.5D, 0);
        attributes.add(SHAttributes.SWORD_DAMAGE, 7.0D, 0);
        attributes.add(SHAttributes.FALL_RESISTANCE, 6.0D, 0);
        attributes.add(SHAttributes.SPRINT_SPEED, 0.15D, 1);
        attributes.add(SHAttributes.JUMP_HEIGHT, 1.5D, 0);
    }
}

