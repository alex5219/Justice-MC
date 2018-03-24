package awex.heroes.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * Trident - FlameChaos618
 * Created using Tabula 4.1.1
 */
public class ModelTrident extends ModelBase {
    public ModelRenderer Tridentmainbody1;
    public ModelRenderer Tridentmainbody2;
    public ModelRenderer Tridentmainbody3;
    public ModelRenderer Transition1;
    public ModelRenderer Transition2;
    public ModelRenderer Transition3;
    public ModelRenderer Fork1;
    public ModelRenderer Fork2;
    public ModelRenderer Fork3;
    public ModelRenderer FT1;
    public ModelRenderer FT2;
    public ModelRenderer Point;
    public ModelRenderer Point2;
    public ModelRenderer Point3;

    public ModelTrident() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Tridentmainbody3 = new ModelRenderer(this, 0, 0);
        this.Tridentmainbody3.setRotationPoint(0.2F, -0.15F, -5.0F);
        this.Tridentmainbody3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 18, 0.0F);
        this.Point3 = new ModelRenderer(this, 0, 0);
        this.Point3.setRotationPoint(0.0F, 0.0F, 19.8F);
        this.Point3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(Point3, 0.0F, 0.7853981633974483F, 0.0F);
        this.Transition3 = new ModelRenderer(this, 0, 0);
        this.Transition3.setRotationPoint(-0.35F, -0.1F, 12.9F);
        this.Transition3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.Transition1 = new ModelRenderer(this, 0, 0);
        this.Transition1.setRotationPoint(-0.2F, -0.2F, 12.8F);
        this.Transition1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.Fork3 = new ModelRenderer(this, 0, 0);
        this.Fork3.setRotationPoint(1.9F, 0.0F, 13.9F);
        this.Fork3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.Fork2 = new ModelRenderer(this, 0, 0);
        this.Fork2.setRotationPoint(-1.3F, 0.0F, 13.9F);
        this.Fork2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.Point2 = new ModelRenderer(this, 0, 0);
        this.Point2.setRotationPoint(1.6F, 0.0F, 17.7F);
        this.Point2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(Point2, 0.0F, 0.7853981633974483F, 0.0F);
        this.FT1 = new ModelRenderer(this, 0, 0);
        this.FT1.setRotationPoint(-1.5F, -0.1F, 13.8F);
        this.FT1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(FT1, 0.0F, 0.45378560551852565F, 0.0F);
        this.Point = new ModelRenderer(this, 0, 0);
        this.Point.setRotationPoint(-1.6F, 0.0F, 17.7F);
        this.Point.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(Point, 0.0F, 0.7853981633974483F, 0.0F);
        this.Tridentmainbody2 = new ModelRenderer(this, 0, 0);
        this.Tridentmainbody2.setRotationPoint(-0.15F, 0.25F, -5.0F);
        this.Tridentmainbody2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 18, 0.0F);
        this.FT2 = new ModelRenderer(this, 0, 0);
        this.FT2.setRotationPoint(1.05F, -0.1F, 13.57F);
        this.FT2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(FT2, 0.0F, -0.45378560551852565F, 0.0F);
        this.Tridentmainbody1 = new ModelRenderer(this, 0, 0);
        this.Tridentmainbody1.setRotationPoint(0.0F, 0.0F, -5.2F);
        this.Tridentmainbody1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 18, 0.0F);
        this.Fork1 = new ModelRenderer(this, 0, 0);
        this.Fork1.setRotationPoint(0.2F, 0.0F, 13.9F);
        this.Fork1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.Transition2 = new ModelRenderer(this, 0, 0);
        this.Transition2.setRotationPoint(-0.1F, -0.3F, 12.9F);
        this.Transition2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    }

    public void render() {
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Tridentmainbody3.offsetX, this.Tridentmainbody3.offsetY, this.Tridentmainbody3.offsetZ);
        GL11.glTranslatef(this.Tridentmainbody3.rotationPointX * 0.0625F, this.Tridentmainbody3.rotationPointY * 0.0625F, this.Tridentmainbody3.rotationPointZ * 0.0625F);
        GL11.glScaled(0.4D, 1.1D, 1.0D);
        GL11.glTranslatef(-this.Tridentmainbody3.offsetX, -this.Tridentmainbody3.offsetY, -this.Tridentmainbody3.offsetZ);
        GL11.glTranslatef(-this.Tridentmainbody3.rotationPointX * 0.0625F, -this.Tridentmainbody3.rotationPointY * 0.0625F, -this.Tridentmainbody3.rotationPointZ * 0.0625F);
        this.Tridentmainbody3.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Point3.offsetX, this.Point3.offsetY, this.Point3.offsetZ);
        GL11.glTranslatef(this.Point3.rotationPointX * 0.0625F, this.Point3.rotationPointY * 0.0625F, this.Point3.rotationPointZ * 0.0625F);
        GL11.glScaled(0.6D, 0.8D, 1.7D);
        GL11.glTranslatef(-this.Point3.offsetX, -this.Point3.offsetY, -this.Point3.offsetZ);
        GL11.glTranslatef(-this.Point3.rotationPointX * 0.0625F, -this.Point3.rotationPointY * 0.0625F, -this.Point3.rotationPointZ * 0.0625F);
        this.Point3.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Transition3.offsetX, this.Transition3.offsetY, this.Transition3.offsetZ);
        GL11.glTranslatef(this.Transition3.rotationPointX * 0.0625F, this.Transition3.rotationPointY * 0.0625F, this.Transition3.rotationPointZ * 0.0625F);
        GL11.glScaled(1.5D, 1.0D, 1.0D);
        GL11.glTranslatef(-this.Transition3.offsetX, -this.Transition3.offsetY, -this.Transition3.offsetZ);
        GL11.glTranslatef(-this.Transition3.rotationPointX * 0.0625F, -this.Transition3.rotationPointY * 0.0625F, -this.Transition3.rotationPointZ * 0.0625F);
        this.Transition3.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Transition1.offsetX, this.Transition1.offsetY, this.Transition1.offsetZ);
        GL11.glTranslatef(this.Transition1.rotationPointX * 0.0625F, this.Transition1.rotationPointY * 0.0625F, this.Transition1.rotationPointZ * 0.0625F);
        GL11.glScaled(1.2D, 1.2D, 1.2D);
        GL11.glTranslatef(-this.Transition1.offsetX, -this.Transition1.offsetY, -this.Transition1.offsetZ);
        GL11.glTranslatef(-this.Transition1.rotationPointX * 0.0625F, -this.Transition1.rotationPointY * 0.0625F, -this.Transition1.rotationPointZ * 0.0625F);
        this.Transition1.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Fork3.offsetX, this.Fork3.offsetY, this.Fork3.offsetZ);
        GL11.glTranslatef(this.Fork3.rotationPointX * 0.0625F, this.Fork3.rotationPointY * 0.0625F, this.Fork3.rotationPointZ * 0.0625F);
        GL11.glScaled(0.2D, 0.8D, 4.0D);
        GL11.glTranslatef(-this.Fork3.offsetX, -this.Fork3.offsetY, -this.Fork3.offsetZ);
        GL11.glTranslatef(-this.Fork3.rotationPointX * 0.0625F, -this.Fork3.rotationPointY * 0.0625F, -this.Fork3.rotationPointZ * 0.0625F);
        this.Fork3.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Fork2.offsetX, this.Fork2.offsetY, this.Fork2.offsetZ);
        GL11.glTranslatef(this.Fork2.rotationPointX * 0.0625F, this.Fork2.rotationPointY * 0.0625F, this.Fork2.rotationPointZ * 0.0625F);
        GL11.glScaled(0.2D, 0.8D, 4.0D);
        GL11.glTranslatef(-this.Fork2.offsetX, -this.Fork2.offsetY, -this.Fork2.offsetZ);
        GL11.glTranslatef(-this.Fork2.rotationPointX * 0.0625F, -this.Fork2.rotationPointY * 0.0625F, -this.Fork2.rotationPointZ * 0.0625F);
        this.Fork2.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Point2.offsetX, this.Point2.offsetY, this.Point2.offsetZ);
        GL11.glTranslatef(this.Point2.rotationPointX * 0.0625F, this.Point2.rotationPointY * 0.0625F, this.Point2.rotationPointZ * 0.0625F);
        GL11.glScaled(0.6D, 0.8D, 1.7D);
        GL11.glTranslatef(-this.Point2.offsetX, -this.Point2.offsetY, -this.Point2.offsetZ);
        GL11.glTranslatef(-this.Point2.rotationPointX * 0.0625F, -this.Point2.rotationPointY * 0.0625F, -this.Point2.rotationPointZ * 0.0625F);
        this.Point2.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.FT1.offsetX, this.FT1.offsetY, this.FT1.offsetZ);
        GL11.glTranslatef(this.FT1.rotationPointX * 0.0625F, this.FT1.rotationPointY * 0.0625F, this.FT1.rotationPointZ * 0.0625F);
        GL11.glScaled(1.4D, 1.0D, 0.5D);
        GL11.glTranslatef(-this.FT1.offsetX, -this.FT1.offsetY, -this.FT1.offsetZ);
        GL11.glTranslatef(-this.FT1.rotationPointX * 0.0625F, -this.FT1.rotationPointY * 0.0625F, -this.FT1.rotationPointZ * 0.0625F);
        this.FT1.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Point.offsetX, this.Point.offsetY, this.Point.offsetZ);
        GL11.glTranslatef(this.Point.rotationPointX * 0.0625F, this.Point.rotationPointY * 0.0625F, this.Point.rotationPointZ * 0.0625F);
        GL11.glScaled(0.6D, 0.8D, 1.7D);
        GL11.glTranslatef(-this.Point.offsetX, -this.Point.offsetY, -this.Point.offsetZ);
        GL11.glTranslatef(-this.Point.rotationPointX * 0.0625F, -this.Point.rotationPointY * 0.0625F, -this.Point.rotationPointZ * 0.0625F);
        this.Point.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Tridentmainbody2.offsetX, this.Tridentmainbody2.offsetY, this.Tridentmainbody2.offsetZ);
        GL11.glTranslatef(this.Tridentmainbody2.rotationPointX * 0.0625F, this.Tridentmainbody2.rotationPointY * 0.0625F, this.Tridentmainbody2.rotationPointZ * 0.0625F);
        GL11.glScaled(1.1D, 0.3D, 1.0D);
        GL11.glTranslatef(-this.Tridentmainbody2.offsetX, -this.Tridentmainbody2.offsetY, -this.Tridentmainbody2.offsetZ);
        GL11.glTranslatef(-this.Tridentmainbody2.rotationPointX * 0.0625F, -this.Tridentmainbody2.rotationPointY * 0.0625F, -this.Tridentmainbody2.rotationPointZ * 0.0625F);
        this.Tridentmainbody2.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.FT2.offsetX, this.FT2.offsetY, this.FT2.offsetZ);
        GL11.glTranslatef(this.FT2.rotationPointX * 0.0625F, this.FT2.rotationPointY * 0.0625F, this.FT2.rotationPointZ * 0.0625F);
        GL11.glScaled(1.4D, 1.0D, 0.5D);
        GL11.glTranslatef(-this.FT2.offsetX, -this.FT2.offsetY, -this.FT2.offsetZ);
        GL11.glTranslatef(-this.FT2.rotationPointX * 0.0625F, -this.FT2.rotationPointY * 0.0625F, -this.FT2.rotationPointZ * 0.0625F);
        this.FT2.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Tridentmainbody1.offsetX, this.Tridentmainbody1.offsetY, this.Tridentmainbody1.offsetZ);
        GL11.glTranslatef(this.Tridentmainbody1.rotationPointX * 0.0625F, this.Tridentmainbody1.rotationPointY * 0.0625F, this.Tridentmainbody1.rotationPointZ * 0.0625F);
        GL11.glScaled(0.8D, 0.8D, 1.02D);
        GL11.glTranslatef(-this.Tridentmainbody1.offsetX, -this.Tridentmainbody1.offsetY, -this.Tridentmainbody1.offsetZ);
        GL11.glTranslatef(-this.Tridentmainbody1.rotationPointX * 0.0625F, -this.Tridentmainbody1.rotationPointY * 0.0625F, -this.Tridentmainbody1.rotationPointZ * 0.0625F);
        this.Tridentmainbody1.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Fork1.offsetX, this.Fork1.offsetY, this.Fork1.offsetZ);
        GL11.glTranslatef(this.Fork1.rotationPointX * 0.0625F, this.Fork1.rotationPointY * 0.0625F, this.Fork1.rotationPointZ * 0.0625F);
        GL11.glScaled(0.4D, 0.8D, 5.8D);
        GL11.glTranslatef(-this.Fork1.offsetX, -this.Fork1.offsetY, -this.Fork1.offsetZ);
        GL11.glTranslatef(-this.Fork1.rotationPointX * 0.0625F, -this.Fork1.rotationPointY * 0.0625F, -this.Fork1.rotationPointZ * 0.0625F);
        this.Fork1.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Transition2.offsetX, this.Transition2.offsetY, this.Transition2.offsetZ);
        GL11.glTranslatef(this.Transition2.rotationPointX * 0.0625F, this.Transition2.rotationPointY * 0.0625F, this.Transition2.rotationPointZ * 0.0625F);
        GL11.glScaled(1.0D, 1.4D, 1.0D);
        GL11.glTranslatef(-this.Transition2.offsetX, -this.Transition2.offsetY, -this.Transition2.offsetZ);
        GL11.glTranslatef(-this.Transition2.rotationPointX * 0.0625F, -this.Transition2.rotationPointY * 0.0625F, -this.Transition2.rotationPointZ * 0.0625F);
        this.Transition2.render(0.0625F);
        GL11.glPopMatrix();
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
