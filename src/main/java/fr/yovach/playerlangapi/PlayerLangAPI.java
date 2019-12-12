package fr.yovach.playerlangapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class PlayerLangAPI extends JavaPlugin {

    public /*static*/ final Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void onEnable() {
        getLogger().info(MaterialLang.values().length + " translations of materials are loaded.");

        HashMap<String, String> colours = new HashMap<>();

        try {
            readJSON("assets/minecraft/lang/en_us.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readJSON(String path) throws IOException {
        InputStream istream = getResource(path);

        assert istream != null;
        final BufferedReader reader = new BufferedReader(new InputStreamReader(istream));
        final Gson gson = new Gson();
        final JsonObject json = gson.fromJson(reader, JsonObject.class);
        reader.close();

        System.out.println("Size : " + json.entrySet().size());

        final JsonObject result = new JsonObject();
        for (Map.Entry<String, JsonElement> consumer : json.entrySet()) {
            final String key = consumer.getKey();
            // System.out.println(key);
            // final String value = consumer.getValue().getAsString();
            final String[] chunks = key.split("\\.");
            if (chunks.length == 3) {
                // {type}.minecraft.{name}.{?..properties} | without properties, length = 3 else > 3
                if (chunks[0].equalsIgnoreCase("block")) {

                } else if (chunks[0].equalsIgnoreCase("item")) {
                    if (!chunks[1].equalsIgnoreCase("minecraft")) {
                        continue;
                    }
                } else {
                    continue;
                }
                final String materialName = Arrays.copyOfRange(chunks, 2, 3)[0];
                // getLogger().info(res[0]);
                // result.addProperty(chunks.sp);
                result.addProperty(materialName.toUpperCase(), key);
                // getLogger().info(key + " *> " + materialName + " => " + value);
                // getLogger().info(materialName.toUpperCase() + " => " + key);
            }

        }
        getLogger().info(result.toString());
        gson.toJson(result, new FileWriter(getDataFolder() + "/tessts.json"));
        // getLogger().info(json.toString());
    }

    public String[] spliceChunks(String[] chunks, int start, int end) {
        final String[] res = chunks.clone();
        int t = 0;
        for (int i = 0; i < res.length; i++) {
            if (i > start && i < end) {
                res[t] = chunks[i];
                t++;
            }
        }
        return res;
    }

    @Override
    public void onDisable() {
    }
}
