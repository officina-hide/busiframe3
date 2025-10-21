package busiframe3.core;

/**
 * 定型文字インターフェースクラス<br>
 */
public interface I_BaseCharactor {

	/** スペース */
	public final static String SP = " ";
	/** イコール */
	public final static String EQ = "=";
	/** シングルクォーテーション */
	public final static String SQ = "'";
	/** セミコロン */
	public final static String SM = ";";
	
	/** テーブル名 */
	public final String P_TABLE_NAME = "tableName";
	/** カラム名　*/
	public final String P_COLUMN_NAME = "columnName";
	/** カラム型　*/
	public final String P_COLUMN_TYPE = "columnType";
	/** カラムサイズ　*/
	public final String P_COLUMN_SIZE = "columnSize";
	/** NOT NULL指定　*/
	public final String P_IS_NOT_NULL = "isNotNull";
	/** コメント　*/
	public final String P_COMMENT = "comment";
	/** 一意制約　*/
	public final String P_IS_UNIQUE = "isUnique";
	/** 主キー指定　*/
	public final String P_IS_PRIMARY_KEY = "isPrimaryKey";

	/** カラム型 : 文字列 */
	public final String C_STRING = "STRING";
	/** カラム型 : 整数 */
	public final String C_INT = "INT";
	/** カラム型 : 文字大 */
	public final String C_TEXT = "TEXT";
	/** カラム型 : 真偽値 */
	public final String C_BOOLEAN = "BOOLEAN";

}
