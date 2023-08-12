package net.nekozouneko.nekolib;

import org.bukkit.plugin.java.JavaPlugin;

public final class NekoLib extends JavaPlugin {
    /* NekoLibのプラグインクラス */
    private static JavaPlugin plugin;
    public static JavaPlugin getPlugin() {return plugin;}

    @Override
    public void onEnable() {
        /* プラグインの起動ロジック */
        // ロジックの定義
        super.onEnable();
        plugin = this;
        // イベントリスナーの定義
        // プラグインコマンドの定義
    }

    @Override
    public void onDisable() {
        /* プラグインの終了ロジック */
        // ロジックの定義
        super.onDisable();
    }
}
