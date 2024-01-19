package cc.seati.NameWhitelist.Commands;

import cc.seati.NameWhitelist.WhitelistFile;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TextComponent;

public class DisableCommand {
    public static int exec(CommandSourceStack source) throws CommandSyntaxException {
        if (WhitelistFile.isDisabled()) {
            source.sendFailure(new TextComponent("The whitelist is already disabled."));
            return 0;
        }
        WhitelistFile.toggleStatus();
        source.sendSuccess(new TextComponent("Successfully disabled the whitelist."), false);
        return 1;
    }
}
