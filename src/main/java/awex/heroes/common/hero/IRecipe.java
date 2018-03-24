package awex.heroes.common.hero;


import net.minecraft.item.ItemStack;

public interface IRecipe {
    ItemStack getRecipeItem_1();
    ItemStack getRecipeItem_2();
    ItemStack getRecipeItem_3();
    ItemStack getRecipeItem_4();
    ItemStack getRecipeItem_5();
    ItemStack getRecipeItem_6();
    int getItemAmount_1();
    int getItemAmount_2();
    int getItemAmount_3();
    int getItemAmount_4();
    int getItemAmount_5();
    int getItemAmount_6();
}
