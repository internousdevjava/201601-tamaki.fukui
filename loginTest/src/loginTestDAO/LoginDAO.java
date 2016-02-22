package loginTestDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import loginTest.util.DBConnector;
public class LoginDAO {

/**
 * ログインして値をデータベースに保存するDAOクラス
 * @author TAMAKI FUKUI
 * @since 1.0
 * @version 1.0
 */

private boolean res;
private Connection con;
private String sql;
private PreparedStatement ps;
private int rs;

/*
 * ログインして値をデータベースに保存するメソッド
 * ログインして値をデータベースに保存します。
 * @return res データの保存に成功したらtrue、失敗したらfalseを返します。
 */
public boolean select(String id, String password){
    res = true;

    try{
        con = (Connection)DBConnector.getConnection();
        java.sql.Statement stm= con.createStatement();

        sql="update login_table set password ='"+password+"' where id ='"+id+"'";
        rs = stm.executeUpdate(sql);
        if(rs==0){
            res = false;
        }
    }
    catch(SQLException e){
        e.printStackTrace();
    }
    return res;
    }
}

