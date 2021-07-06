package Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.WorkbookFactory;

class Cracker implements Runnable {

	 private 	int start;
	 private 	int end;
	 private 	static boolean DONE = false;
	 private 	String found;
	 private	String excelFilePath = "C:\\Users\\SBHOJNAG\\Desktop\\WFH\\Pers_Plan.xlsx";
	 private	File excel_file = new File(excelFilePath);
	 public Cracker(int s, int e) {
		 System.out.println("Cracker.Cracker()"+s+"and"+e);
	  start = s;
	  end = e;
	 }

	 public void generate(StringBuilder sb, int n) {
	  if (DONE)
	   return;

	  if (n == sb.length()) {
	   String candidate = sb.toString();
//	   System.out.println("Cracker.generate()"+candidate);
	   // check password

	   try {
		   WorkbookFactory.create(excel_file, candidate);
		   System.out.println("Cracker.generate(Password is)" + candidate);
		   found = candidate;
		   DONE = true;
	   }catch(Exception e) {
		  // e.printStackTrace();
	   }

	   return;
	  }

	  for (int i = 0; i < PasswordCracker.ALPHABET.length && !DONE; i++) {
	   char letter = PasswordCracker.ALPHABET[i];
	   sb.setCharAt(n, letter);
	   generate(sb, n + 1);
	  }

	 }

	 @Override
	 public void run() {

	  for (int length = start; length <= end && !DONE; length++) {
	   StringBuilder sb = new StringBuilder();
	   sb.setLength(length);
	   generate(sb, 0);
	  }

	  if (DONE) {
	   long duration = System.currentTimeMillis() - PasswordCracker.START_TIME;
	   System.out.println("Password cracked in " + TimeUnit.MILLISECONDS.toSeconds(duration) + "." + TimeUnit.MILLISECONDS.toMillis(duration) + " sec. Password was = " + found);
	  } else {
	   System.out.println("Password not cracked for subset [" + start + ", " + end + "]");
	  }
	 }

	}
