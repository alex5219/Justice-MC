package awex.heroes.common.hero.justiceleague;

import awex.heroes.common.items.ItemJusticeArmor;
import com.google.common.collect.ImmutableList;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IEquipment;
import fiskfille.heroes.common.item.ModItems;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import fiskfille.heroes.common.keybinds.SHKeyBinds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

import java.util.List;

public class HeroRobin extends Hero implements IEquipment {
    public HeroRobin() {
    }

    public void init() {
        this.helmet = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.MASK);
        this.chestplate = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.TORSO);
        this.leggings = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.PANTS);
        this.boots = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.BOOTS);
    }

    public int getTier() {
        return 3;
    }

    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.NONE;
    }

    public SHKeyBinding getEquipmentSwitchKey() {
        return SHKeyBinds.ABILITY_1;
    }

    public SHKeyBinding getEquipmentResetKey() {
        return SHKeyBinds.ABILITY_2;
    }

    public boolean hasPermission(EntityLivingBase entity, Permission permission) {
        return permission == Permission.USE_GRAPPLING_GUN || super.hasPermission(entity, permission);
    }

    public List getEquipment() {
        return ImmutableList.of(ModItems.grapplingGun);
    }

    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, Ability.UTILITY_BELT);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 7.0D, 0);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 0.55D, 1);
        attributes.add(SHAttributes.FALL_RESISTANCE, 4.0D, 0);
        attributes.add(SHAttributes.JUMP_HEIGHT, 1.5D, 0);
        attributes.add(SHAttributes.SPRINT_SPEED, 0.3D, 1);
    }
}

