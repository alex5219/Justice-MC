package awex.heroes.common.items;

import awex.heroes.common.items.constructs.*;
import awex.heroes.common.registry.ItemRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import fiskfille.heroes.common.item.ItemMaterialEnergy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {// Stats
    public static Item willRing;
    public static Item lasso;
    public static Item testDummy = new ItemTestDummy("testDummy");

    public static Item deathstrokesSword;

    public static String will = "Willpower";
    public static Item.ToolMaterial HIGH = EnumHelper.addToolMaterial("High", 4, 3, 18.0F, 5.0F, 0);
    public static Item.ToolMaterial MEDIUM = EnumHelper.addToolMaterial("Medium", 3, 6, 16.0F, 4.5F, 0);
    public static Item.ToolMaterial LOW = EnumHelper.addToolMaterial("Low", 2, 9, 14.0F, 2.5F, 0);
    public static Item.ToolMaterial LOWER = EnumHelper.addToolMaterial("Lower", 1, 12, 12.0F, 1.0F, 0);

    public static Item.ToolMaterial THIGH = EnumHelper.addToolMaterial("High", 5, 15, 18.0F, 1.0F, 0);
    public static Item.ToolMaterial TMEDIUM = EnumHelper.addToolMaterial("Medium", 4, 30, 16.0F, 0.5F, 0);
    public static Item.ToolMaterial TLOW = EnumHelper.addToolMaterial("Low", 3, 45, 14.0F, 0.0F, 0);

    // Construct Swords
    public static Item WILLPOWERBROADSWORD, willKatana, WILLPOWERKNIFE, WILLPOWERKUKRI, WILLPOWERSPEAR, WILLPOWERSCYTHE, WILLPOWERGOLFCLUB, WILLPOWERCROWBAR, WILLPOWERMACHETE, WILLPOWERMACE, WILLPOWERLIGHTSABER, WILLPOWERBASEBALLBAT, WILLPOWERPADDLE, WILLPOWERWRENCH, willTrident;
    public static Item WILLPOWERAXE, WILLPOWERFLINTANDSTEEL, WILLPOWERHATCHET, WILLPOWERLIGHTER, WILLPOWERPICK, WILLPOWERSHEARS, WILLPOWERSTEAK;
    public static Item WILLPOWERHAMMER, WILLPOWERGUITAR, WILLPOWERSHIELD, WILLPOWERPAN, WILLPOWERBATTLEAXE, WILLPOWERPISTOL, WILLPOWERRIFLE, WILLPOWERTASER, WILLPOWERCHAINSAW, WILLPOWERSHOVEL;
    public static Item kryptonite;
    public static Item wonderWomanSword;

    public static void register() {
        deathstrokesSword = new ItemDeathstrokesSword();
        wonderWomanSword = new ItemWonderWomanSword(HIGH, "WonderWomanSword", 200);
        kryptonite = new ItemMaterialEnergy(64);
        willRing = new ItemWillRing();
        lasso = new ItemLasso();
        willKatana = new ItemConstructKatana();
        willTrident = new ItemConstructTrident();
        // No Use
        WILLPOWERPISTOL = new ConstructNoUse(will +"Pistol");
        WILLPOWERRIFLE = new ConstructNoUse(will +"Rifle");
        WILLPOWERGUITAR = new ConstructSword(will +"Guitar", MEDIUM);
        WILLPOWERTASER = new ConstructNoUse(will +"Taser");
        // Swords
        WILLPOWERCHAINSAW = new ConstructSword(will+"Chainsaw", HIGH);
        WILLPOWERSHIELD = new ConstructSword(will +"Shield", MEDIUM);
        WILLPOWERPAN = new ConstructSword(will +"Pan", MEDIUM);
        WILLPOWERBROADSWORD = new ConstructSword(will +"Broadsword", MEDIUM);
        WILLPOWERKNIFE = new ItemConstructKnife();
        WILLPOWERKUKRI = new ConstructSword(will +"Kukri", MEDIUM);
        WILLPOWERSPEAR = new ConstructSword(will +"Spear", LOW);
        WILLPOWERSCYTHE = new ConstructSword(will +"Scythe", LOW);
        WILLPOWERGOLFCLUB = new ConstructSword(will +"GolfClub", LOWER);
        WILLPOWERCROWBAR = new ConstructSword(will +"Crowbar", LOW);
        WILLPOWERMACE = new ConstructSword(will +"Mace", HIGH);
        WILLPOWERMACHETE = new ConstructSword(will +"Machete", HIGH);
        WILLPOWERLIGHTSABER = new ConstructSword(will +"Lightsaber", HIGH);
        WILLPOWERBASEBALLBAT = new ConstructSword(will +"Baseballbat", MEDIUM);
        WILLPOWERPADDLE = new ConstructSword(will +"Paddle", LOW);
        WILLPOWERWRENCH = new ConstructSword(will +"Wrench", LOW);
        WILLPOWERBATTLEAXE = new ConstructAxe(will +"Battleaxe", HIGH);
        // Other
        WILLPOWERSHOVEL = new ConstructShovel(will+"Shovel", TMEDIUM);
        WILLPOWERHAMMER = new ConstructPickaxe(will +"Hammer", TMEDIUM);
        WILLPOWERAXE = new ConstructAxe(will +"Axe", TMEDIUM);
        WILLPOWERFLINTANDSTEEL = new ConstructLighter(will +"FlintandSteel");
        WILLPOWERHATCHET = new ConstructAxe(will +"Hatchet", TLOW);
        WILLPOWERLIGHTER = new ConstructLighter(will +"Lighter");
        WILLPOWERPICK = new ConstructPickaxe(will +"Pickaxe", THIGH);
        WILLPOWERSHEARS = new ConstructShear(will +"Shears");
        WILLPOWERSTEAK = new ConstructFood(will +"Steak", 3, 1.0f, true);
        ItemRegistry.registerItem(testDummy, "testDummy");
        ItemRegistry.registerItem(lasso, "ww_lasso");
        ItemRegistry.registerItem(willRing, "will_ring");
        ItemRegistry.registerIngot(kryptonite, "Kryptonite", "ingotKryptonite");
        ItemRegistry.registerItem(wonderWomanSword, "wonderWomanSword");
        ItemRegistry.registerItem(deathstrokesSword, "DeathstrokesSword");
        GameRegistry.registerItem(WILLPOWERBROADSWORD,will + "Broadsword");
        GameRegistry.registerItem(willKatana,will + "Katana");
        GameRegistry.registerItem(WILLPOWERKNIFE,will + "Knife");
        GameRegistry.registerItem(WILLPOWERKUKRI,will + "Kukri");
        GameRegistry.registerItem(WILLPOWERSPEAR,will + "Spear");
        GameRegistry.registerItem(WILLPOWERSCYTHE,will + "Scythe");
        GameRegistry.registerItem(WILLPOWERGOLFCLUB,will + "Golfclub");
        GameRegistry.registerItem(WILLPOWERCROWBAR,will + "Crowbar");
        GameRegistry.registerItem(WILLPOWERMACHETE,will + "Machete");
        GameRegistry.registerItem(WILLPOWERMACE,will + "Mace");
        GameRegistry.registerItem(WILLPOWERLIGHTSABER,will + "Lightsaber");
        GameRegistry.registerItem(WILLPOWERBASEBALLBAT,will + "BaseballBat");
        GameRegistry.registerItem(WILLPOWERPADDLE,will + "Paddle");
        GameRegistry.registerItem(WILLPOWERWRENCH,will + "Wrench");
        GameRegistry.registerItem(willTrident, will + "Trident");
        GameRegistry.registerItem(WILLPOWERAXE, will + "Axe");
        GameRegistry.registerItem(WILLPOWERFLINTANDSTEEL, will + "Flintandsteel");
        GameRegistry.registerItem(WILLPOWERHATCHET, will + "Hatchet");
        GameRegistry.registerItem(WILLPOWERLIGHTER, will + "Lighter");
        GameRegistry.registerItem(WILLPOWERPICK, will + "Pick");
        GameRegistry.registerItem(WILLPOWERSHEARS, will + "Shears");
        GameRegistry.registerItem(WILLPOWERSTEAK, will + "Steak");
        GameRegistry.registerItem(WILLPOWERHAMMER, will + "Hammer");
        GameRegistry.registerItem(WILLPOWERGUITAR, will+"Guitar");
        GameRegistry.registerItem(WILLPOWERSHIELD, will+"Shield");
        GameRegistry.registerItem(WILLPOWERPAN, will+"Pan");
        GameRegistry.registerItem(WILLPOWERBATTLEAXE, will+"Battleaxe");
        GameRegistry.registerItem(WILLPOWERPISTOL, will+"Pistol");
        GameRegistry.registerItem(WILLPOWERRIFLE, will+"Rifle");
        GameRegistry.registerItem(WILLPOWERTASER, will+"Taser");
        GameRegistry.registerItem(WILLPOWERCHAINSAW, will+"Chainsaw");
        GameRegistry.registerItem(WILLPOWERSHOVEL, will+"Shovel");
    }

    public static final CreativeTabs tabJusticeMC = new CreativeTabs("tabJusticeMC") {
        @Override
        public Item getTabIconItem() {
            return ModItems.willRing;
        }
    };

    public ModItems() {
    }
}