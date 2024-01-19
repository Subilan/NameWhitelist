package cc.seati.NameWhitelist.fabric;

import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
    @Override
    public void onInitialize() {
        cc.seati.NameWhitelist.Main.init();
    }
}
