package cc.seati.NameWhitelist.Commands;

import cc.seati.NameWhitelist.WhitelistFile;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TextComponent;

public class EnableCommand {
    public static int exec(CommandSourceStack source) throws CommandSyntaxException {
        if (!WhitelistFile.isDisabled()) {
            source.sendFailure(new TextComponent("The whitelist is already enabled."));
            return 0;
        }
        WhitelistFile.toggleStatus();
        source.sendSuccess(new TextComponent("Successfully enabled the whitelist."), false);
        return 1;
    }
}
