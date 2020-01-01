package fr.yovach.lang.data;

import fr.yovach.lang.ICraftLang;
import org.bukkit.Color;

import java.util.Arrays;

public enum ColorLang implements ICraftLang<Color> {
    BLACK("black"),
    BLUE("blue"),
    BROWN("brown"),
    CYAN("cyan"),
    GRAY("gray"),
    GREEN("green"),
    LIGHT_BLUE("light_blue"),
    LIGHT_GRAY("light_gray"),
    LIME("lime"),
    MAGENTA("magenta"),
    ORANGE("orange"),
    PINK("pink"),
    PURPLE("purple"),
    RED("red"),
    WHITE("white"),
    YELLOW("yellow"),
    ;

    private final String translation;

    ColorLang(final String translation) {
        this.translation = translation;
    }

    @Override public String getTranslation() {
        final String type = "color";
        return String.join(".", Arrays.asList(type, "minecraft", translation));
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
