package awex.heroes.common.generator;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class WorldGenKryptonite extends WorldGenMinable {
    private Block ore;

    public WorldGenKryptonite(Block block) {
        super(block, 1);
        this.ore = block;
    }

    public boolean generate(World world, Random rand, int x, int y, int z) {
        if (world.getBlock(x, y, z).isReplaceableOreGen(world, x, y, z, Blocks.stone)) {
            world.setBlock(x, y, z, this.ore, 0, 2);
        }

        return true;
    }
}
