package co.grandcircus;


import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Country> countryDetails = new ArrayList<Country>();
		
		
		System.out.println("Welcome to the Countries Maintenance Application!");
		System.out.println("1-See the list of countries\n2-Add a country\n3-Exit");
		System.out.println("Enter menu number: ");
		
		int numInput = scan.nextInt();
		scan.nextLine();
		
		while(numInput != 3) {
			if(numInput == 1) {
				System.out.println(countryDetails);
				numInput = scan.nextInt();
				
			}else if(numInput == 2) {
				System.out.println("Enter a country: ");
				String countryInput = scan.next();
				
				System.out.println("Enter the population: ");
				int population = scan.nextInt();
				
				Country newCountry = new Country(countryInput, population);
				countryDetails.add(newCountry);
				
				scan.nextLine();
				System.out.println("Country: " + countryInput);
				System.out.println("Country Population: " + population);
			}else {
				System.out.println("Bye Bye");
			}
		}
		
		
	}
}	
