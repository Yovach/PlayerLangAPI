package fr.yovach.lang.data;

import fr.yovach.lang.ICraftLang;
import fr.yovach.lang.PlayerLangAPI;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

public enum PotionEffectTypeLang implements ICraftLang<PotionEffectType> {
    ABSORPTION(),
    BAD_OMEN(),
    BLINDNESS(),
    CONDUIT_POWER(),
    DOLPHINS_GRACE(),
    FIRE_RESISTANCE(),
    GLOWING(),
    HASTE(),
    HEALTH_BOOST(),
    HERO_OF_THE_VILLAGE(),
    HUNGER(),
    INSTANT_DAMAGE(),
    INSTANT_HEALTH(),
    INVISIBILITY(),
    JUMP_BOOST(),
    LEVITATION(),
    LUCK(),
    MINING_FATIGUE(),
    NAUSEA(),
    NIGHT_VISION(),
    POISON(),
    REGENERATION(),
    RESISTANCE(),
    SATURATION(),
    SLOWNESS(),
    SLOW_FALLING(),
    SPEED(),
    STRENGTH(),
    UNLUCK(),
    WATER_BREATHING(),
    WEAKNESS(),
    WITHER(),
    ;
    private final String type = "effect";

    @Override public String getTranslation() {
        return getTranslation(Bukkit.getVersion());
    }

    @Override public String getTranslation(String version) {
        return String.join(".", Arrays.asList(type, "minecraft", this.name().toLowerCase()));
    }

    @Override public PotionEffectType get() {
        final PotionEffectType value = PotionEffectType.getByName(this.name());
        Validate.notNull(value, PlayerLangAPI.NOT_SUPPORTED);
        return value;
    }
}
