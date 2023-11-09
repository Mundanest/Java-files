/*
 * FindBestPhones — the main program class, which will print the model names of all
 * the ‘best’ phones.
 */
import java.io.IOException;
import java.util.Collection;

public class FindBestPhones {
	public static String PHONES_FILE = "phone-data.txt";

	public static void main(String[] args) {
		// TODO: use the parseFile() method FROM PhoneParser.JAVA to get the phone data from the file

		// TODO: print the model names of all the best phones: getBestPhones() from PhoneList.java

		// TODO: handle I/O failures by printing an error message, that might occur in parseFile()


		try {
			PhoneList phoneList = PhoneParser.parseFile(PHONES_FILE);

			// Get the best phones from the phone list
			Collection<Phone> bestPhones = phoneList.getBestPhones();

			// Print the model names of the best phones
			System.out.println("Best Phones:");
			for (Phone phone : bestPhones) {
				System.out.println(phone.getModel());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}




	}
} 
