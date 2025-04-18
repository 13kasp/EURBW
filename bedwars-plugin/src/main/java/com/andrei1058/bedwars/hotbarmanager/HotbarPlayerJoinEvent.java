package com.andrei1058.bedwars.hotbarmanager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Map;

public class HotbarPlayerJoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Map<String, Integer> hotbarConfig = new HashMap<>();

        PlayerDataManager.createPlayerDataFile(e.getPlayer());
        if (PlayerDataManager.getPlayerData(e.getPlayer()) == null) {
            PlayerDataManager.savePlayerData(e.getPlayer(), new int[]{0, 1, 2, 3, 4, 5, 8});

            hotbarConfig.put("sword", 0);
            hotbarConfig.put("wool", 1);
            hotbarConfig.put("pick", 2);
            hotbarConfig.put("axe", 3);
            hotbarConfig.put("shears", 4);
            hotbarConfig.put("gapple", 5);
            hotbarConfig.put("ladders", 8);
        }
        else {
            int[] data = PlayerDataManager.getPlayerData(e.getPlayer());

            hotbarConfig.put("sword", data[0]);
            hotbarConfig.put("wool", data[1]);
            hotbarConfig.put("pick", data[2]);
            hotbarConfig.put("axe", data[3]);
            hotbarConfig.put("shears", data[4]);
            hotbarConfig.put("gapple", data[5]);
            hotbarConfig.put("ladders", data[6]);
        }

        PlayerDataManager.hotbarLayout.put(e.getPlayer().getUniqueId(), hotbarConfig);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        PlayerDataManager.hotbarLayout.remove(e.getPlayer().getUniqueId());
        PlayerDataManager.invB4Setup.remove(e.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onPlayerChangeWorld(PlayerChangedWorldEvent e) {
        PlayerDataManager.invB4Setup.remove(e.getPlayer().getUniqueId());
    }
}
