package com.wynntils.modules.core.commands;

import com.wynntils.core.utils.StringUtils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.IClientCommand;


public class CommandStackCalc extends CommandBase implements IClientCommand {

    @Override
    public boolean allowUsageWithoutPrefix(ICommandSender sender, String message) {
        return false;
    }

    @Override
    public String getName() {
        return "stackcalc";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/stackcalc <stacks> [extra]";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        if (args.length == 2 && StringUtils.isValidInteger(args[0]) && StringUtils.isValidInteger(args[1])) {
            int stack = Integer.parseInt(args[0]);
            int extra = Integer.parseInt(args[1]);
            String total = Integer.toString(stack * 64 + extra);
            TextComponentString text = new TextComponentString("The total is: " + total);
            text.getStyle().setColor(TextFormatting.AQUA);

            sender.sendMessage(text);
        } else if (args.length == 1 && StringUtils.isValidInteger(args[0])) {
            int stack = Integer.parseInt(args[0]);
            String total = Integer.toString(stack * 64);
            TextComponentString text = new TextComponentString("The total is: " + total);
            text.getStyle().setColor(TextFormatting.AQUA);

            sender.sendMessage(text);
        } else {
            throw new WrongUsageException(getUsage(sender));
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

}
