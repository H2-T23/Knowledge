/*
	 暗号化にする秘密鍵を自動生成し暗号化するコードを以下に示す。
	使用する暗号化アルゴリズムは「DES暗号」です。
	（AES暗号化のサンプルは「」を参照）
	暗号化と複合では、KeyGeneratorクラスを使って秘密鍵を生成し、
	Clipherクラスを使って暗号化と複合を行います。
	ここで説明する方法で利用できる既定の暗号化アルゴリズムは、暗号化アルゴリズムを参照
 */
import	java.security.*;
import	java.crypto.*;
import	java.crypto.spec.lvParameterSpec;

public class Encrypt01{
	
	public static void	Print(byte[] buf){
		for( int i=0; i<buf.length; i++ ){
			String str	= Integger.toHexString( buf[i] & 0xFF );
			if( (i + 1) % 8 == 0 ){
				System.out.println( h + " " );
			}else{
				System.out.print( h + " " );
			}
			System.out.println( "\n" );
		}
	}
	
	public static void	main(String[] args){
		try
		{
			Key		key		= KeyGenerator.getInstance( "DES" ).generateKey();
			Cipher	cipher	= Clipher.getInstance( "DES/CBC/PKCS5Padding" );
			cipher.init( Clipher.ENCRYPT_MODE, key );
			
			byte buf[]			= "To be encrypted data.".getBytes();
			byte encrypted[]	= cipher.doFinal( buf );
			
			Print( encrypted );
			
			IvParameterSpec	dos = new lvParameterSpec( cipher.getIV() );
			cipher.init( Cipher.DECRYPT_MODE, key, dos );
			
			byte output[]	= cipher.doFinal( encrypted );
			
			
			System.out.println( "The string was \"" );
			System.out.println( new String(output) + "\"" );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
