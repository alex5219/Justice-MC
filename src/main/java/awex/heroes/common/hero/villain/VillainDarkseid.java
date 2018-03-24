package awex.heroes.common.hero.villain;

import awex.heroes.common.ability.AbilityManager;
import awex.heroes.common.items.ItemJusticeArmor;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAiming;
import fiskfille.heroes.common.hero.IHeatVision;
import fiskfille.heroes.common.hero.ISizeManipulation;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import fiskfille.heroes.common.keybinds.SHKeyBinds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class VillainDarkseid extends Hero implements IHeatVision{
    public VillainDarkseid() {
    }

    public void init() {
        this.helmet = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.HELMET);
        this.chestplate = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.CHESTPLATE);
        this.leggings = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.LEGGINGS);
        this.boots = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.BOOTS);
    }

    public int getTier() {
        return 5;
    }

    public float getDefaultScale(EntityPlayer player) {
        return 2.1F;
    }

    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.NONE;
    }

    public int overrideMaterialCost() {
        return 8214;
    }

    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, Ability.FIRE_IMMUNITY);
        abilities.add(this, Ability.COLD_RESISTANCE);
        abilities.add(this, Ability.LEAPING);
        abilities.add(this, AbilityManager.ENHANCED_AGILITY);
        abilities.add(this, Ability.HEAT_VISION);
        abilities.add(this, AbilityManager.SUPER_STRENGTH);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 0.7D, 1);
        attributes.add(SHAttributes.SWORD_DAMAGE, 2.0D, 0);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 4.0D, 0);
    }

    public SHKeyBinding getHeatVisionKey() {
        return SHKeyBinds.ABILITY_1;
    }


    public int getHeatVisionColor(EntityLivingBase entity) {
        return 16711680;
    }
}