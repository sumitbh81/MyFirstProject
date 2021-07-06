package Test;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PasswordCracker {


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

   executorService.submit(new Cracker(start, end));
  }

  executorService.shutdown();

 }

}