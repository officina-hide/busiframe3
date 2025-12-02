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
		alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+EQ+"Sys_Column"+SM+P_COLUMN_NAME+"=column_type;"
			+P_COLUMN_TYPE+EQ+C_INT+SM
			+P_IS_NOT_NULL+SM
			+P_COMMENT+EQ+"カラム種別"));
		alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+EQ+"Sys_Column"+SM+P_COLUMN_NAME+"=column_size;"
			+P_COLUMN_TYPE+EQ+C_INT+SM
			+P_COMMENT+EQ+"カラムサイズ"));
		alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+EQ+"Sys_Column"+SM+P_COLUMN_NAME+"=is_not_null;"
			+P_COLUMN_TYPE+EQ+C_BOOLEAN+SM
			+P_IS_NOT_NULL+SM
			+P_DEFAULT_VALUE_NSQ+EQ+"false;"
			+P_COMMENT+EQ+"NOT NULL設定"));
		alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+EQ+"Sys_Column"+SM+P_COLUMN_NAME+"=is_primary_key;"
			+P_COLUMN_TYPE+EQ+C_BOOLEAN+SM
			+P_IS_NOT_NULL+SM
			+P_DEFAULT_VALUE_NSQ+EQ+"false;"
			+P_COMMENT+EQ+"主キー設定"));
		alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+EQ+"Sys_Column"+SM+P_COLUMN_NAME+"=description;"
			+P_COLUMN_TYPE+EQ+C_TEXT+SM+P_COLUMN_SIZE+EQ+"3000;"
			+P_COMMENT+EQ+"説明"));
		alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+EQ+"Sys_Column"+SM+P_COLUMN_NAME+"=comment;"
			+P_COLUMN_TYPE+EQ+C_STRING+SM+P_COLUMN_SIZE+EQ+"255;"
			+P_COMMENT+EQ+"コメント(カラム論理名)"));
		alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+"=Sys_Column;"+P_COLUMN_NAME+"=created_at;"
				+ P_COLUMN_TYPE+EQ+C_DATETIME+SM+P_DEFAULT_VALUE_NSQ+EQ+"CURRENT_TIMESTAMP;"
				+P_IS_NOT_NULL+SM
				+P_COMMENT+EQ+"作成日時"));
			alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+"=Sys_Column;"+P_COLUMN_NAME+"=updated_at;"
				+ P_COLUMN_TYPE+EQ+C_DATETIME+SM+P_DEFAULT_VALUE_NSQ+EQ+"CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;"
				+P_IS_NOT_NULL+SM
				+P_COMMENT+EQ+"更新日時"));
		
		for (ParamCollection param : alterColumnParams) {
			gu.alterColumns(param);
		}
	}

}
