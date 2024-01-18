package cc.seati.NameWhitelist.Commands;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;

public class RemoveCommand {
    public static int exec(CommandSourceStack source, String name) throws CommandSyntaxException {
        return 1;
    }
}
