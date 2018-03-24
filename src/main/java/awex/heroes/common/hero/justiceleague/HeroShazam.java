package awex.heroes.common.hero.justiceleague;

import awex.heroes.common.ability.AbilityManager;
import awex.heroes.common.items.ItemJusticeArmor;
import awex.heroes.common.items.ModItems;
import awex.heroes.common.weakness.WeaknessManager;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import fiskfille.heroes.common.hero.IAiming;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import fiskfille.heroes.common.keybinds.SHKeyBinds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class HeroShazam extends Hero implements IAbility, IAiming {
    public HeroShazam() {
    }

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

    public float getDefaultScale(EntityPlayer player) {
        return 1.045F;
    }


    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, Ability.FLIGHT);
        abilities.add(this, AbilityManager.BUFF);
        abilities.add(this, AbilityManager.SHAZAM);
        abilities.add(this, Ability.FIRE_IMMUNITY);
        abilities.add(this, Ability.COLD_RESISTANCE);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 16.50D, 0);
        attributes.add(SHAttributes.SWORD_DAMAGE, -2.0D, 0);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 4.0D, 1);
    }
    public boolean canAim(EntityPlayer player, ItemStack heldItem) {
        return heldItem == null;
    }

    public SHKeyBinding getAimKey() { return SHKeyBinds.ABILITY_1; }
}
