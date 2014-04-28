package inf.biskra.application_hash;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class FileCheckSum {
	

	
	//Bloc de la méthode de hachage MD5 pour les fichies
	
	  public static byte[] createChecksumMD5(String filename) throws Exception {
	       InputStream fis =  new FileInputStream(filename);

	       byte[] buffer = new byte[1024];
	       MessageDigest complete = MessageDigest.getInstance("MD5");
	       int numRead;

	       do {
	           numRead = fis.read(buffer);
	           if (numRead > 0) {
	               complete.update(buffer, 0, numRead);
	           }
	       } while (numRead != -1);

	       fis.close();
	       return complete.digest();
	   }

	   // see this How-to for a faster way to convert
	   // a byte array to a HEX string
	   public static String getMD5Checksum(String filename) throws Exception {
	       byte[] b = createChecksumMD5(filename);
	       String result = "";

	       for (int i=0; i < b.length; i++) {
	           result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
	       }
	       return result;
	   }
	   
	   ////Bloc de la méthode de hachage SHA-1 pour les fichies
	   
	   public static byte[] createChecksumSHA1(String filename) throws Exception {
	       InputStream fis =  new FileInputStream(filename);

	       byte[] buffer = new byte[1024];
	       MessageDigest complete = MessageDigest.getInstance("SHA-1");
	       int numRead;

	       do {
	           numRead = fis.read(buffer);
	           if (numRead > 0) {
	               complete.update(buffer, 0, numRead);
	           }
	       } while (numRead != -1);

	       fis.close();
	       return complete.digest();
	   }

	   // see this How-to for a faster way to convert
	   // a byte array to a HEX string
	   public static String getSHA1Checksum(String filename) throws Exception {
	       byte[] b = createChecksumSHA1(filename);
	       String result = "";

	       for (int i=0; i < b.length; i++) {
	           result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
	       }
	       return result;
	   }
	   
	   //Bloc de la méthode de hachage SHA-256 pour les fichies
	   
	   
	   public static byte[] createChecksumSHA256(String filename) throws Exception {
	       InputStream fis =  new FileInputStream(filename);

	       byte[] buffer = new byte[1024];
	       MessageDigest complete = MessageDigest.getInstance("SHA-256");
	       int numRead;

	       do {
	           numRead = fis.read(buffer);
	           if (numRead > 0) {
	               complete.update(buffer, 0, numRead);
	           }
	       } while (numRead != -1);

	       fis.close();
	       return complete.digest();
	   }

	   // see this How-to for a faster way to convert
	   // a byte array to a HEX string
	   public static String getSHA256Checksum(String filename) throws Exception {
	       byte[] b = createChecksumSHA256(filename);
	       String result = "";

	       for (int i=0; i < b.length; i++) {
	           result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
	       }
	       return result;
	   }
	   ///
	   
	   
	   
		  
		//Bloc de la méthode de hachage SHA-384 pour les fichies
	   
		  public static byte[] createChecksumSHA384(String filename) throws Exception {
		       InputStream fis =  new FileInputStream(filename);

		       byte[] buffer = new byte[1024];
		       MessageDigest complete = MessageDigest.getInstance("SHA-384");
		       int numRead;

		       do {
		           numRead = fis.read(buffer);
		           if (numRead > 0) {
		               complete.update(buffer, 0, numRead);
		           }
		       } while (numRead != -1);

		       fis.close();
		       return complete.digest();
		   }
		  
		  public static String getSHA384Checksum(String filename) throws Exception {
		       byte[] b = createChecksumSHA384(filename);
		       String result = "";

		       for (int i=0; i < b.length; i++) {
		           result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
		       }
		       return result;
		   }


}
