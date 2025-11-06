package busiframe3.generate;

import busiframe3.core.Environmwnt;
import busiframe3.core.Message;
import busiframe3.core.MessageCode;

/**
 * 設定情報の生成用実行クラス<br>
 * @since 2025/09/20
 * @version 1.0 2025/09/20 新規作成
 */
public class RunGenerate {
	
	// 環境情報の定数値 TODO 外部化 2025/10/07
	// DB接続情報
	public final static String DNS = "jdbc:mariadb://localhost:3306/busiframe"; // デフォルトのDNS
	public final static String USER = "root";	 // デフォルトのユーザー名
	public final static String PASSWORD = "qaz12wsx"; // デフォルトのパスワード

	public static void main(String[] args) {
		// 環境情報生成
		Environmwnt env = new Environmwnt();
		// TODO 外部隠蔽を行う事 2025/10/07
		env.setDsn(DNS);
		env.setPassword(PASSWORD);
		env.setUser(USER);
		// メッセージクラス
		Message msg = new Message(env);
		// 開始メッセージ
		msg.consoleOut(new MessageCode("IN001001"), "システム生成");
		 
		// 完了メッセージ
		
	}

}
