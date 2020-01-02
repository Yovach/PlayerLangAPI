package fr.yovach.lang.data;

import fr.yovach.lang.ICraftLang;
import fr.yovach.lang.PlayerLangAPI;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;

import java.util.Arrays;

public enum EnchantmentLang implements ICraftLang<Enchantment> {
    PROTECTION_FIRE("fire_protection"),
    DAMAGE_ALL("sharpness"),
    ARROW_FIRE("flame"),
    WATER_WORKER("aqua_affinity"),
    ARROW_KNOCKBACK("punch"),
    LOYALTY("loyalty"),
    DEPTH_STRIDER("depth_strider"),
    VANISHING_CURSE("vanishing_curse"),
    DURABILITY("unbreaking"),
    KNOCKBACK("knockback"),
    LUCK("luck_of_the_sea"),
    BINDING_CURSE("binding_curse"),
    LOOT_BONUS_BLOCKS("fortune"),
    PROTECTION_ENVIRONMENTAL("protection"),
    DIG_SPEED("efficiency"),
    MENDING("mending"),
    FROST_WALKER("frost_walker"),
    LURE("lure"),
    LOOT_BONUS_MOBS("looting"),
    PIERCING("piercing"),
    PROTECTION_EXPLOSIONS("blast_protection"),
    DAMAGE_UNDEAD("smite"),
    MULTISHOT("multishot"),
    FIRE_ASPECT("fire_aspect"),
    CHANNELING("channeling"),
    SWEEPING_EDGE("sweeping"),
    THORNS("thorns"),
    DAMAGE_ARTHROPODS("bane_of_arthropods"),
    OXYGEN("respiration"),
    RIPTIDE("riptide"),
    SILK_TOUCH("silk_touch"),
    QUICK_CHARGE("quick_charge"),
    PROTECTION_PROJECTILE("projectile_protection"),
    IMPALING("impaling"),
    PROTECTION_FALL("feather_falling"),
    ARROW_DAMAGE("power"),
    ARROW_INFINITE("infinity");

    private final String type = "enchantment";
    private final String translation;

    EnchantmentLang(final String translation) {
        this.translation = translation;
    }

    @Override public String getTranslation() {
        return getTranslation(Bukkit.getBukkitVersion());
    }

    @Override public String getTranslation(String version) {
        return String.join(".", Arrays.asList(type, "minecraft", translation));
    }

    @Override public Enchantment get() {
        final Enchantment value = Enchantment.getByKey(NamespacedKey.minecraft(this.translation));
        Validate.notNull(value, PlayerLangAPI.NOT_SUPPORTED);
        return value;
    }
}
