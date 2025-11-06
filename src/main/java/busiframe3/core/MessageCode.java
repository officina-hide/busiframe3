package busiframe3.core;

/**
 * メッセージコードクラス<br>
 * @since 2025/11/04
 * @version 1.0 2025/11/04 新規作成
 */
public class MessageCode {

	/** メッセージコード種別 */
	private String type;
	/** メッセージコード上位番号 */
	private String upperNumber;
	/** メッセージコード下位番号 */
	private String lowerNumber;

	/**
	 * コンストラクタ<br>
	 * メッセージコード解析して各フィールドにセットする<br>
	 * this constructer is to parse message code and set each field<br>
	 * @since 2025/11/04
	 * @param code
	 */
	public MessageCode(String code) {
		if (code.length() != 8) {
			throw new IllegalArgumentException("メッセージコードの形式が不正です。(code=" + code + ")");
		}
		this.type = code.substring(0, 2);
		this.upperNumber = code.substring(2, 5);
		this.lowerNumber = code.substring(5, 8);
	}
	
	public String getType() {
		return type;
	}

	public String getUpperNumber() {
		return upperNumber;
	}

	public void setUpperNumber(String upperNumber) {
		this.upperNumber = upperNumber;
	}

	public String getLowerNumber() {
		return lowerNumber;
	}

	public void setLowerNumber(String lowerNumber) {
		this.lowerNumber = lowerNumber;
	}

	public void setType(String type) {
		this.type = type;
	}

}
