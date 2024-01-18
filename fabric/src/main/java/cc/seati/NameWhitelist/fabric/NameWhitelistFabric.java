package cc.seati.NameWhitelist.fabric;

import cc.seati.NameWhitelist.Main;
import net.fabricmc.api.ModInitializer;

public class NameWhitelistFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Main.init();
    }
}
