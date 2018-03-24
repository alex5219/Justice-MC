package awex.heroes.common.items;

import awex.heroes.common.hero.HeroRegistry;
import com.google.common.collect.Multimap;
import fiskfille.heroes.common.item.IBattlegearSheathed;
import fiskfille.heroes.common.item.IEquipmentItem;
import fiskfille.heroes.common.tileentity.TileEntityDisplayStand;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemDeathstrokesSword extends ItemSword implements IBattlegearSheathed, IEquipmentItem {
    public ItemDeathstrokesSword() {
        super(ToolMaterial.IRON);
        this.setMaxDamage(900);
    }

    public boolean renderSheathed(boolean back) {
        return false;
    }

    public boolean canEquip(ItemStack itemstack, TileEntityDisplayStand tile) {
        return SHHelper.getHeroFromArmor(tile.fakePlayer, 2) == HeroRegistry.DEATHSTROKE;
    }

    public Multimap getAttributeModifiers(ItemStack itemstack) {
        Multimap multimap = super.getAttributeModifiers(itemstack);
        multimap.removeAll(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName());
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", 8.5D, 0));
        return multimap;
    }

    public void registerIcons(IIconRegister iconRegister) {
    }
}
