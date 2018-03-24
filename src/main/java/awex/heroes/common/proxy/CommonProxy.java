package awex.heroes.common.proxy;

import awex.heroes.HeroesUnited;
import awex.heroes.client.render.entity.EntityNumber;
import awex.heroes.client.render.entity.EntityTestDummy;
import awex.heroes.common.ability.AbilityManager;
import awex.heroes.common.blocks.ModBlocks;
import awex.heroes.common.entity.ModEntities;
import awex.heroes.common.event.CommonEventHandler;
import awex.heroes.common.generator.ModWorldGenHandler;
import awex.heroes.common.hero.HeroRegistry;
import awex.heroes.common.items.ModItems;
import awex.heroes.common.recipes.ModRecipes;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy extends fiskfille.heroes.common.proxy.CommonProxy{
    public void preInit(FMLPreInitializationEvent e) {
        HeroRegistry.register();
        AbilityManager.register();
        ModItems.register();
    }

    public void Init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
        ModEntities.register();
        ModBlocks.register();
        MinecraftForge.ORE_GEN_BUS.register(new ModWorldGenHandler());
        ModRecipes.register();
        EntityRegistry.registerModEntity(EntityTestDummy.class, "TestDummy", 1, HeroesUnited.instance, 32, 10, false);
        EntityRegistry.registerModEntity(EntityNumber.class, "Number", 2, HeroesUnited.instance, 32, 1, false);

    }

    public void registerEventHandler(Object obj) {
        MinecraftForge.EVENT_BUS.register(obj);
        FMLCommonHandler.instance().bus().register(obj);
    }


    public void postInit(FMLPostInitializationEvent e) {
    }

    public void registerHandlers() {
    }
}