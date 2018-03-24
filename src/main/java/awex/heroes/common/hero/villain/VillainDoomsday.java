package awex.heroes.common.hero.villain;

import awex.heroes.common.ability.AbilityManager;
import awex.heroes.common.items.ItemJusticeArmor;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class VillainDoomsday extends Hero {
    public VillainDoomsday() {
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

    public float getDefaultScale(EntityPlayer player) {
        return 1.7F;
    }

    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, Ability.SUPERHUMAN_DURABILITY);
        abilities.add(this, Ability.FIRE_IMMUNITY);
        abilities.add(this, AbilityManager.TENACITY);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 19.50D, 0);
        attributes.add(SHAttributes.SWORD_DAMAGE, -2.0D, 0);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 1.8D, 1);
    }
}
