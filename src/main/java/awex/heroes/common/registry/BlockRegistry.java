package awex.heroes.common.registry;

import awex.heroes.common.items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import fiskfille.heroes.FiskHeroes;
import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Locale;

public class BlockRegistry{
        public BlockRegistry() {
        }

        public static void registerBlock(Block block, String name) {
            String unlocalizedName = name.toLowerCase(Locale.ROOT).replaceAll(" ", "_").replaceAll("'", "");
            block.setBlockName(unlocalizedName);
            block.setBlockTextureName("justice:" + unlocalizedName);
            block.setCreativeTab(ModItems.tabJusticeMC);
            GameRegistry.registerBlock(block, unlocalizedName);
        }

        public static void registerItemBlock(Block block, String name, Class clazz) {
            String unlocalizedName = name.toLowerCase(Locale.ROOT).replaceAll(" ", "_").replaceAll("'", "");
            block.setBlockName(unlocalizedName);
            block.setBlockTextureName("justice:" + unlocalizedName);
            block.setCreativeTab(ModItems.tabJusticeMC);
            GameRegistry.registerBlock(block, clazz, unlocalizedName);
        }

        public static void registerOre(Block block, String name, String oreDictName) {
            registerBlock(block, name);
            OreDictionary.registerOre(oreDictName, block);
        }
    public static void registerTileEntity(Block block, String name, Class clazz) {
        registerBlock(block, name);
        GameRegistry.registerTileEntity(clazz, name);
    }

    public static void registerItemBlockAsTileEntity(Block block, String name, Class clazz, Class clazz1) {
        registerItemBlock(block, name, clazz1);
        GameRegistry.registerTileEntity(clazz, name);
    }
}
