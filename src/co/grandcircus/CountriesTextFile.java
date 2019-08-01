package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class CountriesTextFile {
	
	public static ArrayList<Country> readFromFile() {
		ArrayList<Country> listCountries = new ArrayList<>();
		Path path = Paths.get("country_list", filename);
		
		File file = path.toFile();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = br.readLine();

			while (line != null) {
				// 1.
				String[] countryVaule = line.split(",");
				// 2.
				Country c = new Country (countryVaule[0], countryVaule[1], countryVaule[2],
						Integer.parseInt(countryVaule[3]));
				// 3.
				countries.add(c);
				line = br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("Something happened with the file...");
		} catch (IOException e) {
			System.out.println("Something happened when attempting to read from the file...");
		}
		return countries;
	}
	public static void writeToFile(ArrayList<Country> countries) {
		String fileName = "countries.txt";

		Path path = Paths.get("countries_list", fileName);

		File file = path.toFile();
		PrintWriter output = null;

		try {
			
			output = new PrintWriter(new FileOutputStream(file, false));
			for (Country c : countries) {
				output.println(c);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Hey, check again!");
		} finally {
			output.close();
		}

	}
	public static void createOurFile() {
		String fileName = "countries.txt";

		Path path = Paths.get("countries_list", fileName); 
		if (Files.notExists(path)) {

			try {
				Files.createFile(path);
				System.out.println("The file was created successfully!");
			} catch (IOException e) {

				System.out.println("Oops, something went terribly wrong!");
			}
		} else {
			System.out.println("The file already exists!");
		}
	}	
	public static void createDir() {

		String dirPath = "countries_list";

		Path folder = Paths.get(dirPath);

		if (Files.notExists(folder)) {

			try {
				Files.createDirectories(folder);
				System.out.println("The file was created successfully");

			} catch (IOException e) {

				System.out.println("Something went wrong with the folder creation");
			}

		} else {
			System.out.println("The folder already exists!");
		}
	}


}
