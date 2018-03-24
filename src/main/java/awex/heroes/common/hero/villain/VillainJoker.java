package awex.heroes.common.hero.villain;

import awex.heroes.common.ability.AbilityManager;
import awex.heroes.common.items.ItemJusticeArmor;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAiming;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import fiskfille.heroes.common.keybinds.SHKeyBinds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class VillainJoker extends Hero implements IAiming {
    public VillainJoker() {
    }

    public void init() {
        this.helmet = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.HEAD);
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

    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, AbilityManager.FEARTOXIN);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 6.5D, 0);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 0.55D, 1);
        attributes.add(SHAttributes.FALL_RESISTANCE, 5.0D, 0);
        attributes.add(SHAttributes.JUMP_HEIGHT, 1.5D, 0);
        attributes.add(SHAttributes.SPRINT_SPEED, 0.3D, 1);
    }

    public SHKeyBinding getAimKey() {
        return SHKeyBinds.ABILITY_1;
    }

    public boolean canAim(EntityPlayer player, ItemStack heldItem) {
        return heldItem == null;
    }
}

