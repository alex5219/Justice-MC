package awex.heroes.helper;

import net.minecraft.util.ResourceLocation;

public class TextureHelper extends fiskfille.core.helper.TextureHelper{
    public static ResourceLocation getTool(String tool) {
        ResourceLocation resourcelocation = new ResourceLocation("fiskheroes", "textures/null.png");
        if (tool != null && tool.length() > 0) {
            resourcelocation = new ResourceLocation("justicemc", "textures/items/willpower" + tool + ".png");
        }
        return resourcelocation;
    }
}
