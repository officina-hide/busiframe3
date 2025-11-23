package busiframe3.generate;

import java.util.ArrayList;
import java.util.List;

import busiframe3.core.Environmwnt;
import busiframe3.core.I_BaseCharactor;
import busiframe3.core.ParamCollection;
import busiframe3.core.dao.I_TableInformation;

/**
 * メッセージ情報関連初期化クラス<br>
 * @since 2025/10/06
 * @version 1.0 2025/10/06 新規作成
 */
public class MessageInitializer implements I_TableInformation, I_BaseCharactor {

	/** メッセージ情報テーブル情報 */
	private final String TABLE_PARAM_SYS_MESSAGE = "tableId=10001;tableName=sys_message;tableComment=メッセージ情報)";
	
	/**
	 * コンストラクタ<br>
	 * @since 2025/10/06
	 * @param env 環境情報
	 */
	public MessageInitializer(Environmwnt env) {
		// メッセージ情報テーブル生成
		GenerateUtils gu = new GenerateUtils(env);
		ParamCollection pc = new ParamCollection(TABLE_PARAM_SYS_MESSAGE);
		gu.createTableOld(pc);
		List<ParamCollection> columnParams = getSysMessageColumnParams();
		for (ParamCollection columnParam : columnParams) {
			gu.alterColumns(columnParam);
		}
		// 初期登録
		List<ParamCollection> dataParams = getSysMessageDataParams();
		gu.entryData(dataParams);
	}

	/**
	 * システムメッセージデータ情報配列取得<br>
	 * @since 2025/10/20
	 * @return システムメッセージデータ情報配列
	 */
	private List<ParamCollection> getSysMessageDataParams() {
		List<ParamCollection> params = new ArrayList<>();
		params.add(new ParamCollection(
				P_TABLE_NAME + EQ + TABLE_NAME_SYS_MESSAGE
				+ SM + "message_type" + EQ + "IN"
				+ SM + "message_level" + EQ + "1"
				+ SM + "upper_number" + EQ + "001"
				+ SM + "lower_number" + EQ + "001"
				+ SM + "message_text" + EQ + "$1の処理を開始します。"
				+ SM + "related_info" + EQ + ""));
		params.add(new ParamCollection(
				P_TABLE_NAME + EQ + TABLE_NAME_SYS_MESSAGE
				+ SM + "message_type" + EQ + "IN"
				+ SM + "message_level" + EQ + "1"
				+ SM + "upper_number" + EQ + "001"
				+ SM + "lower_number" + EQ + "002"
				+ SM + "message_text" + EQ + "$1の処理を完了しました。"
				+ SM + "related_info" + EQ + ""));
		params.add(new ParamCollection(
				P_TABLE_NAME + EQ + TABLE_NAME_SYS_MESSAGE
				+ SM + "message_type" + EQ + "IN"
				+ SM + "message_level" + EQ + "1"
				+ SM + "upper_number" + EQ + "001"
				+ SM + "lower_number" + EQ + "003"
				+ SM + "message_text" + EQ + "テーブル【$1】を削除しました。"
				+ SM + "related_info" + EQ + ""));
		params.add(new ParamCollection(
				P_TABLE_NAME + EQ + TABLE_NAME_SYS_MESSAGE
				+ SM + "message_type" + EQ + "IN"
				+ SM + "message_level" + EQ + "1"
				+ SM + "upper_number" + EQ + "001"
				+ SM + "lower_number" + EQ + "004"
				+ SM + "message_text" + EQ + "テーブル【$1】を構築しました。（id項目付き）"
				+ SM + "related_info" + EQ + ""));
		params.add(new ParamCollection(
				P_TABLE_NAME + EQ + TABLE_NAME_SYS_MESSAGE
				+ SM + "message_type" + EQ + "IN"
				+ SM + "message_level" + EQ + "1"
				+ SM + "upper_number" + EQ + "001"
				+ SM + "lower_number" + EQ + "005"
				+ SM + "message_text" + EQ + "テーブル【$1】に項目【$2】を追加しました。"
				+ SM + "related_info" + EQ + ""));
		return params;
	}

	/**
	 * システムメッセージカラム情報配列取得<br>
	 * @since 2025/10/19
	 * @return システムメッセージカラム情報配列
	 */
	private List<ParamCollection> getSysMessageColumnParams() {
		List<ParamCollection> params = new ArrayList<>();
		params.add(new ParamCollection(
				P_TABLE_NAME + EQ + TABLE_NAME_SYS_MESSAGE
				+ SM + P_COLUMN_NAME + EQ + "message_type"
				+ SM + P_COLUMN_TYPE + EQ + C_STRING
				+ SM + P_COLUMN_SIZE + EQ + "2"
				+ SM + P_IS_NOT_NULL 
				+ SM + P_COMMENT + EQ + "メッセージ種別"));
		params.add(new ParamCollection(
				P_TABLE_NAME + EQ + TABLE_NAME_SYS_MESSAGE
				+ SM + P_COLUMN_NAME + EQ + "message_level"
				+ SM + P_COLUMN_TYPE + EQ + C_STRING
				+ SM + P_COLUMN_SIZE + EQ + "1"
				+ SM + P_IS_NOT_NULL 
				+ SM + P_COMMENT + EQ + "メッセージレベル"));
		params.add(new ParamCollection(
				P_TABLE_NAME + EQ + TABLE_NAME_SYS_MESSAGE
				+ SM + P_COLUMN_NAME + EQ + "upper_number"
				+ SM + P_COLUMN_TYPE + EQ + C_STRING
				+ SM + P_COLUMN_SIZE + EQ + "3"
				+ SM + P_IS_NOT_NULL
				+ SM + P_COMMENT + EQ + "メッセージ番号1"));
		params.add(new ParamCollection(
				P_TABLE_NAME + EQ + TABLE_NAME_SYS_MESSAGE
				+ SM + P_COLUMN_NAME + EQ + "lower_number"
				+ SM + P_COLUMN_TYPE + EQ + C_STRING
				+ SM + P_COLUMN_SIZE + EQ + "3"
				+ SM + P_IS_NOT_NULL
				+ SM + P_COMMENT + EQ + "メッセージ番号2"));
		params.add(new ParamCollection(
				P_TABLE_NAME + EQ + TABLE_NAME_SYS_MESSAGE
				+ SM + P_COLUMN_NAME + EQ + "message_text"
				+ SM + P_COLUMN_TYPE + EQ + C_TEXT
				+ SM + P_COLUMN_SIZE + EQ + "255"
				+ SM + P_IS_NOT_NULL
				+ SM + P_COMMENT + EQ + "メッセージ本文"));
		params.add(new ParamCollection(
				P_TABLE_NAME + EQ + TABLE_NAME_SYS_MESSAGE
				+ SM + P_COLUMN_NAME + EQ + "related_info"
				+ SM + P_COLUMN_TYPE + EQ + C_TEXT
				+ SM + P_COLUMN_SIZE + EQ + "65535"
				+ SM + P_COMMENT + EQ + "関連情報"));
		return params;
	}

}
