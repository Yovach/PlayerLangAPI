package fr.yovach.lang;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.lang.Validate;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Map;

public final class PlayerLangAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(MaterialLang.values().length + " translations of materials are loaded.");

       try {
            readJSON("assets/minecraft/lang/en_us.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readJSON(String path) throws IOException {
        final InputStream stream = getResource(path);

        final File file = new File(getDataFolder(), "lang.json");
        if(!file.exists()){
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Validate.notNull(stream, "stream cannot be null");
        final BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final JsonObject json = gson.fromJson(reader, JsonObject.class);
        reader.close();

        final JsonObject result = new JsonObject();
        for (Map.Entry<String, JsonElement> consumer : json.entrySet()) {
            final String key = consumer.getKey();
            final String[] chunks = key.split("\\.");
            if (chunks.length == 3) {
                // {type}.minecraft.{name}.{?..properties} | without properties, length = 3 else > 3
                if (chunks[0].equalsIgnoreCase("item")) {
                    if (!chunks[1].equalsIgnoreCase("minecraft")) {
                        continue;
                    }
                } else if (!chunks[0].equalsIgnoreCase("block")){
                    continue;
                }
                final String materialName = Arrays.copyOfRange(chunks, 2, 3)[0].toUpperCase();
                result.addProperty(materialName, key);
            }

        }
        final String content = gson.toJson(result);
        file.delete();
        Files.write(file.toPath(), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    }

    @Override
    public void onDisable() {
    }
}
