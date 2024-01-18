package cc.seati.NameWhitelist.Commands;

import cc.seati.NameWhitelist.WhitelistFile;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TextComponent;

public class RemoveCommand {
    public static int exec(CommandSourceStack source, String name) throws CommandSyntaxException {
        if (!WhitelistFile.containsName(name)) {
            source.sendFailure(new TextComponent(name + " is not in name whitelist"));
            return 0;
        }
        WhitelistFile.removePlayer(name);
        source.sendSuccess(new TextComponent("Removed " + name + " from name whitelist."), false);
        return 1;
    }
}
