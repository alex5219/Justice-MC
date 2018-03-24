package awex.heroes.common.items;

import awex.heroes.helper.ModHelper;
import cpw.mods.fml.common.Optional;
import fiskfille.core.book.widget.IItemListEntry;
import fiskfille.core.helper.FiskServerUtils;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.ItemUntextured;
import fiskfille.heroes.helper.SHFormatHelper;
import fiskfille.heroes.helper.SHHelper;
import mods.battlegear2.api.IAllowItem;
import mods.battlegear2.api.IOffhandWield;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

@Optional.InterfaceList({@Optional.Interface(
        modid = "battlegear2",
        iface = "mods.battlegear2.api.IOffhandWield"
), @Optional.Interface(
        modid = "battlegear2",
        iface = "mods.battlegear2.api.IAllowItem"
)})
public class ItemWillRing extends ItemUntextured implements IItemListEntry, IOffhandWield, IAllowItem {
    public ItemWillRing() {
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setCreativeTab(ModItems.tabJusticeMC);
    }

    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean flag) {
        Hero hero = getContainedHero(itemstack);
        if (hero != null) {
            list.add(SHFormatHelper.formatHero(hero));
        }

    }

    public boolean isOffhandWieldable(ItemStack itemstack, EntityPlayer player) {
        return false;
    }

    public boolean allowOffhand(ItemStack main, ItemStack off) {
        return false;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
        if (itemstack.hasTagCompound()) {
            if (itemstack.getTagCompound().hasKey("Suit", 8)) {
                Hero hero = Hero.getHeroFromName(itemstack.getTagCompound().getString("Suit"));
                if (hero != null) {
                    setContainedArmor(itemstack, hero.getArmorStacks());
                }

                itemstack.getTagCompound().removeTag("Suit");
            }

            if (itemstack.getTagCompound().getBoolean("Dispensed")) {
                itemstack.getTagCompound().removeTag("Items");
            }

            if (itemstack.getTagCompound().hasKey("Dispensed")) {
                itemstack.getTagCompound().removeTag("Dispensed");
            }
        }

        if (itemstack.hasTagCompound() && itemstack.getTagCompound().hasKey("Items", 9)) {
            ItemStack[] armorFromNBT = getArmorFromNBT(itemstack);
            if (armorFromNBT != null) {
                for(int i = 0; i < 4; ++i) {
                    this.swapArmor(player, armorFromNBT[i], 3 - i);
                }
            }

            itemstack.getTagCompound().removeTag("Items");
        } else if (ModHelper.isWill(player)) {
            setContainedArmor(itemstack, SHHelper.getEquipment(player));

            for(int i = 1; i <= 4; ++i) {
                player.setCurrentItemOrArmor(i, (ItemStack)null);
            }
        }

        if (itemstack.hasTagCompound() && itemstack.getTagCompound().hasNoTags()) {
            itemstack.setTagCompound((NBTTagCompound)null);
        }

        return itemstack;
    }

    public void swapArmor(EntityPlayer player, ItemStack itemstack, int armorPiece) {
        if (itemstack != null) {
            if (!player.worldObj.isRemote && player.getCurrentArmor(armorPiece) != null && !player.inventory.addItemStackToInventory(player.getCurrentArmor(armorPiece))) {
                player.entityDropItem(player.getCurrentArmor(armorPiece), 0.0F);
            }

            player.setCurrentItemOrArmor(armorPiece + 1, itemstack);
        }

    }

    public void getSubItems(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item));
        Iterator var4 = ItemLanternArmor.getWill().iterator();

        while(var4.hasNext()) {
            Hero hero = (Hero)var4.next();
            list.add(create(item, hero));
            this.setCreativeTab(ModItems.tabJusticeMC);
        }

    }

    public void getListItems(Item item, CreativeTabs tab, List list) {
        if (item == ModItems.willRing) {
            super.getSubItems(item, tab, list);
            this.setCreativeTab(ModItems.tabJusticeMC);
        } else {
            this.getSubItems(item, tab, list);
            this.setCreativeTab(ModItems.tabJusticeMC);
        }

    }

    public String getPageLink(ItemStack itemstack) {
        return itemstack.getUnlocalizedName();
    }

    public static void setContainedArmor(ItemStack itemstack, ItemStack... armor) {
        NBTTagList itemsList = new NBTTagList();

        for(int i = 0; i < armor.length; ++i) {
            if (armor[i] != null) {
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setByte("Slot", (byte)i);
                itemsList.appendTag(armor[i].writeToNBT(itemTag));
            }
        }

        if (!itemstack.hasTagCompound()) {
            itemstack.setTagCompound(new NBTTagCompound());
        }

        itemstack.getTagCompound().setTag("Items", itemsList);
    }

    public static ItemStack[] getArmorFromNBT(ItemStack itemstack) {
        if (itemstack.hasTagCompound() && itemstack.getTagCompound().hasKey("Items")) {
            NBTTagList nbtItems = itemstack.getTagCompound().getTagList("Items", 10);
            ItemStack[] items = new ItemStack[4];

            for(int i = 0; i < nbtItems.tagCount(); ++i) {
                NBTTagCompound item = nbtItems.getCompoundTagAt(i);
                byte slot = item.getByte("Slot");
                if (slot >= 0 && slot < items.length) {
                    items[slot] = ItemStack.loadItemStackFromNBT(item);
                }
            }

            return items;
        } else {
            return null;
        }
    }

    public static Hero getContainedHero(ItemStack itemstack) {
        if (itemstack.hasTagCompound()) {
            if (itemstack.getTagCompound().hasKey("Items", 9) && !itemstack.getTagCompound().getBoolean("Dispensed")) {
                return SHHelper.getHeroFromArmor((ItemStack) FiskServerUtils.nonNull(getArmorFromNBT(itemstack)));
            }

            if (itemstack.getTagCompound().hasKey("Suit", 8)) {
                return Hero.getHeroFromName(itemstack.getTagCompound().getString("Suit"));
            }
        }

        return null;
    }

    public static ItemStack create(Item item, Hero hero) {
        ItemStack itemstack = new ItemStack(item);
        itemstack.setTagCompound(new NBTTagCompound());
        itemstack.getTagCompound().setString("Suit", hero.delegate.name());
        return itemstack;
    }

    public static ItemStack create(Hero hero) {
        return create(ModItems.willRing, hero);
    }
}
