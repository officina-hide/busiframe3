package busiframe3.core.dao;

import java.util.ArrayList;
import java.util.List;

import busiframe3.core.Environmwnt;
import busiframe3.core.I_BaseCharactor;
import busiframe3.core.ParamCollection;
import busiframe3.generate.GenerateUtils;

/**
 * テーブル情報マネージャークラス<br>
 * @since 2025/11/13
 * @version 1.0 2025/11/13 新規作成
 */
public class SysTable extends BaseDAO implements I_BaseCharactor {

	/** 環境情報 */
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
		List<ParamCollection> alterColumnParams = new ArrayList<>();
		alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+"=Sys_Table;"+P_COLUMN_NAME+"=table_name;"
			+ P_COLUMN_TYPE+EQ+C_STRING+SM+P_COLUMN_SIZE+EQ+"100;"
			+P_IS_NOT_NULL+SM+P_IS_UNIQUE+SM
			+P_COMMENT+EQ+"テーブル物理名"));
		alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+"=Sys_Table;"+P_COLUMN_NAME+"=description;"
			+ P_COLUMN_TYPE+EQ+C_STRING+SM+P_COLUMN_SIZE+EQ+"255;"
			+P_COMMENT+EQ+"説明"));
		alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+"=Sys_Table;"+P_COLUMN_NAME+"=comment;"
			+ P_COLUMN_TYPE+EQ+C_STRING+SM+P_COLUMN_SIZE+EQ+"255;"
			+P_COMMENT+EQ+"コメント"));
		alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+"=Sys_Table;"+P_COLUMN_NAME+"=created_at;"
			+ P_COLUMN_TYPE+EQ+C_DATETIME+SM+P_DEFAULT_VALUE_NSQ+EQ+"CURRENT_TIMESTAMP;"
			+P_IS_NOT_NULL+SM
			+P_COMMENT+EQ+"作成日時"));
		alterColumnParams.add(new ParamCollection("COMMAND=ALTER_COLUMN_ADD;"+P_TABLE_NAME+"=Sys_Table;"+P_COLUMN_NAME+"=updated_at;"
			+ P_COLUMN_TYPE+EQ+C_DATETIME+SM+P_DEFAULT_VALUE_NSQ+EQ+"CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;"
			+P_IS_NOT_NULL+SM
			+P_COMMENT+EQ+"更新日時"));
		for (ParamCollection param : alterColumnParams) {
			gu.alterColumns(param);
		}
		// テーブル情報登録処理
		List<ParamCollection> entryDataParams = new ArrayList<>();
		entryDataParams.add(new ParamCollection("COMMAND=ENTRY_DATA;"+P_TABLE_NAME+"=Sys_Table;"
			+ "table_name"+EQ+"Sys_Table"+SM
			+"description"+EQ+"システムで使用するテーブルの情報を管理する。"+SM
			+"comment"+EQ+"テーブル情報"));
		gu.entryData(entryDataParams);
		
	}
}
