package com.andrei1058.bedwars.commands.bedwars.subcmds.regular;

import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.api.command.ParentCommand;
import com.andrei1058.bedwars.api.command.SubCommand;
import com.andrei1058.bedwars.api.language.Messages;
import com.andrei1058.bedwars.arena.Arena;
import com.andrei1058.bedwars.arena.ArenaManager;
import com.andrei1058.bedwars.commands.bedwars.MainCommand;
import com.andrei1058.bedwars.configuration.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.List;

import static com.andrei1058.bedwars.api.language.Language.getMsg;

public class CmdSpectate extends SubCommand {


    /**
     * Create a sub-command for a bedWars command
     * Make sure you return true or it will say command not found
     *
     * @param parent parent command
     * @param name   sub-command name
     */
    public CmdSpectate(ParentCommand parent, String name) {
        super(parent, name);
        showInList(false);
        setPermission(Permissions.PERMISSION_SPECTATE);
        setDisplayInfo(com.andrei1058.bedwars.commands.bedwars.MainCommand.createTC("§6 ▪ §7/"+ MainCommand.getInstance().getName()+" "+getSubCommandName(), "/"+getParent().getName()+" "+getSubCommandName(), "§fSpectate a game."));
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        if (args.length < 1) {
            s.sendMessage(ChatColor.RED + "Specify a player to spectate");
            return true;
        }

        Player plToSpec = Bukkit.getPlayer(args[0]);
        if (plToSpec == null) {
            s.sendMessage(ChatColor.RED + "Player not found");
            return true;
        }

        IArena senderarena = Arena.getArenaByPlayer(p);
        if (senderarena != null) {
            s.sendMessage(ChatColor.RED + "You cannot spectate while playing");
            return true;
        }

        IArena arena = Arena.getArenaByPlayer(plToSpec);
        if (arena == null) {
            s.sendMessage(ChatColor.RED + "This player isn't in a game");
            return true;
        }

        if (arena.getStatus() != GameState.playing) {
            s.sendMessage(ChatColor.RED + "This game hasn't started or has just ended.");
            return true;
        }

        arena.addSpectator(p, false, arena.getSpectatorLocation());

        for (Player plr : arena.getPlayers()) {
            plr.sendMessage(ChatColor.BLUE + p.getName() + ChatColor.GRAY + " is now spectating this game");
        }
        for (Player plr : arena.getSpectators()) {
            plr.sendMessage(ChatColor.BLUE + p.getName() + ChatColor.GRAY + " is now spectating this game");
        }

        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return List.of();
    }
}
