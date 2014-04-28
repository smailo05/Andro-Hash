package inf.biskra.application_hash;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class method {
	

	//le méthode de hachage MD5 pour un text
	
	public static String getEncodedMD5(String key) {
		byte[] uniqueKey = key.getBytes();
		byte[] hash = null;
		try {
			hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
		} catch (NoSuchAlgorithmException e) {
			throw new Error("no MD5 support in this VM");
		}
		StringBuffer hashString = new StringBuffer();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				hashString.append('0');
				hashString.append(hex.charAt(hex.length() - 1));
			} else {
				hashString.append(hex.substring(hex.length() - 2));
			}
		}
		return hashString.toString();
	}

	
	//le méthode de hachage SHA1 pour un text
	
	public static String getEncodedSHA1(String key) {
		byte[] uniqueKey = key.getBytes();
		byte[] hash = null;
		try {
			hash = MessageDigest.getInstance("SHA1").digest(uniqueKey);
		} catch (NoSuchAlgorithmException e) {
			throw new Error("no SHA-384 support in this VM");
		}
		StringBuffer hashString = new StringBuffer();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				hashString.append('0');
				hashString.append(hex.charAt(hex.length() - 1));
			} else {
				hashString.append(hex.substring(hex.length() - 2));
			}
		}
		return hashString.toString();
	}

	//le méthode de hachage SHA-256 pour un text
	
	public static String getEncodedSHA256(String key) {
		byte[] uniqueKey = key.getBytes();
		byte[] hash = null;
		try {
			hash = MessageDigest.getInstance("SHA-256").digest(uniqueKey);
		} catch (NoSuchAlgorithmException e) {
			throw new Error("no SHA-384 support in this VM");
		}
		StringBuffer hashString = new StringBuffer();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				hashString.append('0');
				hashString.append(hex.charAt(hex.length() - 1));
			} else {
				hashString.append(hex.substring(hex.length() - 2));
			}
		}
		return hashString.toString();
	}


	
	//le méthode de hachage SHA-384 pour un text
	
	public static String getEncodedSHA384(String key) {
		byte[] uniqueKey = key.getBytes();
		byte[] hash = null;
		try {
			hash = MessageDigest.getInstance("SHA-384").digest(uniqueKey);
		} catch (NoSuchAlgorithmException e) {
			throw new Error("no SHA-384 support in this VM");
		}
		StringBuffer hashString = new StringBuffer();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				hashString.append('0');
				hashString.append(hex.charAt(hex.length() - 1));
			} else {
				hashString.append(hex.substring(hex.length() - 2));
			}
		}
		return hashString.toString();
	}
	
}
