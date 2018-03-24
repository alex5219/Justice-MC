package awex.heroes.common.hero.justiceleague;

import awex.heroes.common.items.ItemJusticeArmor;
import com.google.common.collect.ImmutableList;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.ICanaryCry;
import fiskfille.heroes.common.item.ModItems;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import fiskfille.heroes.common.keybinds.SHKeyBinds;
import net.minecraft.item.ItemStack;

import java.util.List;

public class HeroBlackCanaryComics extends Hero implements ICanaryCry {
    public HeroBlackCanaryComics() {
    }

    public void init() {
        this.helmet = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.MASK);
        this.chestplate = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.CHESTPIECE);
        this.leggings = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.PANTS);
        this.boots = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.BOOTS);
    }

    public int getTier() {
        return 3;
    }

    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.COMICS;
    }

    public SHKeyBinding getCanaryCryKey() {
        return SHKeyBinds.ABILITY_1;
    }

    public List getEquipment() {
        return ImmutableList.of(ModItems.blackCanarysTonfas);
    }

    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, Ability.CANARY_CRY);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 5.5D, 0);
        attributes.add(SHAttributes.SWORD_DAMAGE, 0.55D, 1);
        attributes.add(SHAttributes.SPRINT_SPEED, 0.25D, 1);
        attributes.add(SHAttributes.FALL_RESISTANCE, 8.0D, 0);
        attributes.add(SHAttributes.JUMP_HEIGHT, 1.0D, 0);
    }
}
