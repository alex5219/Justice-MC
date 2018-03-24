package awex.heroes.common.entity;

import awex.heroes.HeroesUnited;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;

public class ModEntities {
    private static int nextID = -1;

    public ModEntities() {
    }

    public static void register() {
        registerEntity(EntityVibeWave.class, "VibeWave", 64, 10, true);
    }

    private static void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange, int updateFrequency, boolean sendVelocityUpdates) {
        EntityRegistry.registerModEntity(entityClass, name, ++nextID, HeroesUnited.instance, trackingRange, updateFrequency, sendVelocityUpdates);
    }
}

