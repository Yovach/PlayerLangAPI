package fr.yovach.lang.data;

import fr.yovach.lang.ICraftLang;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

public enum PotionEffectTypeLang implements ICraftLang<PotionEffectType> {
    ABSORPTION("absorption"),
    BAD_OMEN("bad_omen"),
    BLINDNESS("blindness"),
    CONDUIT_POWER("conduit_power"),
    DOLPHINS_GRACE("dolphins_grace"),
    FIRE_RESISTANCE("fire_resistance"),
    GLOWING("glowing"),
    HASTE("haste"),
    HEALTH_BOOST("health_boost"),
    HERO_OF_THE_VILLAGE("hero_of_the_village"),
    HUNGER("hunger"),
    INSTANT_DAMAGE("instant_damage"),
    INSTANT_HEALTH("instant_health"),
    INVISIBILITY("invisibility"),
    JUMP_BOOST("jump_boost"),
    LEVITATION("levitation"),
    LUCK("luck"),
    MINING_FATIGUE("mining_fatigue"),
    NAUSEA("nausea"),
    NIGHT_VISION("night_vision"),
    POISON("poison"),
    REGENERATION("regeneration"),
    RESISTANCE("resistance"),
    SATURATION("saturation"),
    SLOWNESS("slowness"),
    SLOW_FALLING("slow_falling"),
    SPEED("speed"),
    STRENGTH("strength"),
    UNLUCK("unluck"),
    WATER_BREATHING("water_breathing"),
    WEAKNESS("weakness"),
    WITHER("wither"),
    ;

    private final String translation;

    PotionEffectTypeLang(final String translation) {
        this.translation = translation;
    }

    @Override public String getTranslation() {
        final String type = "effect";
        return String.join(".", Arrays.asList(type, "minecraft", translation));
    }
}
