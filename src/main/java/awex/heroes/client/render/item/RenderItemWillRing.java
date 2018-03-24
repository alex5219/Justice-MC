package awex.heroes.client.render.item;

import awex.heroes.client.model.ModelWillRing;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderItemWillRing implements IItemRenderer {
    private ResourceLocation texture = new ResourceLocation("justice", "textures/models/will_ring.png");
    private ModelWillRing model = new ModelWillRing();

    public RenderItemWillRing() {
    }

    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return type == ItemRenderType.INVENTORY || type == ItemRenderType.ENTITY;
    }

    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
        float scale;
        if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.7F, 0.4F, 0.2F);
            GL11.glRotatef(-5.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(210.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            scale = 0.95F;
            GL11.glScalef(scale, scale, scale);
            this.model.render();
            GL11.glPopMatrix();
        } else if (type == ItemRenderType.EQUIPPED) {
            GL11.glPushMatrix();
            GL11.glRotatef(15.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-79.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-105.0F, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.1F, -0.185F, 0.325F);
            scale = 0.5F;
            GL11.glScalef(scale, scale, scale);
            this.model.render();
            GL11.glPopMatrix();
        } else if (type == ItemRenderType.INVENTORY) {
            GL11.glPushMatrix();
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(40.0F, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.0F, 0.4F, 0.0F);
            scale = 1.85F;
            GL11.glScalef(scale, -scale, -scale);
            this.model.render();
            GL11.glPopMatrix();
        } else if (type == ItemRenderType.ENTITY) {
            GL11.glPushMatrix();
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.0F, 0.2F, 0.0F);
            scale = 1.1F;
            GL11.glScalef(scale, -scale, -scale);
            this.model.render();
            GL11.glPopMatrix();
        }

    }
}

