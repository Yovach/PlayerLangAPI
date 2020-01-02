package fr.yovach.lang;

import com.google.gson.JsonObject;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.IllegalPluginAccessException;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class PlayerLangAPI extends JavaPlugin {

    public static final String NOT_SUPPORTED = "Your server version does not support this feature.";

    /*
        BEFORE 1.13 (TextComponent):
        tellraw, title, books, signs, advancements

        AFTER :
        give, bossbar(?), data (entities, tiles entities, tiles), scoreboard(?)
     */
    @Override
    public void onEnable() {
        final Logger logger = getLogger();
        if (!hasNBTAPI()) {
            logger.warning("To use the functions concerning the modification of the display of items, you must install the plugin \"NBTAPI\" (from tr7zw).");
        }
        if (!isAllSupported()) {
            logger.log(Level.SEVERE, "This version of Minecraft is currently unsupported.");
            /*
            logger.warning("Your server seems to use a version of Minecraft that does not propose the use of \"TextComponent\" on items, entities and blocks.");
            logger.warning("If you wish to use them, please upgrade your server to version 1.13+.");
             */
            Bukkit.getPluginManager().disablePlugin(this);
        }

        new MetricsLite(this);
    }

    /**
     * @param item   ItemStack whose NBT value "display" you want to change
     * @param object JsonObject which contains all properties of your modification
     * @return ItemStack which contains our custom display
     * <p>
     * Please take a look to
     * https://minecraft.gamepedia.com/Tutorials/Command_NBT_tags#Items
     * https://minecraft.gamepedia.com/Commands#Raw_JSON_text
     */
    public ItemStack setDisplay(final ItemStack item, final JsonObject object) {
        if (!hasNBTAPI()) {
            throw new IllegalPluginAccessException("The NBTAPI plugin must be enabled on your server to use this method.");
        }
        if (!isAllSupported()) {
            throw new IllegalPluginAccessException("The server must be in 1.13+");
        }
        final NBTItem nbtItem = new NBTItem(item);
        final NBTCompound compound = nbtItem.addCompound("display");
        compound.setString("Name", object.toString());
        return nbtItem.getItem();
    }

    /**
     * @return if NBTAPI plugin is enabled
     */
    public boolean hasNBTAPI() {
        return getServer().getPluginManager().isPluginEnabled("NBTAPI");
    }

    /**
     * @return Returns the major version of the server (1.8, 1.9, 1.10, etc.)
     */
    private static String getServerVersion() {
        final String ver = Bukkit.getBukkitVersion().split("-")[0];
        final String[] chunks = ver.split("\\.");
        return String.format("%s.%s", chunks[0], chunks[1]);
    }

    /**
     * Shows whether "TextComponent" can be used everywhere and if the lang format is the new
     *
     * @return true if MC version 1.13+
     */
    public static boolean isAllSupported() {
        boolean newFormat = true;
        final String version = getServerVersion();
        switch (version) {
            case "1.8":
            case "1.9":
            case "1.10":
            case "1.11":
            case "1.12":
                newFormat = false;
                break;
        }
        return newFormat;
    }
}
