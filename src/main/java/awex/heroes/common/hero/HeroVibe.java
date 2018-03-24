package awex.heroes.common.hero;

import awex.heroes.common.ability.AbilityManager;
import awex.heroes.common.items.ItemJusticeArmor;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import fiskfille.heroes.common.keybinds.SHKeyBinds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class HeroVibe extends Hero implements IWarpWave, IWarp {
    public HeroVibe() {
    }

    public void init() {
        this.helmet = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.GOGGLES);
        this.chestplate = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.CHESTPIECE);
        this.leggings = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.LEGS);
        this.boots = new ItemJusticeArmor(this, ItemHeroArmor.ArmorType.BOOTS);
    }

    public int getTier() {
        return 3;
    }

    public boolean isHidden() {
        return false;
    }
    public SHKeyBinding getWarpWaveKey() {
        return SHKeyBinds.ABILITY_1;
    }
    public SHKeyBinding getWarpKey() {
        return SHKeyBinds.ABILITY_2;
    }

    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.DCTV;
    }

    public float getDefaultScale(EntityPlayer player) {
        return 1.05F;
    }

    public void getAbilities(IAbilityContainer abilities)
    {
        abilities.add(this, AbilityManager.WARP_WAVE);
        abilities.add(this, AbilityManager.ENHANCED_AGILITY);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 6.50D, 0);
        attributes.add(SHAttributes.SWORD_DAMAGE, -2.0D, 0);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 2.0D, 1);
    }
}
