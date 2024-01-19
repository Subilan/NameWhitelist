package cc.seati.NameWhitelist;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;

public class Events {
    public static void handlePlayerJoin(ServerPlayer serverPlayer) {
        if (WhitelistFile.isDisabled()) return;
        if (!WhitelistFile.containsName(serverPlayer.getName().getString())) {
            serverPlayer.connection.disconnect(new TextComponent("You're not whitelisted on this server!"));
        }
    }
}
