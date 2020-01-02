package fr.yovach.lang.data;

import fr.yovach.lang.ICraftLang;
import org.bukkit.Bukkit;
import org.bukkit.Color;

import java.util.Arrays;

public enum ColorLang implements ICraftLang<Color> {
    BLACK(),
    BLUE(),
    BROWN(),
    CYAN(),
    GRAY(),
    GREEN(),
    LIGHT_BLUE(),
    LIGHT_GRAY(),
    LIME(),
    MAGENTA(),
    ORANGE(),
    PINK(),
    PURPLE(),
    RED(),
    WHITE(),
    YELLOW(),
    ;

    private final String type = "color";

    @Override public String getTranslation() {
        return getTranslation(Bukkit.getBukkitVersion());
    }

    @Override public String getTranslation(String version) {
        return String.join(".", Arrays.asList(type, "minecraft", this.name().toLowerCase()));
    }

    /**
     * Don't use this method, it is useless
     *
     * @return null
     */
    @Override public Color get() {
        return null;
    }
}
