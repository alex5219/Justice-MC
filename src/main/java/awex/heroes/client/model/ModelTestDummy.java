package awex.heroes.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTestDummy extends ModelBiped {
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedHeadwear;
    public ModelRenderer bipedEars;
    public ModelRenderer bipedBody;
    public ModelRenderer plate;
    public ModelRenderer bipedHead;


    public ModelTestDummy(float size, float p_i1149_2_)
    {
        this(size, p_i1149_2_, 64, 32);
    }

    public ModelTestDummy(float size, float p_i1149_2_, int xw, int yw)
    {
        super(size, p_i1149_2_, xw, yw);
        this.bipedRightArm = new ModelRenderer(this, 40, 16);
        this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bipedLeftArm = new ModelRenderer(this, 40, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.setRotationPoint(1.899999976158142F, 12.0F, 0.0F);
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.setRotationPoint(-1.899999976158142F, 12.0F, 0.0F);
        this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.bipedEars = new ModelRenderer(this, 24, 0);
        this.bipedEars.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, 0.0F);
        this.plate = new ModelRenderer(this, 0, 32);
        this.plate.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.plate.addBox(-8.0F, 11.5F, -8.0F, 16, 1, 16, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.bipedRightArm.render(f5);
        this.bipedLeftArm.render(f5);
        this.bipedBody.render(f5);
        this.bipedLeftLeg.render(f5);
        this.bipedHead.render(f5);
        this.bipedRightLeg.render(f5);
        this.bipedHeadwear.render(f5);
        this.bipedEars.render(f5);
        this.plate.render(f5);
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
