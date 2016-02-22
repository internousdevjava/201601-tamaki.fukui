/**
 *
 */
package loginTest.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import loginTest.DAO.LoginDAO;

/**
 * 入力された値をデータベースへ保存し次の画面へ移行するアクションクラス
 *
 * @author TAMAKI FUKUI
 * @since 1.0
 * @version 1.0
 */
public class LoginAction extends ActionSupport{

	/*
	 * ユーザーネーム
	 * */
	private String name;
	/*
	 * パスワード
	 * */
	private String password;
	/*
	 * セッション
	 * */
	private Map<String, Object> session;


	/**
	 * データベースへ値を渡し次の画面へ移行するメソッド
	 * データベースへ値を渡し次の画面へ移行します。
	 * @return success/error データの保存に成功したらsuccess、失敗したらerrorを返します。
	 */
	public String execute(){
		LoginDAO dao = new LoginDAO();
		boolean res = dao.selectDB(name, password);
		if(!res){
			return "error";
		}
		return "success";
	}


	/*
	 * nameの値を取得するメソッド
	 * @return name nameを返します。
	 * */
	public String getName() {
		return name;
	}

	/*
	 * nameの値を格納するメソッド
	 * @param name ユーザーネーム
	 * */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * passwordの値を取得するメソッド
	 * @return password passwordを返します。
	 * */
	public String getPassword() {
		return password;
	}

	/*
	 * passwordの値を格納するメソッド
	 * @param password パスワード
	 * */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * sessionの値を取得するメソッド
	 * @return session sessionを返します。
	 * */
	public Map<String, Object> getSession() {
		return session;
	}

	/*
	 * sessionの値を格納するメソッド
	 * @param session セッション
	 * */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
