package awex.heroes.client.render.item;

import awex.heroes.client.model.ModelTrident;
import awex.heroes.client.model.ModelWonderWomanSword;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderItemWonderWomanSword implements IItemRenderer {
    private ResourceLocation texture = new ResourceLocation("justice", "textures/models/will.png");
    private ModelWonderWomanSword model = new ModelWonderWomanSword();

    public RenderItemWonderWomanSword() {
    }

    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return type == ItemRenderType.INVENTORY || type == ItemRenderType.ENTITY;
    }

    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
        EntityPlayer player = null;
        if (data.length > 1 && data[1] instanceof EntityPlayer) {
            player = (EntityPlayer)data[1];
        }

        float scale;
        if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
            GL11.glPushMatrix();
            GL11.glRotatef(140.0F, 0.2F, 0.2F, 0.1F);
            GL11.glRotatef(160.0F, 0.75F, -0.1F, -0.1F); // How far left
            GL11.glRotatef(70.0F, -0.5F, 0.0F, 1.5F);
            GL11.glTranslatef(0.125F, -0.25F, -0.750F);
            GL11.glRotatef(-175.5F, 0.6F, 160.0F, -62.0F);
            if (player != null && player.isUsingItem()) {
                GL11.glRotatef(-195.5F, 9.0F, 130.0F, -92.0F);
            }

            scale = 0.95F;
            GL11.glScalef(scale, scale, scale);
            this.model.render();
            GL11.glPopMatrix();
        } else if (type == ItemRenderType.EQUIPPED) {
            GL11.glPushMatrix();
            GL11.glRotatef(150.0F, 0.3F, 0.2F, 0.1F);
            GL11.glRotatef(160.0F, 1.5F, -0.1F, -0.1F);
            GL11.glRotatef(70.0F, -0.35F, 0.1F, 2.0F);
            GL11.glTranslatef(0.135F, -0.55F, -0.5750F);
            GL11.glRotatef(-175.5F, -1.0F, 75.0F, -55.0F);
            if (player != null && player.isUsingItem()) {
                GL11.glTranslatef(0.3F, 0.2F, 0.0F);
            }
            scale = 0.6F;
            GL11.glScalef(scale, scale, scale);
            this.model.render();
            GL11.glPopMatrix();
        } else if (type == ItemRenderType.INVENTORY) {
            GL11.glPushMatrix();
            GL11.glRotatef(-25.0F, 0.0F, 3.3F, 0.0F);
            GL11.glRotatef(-40.0F, 1.0F, 0.4F, 0.0F);
            GL11.glRotatef(25.0F, 0.0F, 20.1F, 0.0F);
            GL11.glTranslatef(0.1F, -0.2F, 0.24F);
            scale = 1.2F;
            GL11.glScalef(scale, -scale, -scale);
            this.model.render();
            GL11.glPopMatrix();
        } else if (type == ItemRenderType.ENTITY) {
            GL11.glPushMatrix();
            GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(0.0F, -0.85F, 0.0F);
            scale = 0.95F;
            GL11.glScalef(scale, -scale, -scale);
            this.model.render();
            GL11.glPopMatrix();
        }
    }
}

