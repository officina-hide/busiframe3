package busiframe3.generate;

import busiframe3.core.Environmwnt;
import busiframe3.core.ParamCollection;
import busiframe3.core.dao.I_TableInformation;

/**
 * メッセージ情報関連初期化クラス<br>
 * @since 2025/10/06
 * @version 1.0 2025/10/06 新規作成
 */
public class MessageInitializer implements I_TableInformation {

	/** メッセージ情報テーブル情報 */
	private final String TABLE_PARAM_SYS_MESSAGE = "tableId=10001;tableName=sys_message;";
	private ParamCollection pc = new ParamCollection();
	
	/**
	 * コンストラクタ<br>
	 * @since 2025/10/06
	 * @param env 環境情報
	 */
	public MessageInitializer(Environmwnt env) {
		// メッセージ情報テーブル生成
		GenerateUtils gu = new GenerateUtils(env);
		gu.createTable(TABLE_NAME_SYS_MESSAGE);
		// 初期登録
	}

}
