package busiframe3.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import busiframe3.core.Environmwnt;

/**
 * 基盤DAOクラス<br>
 * @since 2025/10/07
 * @version 1.0 2025/10/07 新規作成
 */
public class BaseDAO {

	/** 表示日付書式 */
	protected DateTimeFormatter fomat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	/**
	 * DB接続<br>
	 * @since 2025/10/07
	 * @param env 環境情報
	 * @throws SQLException 
	 */
	public void connection(Environmwnt env) throws SQLException {
		if(env.getConn() != null && env.getConn().isClosed() == false) {
			return;
		}
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			env.setConn(DriverManager.getConnection(env.getDsn()	, env.getUser(), env.getPassword()));
			System.out.println("AutoCommit Mode = "+env.getConn().getAutoCommit());
			System.out.println(LocalDateTime.now().format(fomat) + " : データベースに接続しました。");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
