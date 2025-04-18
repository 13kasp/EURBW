package com.andrei1058.bedwars.commands.bedwars.subcmds.regular;

import com.andrei1058.bedwars.api.command.ParentCommand;
import com.andrei1058.bedwars.api.command.SubCommand;
import com.andrei1058.bedwars.commands.bedwars.MainCommand;
import com.andrei1058.bedwars.hotbarmanager.HotbarItems;
import com.andrei1058.bedwars.hotbarmanager.PlayerDataManager;
import com.andrei1058.bedwars.support.vault.Chat;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CmdHotbar extends SubCommand {

    /**
     * Create a sub-command for a bedWars command
     * Make sure you return true or it will say command not found
     *
     * @param parent parent command
     * @param name   sub-command name
     */
    public CmdHotbar(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(21);
        showInList(true);
        setDisplayInfo(com.andrei1058.bedwars.commands.bedwars.MainCommand.createTC("§6 ▪ §7/"+ MainCommand.getInstance().getName()+" "+getSubCommandName(), "/"+getParent().getName()+" "+getSubCommandName(), "§fManage your hotbar."));
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (!(s instanceof Player)) {
            return false;
        }

        Player p = (Player) s;

        if (!p.getWorld().getName().equals("world")) {
            p.sendMessage(ChatColor.RED + "You can't do that here");
            return true;
        }

        if (!PlayerDataManager.invB4Setup.containsKey(p.getUniqueId())) {
            PlayerDataManager.invB4Setup.put(p.getUniqueId(), new HashMap<>());
            for (int i = 0; i < p.getInventory().getSize(); i++) {
                ItemStack is = p.getInventory().getItem(i);

                if (is != null) {
                    PlayerDataManager.invB4Setup.get(p.getUniqueId()).put(i, is);
                }
            }

            p.getInventory().clear();

            for (Map.Entry<String, Integer> entry : PlayerDataManager.hotbarLayout.get(p.getUniqueId()).entrySet()) {
                p.getInventory().setItem(entry.getValue(), HotbarItems.getItemStackFromCategoryName(entry.getKey()));
            }
            p.sendMessage(ChatColor.GREEN + "You're now editing your hotbar." + ChatColor.BOLD + " Use /bw hotbarsave to save it");
        } else {
            p.sendMessage(ChatColor.RED + "You're already editing the hotbar. Use /bw hotbarsave to save it");
        }

        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return List.of();
    }
}
