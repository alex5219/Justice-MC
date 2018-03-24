package awex.heroes.common.items.constructs;

import awex.heroes.common.items.ModItems;
import com.google.common.collect.Multimap;
import fiskfille.heroes.common.item.IBattlegearSheathed;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemConstructKnife extends ItemSword implements IBattlegearSheathed {
    public ItemConstructKnife() {
        super(ModItems.MEDIUM);
        this.setMaxDamage(8);
        this.setCreativeTab(null);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("WillpowerKnife");
    }

    public boolean renderSheathed(boolean back) {
        return false;
    }

    public Multimap getAttributeModifiers(ItemStack itemstack) {
        Multimap multimap = super.getAttributeModifiers(itemstack);
        multimap.removeAll(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName());
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", 6.25D, 0));
        return multimap;
    }

    public void registerIcons(IIconRegister iconRegister) {
    }
}
