package busiframe3.core.dao;

import busiframe3.core.Environmwnt;
import busiframe3.core.ParamCollection;
import busiframe3.generate.GenerateUtils;

/**
 * テーブル情報マネージャークラス<br>
 * @since 2025/11/13
 * @version 1.0 2025/11/13 新規作成
 */
public class SysTable extends BaseDAO {

	/** 環境情報 */
	@SuppressWarnings("unused")
	private Environmwnt env;
	
	/**
	 * コンストラクタ<br>
	 * @param env 環境情報
	 */
	public SysTable(Environmwnt env) {
		this.env = env;
	}

	/**
	 * テーブル情報初期化<br>
	 * ・テーブル情報テーブルの構築<br>
	 * ・テーブル情報登録<br>
	 * @since 2025/11/14
	 */
	public void initialize() {
		ParamCollection tableDropParams = new ParamCollection("COMMAND=TABLE_DROP;NAME=Sys_Table");
		GenerateUtils gu = new GenerateUtils(env);
		gu.dropTable(tableDropParams);
		ParamCollection tableCreateParams = new ParamCollection("COMMAND=TABLE_CREATE;NAME=Sys_Table;COMMENT=テーブル情報;");
		gu.createTable(tableCreateParams);
	}
}
