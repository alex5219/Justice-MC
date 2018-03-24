package awex.heroes.common.entity;

import awex.heroes.common.ability.AbilityManager;
import fiskfille.heroes.common.data.SHData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;

import java.util.UUID;

import static fiskfille.heroes.common.entity.attribute.SHAttributes.applyModifier;

public class ModAttributes {
    private static final UUID UUID_HEALTH_MOD = UUID.randomUUID();

    public static void applyModifiers(EntityPlayer player) {
        IAttributeInstance healthAttribute = player.getEntityAttribute(SharedMonsterAttributes.maxHealth);
        if ((Float) SHData.SCALE.get(player) > 1.0F) {
            if(AbilityManager.SUPER_STRENGTH.isActive(player)){
                applyModifier(healthAttribute, UUID_HEALTH_MOD, (double)((Float)SHData.SCALE.get(player) + 1.0F), 1);
            }
        }

    }
}
