package cc.seati.NameWhitelist.Commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class CommandManager {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, Commands.CommandSelection selection) {
        dispatcher.register(Commands.literal("nwl")
                .requires(source -> source.getServer().isSingleplayer() || source.hasPermission(2))
                .then(
                        Commands.literal("add")
                                .then(
                                        Commands.argument("name", StringArgumentType.greedyString())
                                                .executes(ctx -> AddCommand.exec(ctx.getSource(), StringArgumentType.getString(ctx, "name")))
                                )
                )
                .then(
                        Commands.literal("remove")
                                .then(
                                        Commands.argument("name", StringArgumentType.greedyString())
                                                .executes(ctx -> RemoveCommand.exec(ctx.getSource(), StringArgumentType.getString(ctx, "name")))
                                )
                )
                .then(
                        Commands.literal("reload")
                                .executes(ctx -> ReloadCommand.exec(ctx.getSource()))
                )
        );
    }
}
