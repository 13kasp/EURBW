package com.andrei1058.bedwars.commands.bedwars.subcmds.regular;

import com.andrei1058.bedwars.api.command.ParentCommand;
import com.andrei1058.bedwars.api.command.SubCommand;
import com.andrei1058.bedwars.commands.bedwars.MainCommand;
import com.andrei1058.bedwars.hotbarmanager.HotbarItems;
import com.andrei1058.bedwars.hotbarmanager.PlayerDataManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CmdHotbarSave extends SubCommand {

    /**
     * Create a sub-command for a bedWars command
     * Make sure you return true or it will say command not found
     *
     * @param parent parent command
     * @param name   sub-command name
     */
    public CmdHotbarSave(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(22);
        showInList(true);
        setDisplayInfo(MainCommand.createTC("§6 ▪ §7/"+ MainCommand.getInstance().getName()+" "+getSubCommandName(), "/"+getParent().getName()+" "+getSubCommandName(), "§fSave your hotbar."));
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

        Map<String, Integer> hotbarLayout = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            ItemStack is = p.getInventory().getItem(i);

            if (is == null || is.getType() == Material.AIR) {
                continue;
            }

            String item = HotbarItems.getStringFromItemMaterial(is.getType());

            hotbarLayout.put(item, i);
        }

        PlayerDataManager.hotbarLayout.put(p.getUniqueId(), hotbarLayout);

        int[] slots = { hotbarLayout.get("sword"),
                hotbarLayout.get("wool"),
                hotbarLayout.get("pick"),
                hotbarLayout.get("axe"),
                hotbarLayout.get("shears"),
                hotbarLayout.get("gapple"),
                hotbarLayout.get("ladders")};

        PlayerDataManager.savePlayerData(p, slots);

        p.getInventory().clear();

        if (PlayerDataManager.invB4Setup.get(p.getUniqueId()) != null) {
            for (int i = 0; i < p.getInventory().getSize(); i++) {
                if (PlayerDataManager.invB4Setup.get(p.getUniqueId()).containsKey(i)) {
                    p.getInventory().setItem(i, PlayerDataManager.invB4Setup.get(p.getUniqueId()).get(i));
                }
            }

            PlayerDataManager.invB4Setup.remove(p.getUniqueId());
        }

        p.sendMessage(ChatColor.GREEN + "Your inventory layout has been saved");

        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return List.of();
    }
}
