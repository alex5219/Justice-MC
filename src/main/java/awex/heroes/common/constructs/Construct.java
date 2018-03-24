package awex.heroes.common.constructs;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.ByteBufUtils;
import fiskfille.core.helper.FiskPredicates;
import fiskfille.core.helper.FiskServerUtils;
import fiskfille.core.helper.NBTHelper;
import fiskfille.core.registry.FiskRegistryEntry;
import fiskfille.core.registry.FiskRegistryNamespaced;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import fiskfille.heroes.common.item.Tiers;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.common.weakness.Weakness;
import fiskfille.heroes.helper.SHHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.StatCollector;

import java.util.Iterator;
import java.util.List;

public abstract class Construct extends FiskRegistryEntry<Construct> implements Comparable<Construct>, NBTHelper.INBTSavedObject<Construct> {
    public static final FiskRegistryNamespaced<Construct> REGISTRY = new FiskRegistryNamespaced("justice", "hal_jordan");

    protected Item weapon;

    public static void register(String key, Hero value) {
        REGISTRY.putObject(key, value);
    }
    public static Construct getConstructFromName(String key) {
        return (Construct)REGISTRY.getObject(key);
    }

    public static String getNameForConstruct(Construct value) {
        return REGISTRY.getNameForObject(value);
    }

    public static Iterable<Construct> getAll(Class<?> type) {
        return Iterables.filter(REGISTRY, FiskPredicates.ofType(type));
    }

    public abstract void init();
    public abstract int getDamage();

    public final Item getWeapon() {
        return this.weapon;
    }


    public final Item[] getWeapons() {
        return new Item[]{this.weapon};
    }


    public String getUnlocalizedName() {
        return "hero." + this.delegate.name().replace(':', '.');
    }

    public String getLocalizedName() {
        return StatCollector.translateToLocal(this.getUnlocalizedName() + ".name").trim().replace("\\u00f1", "ñ");
    }

    public void onUpdate(EntityPlayer player, TickEvent.Phase phase) {
    }

    public List getEquipment() {
        return Lists.newArrayList();
    }

    public final ImmutableList<ItemStack> getEquipmentStacks() {
        ImmutableList.Builder<ItemStack> builder = ImmutableList.builder();
        Iterator var2 = this.getEquipment().iterator();

        while(var2.hasNext()) {
            Object obj = var2.next();
            ItemStack itemstack = FiskServerUtils.getStackFrom(obj);
            if (itemstack != null) {
                builder.add(itemstack);
            }
        }

        return builder.build();
    }


    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        attributes.add(SHAttributes.DAMAGE_REDUCTION, Tiers.getProtection(this.getDamage()), 1);
    }

    public boolean hasProperty(EntityLivingBase entity, Hero.Property property) {
        return false;
    }

    public boolean hasPermission(EntityLivingBase entity, Hero.Permission permission) {
        return false;
    }

    public void onToggleMask(EntityLivingBase entity, boolean state) {
    }

    public float getDefaultScale(EntityPlayer player) {
        return 1.0F;
    }

    public boolean isHidden() {
        return false;
    }

    public int overrideMaterialCost() {
        return -1;
    }

    public int getDurability(int armorPiece) {
        return 1024 + (this.getDamage() - 1) * 256;
    }

    public final String[] getHeaderText() {
        String s = this.getLocalizedName();
        String[] astring = new String[2];
        if (s != null && s.contains("/")) {
            astring[0] = s.substring(0, s.indexOf("/"));
            astring[1] = s.substring(s.indexOf("/") + 1);
        } else {
            astring[0] = s;
        }

        return astring;
    }

    public NBTBase writeToNBT() {
        return new NBTTagString(this.delegate.name());
    }

    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, this.delegate.name());
    }

    static {
        NBTHelper.registerAdapter(Hero.class, new NBTHelper.INBTSaveAdapter<Hero>() {
            public Hero readFromNBT(NBTBase tag) {
                return tag instanceof NBTTagString ? Hero.getHeroFromName(((NBTTagString)tag).func_150285_a_()) : null;
            }

            public Hero fromBytes(ByteBuf buf) {
                return Hero.getHeroFromName(ByteBufUtils.readUTF8String(buf));
            }
        });
    }

}

