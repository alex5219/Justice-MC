package awex.heroes.client.render.hero;

import awex.heroes.common.hero.HeroRegistry;
import fiskfille.heroes.client.model.ModelCaped;
import fiskfille.heroes.client.model.ModelFemale;
import fiskfille.heroes.client.render.hero.HeroRenderer;
import fiskfille.heroes.client.render.hero.HeroRendererBase;
import fiskfille.heroes.common.hero.HeroManager;

public class RendererManager {
    public RendererManager() {
    }

    public static void register() {
        HeroRenderer.register(HeroRegistry.HAL_JORDAN, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.HAL_JORDAN_HAIR, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.JOHN_STEWART, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.JESSICA_CRUZ, new HeroRendererBase(new ModelFemale(1.0F, 1.0F)));
        HeroRenderer.register(HeroRegistry.GREEN_LANTERN, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.KILOWOG, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.SUPERMAN, new HeroRendererBase(new ModelCaped(22)));
        HeroRenderer.register(HeroRegistry.BATMAN, new HeroRendererBase(new ModelCaped(24)));
        HeroRenderer.register(HeroRegistry.WONDER_WOMAN, new HeroRendererBase(new ModelFemale(1.0F, 1.0F)));
        HeroRenderer.register(HeroRegistry.GREEN_ARROW_COMICS, new HeroRendererBase());
        HeroRenderer.register(HeroManager.GREEN_ARROW, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.BLACK_CANARY_COMICS, new HeroRendererBase(new ModelFemale(1.0F, 1.0F)));
        HeroRenderer.register(HeroRegistry.VIBE, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.THE_QUESTION, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.CYBORG, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.SHAZAM, new HeroRendererBase(new ModelCaped(24)));
        HeroRenderer.register(HeroRegistry.ROBIN, new HeroRendererBase(new ModelCaped(24)));
        HeroRenderer.register(HeroRegistry.AQUAMAN, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.LEX_LUTHOR, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.DARKSEID, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.DOOMSDAY, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.DEATHSTROKE, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.GRUNDY, new HeroRendererBase());
        HeroRenderer.register(HeroRegistry.JOKER, new HeroRendererBase());
    }
}
