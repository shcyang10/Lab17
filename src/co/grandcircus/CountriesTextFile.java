package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class CountriesTextFile {
	
	public static void readFromFile() {
		String fileName = "countries.txt";
		Path path = Paths.get("country_list", fileName);
		
		File file = path.toFile();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("Something happened with the file...");
		} catch (IOException e) {
			System.out.println("Something happened when attempting to read from the file...");
		}
	}
	public static void writeToFile(ArrayList<Country> Countries) {

		String fileName = "countries.txt";

		Path path = Paths.get(fileName);

		File file = path.toFile();
		
		if (file == null) {
		file = new File("countries.txt");
		  
		
		try {
			if (file.createNewFile())
			{
			    System.out.println("File is created!");
			} else {
			    System.out.println("File already exists.");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}
		PrintWriter output = null;
		try {

			output = new PrintWriter(new FileOutputStream(file, true)); 
			for (Country c : Countries) {
				output.println(c.toString());
			}

		} catch (FileNotFoundException e) {
			System.out.println("Hey, contact customer service!");

		} finally {
			output.close();
		}
	}
}	