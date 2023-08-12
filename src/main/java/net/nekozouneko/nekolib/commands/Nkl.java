package net.nekozouneko.nekolib.commands;

import net.nekozouneko.nekolib.NekoLib;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Nkl implements CommandExecutor {
    /* NklCommandの処理クラス */

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        /* コマンドが実行されたとき */
        if (! sender.isOp()) {
            // コマンド送信者が管理者ではないなら
            sender.sendMessage(ChatColor.RED + "管理者権限で実行してください。");
            return true;
        }
        String version = NekoLib.getPlugin().getDescription().getVersion();
        sender.sendMessage("バージョン " + version + " のNekoLibがサーバーサイドで動作しています。");
        return true;
    }
}
