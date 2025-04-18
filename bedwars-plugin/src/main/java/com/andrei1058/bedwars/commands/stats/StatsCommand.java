package com.andrei1058.bedwars.commands.stats;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.List;

public class StatsCommand extends BukkitCommand {
    public StatsCommand(String name) {
        super(name);
        setAliases(List.of("statistics"));
    }

    @Override
    public boolean execute(CommandSender s, String st, String[] args) {
        if (s instanceof ConsoleCommandSender) {
            s.sendMessage("This command is for players!");
            return true;
        }

        Player p = (Player) s;

        Bukkit.dispatchCommand(p, "bw stats " + args[0]);
        return true;
    }
}
