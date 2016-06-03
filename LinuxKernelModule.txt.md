
# Linuxカーネルモジュール入門

## ビルド環境(Fedora)

```
	> su							# 管理者になる
	> yum install rpmdeevtools
	> yum install yum-utils
	> exit							# 一般ユーザに戻る
	> cd
	> rpmdev-setuptree
	
	> su							# 管理者になる
	> yum-builddep kernel-2.6.23.15-80.fc7
	> exit							# 一般ユーザになる
	> rpm -Uvh kernel-2.6.23.15.80.fc7.src.rpm
	> ls ~/rpmbuild/SOURCES/
	
	> cd ~/rpmbuild/SPECS/
	> rpmbuild -bp --target=`uname -m` kernel-2.6.spec
	> cd ~/rpmbuild/BUILD/kernel-2.6.23/linux-2.6.23.i686/
	
	> make
	
```

## ビルド環境(Debian)

```
	> su 
	> uname -a	# カーンバージョン確認 
	
	> apt-get install kernel-package
	> apt-get install linux-source-2.6.26
	> exit

	> mkdir ~/kernel
	> cd ~/kernel
	> tar xvfj /usr/src/linux-source-2.6.26.tar.bz2


	# MakefileのEXTRAVERSIONを変更する

	> vi Makefile

	# configのコピー
	> cp /boot/config-2.6.26-686 .config
	> make
```
	
## エントリーモデル(modtest.c)

```
	#include <linux/module.h>
	#include <linux/kernel.h>
	
	static int	__init	modtest_module_init(void)
	{
		printf( KERN_INFO"modtest is loaded\n" );
		return 0;
	}
	
	static void	__exit	modtest_module_exit(void)
	{
		printf( KERN_INFO"modtest is remove\n" );
	}
	
	// ユーザ定義関数の登録
	module_init( modtest_module_init );
	module_exit( modtext_module_exit );
	
	// `/sbin/modinfo`実行時に表示されるモジュール情報
	MODULE_DESCRIPTION( "modtest" );
	MODULE_LICENSE( "GGPL2" );	
```

## メイクファイル(makefile)

```
	obj-m:= modtest.o
	ROOTDIR := ~/rpmbuild/BUILD/kernel-2.6.23/linux-2.6.23.i686/
	PWD := $(shell pwd)
	
	
	all:
		$(MAKE) -C $(ROOTDIR) M=$(PWD) modules
	clean:
		$(RM) -f *.o *.ko
	
```

## 実行

```
	> su
	> /sbin/insmod modtest.ko
	> /sbin/lsmod | grep modtest
	> /sbin/rmmod modtest
	> exit
```

## 実行結果

```
	modtest is loaded
	modtest is removed
```

## モジュールパラメータ

```
	#include	<linux/module.h>
	#include	<linux/kernel.h>
	
	static char*	str = "parameters";
	
	static	int		__init	modtext_module_init(void)
	{
		printf( KERN_INFO "modtest is loaded %s.\n", str );
		return 0;
	}
	
	static	void	__exit	modtest_module_exit(void)
	{
		printf( KERN_INFO "modtest is remove.\n" );
	}
	
	module_param( str, charp, S_IRUO );
	module_init( modtest_module_init );
	module_exit( modtest_module_exit );
	
	MODULE_PARM_DESC( str, "test param" );
	MODULE_DESCRIPTION( "modtest" );
	MODULE_LICENSE( "GPL2" );
```

## procファイルシステム

ユーザがモジュールとデータをやり取りするときに、何かしらのインターフェイスを用意する必要がある。
最も簡単な方法はprocファイルシステム(procfs)を使用する方法である。

procfsとは、
/proc配下に仮想ファイルをマウントし、それをインターフェイスとしてモジュールとユーザ空間内で
データのやりとりをするものである。
例として/proc/driver/modtestというインターフェイスを作成するモジュールは次のようになる。

```
	#include <linux/module.h>
	#include <linux/kernel.h>
	#include <linux/proc_fs.h>
	#include <asm/uaccess.h>

	#define	MAXBUF	(64)

	static char			buff[ MAXBUF ];
	static int			len;

	static int		proc_write( struct file* pFile
							, const char* buf
							, unsigned long len
							, void* data )
	{
	}

	static int		proc_read( char* page
							, char** begin
							, off_t ofs
							, int cnt
							, int* pEOF
							, void* data )
	{
		unsigned long	oubbyte = 0;
	}
```
