package awex.heroes.common.hero;

import fiskfille.heroes.common.keybinds.KeyBindTranslator;
import fiskfille.heroes.common.keybinds.SHKeyBinding;

public interface IHalJordan extends fiskfille.heroes.common.hero.IAbility {
    @KeyBindTranslator.TranslatedKeyBind(
            key = "key.energyTwin"
    )
    SHKeyBinding getTwinModeKey();
}