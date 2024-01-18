package cc.seati.NameWhitelist;

import cc.seati.NameWhitelist.Commands.CommandManager;
import me.shedaniel.architectury.event.events.CommandRegistrationEvent;
import me.shedaniel.architectury.event.events.PlayerEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static final String MOD_ID = "namewhitelist";
    public static final Logger LOGGER = LogManager.getLogger("NameWhitelist");
    public static void init() {
        WhitelistFile.init();
        CommandRegistrationEvent.EVENT.register(CommandManager::register);
        PlayerEvent.PLAYER_JOIN.register(Events::handlePlayerJoin);
    }
}
