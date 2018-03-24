package awex.heroes.common.recipes;

import awex.heroes.common.blocks.ModBlocks;
import awex.heroes.common.items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes {
    public ModRecipes(){

    }
    public static void register(){
        GameRegistry.addSmelting(ModBlocks.kryptoniteOre, new ItemStack(ModItems.kryptonite), 1.5F);
        GameRegistry.addRecipe(new ItemStack(ModItems.willRing, 1), new Object[]{"NGN", "N N", "NNN", 'N', Items.diamond, 'G', Items.iron_ingot});
    }
}
