# CertUtil

## hashfileダイジェスト表示
ファイルに暗号化ハッシュを生成し表示する
### [Syntax]

```
	CertUtil [Options] -hashfile InFile [HashAlgorithm]
```

|Options					|												|
|:--------------------------|:----------------------------------------------|
|Unicode					|リダイレクトされた出力をUnicodeとして書き込む	|
|gmt						|時刻をGMTで表示								|
|seconds					|時間を秒とミリ秒で表示							|
|v							|メッセージを詳細に表示							|
|privatekey					|パスワードと秘密キーのデータ表示				|
|pin PIN					|スマートカードのPIN							|
|sid WELL_KNOWON_SID_TYPE	|数値SID										|
|							|22:ローカルシステム							|
|							|23:ネットワークシステム						|
|							|24:ローカルサービス							|


|HashAlgorithm	|
|:--------------|
|MD2			|
|MD4			|
|MD5			|
|SHA1			|
|SHA256			|
|SHA384			|
|SHA512			|

