package busiframe3.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * パラメータ情報クラス<br>
 * 
 * @since 2025/10/13
 * @version 1.0 2025/10/13 新規作成
 */
public class ParamCollection {

	/** パラメータリスト */
	List<Map<String, String>> params = new ArrayList<>();

	public ParamCollection() {
	}

	/**
	 * コンストラクタ<br>
	 * 引数のパラメータ情報から初期化を行う<br>
	 * 
	 * @since 2025/10/15
	 * @param data パラメータ情報
	 */
	public ParamCollection(String data) {
		for (String param : data.split(";")) {
			String[] keyValue = param.split("=");
			if (keyValue.length == 2) {
				Map<String, String> map = new HashMap<>();
				String key = keyValue[0].trim();
				String value = keyValue[1].trim();
				map.put(key, value);
				params.add(map);
			}
			if(keyValue.length == 1) {
				Map<String, String> map = new HashMap<>();
				String key = keyValue[0].trim();
				map.put(key, "");
				params.add(map);
			}
		}
	}

	/**
	 * パラメータ情報取得<br>
	 * 指定されたキー名に対応するパラメータ情報を取得する。もし、キー名が見つからなかったときはnullを返す。<br>
	 * @since 2025/10/19
	 * @param keyName キー名
	 * @return パラメータ情報
	 */
	public String getData(String keyName) {
		for (Map<String, String> map : params) {
			if (map.containsKey(keyName)) {
				return map.get(keyName);
			}
		}
		return null;
	}

	/**
	 * キー名配列取得<br>
	 * @param since 2025/10/20
	 * @return キー名配列
	 */
	public List<String> getKeys() {
		List<String> keys = new ArrayList<>();
		for (Map<String, String> map : params) {
			for (String key : map.keySet()) {
				keys.add(key);
			}
		}
		return keys;
	}

}
