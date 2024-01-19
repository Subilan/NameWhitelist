package cc.seati.NameWhitelist.forge;

import me.shedaniel.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(cc.seati.NameWhitelist.Main.MOD_ID)
public class Main {
    public Main() {
        EventBuses.registerModEventBus(cc.seati.NameWhitelist.Main.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        cc.seati.NameWhitelist.Main.init();
    }
}
