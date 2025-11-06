package busiframe3.core.dao;

import java.sql.ResultSet;

import busiframe3.core.Environmwnt;

/**
 * システムメッセージDAOクラス<br>
 * @since 2025/10/01
 * @version 1.0 2025/10/01 新規作成
 */
public class X_SysMessage {

	/** 環境情報 */
	private Environmwnt env;
	
	// テーブル項目
	private Integer id;
	private String messageType;
	private Integer messageLevel;
	private String upperNumber;
	private String lowerNumber;
	private String messageText;
	private String relatedInfo;
	
	
	/**
	 * コンストラクタ<br>
	 * @param env 環境情報
	 */
	public X_SysMessage(Environmwnt env) {
		this.env = env;
	}


	public Environmwnt getEnv() {
		return env;
	}

	/**
	 * 項目設定<br>
	 * @since 2025/10/06
	 * @param rs 結果セット
	 */
	public void setItem(ResultSet rs) {
		try {
			this.id = rs.getInt("id");
			this.messageType = rs.getString("message_type");
			this.messageLevel = rs.getInt("message_level");
			this.upperNumber = rs.getString("upper_number");
			this.lowerNumber = rs.getString("lower_number");
			this.messageText = rs.getString("message_text");
			this.relatedInfo = rs.getString("related_info");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setEnv(Environmwnt env) {
		this.env = env;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMessageType() {
		return messageType;
	}


	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}


	public Integer getMessageLevel() {
		return messageLevel;
	}


	public void setMessageLevel(Integer messageLevel) {
		this.messageLevel = messageLevel;
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


	public String getMessageText() {
		return messageText;
	}


	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}


	public String getRelatedInfo() {
		return relatedInfo;
	}

	public void setRelatedInfo(String relatedInfo) {
		this.relatedInfo = relatedInfo;
	}

}
