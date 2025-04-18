package com.andrei1058.bedwars.hotbarmanager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerDataManager {

    public static Map<UUID, Map<String, Integer>> hotbarLayout = new HashMap<>();
    public static Map<UUID, Map<Integer, ItemStack>> invB4Setup = new HashMap<>();

    private static Map<UUID, File> playerDataFiles = new HashMap<>();
    private static Map<UUID, FileConfiguration> playerDataConfigs = new HashMap<>();

    public static void createPlayerDataFile(Player player) {
        UUID playerUUID = player.getUniqueId();

        File dataFolder = new File("plugins/bw1058hotbarmg/players");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        File playerDataFile = new File(dataFolder, playerUUID.toString() + ".yml");
        playerDataFiles.put(playerUUID, playerDataFile);

        if (!playerDataFile.exists()) {
            try {
                playerDataFile.createNewFile();
                System.out.println("Created new data file for player " + player.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        playerDataConfigs.put(playerUUID, playerDataConfig);
    }

    public static void savePlayerData(Player player, int[] items) {
        UUID playerUUID = player.getUniqueId();
        FileConfiguration playerDataConfig = playerDataConfigs.get(playerUUID);
        File playerDataFile = playerDataFiles.get(playerUUID);

        if (playerDataConfig != null && playerDataFile != null) {
            playerDataConfig.set("sword", items[0]);
            playerDataConfig.set("wool", items[1]);
            playerDataConfig.set("pick", items[2]);
            playerDataConfig.set("axe", items[3]);
            playerDataConfig.set("shears", items[4]);
            playerDataConfig.set("gapple", items[5]);
            playerDataConfig.set("ladders", items[6]);

            try {
                playerDataConfig.save(playerDataFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int[] getPlayerData(Player player) {
        UUID playerUUID = player.getUniqueId();
        FileConfiguration playerDataConfig = playerDataConfigs.get(playerUUID);

        if (playerDataConfig != null && playerDataConfig.contains("sword")) {
            int[] slots = new int[7];
            slots[0] = playerDataConfig.getInt("sword");
            slots[1] = playerDataConfig.getInt("wool");
            slots[2] = playerDataConfig.getInt("pick");
            slots[3] = playerDataConfig.getInt("axe");
            slots[4] = playerDataConfig.getInt("shears");
            slots[5] = playerDataConfig.getInt("gapple");
            slots[6] = playerDataConfig.getInt("ladders");
            return slots;
        } else {
            return null; // Data not found
        }
    }
}

