package awex.heroes.common.blocks;

import awex.heroes.common.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ModBlocks {
    public static Block kryptoniteOre;

    public ModBlocks() {
    }

    public static void register() {
        kryptoniteOre = (new ModBlockOre(new ItemBlock(ModBlocks.kryptoniteOre)).setHarvestLvl("pickaxe", 1).setCanFortuneHarvest(false).setHardness(3.0F).setResistance(2000.0F));

        BlockRegistry.registerOre(kryptoniteOre, "Kryptonite Ore", "oreKryptonite");
    }
}
