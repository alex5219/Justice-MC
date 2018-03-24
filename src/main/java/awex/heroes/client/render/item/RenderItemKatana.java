package awex.heroes.client.render.item;

import fiskfille.heroes.client.model.item.ModelKatana;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderItemKatana implements IItemRenderer {
    private ResourceLocation texture = new ResourceLocation("justice", "textures/models/will.png");
    private ModelKatana model = new ModelKatana();

    public RenderItemKatana() {
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

        this.model.guard.isHidden = true;
        float scale;
        if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
            GL11.glPushMatrix();
            GL11.glRotatef(85.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(150.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-2.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(0.05F, 0.2F, -0.725F);
            GL11.glRotatef(-5.0F, 1.0F, 0.0F, 0.0F);
            if (player != null && player.isUsingItem()) {
                GL11.glTranslatef(0.3F, 0.1F, 0.0F);
            }

            scale = 0.55F;
            GL11.glScalef(scale, scale, scale);
            this.model.render();
            GL11.glPopMatrix();
        } else if (type == ItemRenderType.EQUIPPED) {
            GL11.glPushMatrix();
            GL11.glRotatef(85.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(150.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-2.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(0.05F, 0.2F, -0.725F);
            if (player != null && player.isUsingItem()) {
                GL11.glTranslatef(0.05F, 0.1F, 0.0F);
            }

            scale = 0.6F;
            GL11.glScalef(scale, scale, scale);
            this.model.render();
            GL11.glPopMatrix();
        } else if (type == ItemRenderType.INVENTORY) {
            GL11.glPushMatrix();
            GL11.glRotatef(-45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-40.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-25.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.9F, 0.0F);
            scale = 0.8F;
            GL11.glScalef(scale, -scale, -scale);
            this.model.render();
            GL11.glPopMatrix();
        } else if (type == ItemRenderType.ENTITY) {
            GL11.glPushMatrix();
            GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(0.0F, -0.85F, 0.0F);
            scale = 0.7F;
            GL11.glScalef(scale, -scale, -scale);
            this.model.render();
            GL11.glPopMatrix();
        }
    }
}
