package awex.heroes.common.items.constructs;

import awex.heroes.common.hero.IConstruct;
import net.minecraft.item.ItemSword;

public class ItemConstruct extends ItemSword implements IConstruct{
    public ItemConstruct(ToolMaterial material, String name, int durability) {
        super(material);
        this.setUnlocalizedName(name);
        this.setMaxDamage(durability);
        this.setMaxStackSize(1);
        this.setCreativeTab(null);
    }
}
