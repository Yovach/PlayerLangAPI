### What is PlayerLangAPI ?

PlayerLangAPI is a library enables developpers to use translations on client side dynamically.

This plugin is only compatible with 1.13+ versions (until Mojang changes languages format)

I haven't tested in 1.13.x and 1.14.x but I think it should work because the format of lang hasn't been updated since 1.13


### Why use this library?
Usually several plugins use stored object names without taking into account the client's translation or the object name is fixed and if the client changes language, he will always see the old name.

This plugin in the form of a library gives you the possibility to use the languages used by the client. However, you will have to master the "TranslatableComponent" (see https://www.spigotmc.org/wiki/the-chat-component-api/#basics)

### How use it  ?

##### Maven repository

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

##### Maven dependency


```xml
<dependency>
    <groupId>com.github.Yovach</groupId>
    <artifactId>PlayerLangAPI</artifactId>
    <version>0.3</version>
</dependency>
```


##### Plugins folder
Place the plugin (.jar) in "./plugins/" folder


### Usage

If you want to send the name of the stone sword according to the player's language (null example but it is an example) :
```
final TranslatableComponent component = new TranslatableComponent(MaterialLang.STONE_SWORD.getTranslation());
player.sendMessage(component);
```
This will send "Stone sword" for a player whose language of play is English and "Espada de piedre" for a Spanish player.

Translatable component into a sentence :
```
/* Our text component (a sentence for example) */
final TextComponent text = new TextComponent("Please use your ");

/* Our component which will be translated by client */
final TranslatableComponent translatableDiamond = new TranslatableComponent(MaterialLang.DIAMOND.getTranslation());

text.addExtra(translatableDiamond);

/* We can put a color on the translated component :) */
translatableDiamond.setColor(net.md_5.bungee.api.ChatColor.GOLD);


player.sendMessage(text);
```

Retrieve a class from the API (EnchantmentLang -> Enchantment, MaterialLang -> Material) :
```
final Enchantment enchantment = EnchantmentLang.DAMAGE_ALL.get();
final Material material = MaterialLang.DIAMOND.get();
```

Add a translatable display name on a ItemStack (**requires [NBTAPI](https://www.spigotmc.org/resources/nbt-api.7939/)**) :
```
// We check if the PlayerLangAPI is enabled on the server
if(Bukkit.getPluginManager().isPluginEnabled("PlayerLangAPI")) {
    // Get the instance of plugin
    final PlayerLangAPI langAPI = (PlayerLangAPI) Bukkit.getPluginManager().getPlugin("PlayerLangAPI");
    Validate.notNull(langAPI, "PlayerLangAPI is disabled!");
    // We check if NBTAPI plugin is enabled on the server.
    if(langAPI.hasNBTAPI()) {
        /* Creation of a new ItemStack */
        final ItemStack itemStack = new ItemStack(MaterialLang.DIAMOND.get());

        /* We put properties of display */
        final JsonObject gson = new JsonObject();
        gson.addProperty("translate", MaterialLang.STONE_SWORD.getTranslation());
        gson.addProperty("color", "red");
        gson.addProperty("italic", "false");

        /* We finally add itemstack into inventory of player */
        player.getInventory().addItem(langAPI.setDisplay(itemStack, gson));
    }
}
```

**NOTE :** When I started to create the plugin, I hadn't noticed that there was a plugin similar to this one but that only supports 1.7-1.12 versions. (https://www.spigotmc.org/resources/1-7-x-1-12-language-utils.8859/)

Screenshots are provided on the SpigotMC page of the plugin!
If you have any suggestions, don't hesitate to tell me!

SpigotMC page: https://www.spigotmc.org/resources/playerlangapi.73932/
