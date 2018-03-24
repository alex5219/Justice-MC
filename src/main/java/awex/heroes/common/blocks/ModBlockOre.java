package awex.heroes.common.blocks;

import awex.heroes.common.items.ModItems;
import fiskfille.heroes.helper.FabricatorHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class ModBlockOre extends Block implements FabricatorHelper.IMaterialEnergy {
    private Random rand = new Random();
    private Item itemToDrop;
    private boolean canSilkHarvest = true;
    private boolean canFortuneHarvest = true;
    private int xpDropMin;
    private int xpDropMax;
    private final Item itemEquivalent;

    public ModBlockOre(Item item) {
        super(Material.rock);
        this.itemEquivalent = item;
        this.setCreativeTab(ModItems.tabJusticeMC);
    }

    public ModBlockOre setHarvestLvl(String toolClass, int level) {
        this.setHarvestLevel(toolClass, level);
        return this;
    }

    public ModBlockOre setItemDrop(Item item) {
        this.itemToDrop = item;
        return this;
    }

    public ModBlockOre setCanSilkHarvest(boolean flag) {
        this.canSilkHarvest = flag;
        return this;
    }

    public ModBlockOre setCanFortuneHarvest(boolean flag) {
        this.canFortuneHarvest = flag;
        return this;
    }

    public ModBlockOre setXpDrop(int min, int max) {
        this.xpDropMin = min;
        this.xpDropMax = max;
        return this;
    }

    public int getEnergyValue() {
        return FabricatorHelper.getEnergy(this.itemEquivalent) / 2;
    }

    protected boolean canSilkHarvest() {
        return this.canSilkHarvest;
    }

    public Item getItemDropped(int metadata, Random rand, int fortune) {
        return this.itemToDrop != null ? this.itemToDrop : Item.getItemFromBlock(this);
    }

    public int quantityDroppedWithBonus(int fortune, Random rand) {
        if (fortune > 0 && this.canFortuneHarvest && this.getItemDropped(0, rand, fortune) != Item.getItemFromBlock(this)) {
            int i = rand.nextInt(fortune + 2) - 1;
            if (i < 0) {
                i = 0;
            }

            return this.quantityDropped(rand) * (i + 1);
        } else {
            return this.quantityDropped(rand);
        }
    }

    public int getExpDrop(IBlockAccess world, int metadata, int fortune) {
        return this.xpDropMax > 0 ? MathHelper.getRandomIntegerInRange(this.rand, this.xpDropMin, this.xpDropMax) : 0;
    }
}
