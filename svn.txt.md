



	mkdir -p /home/svn/repos/sample
	svnadmin create /home/svn/repos/sample

	svn mkdir file://localhost/home/svn/repos/sample/trank -m "create"
	svn mkdir file://localhost/home/svn/repos/sample/branches -m "create"
	svn mkdir file://localhost/home/svn/repos/sample/tags -m "create"

	svn import /tmp/sample file:://localhost/host/svn/repos/sample/trunk -m "import trunk"


#リポジトリを作成する前に

	リポジトリには複数のプロジェクトを入れてもいいし、
	１つのプロジェクト毎にリポジトリを作ってもいい。
	これは使用者の好みの問題らしい。

	リビジョンはリポジトリに対して振られるので、
	私は１プロジェクト毎にリポジトリを作るのがいいと思う。
	複数リポジトリを作る場合は、あちこちのディレクトリに作るのではなく。
	```
	/usr/local/svnroot/repos1
	/usr/local/svnroot/repos2
	`	
	のように１つディレクトリを決めえて、その下に作っていくのがいいと思う。
	（svnserveで公開するときのことを考えると）
	
#リポジトリを作成する

	```
	$ mkdir repos
	$ svnadmin create repos
	`
	
	これだけ。
	次にインポートを試してみること。
	
	POSの場合は、リポジトリの所有者をposにしたかったので、
	次のようにした
	rootになって、
	```
	mkdir /usr/local/pos_repos
	svadmin create /usr/local/pos_repos
	chwon -R pos:pos /usr/local/pos_repos
	`

#importする前に、

	subversionではブランチやタグがディレクトリと同じ扱いで、
	trunkというディレクトリを作って、そこにトランクを入れる。

	よって、
	```
	repos/trunk
	repos/branches
	repos/tags
	```
	`という３個のトップレベルディレクトリを作るのが普通らしい。
	（ただし、１リポジトリ複数プロジェクトの場合はちょっと違ったりする）

	そしてプロジェクトをtrunkの下にimportする。
	アクセスするときは
	```
	svn://172.16.100.43/trunk/pos
	```
	のようになる。

	subversionを使ってインポートする場合は、ダイアログでこの辺りを設定できる。

	リポジトリのレイアウトには２つの方法があり、良いと思う方を使えばよいようです。
	各プロジェクト毎にtrunk/brronchesを設ける方法
	```
	repos
		+--- projA
		|		+--- trunk
		|		+--- branches
		+--- projB
		|		+--- trunk
		|		+--- bbranches
	`


