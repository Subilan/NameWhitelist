package cc.seati.NameWhitelist.forge;

import me.shedaniel.architectury.platform.forge.EventBuses;
import cc.seati.NameWhitelist.Main;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MOD_ID)
public class ExampleModForge {
    public ExampleModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Main.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Main.init();
    }
}
