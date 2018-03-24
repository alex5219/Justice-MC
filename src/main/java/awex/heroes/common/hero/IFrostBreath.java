package awex.heroes.common.hero;

import fiskfille.heroes.common.hero.IAbility;
import fiskfille.heroes.common.keybinds.KeyBindTranslator;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IFrostBreath extends IAbility {
    @KeyBindTranslator.TranslatedKeyBind(
            key = "key.frostBreath"
    )
    SHKeyBinding getFrostBreathKey();
}
