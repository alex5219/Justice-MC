package awex.heroes.common.items;

import com.google.common.collect.Lists;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import java.util.List;
import java.util.Locale;

public class ItemJusticeArmor extends ItemHeroArmor {
    public ItemJusticeArmor(Hero hero, ItemHeroArmor.ArmorType type) {
        super(hero, type);
        this.setCreativeTab(ModItems.tabJusticeMC);
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