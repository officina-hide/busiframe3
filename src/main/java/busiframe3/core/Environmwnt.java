package busiframe3.core;

import java.sql.Connection;

/**
 * 環境クラス<br>
 * このクラスは、プロジェクトの環境設定を管理するためのクラスです。<br>
 * This class is responsible for managing the environment settings of the project.<br>
 * @since 2025/09/30
 * @version 1.0 2025/09/30 新規作成
 */
public class Environmwnt {
	
	/** DB : データソース名 */
	private String dsn;
	/** DB : ユーザー名 */
	private String user;
	/** DB : パスワード */
	private String password;
	/** DBコネクション */
	private Connection conn;
	
	public String getDsn() {
		return dsn;
	}
	public void setDsn(String dsn) {
		this.dsn = dsn;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection connection) {
		this.conn = connection;		
	}

}
