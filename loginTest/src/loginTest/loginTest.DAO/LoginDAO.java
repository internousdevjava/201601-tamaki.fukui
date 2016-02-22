/**
 *
 */
package loginTest.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

import loginTest.util.DBConnector;

/**
 * 入力された値をデータベースに保存するクラス
 *
 * @author TAMAKI FUKUI
 * @since 1.0
 * @version 1.0
 */
public class LoginDAO extends ActionSupport{

	/*
	 * 保存が成功したらtrue、失敗したらfalseを格納する変数
	 * */
	private boolean res;
	/*
	 * データベースの起動
	 * */
	private Connection con;
	/*
	 * sqlの命令文
	 * */
	private String sql;
	/*
	 * 更新件数
	 * */
	private int rs;


	/**
	 * データベースに値を保存するメソッド
	 * データベースに値を保存し、成功したらtrue、失敗したらfalseを返します。
	 * @param name ユーザーネーム
	 * @param password パスワード
	 * @return res 保存に成功したらtrue、失敗したらfalseを返します。
	 */
	public boolean selectDB(String name, String password){
	       res = false;


	        try{
	            con = DBConnector.getConnection("sample");

	            Statement stm = con.createStatement();
	            sql  = "insert into login(name,password)values('"+name+"','"+password+"')";

	            rs = stm.executeUpdate(sql);

	                if(rs==1){
	                    res = true;
	                    }

	        }
	        catch(SQLException e){
	            e.printStackTrace();
	        }
	        return res;

	    }
}

