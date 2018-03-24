package awex.heroes.common.proxy;

import awex.heroes.HeroesUnited;
import awex.heroes.client.gui.GuiHandler;
import awex.heroes.client.render.entity.*;
import awex.heroes.client.render.hero.RendererManager;
import awex.heroes.client.render.item.*;
import awex.heroes.common.entity.EntityVibeWave;
import awex.heroes.common.event.ClientEventHandler;
import awex.heroes.common.items.ModItems;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy{

    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    public void Init(FMLInitializationEvent e) {
        super.Init(e);
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        MinecraftForgeClient.registerItemRenderer(ModItems.willRing, new RenderItemWillRing());
        MinecraftForgeClient.registerItemRenderer(ModItems.willKatana, new RenderItemKatana());
        MinecraftForgeClient.registerItemRenderer(ModItems.WILLPOWERKNIFE, new RenderItemKnife());
        MinecraftForgeClient.registerItemRenderer(ModItems.willTrident, new RenderItemTrident());
        MinecraftForgeClient.registerItemRenderer(ModItems.wonderWomanSword, new RenderItemWonderWomanSword());
        MinecraftForgeClient.registerItemRenderer(ModItems.deathstrokesSword, new RenderItemDeathstrokesSword());
        RenderingRegistry.registerEntityRenderingHandler(EntityVibeWave.class, new RenderWave());
        RenderingRegistry.registerEntityRenderingHandler(EntityTestDummy.class, new RenderTestDummy());
        RenderingRegistry.registerEntityRenderingHandler(EntityNumber.class, new RenderNumber());
    }

    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        RendererManager.register();
    }

    public void registerEventHandler(Object obj) {
        MinecraftForge.EVENT_BUS.register(obj);
    }


    public void registerHandlers(){
        NetworkRegistry.INSTANCE.registerGuiHandler(HeroesUnited.instance, new GuiHandler());
    }
}
