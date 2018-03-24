package awex.heroes.client.render.entity;

import awex.heroes.client.model.ModelTestDummy;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderTestDummy extends RenderBiped {
    private static final ResourceLocation texture = new ResourceLocation("justice" ,"textures/models/tile/test_dummy.png");
    public static final ModelTestDummy model = new ModelTestDummy(0.0f, 0.0F);

    public RenderTestDummy() {
        super(model, 0.125f);
    }

    protected ResourceLocation getEntityTexture(EntityLiving e) {
        return texture;
    }

    protected void func_82421_b()
    {
        this.field_82423_g = new ModelTestDummy(1.0F, 0f, 64, 32);
        this.field_82425_h = new ModelTestDummy(0.5F, 0f, 64, 32);

        ((ModelTestDummy)this.field_82423_g).plate.showModel = false;
        ((ModelTestDummy)this.field_82425_h).plate.showModel = false;
    }
}