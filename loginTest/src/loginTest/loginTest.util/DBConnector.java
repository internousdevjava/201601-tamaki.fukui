package loginTest.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * データベースに接続するクラス
 *
 * @author TAMAKI FUKUI
 * @version 1.0
 *
 */
public class DBConnector {

	/**
	 * com.mysql.jdbc.Driverを格納する変数
	 */
	private static String driverName = "com.mysql.jdbc.Driver";

	/**
	 *ローカルホストのurlを格納する変数
	 */
	private static String url = "jdbc:mysql://localhost/";

	/**
	 *mysqlのユーザー名を格納する変数
	 */
	private static String user = "root";

	/**
	 *mysqlのログインパスワードを格納する変数
	 */
	private static String pass = "mysql";

	/**
	 * データベースに接続するメソッド
	 * @param DBName
	 * @return nullのconを返します。
	 */
	public static Connection getConnection(String DBName){
		StringBuffer sBuffer = new StringBuffer("");
		sBuffer.append(url);
		sBuffer.append(DBName);
		url = sBuffer.toString();
		Connection con = null;
		try{
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,pass);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		url = "jdbc:mysql://localhost/";
		return con;
	}
}
