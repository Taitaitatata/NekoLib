package net.nekozouneko.nekolib.utils;

import com.google.common.base.Preconditions;
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
        return Bukkit.getOnlinePlayers().stream()
                .map(Player::getName) // プレイヤー名のみの内容にし
                .anyMatch(name::equals); // 同じ名前のものが一つでもあったらtrue
    }

    public static boolean isOnline(UUID uuid) {
        /* オンラインかを判定する: uuid */
        return Bukkit.getPlayer(uuid) != null; // 同一UUIDのプレイヤーがオンラインじゃなければnullを返す
    }

    public static boolean hasScoreboardTag(Player player, String scoreboardTag) {
        /* scoreboardTagを持つかを判定する: player */
        return player.getScoreboardTags().contains(scoreboardTag); // getScoreboardTagsに含まれていればtrue
    }

    public static boolean hasScoreboardTag(String name, String scoreboardTag) {
        /* scoreboardTagを持つかを判定する: name */
        Player p = Bukkit.getPlayer(name);
        if (p == null) return false; // p == nullならエラーを吐く

        return hasScoreboardTag(p, scoreboardTag);
    }

    public static boolean hasScoreboardTag(UUID uuid, String scoreboardTag) {
        /* scoreboardTagを持つかを判定する: name */
        Player p = Bukkit.getPlayer(uuid);
        if (p == null) return false; // p == nullならエラーを吐く

        return hasScoreboardTag(p, scoreboardTag);
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
