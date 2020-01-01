package fr.yovach.lang;

import com.google.gson.JsonObject;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.IllegalPluginAccessException;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerLangAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        if (!hasNBTAPI()) {
            getLogger().warning("To use the functions concerning the modification of the display of items, you must install the plugin \"NBTAPI\" (from tr7zw).");
        }
    }

    /**
     * @return if NBTAPI plugin is enabled
     */
    public boolean hasNBTAPI() {
        return getServer().getPluginManager().isPluginEnabled("NBTAPI");
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
        final NBTItem nbtItem = new NBTItem(item);
        final NBTCompound compound = nbtItem.addCompound("display");
        compound.setString("Name", object.toString());
        return nbtItem.getItem();
    }
}
