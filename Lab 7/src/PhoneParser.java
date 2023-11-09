/*
 * PhoneParser — a helper class which can parse phone data from a string, and load
 * all the phone data from a text file.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PhoneParser {
	/*
	 * Parses a phone data string, in the following format:
	 * 
	 *     model screenSize batteryCapacity
	 *     
	 * The model name is encoded with underscores instead of spaces.
	 */
	public static Phone parse(String data) {
		// : parse the phone data string, and return a Phone object.
		// you may use string manipulation, a regex, or a Scanner
		//Task 4:
		try (Scanner scanner = new Scanner(data)){
			// set delimiter to split on spaces
			scanner.useDelimiter(" ");

			if (scanner.hasNext()) {
				String model = scanner.next().replace("_"," ");
				if (scanner.hasNextDouble() && scanner.hasNextInt()) {
					double screenSize = scanner.nextDouble();
					int batteryCapacity = scanner.nextInt();
					return new Phone(model, screenSize, batteryCapacity);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// Returns null if parsing fails
		return null;
	}

	/*
	 * Returns a PhoneList by parsing a text file containing the phone data.
	 */
	public static PhoneList parseFile(String filename) throws IOException {
		// : create a PhoneList TASK 5:
		PhoneList phoneList = new PhoneList();

		// : create a BufferedReader to read from the file TASK 5:
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

			// : for each line, parse it as a Phone and add it to the list TASK 5:
			String line;
			while ((line = reader.readLine()) != null) {
				Phone phone = parse(line);
				if (phone != null) {
					phoneList.addPhone(phone);
				}	
			}
		}
		return phoneList;
	}

}
