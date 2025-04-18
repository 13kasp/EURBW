package com.andrei1058.bedwars.hotbarmanager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class HotbarItems {

    public static ItemStack getSwordCategoryItem(boolean displayLore) {
        ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(ChatColor.WHITE + "All sword items");
        if (displayLore) swordMeta.setLore(List.of(ChatColor.GRAY + "Click here to select"));
        swordMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE,
                ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS);
        sword.setItemMeta(swordMeta);

        return sword;
    }

    public static ItemStack getWoolCategoryItem(boolean displayLore) {
        ItemStack wool = new ItemStack(Material.WOOL, 1, (short) 13);
        ItemMeta woolMeta = wool.getItemMeta();
        woolMeta.setDisplayName(ChatColor.WHITE + "Wool");
        if (displayLore) woolMeta.setLore(List.of(ChatColor.GRAY + "Click here to select"));
        woolMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE,
                ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS);
        wool.setItemMeta(woolMeta);

        return wool;
    }

    public static ItemStack getPickCategoryItem(boolean displayLore) {
        ItemStack pick = new ItemStack(Material.WOOD_PICKAXE, 1);
        ItemMeta pickMeta = pick.getItemMeta();
        pickMeta.setDisplayName(ChatColor.WHITE + "" + "All pickaxe items");
        if (displayLore) pickMeta.setLore(List.of(ChatColor.GRAY + "Click here to select"));
        pickMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE,
                ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS);
        pick.setItemMeta(pickMeta);

        return pick;
    }

    public static ItemStack getAxeCategoryItem(boolean displayLore) {
        ItemStack axe = new ItemStack(Material.WOOD_AXE, 1);
        ItemMeta axeMeta = axe.getItemMeta();
        axeMeta.setDisplayName(ChatColor.WHITE + "All axe items");
        if (displayLore) axeMeta.setLore(List.of(ChatColor.GRAY + "Click here to select"));
        axeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE,
                ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS);
        axe.setItemMeta(axeMeta);

        return axe;
    }

    public static ItemStack getShearsCategoryItem(boolean displayLore) {
        ItemStack shears = new ItemStack(Material.SHEARS, 1);
        ItemMeta shearsMeta = shears.getItemMeta();
        shearsMeta.setDisplayName(ChatColor.WHITE + "Shears");
        if (displayLore) shearsMeta.setLore(List.of(ChatColor.GRAY + "Click here to select"));
        shearsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE,
                ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS);
        shears.setItemMeta(shearsMeta);

        return shears;
    }

    public static ItemStack getGappleCategoryItem(boolean displayLore) {
        ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta gappleMeta = gapple.getItemMeta();
        gappleMeta.setDisplayName(ChatColor.WHITE + "Misc items");
        if (displayLore) gappleMeta.setLore(List.of(
                ChatColor.GRAY + "Click here to select",
                ChatColor.GRAY + "- Gapples",
                ChatColor.GRAY + "- Fireballs"));
        gappleMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE,
                ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS);
        gapple.setItemMeta(gappleMeta);

        return gapple;
    }

    public static ItemStack getLaddersCategoryItem(boolean displayLore) {
        ItemStack ladders = new ItemStack(Material.LADDER, 1);
        ItemMeta laddersMeta = ladders.getItemMeta();
        laddersMeta.setDisplayName(ChatColor.WHITE + "Ladders");
        if (displayLore) laddersMeta.setLore(List.of(ChatColor.GRAY + "Click here to select"));
        laddersMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE,
                ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS);
        ladders.setItemMeta(laddersMeta);

        return ladders;
    }

    public static ItemStack getItemStackFromCategoryName(String categoryname) {
        return switch (categoryname) {
            case "wool" -> HotbarItems.getWoolCategoryItem(false);
            case "sword" -> HotbarItems.getSwordCategoryItem(false);
            case "pick" -> HotbarItems.getPickCategoryItem(false);
            case "axe" -> HotbarItems.getAxeCategoryItem(false);
            case "shears" -> HotbarItems.getShearsCategoryItem(false);
            case "gapple" -> HotbarItems.getGappleCategoryItem(false);
            case "ladders" -> HotbarItems.getLaddersCategoryItem(false);
            default -> HotbarItems.getWoolCategoryItem(false);
        };
    }

    public static String getStringFromItemMaterial(Material material) {
        return switch (material) {
            case WOOL -> "wool";
            case WOOD_SWORD, IRON_SWORD, STONE_SWORD, GOLD_SWORD, DIAMOND_SWORD -> "sword";
            case WOOD_PICKAXE, GOLD_PICKAXE, STONE_PICKAXE, IRON_PICKAXE, DIAMOND_PICKAXE -> "pick";
            case WOOD_AXE, STONE_AXE, GOLD_AXE, IRON_AXE, DIAMOND_AXE -> "axe";
            case SHEARS -> "shears";
            case GOLDEN_APPLE, SNOW_BALL, MONSTER_EGG, FIREBALL, TNT, ENDER_PEARL, WATER_BUCKET, EGG, MILK_BUCKET, SPONGE, CHEST -> "gapple";
            case LADDER -> "ladders";
            default -> "invalid";
        };
    }
}
