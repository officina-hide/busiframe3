package busiframe3.core;

import busiframe3.core.dao.X_SysMessage;

/**
 * メッセージクラス<br>
 * 
 * @since 2025/10/01
 * @version 1.0 2025/10/01 新規作成
 */
public class Message {

	private Environmwnt env;

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
		if (isInitialized()) {

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
		/*
		 * DAOクラスからテーブルの存在を確認し、テーブルが無い場合はテーブル構築・初期情報登録を実施する。	2025/10/01
		 */
		X_SysMessage smdao = new X_SysMessage(env);
		if(smdao.load(0) == false) {
			smdao.create();
		}
		return initialized;
	}

}
