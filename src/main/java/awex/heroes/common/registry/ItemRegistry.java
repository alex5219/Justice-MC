package awex.heroes.common.registry;

import awex.heroes.common.items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Locale;

public class ItemRegistry {
    public ItemRegistry() {
    }

    public static void registerItem(Item item, String unlocalizedName) {
        item.setCreativeTab(ModItems.tabJusticeMC);
        registerItemNoTab(item, unlocalizedName);
    }

    public static void registerArmor(ItemHeroArmor item, Hero hero) {
        if (Hero.REGISTRY.containsValue(hero) && Hero.REGISTRY.containsKey(Hero.getNameForHero(hero))) {
            String unlocalizedName = hero.getRegistryName().getResourcePath();
            if (!unlocalizedName.endsWith("s")) {
                unlocalizedName = unlocalizedName + "s";
            }

            unlocalizedName = unlocalizedName + "_" + item.armorType.name().toLowerCase(Locale.ROOT);
            item.setUnlocalizedName(unlocalizedName);
            item.setTextureName("justice:" + unlocalizedName);
            item.setCreativeTab(ModItems.tabJusticeMC);
            GameRegistry.registerItem(item, unlocalizedName);
        } else {
            throw new RuntimeException(String.format("Hero %s is not registered!", hero));
        }
    }

    public static void registerIngot(Item item, String unlocalizedName, String oreDictName) {
        registerItem(item, unlocalizedName);
        OreDictionary.registerOre(oreDictName, item);
    }

    public static void registerItemNoTab(Item item, String unlocalizedName) {
        item.setUnlocalizedName(unlocalizedName);
        item.setTextureName("justice:" + unlocalizedName);
        GameRegistry.registerItem(item, unlocalizedName);
    }
}

