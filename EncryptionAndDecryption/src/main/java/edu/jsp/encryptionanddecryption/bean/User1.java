package edu.jsp.encryptionanddecryption.bean;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class User1 {
	
	public static final String ALGORITHMRITHM = "AES" ;
	
	public static final String key  = "this is pa5swo6d" ;
	
	public static void main(String[] args) {
		
		String plainText = "pa55w06d" ;
		
		String encryptedTexct = encrypt(plainText) ;
		System.out.println("Encrypted Text :"+encryptedTexct);
		
		String decryptedText =decrypted(encryptedTexct) ;
        System.out.println("Decrypted Text: " + decryptedText);
	}

	public static String decrypted(String encryptedTexct) {
		
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHMRITHM) ;
		
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHMRITHM) ;
			
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			
			byte[] encryptedBytes = Base64.getDecoder().decode(encryptedTexct);
			
            byte[] decryptedBytes = null;
			try {
				decryptedBytes = cipher.doFinal(encryptedBytes);
			} catch (IllegalBlockSizeException | BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return new String(decryptedBytes);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

	public static String encrypt(String plainText) {
		
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), plainText) ;
		
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHMRITHM) ;
			
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			
			byte[] encryptedBytes = cipher.doFinal(plainText.getBytes()) ;
			
			return Base64.getEncoder().encodeToString(encryptedBytes);
			
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
