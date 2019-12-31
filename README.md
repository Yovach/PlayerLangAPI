# PlayerLangAPI
A plugin which enables developpers to use translations on client side dynamically (with lang.json)

This plugin is only compatible with 1.13+ versions (until Mojang changes languages format)


# Why ?

Usually several plugins use stored object names without taking into account the client's translation or the object name is fixed and if the client changes language, he will always see the old name.

This plugin in the form of a library gives you the possibility to use the languages used by the client. However, you will have to master the "TranslatableComponent" (see https://www.spigotmc.org/wiki/the-chat-component-api/#basics)

**NOTE :** When I started to create the plugin, I hadn't noticed that there was a plugin similar to this one but that only supports 1.7-1.12 versions. (https://www.spigotmc.org/resources/1-7-x-1-12-language-utils.8859/)
