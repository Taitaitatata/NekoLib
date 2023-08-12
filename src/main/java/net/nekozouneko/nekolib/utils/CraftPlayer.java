package net.nekozouneko.nekolib.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class CraftPlayer {
    /* CraftPlayerUtilの実装クラス */

    public static boolean isOnline(String name) {
        /* オンラインかを判定する: name */
        boolean online = false;
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName().equals(name)) {
                online = true;
                break;
            }
        }
        return online;
    }

    public static boolean isOnline(UUID uuid) {
        /* オンラインかを判定する: uuid */
        boolean online = false;
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getUniqueId().equals(uuid)) {
                online = true;
                break;
            }
        }
        return online;
    }

    public static boolean hasScoreboardTag(Player player, String scoreboardTag) {
        /* scoreboardTagを持つかを判定する: player */
        for (String tag : player.getScoreboardTags()) {
            if (tag.equals(scoreboardTag)) {
                // 一致するなら
                return true;
            }
        }
        return false;
    }

    public static boolean hasScoreboardTag(String name, String scoreboardTag) {
        /* scoreboardTagを持つかを判定する: name */
        for (String tag : Bukkit.getServer().getPlayer(name).getScoreboardTags()) {
            if (tag.equals(scoreboardTag)) {
                // 一致するなら
                return true;
            }
        }
        return false;
    }

    public static boolean hasScoreboardTag(UUID uuid, String scoreboardTag) {
        /* scoreboardTagを持つかを判定する: name */
        for (String tag : Bukkit.getServer().getPlayer(uuid).getScoreboardTags()) {
            if (tag.equals(scoreboardTag)) {
                // 一致するなら
                return true;
            }
        }
        return false;
    }

    public static ItemStack getHead(Player player) {
        /* Headを取得する: player */
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwningPlayer(player);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getHead(String name) {
        /* Headを取得する: name */
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(name));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getHead(UUID uuid) {
        /* Headを取得する: name */
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(uuid));
        item.setItemMeta(meta);
        return item;
    }
}
