package fr.yovach.lang.data;

import fr.yovach.lang.ICraftLang;
import fr.yovach.lang.PlayerLangAPI;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;

import java.util.Arrays;

public enum EntityTypeLang implements ICraftLang<EntityType> {
    AREA_EFFECT_CLOUD(),
    ARMOR_STAND(),
    ARROW(),
    BAT(),
    BEE(),
    BLAZE(),
    BOAT(),
    CAT(),
    CAVE_SPIDER(),
    CHEST_MINECART(),
    CHICKEN(),
    COD(),
    COMMAND_BLOCK_MINECART(),
    COW(),
    CREEPER(),
    DOLPHIN(),
    DONKEY(),
    DRAGON_FIREBALL(),
    DROWNED(),
    EGG(),
    ELDER_GUARDIAN(),
    ENDERMAN(),
    ENDERMITE(),
    ENDER_DRAGON(),
    ENDER_PEARL(),
    END_CRYSTAL(),
    EVOKER(),
    EVOKER_FANGS(),
    EXPERIENCE_BOTTLE(),
    EXPERIENCE_ORB(),
    EYE_OF_ENDER(),
    FALLING_BLOCK(),
    FIREBALL(),
    FIREWORK_ROCKET(),
    FISHING_BOBBER(),
    FOX(),
    FURNACE_MINECART(),
    GHAST(),
    GIANT(),
    GUARDIAN(),
    HOPPER_MINECART(),
    HORSE(),
    HUSK(),
    ILLUSIONER(),
    IRON_GOLEM(),
    ITEM(),
    ITEM_FRAME(),
    KILLER_BUNNY(),
    LEASH_KNOT(),
    LIGHTNING_BOLT(),
    LLAMA(),
    LLAMA_SPIT(),
    MAGMA_CUBE(),
    MINECART(),
    MOOSHROOM(),
    MULE(),
    OCELOT(),
    PAINTING(),
    PANDA(),
    PARROT(),
    PHANTOM(),
    PIG(),
    PILLAGER(),
    PLAYER(),
    POLAR_BEAR(),
    POTION(),
    PUFFERFISH(),
    RABBIT(),
    RAVAGER(),
    SALMON(),
    SHEEP(),
    SHULKER(),
    SHULKER_BULLET(),
    SILVERFISH(),
    SKELETON(),
    SKELETON_HORSE(),
    SLIME(),
    SMALL_FIREBALL(),
    SNOWBALL(),
    SNOW_GOLEM(),
    SPAWNER_MINECART(),
    SPECTRAL_ARROW(),
    SPIDER(),
    SQUID(),
    STRAY(),
    TNT(),
    TNT_MINECART(),
    TRADER_LLAMA(),
    TRIDENT(),
    TROPICAL_FISH(),
    TURTLE(),
    VEX(),
    VILLAGER(),
    VINDICATOR(),
    WANDERING_TRADER(),
    WITCH(),
    WITHER(),
    WITHER_SKELETON(),
    WITHER_SKULL(),
    WOLF(),
    ZOMBIE(),
    ZOMBIE_HORSE(),
    ZOMBIE_PIGMAN(),
    ZOMBIE_VILLAGER(),
    ;

    private final String type = "entity";

    @Override public String getTranslation() {
        return getTranslation(Bukkit.getBukkitVersion());
    }

    @Override public String getTranslation(String version) {
        return String.join(".", Arrays.asList(type, "minecraft", this.name().toLowerCase()));
    }

    @Override public EntityType get() {
        final EntityType value = EntityType.valueOf(this.name());
        Validate.notNull(value, PlayerLangAPI.NOT_SUPPORTED);
        return value;
    }
}
