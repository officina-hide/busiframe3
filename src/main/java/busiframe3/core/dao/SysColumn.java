package busiframe3.core.dao;

import java.util.ArrayList;
import java.util.List;

import busiframe3.core.Environmwnt;
import busiframe3.core.I_BaseCharactor;
import busiframe3.core.ParamCollection;
import busiframe3.generate.GenerateUtils;

/**
 * カラム情報モデルクラス<br>
 * @since 2025/11/27
 * @version 1.0 2025/11/27 新規作成
 */
public class SysColumn implements I_BaseCharactor {

	/** 環境情報 */
	private Environmwnt env;
	
	/**
	 * コンストラクタ<br>
	 * @param env 環境情報
	 */
	public SysColumn(Environmwnt env) {
		this.env = env;
	}

	/**
	 * カラム情報初期化<br>
	 * ・カラム情報テーブルの構築<br>
	 * ・カラム情報登録<br>
	 * @since 2025/11/27
	 */
	public void initialize() {
		ParamCollection tableDropParams = new ParamCollection("COMMAND=TABLE_DROP;NAME=Sys_Column");
		GenerateUtils gu = new GenerateUtils(env);
		gu.dropTable(tableDropParams);
		ParamCollection tableCreateParams = new ParamCollection("COMMAND=TABLE_CREATE;NAME=Sys_Column;COMMENT=テーブル項目情報;");
		gu.createTable(tableCreateParams);
		List<ParamCollection> alterColumnParams = new ArrayList<>();
		alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+EQ+"Sys_Column"+SM+P_COLUMN_NAME+"=table_id;"
			+P_COLUMN_TYPE+EQ+C_INT+SM
			+P_IS_NOT_NULL+SM
			+P_COMMENT+EQ+"テーブルID"));
		alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+EQ+"Sys_Column"+SM+P_COLUMN_NAME+"=column_name;"
			+P_COLUMN_TYPE+EQ+C_STRING+SM+P_COLUMN_SIZE+EQ+"100;"
			+P_IS_NOT_NULL+SM
			+P_COMMENT+EQ+"カラム物理名"));
		
		for (ParamCollection param : alterColumnParams) {
			gu.alterColumns(param);
		}
	}

}
