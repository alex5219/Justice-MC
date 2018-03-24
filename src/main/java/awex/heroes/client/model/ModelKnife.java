package awex.heroes.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import org.lwjgl.opengl.GL11;

/**
 * NewProject - Undefined
 * Created using Tabula 4.1.1
 */
public class ModelKnife extends ModelBase {
    private ModelRenderer MainBody2;
    private ModelRenderer HandGuard2;
    private ModelRenderer HandGuard;
    private ModelRenderer Blade2;
    private ModelRenderer Blade1;
    private ModelRenderer sharpend;
    private ModelRenderer Mainbody;
    private ModelRenderer Handle;
    private ModelRenderer shape5_1;

    public ModelKnife() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.HandGuard = new ModelRenderer(this, 0, 0);
        this.HandGuard.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HandGuard.addBox(0.0F, 0.0F, 0.0F, 5, 1, 3, 0.0F);
        this.shape5_1 = new ModelRenderer(this, 0, 0);
        this.shape5_1.setRotationPoint(-0.3F, 1.6F, 1.0F);
        this.shape5_1.addBox(1.6F, 0.0F, 0.0F, 2, 7, 1, 0.0F);
        this.MainBody2 = new ModelRenderer(this, 0, 0);
        this.MainBody2.setRotationPoint(0.0F, -10.7F, 1.0F);
        this.MainBody2.addBox(0.0F, 0.0F, 0.0F, 5, 12, 1, 0.0F);
        this.Handle = new ModelRenderer(this, 0, 0);
        this.Handle.setRotationPoint(1.4F, 1.6F, 1.0F);
        this.Handle.addBox(1.6F, 0.0F, 0.0F, 2, 7, 1, 0.0F);
        this.HandGuard2 = new ModelRenderer(this, 0, 0);
        this.HandGuard2.setRotationPoint(-1.0F, 0.0F, 0.5F);
        this.HandGuard2.addBox(0.0F, 0.0F, 0.0F, 5, 1, 2, 0.0F);
        this.Mainbody = new ModelRenderer(this, 0, 0);
        this.Mainbody.setRotationPoint(0.0F, -9.5F, 1.0F);
        this.Mainbody.addBox(0.0F, 0.0F, 0.0F, 5, 12, 1, 0.0F);
        this.Blade2 = new ModelRenderer(this, 0, 0);
        this.Blade2.setRotationPoint(3.4F, -14.4F, 1.0F);
        this.Blade2.addBox(0.1F, 0.0F, 0.0F, 2, 15, 1, 0.0F);
        this.setRotateAngle(Blade2, 0.0F, 0.0F, 0.06632251157578452F);
        this.sharpend = new ModelRenderer(this, 0, 0);
        this.sharpend.setRotationPoint(4.1F, -18.8F, 1.0F);
        this.sharpend.addBox(0.0F, -1.9F, 0.0F, 3, 11, 1, 0.0F);
        this.setRotateAngle(sharpend, 0.0F, 0.0F, 1.2112585008840648F);
        this.Blade1 = new ModelRenderer(this, 0, 0);
        this.Blade1.setRotationPoint(1.5F, -12.7F, 1.0F);
        this.Blade1.addBox(0.0F, 0.0F, 0.0F, 2, 15, 1, 0.0F);
    }

    public void render() {
        this.HandGuard.render(0.0625F);
        this.shape5_1.render(0.0625F);
        this.MainBody2.render(0.0625F);
        this.Handle.render(0.0625F);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.HandGuard2.offsetX, this.HandGuard2.offsetY, this.HandGuard2.offsetZ);
        GL11.glTranslatef(this.HandGuard2.rotationPointX * 0.0625F, this.HandGuard2.rotationPointY * 0.0625F, this.HandGuard2.rotationPointZ * 0.0625F);
        GL11.glScaled(1.4D, 1.0D, 1.0D);
        GL11.glTranslatef(-this.HandGuard2.offsetX, -this.HandGuard2.offsetY, -this.HandGuard2.offsetZ);
        GL11.glTranslatef(-this.HandGuard2.rotationPointX * 0.0625F, -this.HandGuard2.rotationPointY * 0.0625F, -this.HandGuard2.rotationPointZ * 0.0625F);
        this.HandGuard2.render(0.0625F);
        GL11.glPopMatrix();
        this.Mainbody.render(0.0625F);
        this.Blade2.render(0.0625F);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.sharpend.offsetX, this.sharpend.offsetY, this.sharpend.offsetZ);
        GL11.glTranslatef(this.sharpend.rotationPointX * 0.0625F, this.sharpend.rotationPointY * 0.0625F, this.sharpend.rotationPointZ * 0.0625F);
        GL11.glScaled(0.5D, 2.1D, 1.0D);
        GL11.glTranslatef(-this.sharpend.offsetX, -this.sharpend.offsetY, -this.sharpend.offsetZ);
        GL11.glTranslatef(-this.sharpend.rotationPointX * 0.0625F, -this.sharpend.rotationPointY * 0.0625F, -this.sharpend.rotationPointZ * 0.0625F);
        this.sharpend.render(0.0625F);
        GL11.glPopMatrix();
        this.Blade1.render(0.0625F);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
