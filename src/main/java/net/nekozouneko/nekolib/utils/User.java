package net.nekozouneko.nekolib.utils;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.ResultSet;
import java.util.UUID;

public class User {
    /* UserUtilの実装クラス */
    private final String userId;

    public User(String userId) {
        /* コンストラクタ */
        this.userId = userId;
        // ユーザーデータが紐づけされているかを判定する
        FileConfiguration config = Bukkit.getPluginManager().getPlugin("NekoLib").getConfig();
        DataBase db = new DataBase(config.getString("database.url"), config.getString("database.user"), config.getString("database.pass"));
        ResultSet rs = db.executeQuery("SELECT * FROM users WHERE id='" + this.userId + "'");
        try {
            // ユーザーデータの検証を試みる
            if (! rs.next()) {
                // 紐づけされていないなら
                // ユーザーデータを作成する
                OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(this.userId));
                String name = player.getName();
                db.executeUpdate("INSERT INTO users VALUES('" + this.userId + "', '" + name + "', 0)");
            }
        }catch (Exception e) {
            // ユーザーデータの検証に失敗したなら
        }
        db.close();
    }

    public String getUserId() {
        /* userIdを取得する */
        return userId;
    }

    public String getName() {
        /* nameを取得する */
        String name = "";
        FileConfiguration config = Bukkit.getPluginManager().getPlugin("NekoLib").getConfig();
        DataBase db = new DataBase(config.getString("database.url"), config.getString("database.user"), config.getString("database.pass"));
        ResultSet rs = db.executeQuery("SELECT name FROM users WHERE id = '" + userId + "'");
        try {
            // dbからのnameの取得を試みる
            while (rs.next()) {
                name = rs.getString("name");
            }
        }catch (Exception e) {
            // dbからのnameの取得に失敗したなら
        }
        db.close();
        return name;
    }

    public void setName(String name) {
        /* nameを設定する */
        FileConfiguration config = Bukkit.getPluginManager().getPlugin("NekoLib").getConfig();
        DataBase db = new DataBase(config.getString("database.url"), config.getString("database.user"), config.getString("database.pass"));
        db.executeUpdate("UPDATE users SET name = '" + name + "' WHERE id = '" + userId + "'");
        db.close();
    }

    public String getLore() {
        /* loreを取得する */
        String name = "";
        FileConfiguration config = Bukkit.getPluginManager().getPlugin("NekoLib").getConfig();
        DataBase db = new DataBase(config.getString("database.url"), config.getString("database.user"), config.getString("database.pass"));
        ResultSet rs = db.executeQuery("SELECT name FROM users WHERE id = '" + userId + "'");
        try {
            // dbからのloreの取得を試みる
            while (rs.next()) {
                name = rs.getString("lore");
            }
        }catch (Exception e) {
            // dbからのloreの取得に失敗したなら
        }
        db.close();
        return name;
    }

    public void setLore(String lore) {
        /* loreを設定する */
        FileConfiguration config = Bukkit.getPluginManager().getPlugin("NekoLib").getConfig();
        DataBase db = new DataBase(config.getString("database.url"), config.getString("database.user"), config.getString("database.pass"));
        db.executeUpdate("UPDATE users SET lore = '" + lore + "' WHERE id = '" + userId + "'");
        db.close();
    }

    public int getMoney() {
        /* moneyを取得する */
        int money = 0;
        FileConfiguration config = Bukkit.getPluginManager().getPlugin("NekoLib").getConfig();
        DataBase db = new DataBase(config.getString("database.url"), config.getString("database.user"), config.getString("database.pass"));
        ResultSet rs = db.executeQuery("SELECT money FROM users WHERE id = '" + userId + "'");
        try {
            // dbからのnameの取得を試みる
            while (rs.next()) {
                money = rs.getInt("money");
            }
        }catch (Exception e) {
            // dbからのnameの取得に失敗したなら
        }
        db.close();
        return money;
    }

    public void setMoney(int money) {
        /* moneyを設定する */
        FileConfiguration config = Bukkit.getPluginManager().getPlugin("NekoLib").getConfig();
        DataBase db = new DataBase(config.getString("database.url"), config.getString("database.user"), config.getString("database.pass"));
        db.executeUpdate("UPDATE users SET money = " + money + " WHERE id = '" + userId + "'");
        db.close();
    }
}
