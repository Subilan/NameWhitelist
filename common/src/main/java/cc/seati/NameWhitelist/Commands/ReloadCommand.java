package cc.seati.NameWhitelist.Commands;

import cc.seati.NameWhitelist.WhitelistFile;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TextComponent;

public class ReloadCommand {
    public static int exec(CommandSourceStack source) throws CommandSyntaxException {
        WhitelistFile.reload();
        source.sendSuccess(new TextComponent("Successfully reloaded name whitelist."), false);
        return 1;
    }
}
