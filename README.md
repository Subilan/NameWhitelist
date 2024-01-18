# NameWhitelist

**Name Whitelist** is the _super-simplified_ version of the vanilla whitelist. It checks if the name of the player who trying to join the server is on the list, and forcefully disconnect (like _kick_, or something) players not listed actively.

## Reason

It's known that the vanilla whitelist records both players' name and UUID, which may work perfectly on server with `online-mode` set to `true`. But things would get tricky when it comes to offline servers. The whole thing might not work at all.

NameWhitelist provides a solution for those who want to keep their server offline and are still in need of this kind of "auto rejecting strangers who are not in the list" thing. Also it also helps admins who hate the vanilla whitelist for whatever reason (inconvenience of updating, high latency when adding/removing players, no bulk action available, etc.) to get rid of it.

> [!NOTE]
> For offline servers, there is one more thing that requires your attention. 
> 
> Since player can choose whatever they want to be their name used to join the server through offline launchers, **identification** is a must to ensure the safety of player's data. Consider using [SimpleLogin](https://www.curseforge.com/minecraft/mc-mods/simple-login) to give each user a unique password, stored on player's own PC and encrypted on the server.

## Version & Dependency

- Java 1.16.5+
  - Both Forge and Fabric is supported (the full release will come out before Jan 22, 2024)
- Dependency: [Architectury API](https://www.curseforge.com/minecraft/mc-mods/architectury-api)

## License
MIT
