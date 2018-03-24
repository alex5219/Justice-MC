package awex.heroes.client.gui;

import awex.heroes.HeroesUnited;
import awex.heroes.common.network.MessageGiveTool;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;

@SideOnly(Side.CLIENT)
public class GuiConstruct extends GuiPickTool
{
    public GuiConstruct()
    {
        super(I18n.format("gui.construct"));
    }

    @Override
    public void onDone(String finalName) {
        if (finalName != null && !finalName.isEmpty())
        {
            if (GuiPickTool.recentlyUsed.contains(finalName))
            {
                GuiPickTool.recentlyUsed.remove(finalName);
            }

            GuiPickTool.recentlyUsed.add(finalName);

            if (GuiPickTool.recentlyUsed.size() > 10)
            {
                GuiPickTool.recentlyUsed.remove(0);
            }
            if(!finalName.equalsIgnoreCase(null)){
                HeroesUnited.packetHandler.sendToServer(new MessageGiveTool(finalName));
            }
        }
    }
}
