package Test;

import java.io.File;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static void main(String[] args) {
		String excelFilePath = "C:\\Users\\SBHOJNAG\\Desktop\\WFH\\New folder\\Book12.xlsx";
		String password = "qwerty";
		File excel_file = new File(excelFilePath);
		Workbook workbook = null ;
		String[] char_set = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9","@","#","$","%"};
		try {
			for (int no_of_chars=1;  no_of_chars <=12; no_of_chars=no_of_chars+1) {

				for (int j=0;  j <char_set.length;j=j+1) {
				
			//		password = char_set
					
				}

			}
			//workbook =	WorkbookFactory.create(excel_file, password);
			System.out.println("Password is :-" + password);
			//workbook.close();
		} catch (Exception ex) {
		//	ex.printStackTrace();
		}
	}
}