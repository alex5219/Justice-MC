package awex.heroes;

import awex.heroes.common.network.MessageArmor;
import awex.heroes.common.network.MessageDamage;
import awex.heroes.common.network.MessageGiveTool;
import awex.heroes.common.proxy.CommonProxy;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = HeroesUnited.MODID, name = HeroesUnited.NAME, version = HeroesUnited.VERSION)
public class HeroesUnited
{
    public static final String MODID = "justice";
    public static final String VERSION = "1.2.0";
    public static final String NAME = "Heroes United";

    public static final SimpleNetworkWrapper packetHandler = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);

    public static boolean xray = false;
    public static boolean isMagic = false;

    @Mod.Instance(HeroesUnited.MODID)
    public static HeroesUnited instance;

    @SidedProxy(clientSide = "awex.heroes.common.proxy.ClientProxy", serverSide = "awex.heroes.common.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
        isMagic = Loader.isModLoaded("arsmagica2");
        xray = Loader.isModLoaded("xray") || Loader.isModLoaded("fgtXray") || Loader.isModLoaded("Kardxns Xray") || Loader.isModLoaded("Scenter") || Loader.isModLoaded("cheating essentials") || Loader.isModLoaded("cheatclient");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.registerHandlers();
        proxy.Init(e);
        packetHandler.registerMessage(MessageGiveTool.class, MessageGiveTool.class,1, Side.SERVER);
        packetHandler.registerMessage(MessageDamage.MessageHandlerClient.class, MessageDamage.class, 2, Side.CLIENT);
        packetHandler.registerMessage(MessageArmor.MessageHandlerClient.class, MessageArmor.class, 3, Side.CLIENT);
    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
