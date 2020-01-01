###What is PlayerLangAPI ?

PlayerLangAPI is a library enables developpers to use translations on client side dynamically.

This plugin is only compatible with 1.13+ versions (until Mojang changes languages format)

I haven't tested in 1.13.x and 1.14.x but I think it should work because the format of lang hasn't been updated since 1.13


###Why use this library?
Usually several plugins use stored object names without taking into account the client's translation or the object name is fixed and if the client changes language, he will always see the old name.

This plugin in the form of a library gives you the possibility to use the languages used by the client. However, you will have to master the "TranslatableComponent" (see https://www.spigotmc.org/wiki/the-chat-component-api/#basics)

###How use it  ?
Currently, it's rather difficult to use since I don't have a Maven directory, but I'll find out more about that in a few days.
You can however use the library by compiling it and using the local repository.


###Usage

If you want to send the name of the stone sword according to the player's language (null example but it is an example) :
```
final TranslatableComponent component = new TranslatableComponent(MaterialLang.STONE_SWORD.getTranslation());
player.sendMessage(component);
```
This will send "Stone sword" for a player whose language of play is English and "Espada de piedre" for a Spanish player.

**NOTE :** When I started to create the plugin, I hadn't noticed that there was a plugin similar to this one but that only supports 1.7-1.12 versions. (https://www.spigotmc.org/resources/1-7-x-1-12-language-utils.8859/)


If you have any suggestions, don't hesitate to tell me!
