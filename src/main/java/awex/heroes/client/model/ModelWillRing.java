package awex.heroes.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelWillRing extends ModelBase {
    public ModelRenderer symbol;
    public ModelRenderer topRing1;
    public ModelRenderer upperRingBase1;
    public ModelRenderer ring1;
    public ModelRenderer upperRingSide2;
    public ModelRenderer upperRingSide1;
    public ModelRenderer symbolChild;
    public ModelRenderer symbolChild_1;
    public ModelRenderer symbolChild_2;
    public ModelRenderer symbolChild_3;
    public ModelRenderer symbolChild_4;
    public ModelRenderer symbolChild_5;
    public ModelRenderer symbolChild_6;
    public ModelRenderer symbolChild_7;
    public ModelRenderer symbolChild_8;
    public ModelRenderer topRing1Child;
    public ModelRenderer topRing1Child_1;
    public ModelRenderer topRing1Child_2;
    public ModelRenderer topRing1Child_3;
    public ModelRenderer topRing1Child_4;
    public ModelRenderer topRing1Child_5;
    public ModelRenderer topRing1Child_6;
    public ModelRenderer upperRingBase1Child;
    public ModelRenderer ring1Child;
    public ModelRenderer ring1Child_1;
    public ModelRenderer ring1Child_2;
    public ModelRenderer ring1Child_3;
    public ModelRenderer ring1Child_4;
    public ModelRenderer ring1Child_5;
    public ModelRenderer ring1Child_6;

    public ModelWillRing() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.topRing1Child = new ModelRenderer(this, 9, 0);
        this.topRing1Child.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.topRing1Child.addBox(-1.5F, -3.6500000953674316F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(topRing1Child, 0.0F, 0.0F, -2.356194496154785F);
        this.symbolChild_3 = new ModelRenderer(this, 23, 0);
        this.symbolChild_3.setRotationPoint(1.899999976158142F, 0.0F, -9.399999618530273F);
        this.symbolChild_3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(symbolChild_3, 0.0F, -0.5220279693603516F, 0.0F);
        this.ring1Child = new ModelRenderer(this, 0, 0);
        this.ring1Child.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ring1Child.addBox(-1.5F, -3.6500000953674316F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(ring1Child, 0.0F, 0.0F, 2.356194496154785F);
        this.topRing1Child_3 = new ModelRenderer(this, 9, 0);
        this.topRing1Child_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.topRing1Child_3.addBox(-1.5F, -3.6500000953674316F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(topRing1Child_3, 0.0F, 0.0F, 3.1415927410125732F);
        this.symbolChild_4 = new ModelRenderer(this, 23, 0);
        this.symbolChild_4.setRotationPoint(6.099999904632568F, 0.0F, -8.899999618530273F);
        this.symbolChild_4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(symbolChild_4, 0.0F, 0.6475171446800232F, 0.0F);
        this.symbol = new ModelRenderer(this, 18, 0);
        this.symbol.setRotationPoint(-1.1F, -1.0F, 1.0F);
        this.symbol.addBox(0.0F, 0.0F, 0.0F, 10, 1, 1, 0.0F);
        this.ring1 = new ModelRenderer(this, 0, 0);
        this.ring1.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.ring1.addBox(-1.5F, -3.6500000953674316F, -1.5F, 3, 1, 3, 0.0F);
        this.topRing1Child_5 = new ModelRenderer(this, 9, 0);
        this.topRing1Child_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.topRing1Child_5.addBox(-1.5F, -3.6500000953674316F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(topRing1Child_5, 0.0F, 0.0F, 2.356194496154785F);
        this.symbolChild_5 = new ModelRenderer(this, 19, 0);
        this.symbolChild_5.setRotationPoint(0.800000011920929F, 0.0F, -0.6000000238418579F);
        this.symbolChild_5.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
        this.symbolChild_1 = new ModelRenderer(this, 23, 0);
        this.symbolChild_1.setRotationPoint(0.10000000149011612F, 0.0F, -2.5F);
        this.symbolChild_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(symbolChild_1, 0.0F, 0.6642723083496093F, 0.0F);
        this.ring1Child_3 = new ModelRenderer(this, 0, 0);
        this.ring1Child_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ring1Child_3.addBox(-1.5F, -3.6500000953674316F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(ring1Child_3, 0.0F, 0.0F, -0.7853981852531433F);
        this.symbolChild = new ModelRenderer(this, 26, 0);
        this.symbolChild.setRotationPoint(8.5F, 0.0F, -3.200000047683716F);
        this.symbolChild.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(symbolChild, 0.0F, -0.6457718014717102F, -0.06649704277515411F);
        this.ring1Child_4 = new ModelRenderer(this, 0, 0);
        this.ring1Child_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ring1Child_4.addBox(-1.5F, -3.6500000953674316F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(ring1Child_4, 0.0F, 0.0F, -2.356194496154785F);
        this.symbolChild_7 = new ModelRenderer(this, 23, 0);
        this.symbolChild_7.setRotationPoint(8.300000190734863F, 0.0F, -6.5F);
        this.symbolChild_7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.ring1Child_1 = new ModelRenderer(this, 0, 0);
        this.ring1Child_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ring1Child_1.addBox(-1.5F, -3.6500000953674316F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(ring1Child_1, 0.0F, 0.0F, 3.1415927410125732F);
        this.symbolChild_6 = new ModelRenderer(this, 23, 0);
        this.symbolChild_6.setRotationPoint(0.10000000149011612F, 0.0F, -6.5F);
        this.symbolChild_6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.topRing1 = new ModelRenderer(this, 9, 0);
        this.topRing1.setRotationPoint(0.0F, -0.699999988079071F, 0.0F);
        this.topRing1.addBox(-1.5F, -3.6500000953674316F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(topRing1, 1.5707963705062866F, 0.0F, 0.0F);
        this.topRing1Child_2 = new ModelRenderer(this, 9, 0);
        this.topRing1Child_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.topRing1Child_2.addBox(-1.5F, -3.6500000953674316F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(topRing1Child_2, 0.0F, 0.0F, -1.5707963705062866F);
        this.topRing1Child_4 = new ModelRenderer(this, 9, 0);
        this.topRing1Child_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.topRing1Child_4.addBox(-1.5F, -3.6500000953674316F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(topRing1Child_4, 0.0F, 0.0F, 0.7853981852531433F);
        this.topRing1Child_1 = new ModelRenderer(this, 9, 0);
        this.topRing1Child_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.topRing1Child_1.addBox(-1.5F, -3.6500000953674316F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(topRing1Child_1, 0.0F, 0.0F, -0.7853981852531433F);
        this.ring1Child_5 = new ModelRenderer(this, 0, 0);
        this.ring1Child_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ring1Child_5.addBox(-1.5F, -3.6500000953674316F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(ring1Child_5, 0.0F, 0.0F, 1.5707963705062866F);
        this.upperRingSide2 = new ModelRenderer(this, 0, 15);
        this.upperRingSide2.mirror = true;
        this.upperRingSide2.setRotationPoint(1.5800000429153442F, -0.949999988079071F, 0.0F);
        this.upperRingSide2.addBox(-0.5F, 0.0F, -1.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(upperRingSide2, 0.0F, 0.0F, -0.5235987901687622F);
        this.topRing1Child_6 = new ModelRenderer(this, 9, 0);
        this.topRing1Child_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.topRing1Child_6.addBox(-1.5F, -3.6500000953674316F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(topRing1Child_6, 0.0F, 0.0F, 1.5707963705062866F);
        this.symbolChild_2 = new ModelRenderer(this, 20, 0);
        this.symbolChild_2.setRotationPoint(-0.699999988079071F, 0.0F, -9.600000381469727F);
        this.symbolChild_2.addBox(0.0F, 0.0F, 0.0F, 11, 1, 1, 0.0F);
        this.upperRingBase1 = new ModelRenderer(this, 0, 10);
        this.upperRingBase1.setRotationPoint(0.0F, -0.4000000059604645F, 0.0F);
        this.upperRingBase1.addBox(-2.5F, -1.0F, -2.0F, 5, 1, 4, 0.0F);
        this.upperRingSide1 = new ModelRenderer(this, 0, 15);
        this.upperRingSide1.setRotationPoint(-1.5800000429153442F, -0.949999988079071F, 0.0F);
        this.upperRingSide1.addBox(-0.5F, 0.0F, -1.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(upperRingSide1, 0.0F, 0.0F, 0.5235987901687622F);
        this.upperRingBase1Child = new ModelRenderer(this, 0, 4);
        this.upperRingBase1Child.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.upperRingBase1Child.addBox(-2.0F, -1.0F, -2.5F, 4, 1, 5, 0.0F);
        this.symbolChild_8 = new ModelRenderer(this, 18, 0);
        this.symbolChild_8.setRotationPoint(0.800000011920929F, 0.0F, -8.699999809265137F);
        this.symbolChild_8.addBox(0.0F, 0.0F, -0.30000001192092896F, 8, 1, 1, 0.0F);
        this.ring1Child_2 = new ModelRenderer(this, 0, 0);
        this.ring1Child_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ring1Child_2.addBox(-1.5F, -3.6500000953674316F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(ring1Child_2, 0.0F, 0.0F, 0.7853981852531433F);
        this.ring1Child_6 = new ModelRenderer(this, 0, 0);
        this.ring1Child_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ring1Child_6.addBox(-1.5F, -3.6500000953674316F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(ring1Child_6, 0.0F, 0.0F, -1.5707963705062866F);
        this.topRing1.addChild(this.topRing1Child);
        this.symbol.addChild(this.symbolChild_3);
        this.ring1.addChild(this.ring1Child);
        this.topRing1.addChild(this.topRing1Child_3);
        this.symbol.addChild(this.symbolChild_4);
        this.topRing1.addChild(this.topRing1Child_5);
        this.symbol.addChild(this.symbolChild_5);
        this.symbol.addChild(this.symbolChild_1);
        this.ring1.addChild(this.ring1Child_3);
        this.symbol.addChild(this.symbolChild);
        this.ring1.addChild(this.ring1Child_4);
        this.symbol.addChild(this.symbolChild_7);
        this.ring1.addChild(this.ring1Child_1);
        this.symbol.addChild(this.symbolChild_6);
        this.topRing1.addChild(this.topRing1Child_2);
        this.topRing1.addChild(this.topRing1Child_4);
        this.topRing1.addChild(this.topRing1Child_1);
        this.ring1.addChild(this.ring1Child_5);
        this.topRing1.addChild(this.topRing1Child_6);
        this.symbol.addChild(this.symbolChild_2);
        this.upperRingBase1.addChild(this.upperRingBase1Child);
        this.symbol.addChild(this.symbolChild_8);
        this.ring1.addChild(this.ring1Child_2);
        this.ring1.addChild(this.ring1Child_6);
    }


    public void render() {
        GL11.glPushMatrix();
        GL11.glTranslatef(this.upperRingSide2.offsetX, this.upperRingSide2.offsetY, this.upperRingSide2.offsetZ);
        GL11.glTranslatef(this.upperRingSide2.rotationPointX * 0.0625F, this.upperRingSide2.rotationPointY * 0.0625F, this.upperRingSide2.rotationPointZ * 0.0625F);
        GL11.glScaled(1.0D, 1.0D, 0.8D);
        GL11.glTranslatef(-this.upperRingSide2.offsetX, -this.upperRingSide2.offsetY, -this.upperRingSide2.offsetZ);
        GL11.glTranslatef(-this.upperRingSide2.rotationPointX * 0.0625F, -this.upperRingSide2.rotationPointY * 0.0625F, -this.upperRingSide2.rotationPointZ * 0.0625F);
        this.upperRingSide2.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.upperRingBase1.offsetX, this.upperRingBase1.offsetY, this.upperRingBase1.offsetZ);
        GL11.glTranslatef(this.upperRingBase1.rotationPointX * 0.0625F, this.upperRingBase1.rotationPointY * 0.0625F, this.upperRingBase1.rotationPointZ * 0.0625F);
        GL11.glScaled(0.6D, 0.55D, 0.6D);
        GL11.glTranslatef(-this.upperRingBase1.offsetX, -this.upperRingBase1.offsetY, -this.upperRingBase1.offsetZ);
        GL11.glTranslatef(-this.upperRingBase1.rotationPointX * 0.0625F, -this.upperRingBase1.rotationPointY * 0.0625F, -this.upperRingBase1.rotationPointZ * 0.0625F);
        this.upperRingBase1.render(0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.topRing1.offsetX, this.topRing1.offsetY, this.topRing1.offsetZ);
        GL11.glTranslatef(this.topRing1.rotationPointX * 0.0625F, this.topRing1.rotationPointY * 0.0625F, this.topRing1.rotationPointZ * 0.0625F);
        GL11.glScaled(0.55D, 0.5D, 0.55D);
        GL11.glTranslatef(-this.topRing1.offsetX, -this.topRing1.offsetY, -this.topRing1.offsetZ);
        GL11.glTranslatef(-this.topRing1.rotationPointX * 0.0625F, -this.topRing1.rotationPointY * 0.0625F, -this.topRing1.rotationPointZ * 0.0625F);
        this.topRing1.render(0.0625F);
        GL11.glPopMatrix();
        this.ring1.render(0.0625F);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.upperRingSide1.offsetX, this.upperRingSide1.offsetY, this.upperRingSide1.offsetZ);
        GL11.glTranslatef(this.upperRingSide1.rotationPointX * 0.0625F, this.upperRingSide1.rotationPointY * 0.0625F, this.upperRingSide1.rotationPointZ * 0.0625F);
        GL11.glScaled(1.0D, 1.0D, 0.8D);
        GL11.glTranslatef(-this.upperRingSide1.offsetX, -this.upperRingSide1.offsetY, -this.upperRingSide1.offsetZ);
        GL11.glTranslatef(-this.upperRingSide1.rotationPointX * 0.0625F, -this.upperRingSide1.rotationPointY * 0.0625F, -this.upperRingSide1.rotationPointZ * 0.0625F);
        this.upperRingSide1.render(0.0625F);
        GL11.glTranslatef(this.symbol.offsetX, this.symbol.offsetY, this.symbol.offsetZ);
        GL11.glTranslatef(this.symbol.rotationPointX * 0.0625F, this.symbol.rotationPointY * 0.0625F, this.symbol.rotationPointZ * 0.0625F);
        GL11.glScaled(0.25D, 0.25D, 0.25D);
        GL11.glTranslatef(-this.symbol.offsetX, -this.symbol.offsetY, -this.symbol.offsetZ);
        GL11.glTranslatef(-this.symbol.rotationPointX * 0.0625F, -this.symbol.rotationPointY * 0.0625F, -this.symbol.rotationPointZ * 0.0625F);
        this.symbol.render(0.0625F);
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
