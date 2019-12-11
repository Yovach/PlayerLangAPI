package fr.yovach.playerlangapi;

import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerLangAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(MaterialLang.ACACIA_BOAT.getTranslationId());
    }

    @Override
    public void onDisable() {
    }
}
