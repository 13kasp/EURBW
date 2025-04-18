package com.andrei1058.bedwars.commands.spectate;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.List;

public class SpectateCommand extends BukkitCommand {

    public SpectateCommand(String name) {
        super(name);
        setAliases(List.of("spec"));
    }

    @Override
    public boolean execute(CommandSender s, String st, String[] args) {
        if (s instanceof ConsoleCommandSender) {
            s.sendMessage("This command is for players!");
            return true;
        }

        Player p = (Player) s;

        if (args.length == 0) {
            Bukkit.dispatchCommand(p, "bw spectate");
            return true;
        }

        Bukkit.dispatchCommand(p, "bw spectate " + args[0]);
        return true;
    }
}
