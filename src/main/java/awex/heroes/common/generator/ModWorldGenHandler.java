package awex.heroes.common.generator;

import awex.heroes.common.blocks.ModBlocks;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fiskfille.heroes.SHReflection;
import fiskfille.heroes.common.block.BlockStack;
import fiskfille.heroes.common.data.world.SHMapData;
import fiskfille.heroes.common.generator.WorldGenTutridium;
import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Map;
import java.util.Random;

public class ModWorldGenHandler {

    private World world;
    private Random rand;
    private int xCoord;
    private int zCoord;
    private boolean gatherOreList;
    public WorldGenerator kryptoniteGen;

    public ModWorldGenHandler() {
        this.kryptoniteGen = new WorldGenKryptonite(ModBlocks.kryptoniteOre);
    }

    @SubscribeEvent
    public void onOreGenPre(OreGenEvent.Pre event) {
        this.world = event.world;
        this.rand = event.rand;
        this.xCoord = event.worldX;
        this.zCoord = event.worldZ;
        ChunkCoordinates coords = this.world.getSpawnPoint();
        this.gatherOreList = this.xCoord >> 4 == coords.posX >> 4 && this.zCoord >> 4 == coords.posZ >> 4 || SHMapData.get(this.world).ores.isEmpty();
    }

    @SubscribeEvent
    public void onOreGenPost(OreGenEvent.Post event) {
        this.genStandardOre(1, this.kryptoniteGen, 48);
    }

    @SubscribeEvent
    public void onGenerateOre(OreGenEvent.GenerateMinable event) {
        if (event.type != OreGenEvent.GenerateMinable.EventType.DIRT && event.type != OreGenEvent.GenerateMinable.EventType.GRAVEL) {
            if (this.gatherOreList && event.generator instanceof WorldGenMinable) {
                WorldGenMinable generator = (WorldGenMinable)event.generator;
                BlockStack stack = new BlockStack((Block) SHReflection.genMineableOreField.get(generator), (Integer)SHReflection.genMineableMetaField.get(generator));
                Map<BlockStack, Integer> size = SHMapData.get(this.world).getOreGen((Block)SHReflection.genMineableStoneField.get(generator));
                if (!size.containsKey(stack)) {
                    size.put(stack, SHReflection.genMineableNumField.get(generator));
                }
            }
        }
    }

    protected void genStandardOre(int veins, WorldGenerator generator, int maxHeight) {
        if (TerrainGen.generateOre(this.world, this.rand, generator, this.xCoord, this.zCoord, OreGenEvent.GenerateMinable.EventType.CUSTOM)) {
            for(int i = 0; i < veins; ++i) {
                int x = this.xCoord + this.rand.nextInt(16);
                int y = this.rand.nextInt(maxHeight);
                int z = this.zCoord + this.rand.nextInt(16);
                generator.generate(this.world, this.rand, x, y, z);
            }
        }
    }
}
