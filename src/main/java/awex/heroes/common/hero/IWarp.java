package awex.heroes.common.hero;

import fiskfille.heroes.common.hero.IAbility;
import fiskfille.heroes.common.keybinds.KeyBindTranslator;
import fiskfille.heroes.common.keybinds.SHKeyBinding;

public interface IWarp extends IAbility {
    @KeyBindTranslator.TranslatedKeyBind(
            key = "key.warp"
    )
    SHKeyBinding getWarpKey();
}
