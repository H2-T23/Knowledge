/*
	 �Í����ɂ���閧���������������Í�������R�[�h���ȉ��Ɏ����B
	�g�p����Í����A���S���Y���́uDES�Í��v�ł��B
	�iAES�Í����̃T���v���́u�v���Q�Ɓj
	�Í����ƕ����ł́AKeyGenerator�N���X���g���Ĕ閧���𐶐����A
	Clipher�N���X���g���ĈÍ����ƕ������s���܂��B
	�����Ő���������@�ŗ��p�ł������̈Í����A���S���Y���́A�Í����A���S���Y�����Q��
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
