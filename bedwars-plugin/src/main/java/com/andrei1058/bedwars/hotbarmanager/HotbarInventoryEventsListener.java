package com.andrei1058.bedwars.hotbarmanager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;

public class HotbarInventoryEventsListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!e.getWhoClicked().getWorld().getName().equals("world")) {
            return;
        }

        if (!List.of(0, 1, 2, 3, 4, 5, 6, 7, 8).contains(e.getSlot())) {
            e.setCancelled(true);
        }

        if (PlayerDataManager.invB4Setup.containsKey(e.getWhoClicked().getUniqueId())) {
            e.setCancelled(false);
        }
    }
}
