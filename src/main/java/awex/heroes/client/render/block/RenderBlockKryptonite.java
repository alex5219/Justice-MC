package awex.heroes.client.render.block;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import fiskfille.heroes.client.SHRenderHooks;
import fiskfille.heroes.client.render.block.RenderBlockDisplayStand;
import fiskfille.heroes.common.block.BlockDisplayStand;
import fiskfille.heroes.common.block.BlockStack;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RenderBlockKryptonite implements ISimpleBlockRenderingHandler {
    public static RenderBlockKryptonite instance = new RenderBlockKryptonite();
    public static int renderId = RenderingRegistry.getNextAvailableRenderId();

    public RenderBlockKryptonite() {
    }

    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        boolean flag = false;
        boolean ao = renderer.enableAO;
        int metadata = world.getBlockMetadata(x, y, z);
        Map<List<AxisAlignedBB>, BlockStack> map = BlockDisplayStand.getExtraBounds(world, x, y, z);
        renderer.setRenderAllFaces(true);
        renderer.enableAO = false;
        Iterator var12 = map.entrySet().iterator();

        while(true) {
            Map.Entry e;
            BlockStack stack;
            do {
                do {
                    do {
                        if (!var12.hasNext()) {
                            BlockDisplayStand.renderingBlock = null;
                            renderer.clearOverrideBlockTexture();
                            renderer.setRenderAllFaces(false);
                            renderer.enableAO = ao;
                            return flag;
                        }

                        e = (Map.Entry)var12.next();
                        stack = (BlockStack)e.getValue();
                    } while(stack == null);
                } while(stack.block.getMaterial() == Material.air);
            } while(!stack.block.canRenderInPass(block.getRenderBlockPass()));

            renderer.setOverrideBlockTexture(stack.block.getIcon(1, stack.metadata));
            BlockDisplayStand.renderingBlock = stack;
            Iterator var15 = ((List)e.getKey()).iterator();

            while(var15.hasNext()) {
                AxisAlignedBB aabb = (AxisAlignedBB)var15.next();
                boolean flag1 = false;
                int renderY = y;
                if (metadata < 8) {
                    if (aabb.minY >= 1.0D) {
                        renderY = y + 1;
                    }
                } else if (aabb.minY <= 1.0D) {
                    renderY = y - 1;
                }

                if (aabb.minY - 1.0D >= 0.0D) {
                    --aabb.minY;
                    --aabb.maxY;
                    Tessellator.instance.addTranslation(0.0F, 1.0F, 0.0F);
                    flag1 = true;
                }

                int translation = y - renderY;
                if (translation != 0) {
                    Tessellator.instance.addTranslation(0.0F, (float)translation, 0.0F);
                }

                renderer.setRenderBounds(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
                flag |= renderer.renderStandardBlock(block, x, renderY, z);
                if (translation != 0) {
                    Tessellator.instance.addTranslation(0.0F, (float)(-translation), 0.0F);
                }

                if (flag1) {
                    Tessellator.instance.addTranslation(0.0F, -1.0F, 0.0F);
                }
            }
        }
    }

    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        block.setBlockBoundsForItemRender();
        renderer.setRenderBoundsFromBlock(block);
        renderer.setOverrideBlockTexture(Blocks.stone_slab.getIcon(0, 0));
        SHRenderHooks.renderBlock(block, metadata, renderer);
        renderer.clearOverrideBlockTexture();
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    public int getRenderId() {
        return renderId;
    }
}

