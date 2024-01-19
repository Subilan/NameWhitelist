package cc.seati.NameWhitelist.Commands;

import cc.seati.NameWhitelist.WhitelistFile;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TextComponent;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveCommand {
    public static int exec(CommandSourceStack source, String names) throws CommandSyntaxException {
        String[] nameList = names.split(" ");
        List<String> inList = Arrays.stream(nameList).filter(WhitelistFile::containsName).collect(Collectors.toList());
        if (inList.isEmpty()) {
            source.sendFailure(new TextComponent("All of the names are not the name whitelist."));
            return 0;
        }
        inList.forEach(WhitelistFile::removePlayer);
        int ignoredCount = nameList.length - inList.size();
        if (ignoredCount > 0)  source.sendSuccess(new TextComponent("Removed " + inList.size() + " names from name whitelist, " + (nameList.length - inList.size()) + " ignored."), false);
        else if (inList.size() == 1) source.sendSuccess(new TextComponent("Removed " + inList.get(0) + " from name whitelist."), false);
        else source.sendSuccess(new TextComponent("Removed " + inList.size() + " names from name whitelist."), false);
        return 1;
    }
}
