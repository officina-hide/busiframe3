package busiframe3.generate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import busiframe3.core.Environmwnt;
import busiframe3.core.I_BaseCharactor;
import busiframe3.core.Message;
import busiframe3.core.MessageCode;
import busiframe3.core.ParamCollection;
import busiframe3.core.dao.BaseDAO;

/**
 * 生成用汎用クラス<br>
 * 各メソッドは場合によってクラス構成が変わる可能性が有ります。<br>
 * @since 2025/10/06
 * @version 1.0 2025/10/06 新規作成
 */
public class GenerateUtils extends BaseDAO implements I_BaseCharactor {

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
	 * @param params パラメータ情報
	 */
	public void createTable(ParamCollection params) {
		PreparedStatement ptsmt = null;
		// テーブル削除
		StringBuffer sql = new StringBuffer();
		sql.append("DROP TABLE IF EXISTS " + params.getData("tableName") + ";");
		try {
			connection(env);
			ptsmt = env.getConn().prepareStatement(sql.toString());
			ptsmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// テーブル生成
		sql = new StringBuffer();
		sql.append("CREATE TABLE").append(SP).append(params.getData("tableName")).append(SP).append("(");
		sql.append("id INT PRIMARY KEY AUTO_INCREMENT");
		sql.append(")").append(SP).append("COMMENT").append(SP).append(EQ).append(SP).append(SQ).append(params.getData("tableComment")).append(SQ).append(";");
		try {
			ptsmt = env.getConn().prepareStatement(sql.toString());
			ptsmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ptsmt, null);
		}
	}

	/**
	 * カラム追加<br>
	 * @since 2025/10/19
	 * @param params パラメータ情報
	 */
	public void alterColumns(ParamCollection params) {
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer("ALTER TABLE ")
				.append(params.getData(P_TABLE_NAME)).append(SP)
				.append("ADD COLUMN").append(SP).append(params.getData(P_COLUMN_NAME));
		switch (params.getData(P_COLUMN_TYPE).toUpperCase()) {
			case C_STRING:
				sql.append(SP).append("VARCHAR(").append(params.getData(P_COLUMN_SIZE)).append(")");
				break;
			case C_INT:
				sql.append(SP).append("INT");
				break;
			case C_TEXT:
				sql.append(SP).append("TEXT").append("(").append(params.getData(P_COLUMN_SIZE)).append(")");
				break;
			case C_BOOLEAN:
				sql.append(SP).append("BOOLEAN");
				break;
		}
		if (params.getData(P_IS_NOT_NULL) != null ) {
			sql.append(SP).append("NOT NULL");
		}
		if (params.getData(P_IS_UNIQUE) != null) {
			sql.append(SP).append("UNIQUE");
		}
		if (params.getData(P_IS_PRIMARY_KEY) != null) {
			sql.append(SP).append("PRIMARY KEY");
		}
		if (params.getData("default_value") != null) {
			sql.append(SP).append("DEFAULT").append(SP)
				.append(SQ).append(params.getData("default_value")).append(SQ);
		}
		if (params.getData(P_COMMENT) != null) {
			sql.append(SP).append("COMMENT").append(SP)
				.append(SQ).append(params.getData("comment")).append(SQ);
		}
		try {
			connection(env);
			pstmt = env.getConn().prepareStatement(sql.toString());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("Error executing SQL: " + sql);
			e.printStackTrace();
		} finally {
			close(pstmt, null);
		}
	}

	/**
	 * データ初期登録<br>
	 * @since 2025/10/20
	 * @param dataParams データパラメータ情報配列
	 */
	public void entryData(List<ParamCollection> dataParams) {
		PreparedStatement pstmt = null;
		for (ParamCollection dataParam : dataParams) {
			StringBuffer sql = new StringBuffer("INSERT INTO ")
					.append(dataParam.getData(P_TABLE_NAME)).append(SP)
					.append("SET").append(SP);
			boolean first = true;
			for (String key : dataParam.getKeys()) {
				if (key.equals(P_TABLE_NAME)) {
					continue;
				}
				if (!first) {
					sql.append(",").append(SP);
				}
				sql.append(key).append(SP).append(EQ).append(SP)
					.append(SQ).append(dataParam.getData(key)).append(SQ);
				first = false;
			}
			try {
				connection(env);
				pstmt = env.getConn().prepareStatement(sql.toString());
				pstmt.executeUpdate();
			} catch (Exception e) {
				System.err.println("Error executing SQL: " + sql);
				e.printStackTrace();
			} finally {
				close(pstmt, null);
			}
//			System.out.println("Executing SQL: " + sql.toString());
		}
	}

	/**
	 * テーブル削除<br>
	 * COMMAD : TABLE_DROP<br>
	 * NAME : テーブル名<br>
	 * 直接呼び出されるときは、COMMANDは使用しない。<br>
	 * @since 2025/11/14
	 * @param params パラメータ情報
	 */
	public void dropTable(ParamCollection params) {
		Message msg = new Message(env);
		PreparedStatement ptsmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("DROP TABLE IF EXISTS").append(SP).append(params.getData("NAME")).append(SM);
		try {
			connection(env);
			ptsmt = env.getConn().prepareStatement(sql.toString());
			ptsmt.executeUpdate();
			msg.consoleOut(new MessageCode("IN001003"), params.getData("NAME"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ptsmt, null);
		}
	}

}
