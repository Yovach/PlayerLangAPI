package fr.yovach.lang.data;

import fr.yovach.lang.ICraftLang;
import org.bukkit.entity.EntityType;

import java.util.Arrays;

public enum EntityTypeLang implements ICraftLang<EntityType> {
    AREA_EFFECT_CLOUD("area_effect_cloud"),
    ARMOR_STAND("armor_stand"),
    ARROW("arrow"),
    BAT("bat"),
    BEE("bee"),
    BLAZE("blaze"),
    BOAT("boat"),
    CAT("cat"),
    CAVE_SPIDER("cave_spider"),
    CHEST_MINECART("chest_minecart"),
    CHICKEN("chicken"),
    COD("cod"),
    COMMAND_BLOCK_MINECART("command_block_minecart"),
    COW("cow"),
    CREEPER("creeper"),
    DOLPHIN("dolphin"),
    DONKEY("donkey"),
    DRAGON_FIREBALL("dragon_fireball"),
    DROWNED("drowned"),
    EGG("egg"),
    ELDER_GUARDIAN("elder_guardian"),
    ENDERMAN("enderman"),
    ENDERMITE("endermite"),
    ENDER_DRAGON("ender_dragon"),
    ENDER_PEARL("ender_pearl"),
    END_CRYSTAL("end_crystal"),
    EVOKER("evoker"),
    EVOKER_FANGS("evoker_fangs"),
    EXPERIENCE_BOTTLE("experience_bottle"),
    EXPERIENCE_ORB("experience_orb"),
    EYE_OF_ENDER("eye_of_ender"),
    FALLING_BLOCK("falling_block"),
    FIREBALL("fireball"),
    FIREWORK_ROCKET("firework_rocket"),
    FISHING_BOBBER("fishing_bobber"),
    FOX("fox"),
    FURNACE_MINECART("furnace_minecart"),
    GHAST("ghast"),
    GIANT("giant"),
    GUARDIAN("guardian"),
    HOPPER_MINECART("hopper_minecart"),
    HORSE("horse"),
    HUSK("husk"),
    ILLUSIONER("illusioner"),
    IRON_GOLEM("iron_golem"),
    ITEM("item"),
    ITEM_FRAME("item_frame"),
    KILLER_BUNNY("killer_bunny"),
    LEASH_KNOT("leash_knot"),
    LIGHTNING_BOLT("lightning_bolt"),
    LLAMA("llama"),
    LLAMA_SPIT("llama_spit"),
    MAGMA_CUBE("magma_cube"),
    MINECART("minecart"),
    MOOSHROOM("mooshroom"),
    MULE("mule"),
    OCELOT("ocelot"),
    PAINTING("painting"),
    PANDA("panda"),
    PARROT("parrot"),
    PHANTOM("phantom"),
    PIG("pig"),
    PILLAGER("pillager"),
    PLAYER("player"),
    POLAR_BEAR("polar_bear"),
    POTION("potion"),
    PUFFERFISH("pufferfish"),
    RABBIT("rabbit"),
    RAVAGER("ravager"),
    SALMON("salmon"),
    SHEEP("sheep"),
    SHULKER("shulker"),
    SHULKER_BULLET("shulker_bullet"),
    SILVERFISH("silverfish"),
    SKELETON("skeleton"),
    SKELETON_HORSE("skeleton_horse"),
    SLIME("slime"),
    SMALL_FIREBALL("small_fireball"),
    SNOWBALL("snowball"),
    SNOW_GOLEM("snow_golem"),
    SPAWNER_MINECART("spawner_minecart"),
    SPECTRAL_ARROW("spectral_arrow"),
    SPIDER("spider"),
    SQUID("squid"),
    STRAY("stray"),
    TNT("tnt"),
    TNT_MINECART("tnt_minecart"),
    TRADER_LLAMA("trader_llama"),
    TRIDENT("trident"),
    TROPICAL_FISH("tropical_fish"),
    TURTLE("turtle"),
    VEX("vex"),
    VILLAGER("villager"),
    VINDICATOR("vindicator"),
    WANDERING_TRADER("wandering_trader"),
    WITCH("witch"),
    WITHER("wither"),
    WITHER_SKELETON("wither_skeleton"),
    WITHER_SKULL("wither_skull"),
    WOLF("wolf"),
    ZOMBIE("zombie"),
    ZOMBIE_HORSE("zombie_horse"),
    ZOMBIE_PIGMAN("zombie_pigman"),
    ZOMBIE_VILLAGER("zombie_villager"),
    ;

    private final String translation;

    EntityTypeLang(final String translation) {
        this.translation = translation;
    }

    @Override public String getTranslation() {
        final String type = "entity";
        return String.join(".", Arrays.asList(type, "minecraft", translation));
    }

    @Override public EntityType get() {
        return EntityType.valueOf(this.name());
    }
}
