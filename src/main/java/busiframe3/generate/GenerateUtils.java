package busiframe3.generate;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import busiframe3.core.Environmwnt;
import busiframe3.core.dao.BaseDAO;

/**
 * 生成用汎用クラス<br>
 * 各メソッドは場合によってクラス構成が変わる可能性が有ります。<br>
 * @since 2025/10/06
 * @version 1.0 2025/10/06 新規作成
 */
public class GenerateUtils extends BaseDAO {

	/** 環境情報 */
	private Environmwnt env;
	
	/**
	 * コンストラクタ<br>
	 * @since 2025/10/06
	 * @param env 環境情報
	 */
	public GenerateUtils(Environmwnt env) {
		this.env = env;
	}

	/**
	 * テーブル生成<br>
	 * @since 2025/10/07
	 * @param tableName テーブル名
	 */
	public void createTable(String tableName) {
		PreparedStatement ptsmt = null;
		// テーブル削除
		StringBuffer sql = new StringBuffer();
		sql.append("DROP TABLE IF EXISTS " + tableName + ";");
		try {
			connection(env);
			ptsmt = env.getConn().prepareStatement(sql.toString());
			ptsmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
