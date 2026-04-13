import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class DataSaver {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> records = new ArrayList<>();
		String response;

		do {
			System.out.print("First Name: ");
			String firstName = in.nextLine();

			System.out.print("Last Name: ");
			String lastName = in.nextLine();

			System.out.print("ID Number: ");
			String idNumber = in.nextLine();

			System.out.print("Email: ");
			String email = in.nextLine();

			System.out.print("Year of Birth: ");
			String year = in.nextLine();

			records.add(firstName + ", " + lastName + ", " + idNumber + ", " + email + ", " + year);

			System.out.print("Add another record? (Y/N): ");
			response = in.nextLine();
		} while (response.equalsIgnoreCase("Y"));

		System.out.print("Enter file name: ");
		String fileName = in.nextLine();

		Path target = Paths.get("src", fileName + ".csv");

		try {
			Files.write(target, records);
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}