package awex.heroes.common.hero.justiceleague;

import awex.heroes.common.ability.AbilityManager;
import awex.heroes.common.items.ItemJusticeArmor;
import awex.heroes.common.weakness.WeaknessManager;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.*;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import fiskfille.heroes.common.keybinds.SHKeyBinds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class HeroSuperman extends Hero implements IHeatVision, ISlowMotion, IAbility {
    public HeroSuperman() {
    }

    public void init() {
        this.chestplate = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.TORSO);
        this.leggings = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.LEGS);
        this.boots = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.BOOTS);
    }

    public int getTier() {
        return 5;
    }

    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.NONE;
    }

    public float getDefaultScale(EntityPlayer player) {
        return 1.05F;
    }

    public SHKeyBinding getHeatVisionKey() {
        return SHKeyBinds.ABILITY_1;
    }
    public SHKeyBinding getSlowMotionKey() {
        return SHKeyBinds.ABILITY_2;
    }

    public int getHeatVisionColor(EntityLivingBase entity) {
        return 16711680;
    }

    public boolean hasProperty(EntityLivingBase entity, Property property) {
        switch(property) {
            case MASK_TOGGLE:
                return false;
            case BREATHE_UNDERWATER:
                return true;
            case BREATHE_SPACE:
                return true;
            default:
                return super.hasProperty(entity, property);
        }
    }
    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, AbilityManager.SUPERMAN_FLIGHT);
        abilities.add(this, Ability.HEAT_VISION);
        abilities.add(this, Ability.ACCELERATED_PERCEPTION);
        abilities.add(this, Ability.ENHANCED_REFLEXES);
        abilities.add(this, AbilityManager.BUFF);
        abilities.add(this, Ability.FIRE_IMMUNITY);
        abilities.add(this, Ability.COLD_RESISTANCE);
        abilities.add(this, WeaknessManager.KRYPTONITE);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 22.50D, 0);
        attributes.add(SHAttributes.SWORD_DAMAGE, -2.0D, 0);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 2.0D, 1);
    }
}
