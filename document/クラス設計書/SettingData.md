# SettingDataクラス  

### initializing(Enbironment env)  
- 設定情報を保存する為の環境構築  
テーブル[Sys_Setting]構築
### createData(String group, int seq, BigDecimal(3,2) version, String command, ParamData param)  

  設定情報作成

### 参考情報
- group  
  "core" - システムの基盤となる情報  
  "project" - 開発管理    
  "educate" - 教育機能  
  "account" - 会計機能  

