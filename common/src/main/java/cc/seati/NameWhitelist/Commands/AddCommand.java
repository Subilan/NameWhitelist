package cc.seati.NameWhitelist.Commands;

import cc.seati.NameWhitelist.WhitelistFile;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.TextComponent;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddCommand {
    public static int exec(CommandSourceStack source, String names) throws CommandSyntaxException {
        String[] nameList = names.split(" ");
        List<String> notInList = Arrays.stream(nameList).filter(s -> !WhitelistFile.containsName(s)).collect(Collectors.toList());
        if (notInList.isEmpty()) {
            source.sendFailure(new TextComponent("All of the names are already in the name whitelist."));
            return 0;
        }
        notInList.forEach(WhitelistFile::addPlayer);
        int ignoredCount = nameList.length - notInList.size();
        if (ignoredCount > 0)  source.sendSuccess(new TextComponent("Added " + notInList.size() + " names to name whitelist, " + (nameList.length - notInList.size()) + " ignored."), false);
        else if (notInList.size() == 1) source.sendSuccess(new TextComponent("Added " + notInList.get(0) + " to name whitelist."), false);
        else source.sendSuccess(new TextComponent("Added " + notInList.size() + " names to name whitelist."), false);
        return 1;
    }
}
