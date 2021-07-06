package Test;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PasswordCracker2 {


 public static char[] ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%_".toCharArray();
 public static final int PASSWORD_MAX_LENGTH = 14;
 public static long START_TIME;

 public static void main(String[] args) throws NoSuchAlgorithmException {
  int cores = Runtime.getRuntime().availableProcessors();
  int lengthSet = PASSWORD_MAX_LENGTH / cores;
  int end = 5;

  START_TIME = System.currentTimeMillis();

  ExecutorService executorService = Executors.newFixedThreadPool(cores);

  while (end < PASSWORD_MAX_LENGTH) {
   int start = end + 1;
   end = start + lengthSet;

   if (end > PASSWORD_MAX_LENGTH)
    end = PASSWORD_MAX_LENGTH;

   
   for (int length = start; length <= end; length++) {
	   StringBuilder sb = new StringBuilder();
	   sb.setLength(length);
	   generate(sb, 0);
	  }
   
   executorService.submit(new Cracker(start, end));
  }

  executorService.shutdown();

 }

 public static void generate(StringBuilder sb, int n) {

	  if (n == sb.length()) {
	   String candidate = sb.toString();
//	   System.out.println("Cracker.generate()"+candidate);
	   // check password


	   return;
	  }

	  for (int i = 0; i < PasswordCracker.ALPHABET.length && !DONE; i++) {
	   char letter = PasswordCracker.ALPHABET[i];
	   sb.setCharAt(n, letter);
	   generate(sb, n + 1);
	  }

	 }

 
}