package awex.heroes.common.items;

import awex.heroes.common.hero.IWill;
import com.google.common.collect.Lists;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;
import java.util.Locale;

import static fiskfille.heroes.common.hero.Hero.getAll;

public class ItemSpecialLantern extends ItemHeroArmor {
    public ItemSpecialLantern(Hero hero, ItemHeroArmor.ArmorType type) {
        super(hero, type);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    public static Iterable<Hero> getWill() {
        return getAll(IWill.class);
    }

    public String getItemStackDisplayName(ItemStack itemstack) {
        Hero hero = this.getHero(itemstack);
        ItemHeroArmor.ArmorVersion version = hero.getVersion();
        String name = hero.getLocalizedName();
        String key = "item.superhero_armor.name";
        if (name.contains("/") && itemstack != null) {
            name = name.substring(0, name.indexOf("/"));
        }

        List<String> args = Lists.newArrayList(new String[]{name, StatCollector.translateToLocal(String.format("item.superhero_armor.piece.%s", this.armorType.name().toLowerCase(Locale.ROOT)))});
        if (!version.isDefault()) {
            key = key + ".version";
            args.add(StatCollector.translateToLocal(String.format("item.superhero_armor.version.%s", version.name().toLowerCase(Locale.ROOT))));
        }

        if (name.endsWith("s")) {
            key = key + ".alt";
        }

        return StatCollector.translateToLocalFormatted(key, args.toArray()).trim();
    }

}