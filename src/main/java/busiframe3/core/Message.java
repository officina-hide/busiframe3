package busiframe3.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import busiframe3.core.dao.BaseDAO;
import busiframe3.core.dao.X_SysMessage;
import busiframe3.generate.MessageInitializer;

/**
 * メッセージクラス<br>
 * 
 * @since 2025/10/01
 * @version 1.0 2025/10/01 新規作成
 */
public class Message extends BaseDAO {

	/** 環境情報 */
	private Environmwnt env;
	/** メッセージ情報 */
	X_SysMessage message;

	/**
	 * コンストラクタ<br>
	 * 
	 * @since 2025/10/01
	 * @param env
	 */
	public Message(Environmwnt env) {
		// 環境情報を保存する。
		this.env = env;
		// メッセージ情報の初期化の有無確認
		if (isInitialized() == false) {
			new MessageInitializer(env);
		}
	}

	/**
	 * メッセージ情報の初期化の有無確認<br>
	 * 
	 * @since 2025/10/01
	 * @return true:初期化済み false:未初期化
	 */
	private boolean isInitialized() {
		boolean initialized = false;
		return initialized;
	}

	/**
	 * メッセージコンソール出力<br>
	 * @since 2025/10/04
	 * @param messageCode メッセージコード
	 * @param params パラメータ配列
	 */
	public void consoleOut(MessageCode messageCode, String... params) {
		// メッセージ情報の取得
		load(messageCode);
		String msgText = message.getMessageText();
		msgText = msgText.replace("$1", params.length >= 1 ? params[0] : "");
		System.out.println(msgText);
	}

	/**
	 * メッセージ情報の取得<br>
	 * @since 2025/10/05
	 * @param messageCode
	 */
	private void load(MessageCode messageCode) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				connection(env);
				String sql = "SELECT * FROM sys_message WHERE message_type = ? AND upper_number = ? AND lower_number = ?";
				pstmt = env.getConn().prepareStatement(sql);
				pstmt.setString(1, messageCode.getType());
				pstmt.setString(2, messageCode.getUpperNumber());
				pstmt.setString(3, messageCode.getLowerNumber());
				rs = pstmt.executeQuery();
				if(rs.next()) {
					message = new X_SysMessage(env);
					message.setItem(rs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt, rs);
			}
	}

}
