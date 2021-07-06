package Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.WorkbookFactory;

class Cracker2 implements Runnable {

	 private 	int start;
	 private 	int end;
	 private 	static boolean DONE = false;
	 private 	String found;
	 private	String excelFilePath = "C:\\Users\\SBHOJNAG\\Desktop\\WFH\\Pers_Plan.xlsx";
	 private	File excel_file = new File(excelFilePath);
	 public Cracker2(int s, int e) {
		 System.out.println("Cracker.Cracker()"+s+"and"+e);
	  start = s;
	  end = e;
	 }


	 @Override
	 public void run() {

	

	  if (DONE) {
	   long duration = System.currentTimeMillis() - PasswordCracker.START_TIME;
	   System.out.println("Password cracked in " + TimeUnit.MILLISECONDS.toSeconds(duration) + "." + TimeUnit.MILLISECONDS.toMillis(duration) + " sec. Password was = " + found);
	  } else {
	   System.out.println("Password not cracked for subset [" + start + ", " + end + "]");
	  }
	 }

	}
