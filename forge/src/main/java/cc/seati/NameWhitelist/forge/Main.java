package cc.seati.NameWhitelist.forge;

import me.shedaniel.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(cc.seati.NameWhitelist.Main.MOD_ID)
public class Main {
    public Main() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(cc.seati.NameWhitelist.Main.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        cc.seati.NameWhitelist.Main.init();
    }
}
