package busiframe3.core.dao;

import busiframe3.core.Environmwnt;

/**
 * システムメッセージDAOクラス<br>
 * @since 2025/10/01
 * @version 1.0 2025/10/01 新規作成
 */
public class X_SysMessage {

	/** 環境情報 */
	private Environmwnt env;
	
	/**
	 * コンストラクタ<br>
	 * @param env 環境情報
	 */
	public X_SysMessage(Environmwnt env) {
		this.env = env;
	}

	/**
	 * 特定のメッセージIdを持つメッセージ情報をロードする。<br>
	 * @since 2025/10/02
	 * @param messageId メッセージID
	 * @return true:ロード成功 false:ロード失敗
	 */
	public boolean load(int messageId) {
		// TODO とりあえずFalseを返すで実装する。
		return false;
	}

	/**
	 * メッセージ情報環境の生成<br>
	 * TODO 本来の実装は別クラスも検討する。<br>
	 * @since 2025/10/02
	 */
	public void create() {
		
	}

}
