package cc.seati.NameWhitelist.Commands;

import cc.seati.NameWhitelist.WhitelistFile;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TextComponent;

public class AddCommand {
    public static int exec(CommandSourceStack source, String name) throws CommandSyntaxException {
        if (WhitelistFile.containsName(name)) {
            source.sendFailure(new TextComponent(name + " is already in name whitelist"));
            return 0;
        }
        WhitelistFile.addPlayer(name);
        source.sendSuccess(new TextComponent("Added " + name + " to name whitelist."), false);
        return 1;
    }
}
