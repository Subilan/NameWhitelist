# NameWhitelist

**NameWhitelist** is the _super-simplified_ version of the vanilla whitelist. It checks if the name of the player who trying to join the server is on the list, and forcefully disconnect (like _kick_, or something) players not listed actively.

## Usage

### For the First Time (Installation)

1. Put NameWhitelist and Architectury API jar file into `mods/`.
2. Edit `server.properties`, turn the vanilla whitelist off. This is not required. Yoo can leave it on if you have some _special_ purpose ;)
3. (Re)start server, ***OR***, manually create a file named `name-whitelist.txt` in the same directory as the vanilla whitelist, put the names in it, and (re)start the server.

If NameWhitelist is enabled, players with names that are not listed in `name-whitelist.txt` will be actively disconnected once joined in the server. Theorectically, they won't even be able to see the appearance of the world.

### For the Last Time (Turning Off)

Three ways.
- A) Remove NameWhitelist jar file from `mods/`. Restart the server.
- B) Put "#disabled" in the first line of `name-whitelist.txt`. Execute `nwl reload`.
- C) Execute `wl disable` in game or console.

### Commands

Commands start with `nwl` (name white list).

- `nwl add <PlayerNames...>` - Add player names to `name-whitelist.txt`. The names are separated by space ` `. Case insensitive.
- `nwl remove <PlayerNames...>` - Remove player names from  `name-whitelist.txt`. The names are separated by space ` `. Case insensitive.
- `nwl reload` - Reload. Read conteng of `name-whitelist.txt` again.
- `nwl disable` - Disable whitelist.
- `nwl enable` - Enable whitelist.

## Reason

It's known that the vanilla whitelist records both players' name and UUID, which may work perfectly on server with `online-mode` set to `true`. But things would get tricky when it comes to offline servers. The whole thing might not work at all.

NameWhitelist provides a solution for those who want to keep their server offline and are still in need of this kind of "auto rejecting strangers who are not in the list" thing. Also it helps admins who hate the vanilla whitelist for whatever reason (inconvenience of updating, high latency when adding/removing players, no bulk action available, online requirement, etc.) to get rid of it.

> [!IMPORTANT]
> For offline servers, there is one more thing that requires your attention. 
> 
> Since player can choose whatever they want to be their name used to join the server through offline launchers, **identification** is a must to ensure the safety of player's data. Consider using [SimpleLogin](https://www.curseforge.com/minecraft/mc-mods/simple-login) to give each user a unique password, stored on player's own PC and encrypted on the server.

## Highlights and Cautions

Some highlights of NameWhitelist includes:
- Totally based on simple string things. Simple, no plot, crystal clear. *CASE-INSENSITIVE*.
- Takes effect instantly. I mean, there can't be a reason for some string process to drag, right?
- Open source, thus extensible. As you can see, the code is quite simple, thanks to Architectury API. If something is in your mind, like "auto fetching the UUID from MOJANG server and write it into the file", just fork the repo, make your modification, and get your own tailored (by yourself) whitelist system!

> [!CAUTION]
> Most importantly, as the list is static and no UUID information is recorded, the names will **NOT** be updated automatically after player changed his/her name. So manually removing the old name and adding the new name is required when something like this happens.
>
> What NameWhitelist maintain is just a simple plain text file filled with the names of players, separated by returns `\n`. For now, it won't check the validity of the names (this does not hurt though, as the whitelist only plays when some player with of course valid username is trying to join the server), either.

## Version & Dependency

- Java 1.16.5+
  - Both Forge and Fabric is supported (the full release will come out before Jan 22, 2024)
- Dependency: [Architectury API](https://www.curseforge.com/minecraft/mc-mods/architectury-api)

## License
MIT
