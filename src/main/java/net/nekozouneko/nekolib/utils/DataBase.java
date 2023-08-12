package net.nekozouneko.nekolib.utils;

import java.sql.*;

public class DataBase {
    /* DataBaseオブジェクトの実装クラス */
    private final String URL;
    private final String USER;
    private final String PASS;
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public DataBase(String URL, String USER, String PASS) {
        /* コンストラクタ */
        this.URL = URL;
        this.USER = USER;
        this.PASS = PASS;
    }

    public void executeUpdate(String sql) {
        /* sqlをexecuteUpdateで実行する */
        try {
            // sql文の処理を試みる
            con = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            // sql文の処理に失敗したなら
        }
    }

    public ResultSet executeQuery(String sql) {
        /* sqlをexecuteQueryで実行する */
        try {
            // sql文の処理を試みる
            con = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        }catch (Exception e) {
            // sql文の処理に失敗したなら
        }
        return rs;
    }

    public PreparedStatement preparedStatement(String sql) {
        /* sqlをpreparedStatementで実行する */
        try {
            // sql文の処理を試みる
            con = DriverManager.getConnection(this.URL, this.USER, this.PASS);
            ps = con.prepareStatement(sql);
        }catch (Exception e) {
            // sql文の処理に失敗したなら
        }
        return ps;
    }

    public void close() {
        /* リソースを解放する */
        try {
            // リソースの解放を試みる
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
            if (ps != null) ps.close();
        }catch (Exception e) {
            // リソースの解放に失敗したなら
        }
    }
}
