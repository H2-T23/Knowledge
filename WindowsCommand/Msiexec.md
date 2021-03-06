# MsiExec

-------------------------------------------------------------------------------
## 1. インストールまたは構成する

### 1.1 Syntax

	MsiExec /i {Package | ProductCode}

### 1.2 Parameters

|Parameters	|												|
|:----------|:----------------------------------------------|
|/i			|インストールまたは構成する						|
|Package	|Windowsインストールパッケージファイルの名前	|
|ProductCode|WindowsインストールパッケージのGUID			|

### 1.3 Examples

*	A:\Example.msiから製品をインストールする


'''
msiexec /i A:\Example.msi
'''


-------------------------------------------------------------------------------
## 2. 管理者用インストールオプションを使用する

### 2.1 Syntax

	msiexec /a Package
	
### 2.2 Parameters

|Parameters		|												|
|:--------------|:----------------------------------------------|
|/a				|管理者用インストールオプションを適用する		|
|Package		|Windowsインストーラパッケージファイルの名前	|
	
	
-------------------------------------------------------------------------------
## 3. 修復する

### 3.1 Syntax

	msiexec /f[p][o][e][d][c][a][u][m][s][v] {Package | ProductCode}
	
### 3.2 Parameters

|Parameters		|														|
|:--------------|:------------------------------------------------------|
|/f				|以下のコマンドオプションのうち、1つ以上を有効にする	|
|p				|	|
|o				|	|
|e				|	|
|d				|	|
|c				|	|
|a				|	|
|u				|	|
|m				|	|
|s				|	|
|v				|	|
|Package		|Windowsインストーラパッケージファイルの名前			|
|ProduceCode	|WindowsインストーラパッケージのGUID					|


### 3.3 Examples

* インストールパッケージを修復する

'''
	msiexec /fpecms Example.msi
'''

	
-------------------------------------------------------------------------------
## 4. アンインストール

### 4.1 Syntax

	msiexec /x {Package | ProductCode}

### 4.2 Parameters

|Parameters		|														|
|:--------------|:------------------------------------------------------|
|/x				|アンインストールする									|
|Package		|Windowsインストーラパッケージファイルの名前			|
|ProduceCode	|WindowsインストーラパッケージのGUID					|

