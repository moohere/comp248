// ---------------------------------------------
// Assignment 1 - Question 1
// Written by: Muherthan Thalayasingam, 27223064
// For COMP 248-S - Winter 2018
// ---------------------------------------------

// Retrieves user information regarding their studies and then
// returns an organized output of the provided information

// Imported Scanner to allow user inputs to be recorded
import java.util.Scanner;

public class a1q1 {
	public static void main (String[] args) {
		Scanner userInput = new Scanner (System.in);
		
		// Starting message to welcome users and ask for their information
		System.out.println("Welcome, please enter the following information: ");

		System.out.println();
		
		// Below are all the information that we need to collect, each one assigned to a variable
		System.out.print("First Name: ");
		String fname = userInput.nextLine();
		
		System.out.print("Last Name: ");
		String lname = userInput.nextLine();
		
		System.out.print("Major: ");
		String major = userInput.nextLine();
		
		System.out.print("Year: ");
		int year = userInput.nextInt();
		
		System.out.print("Student Number: ");
		int snumber = userInput.nextInt();
		
		// Used to skip a line since the previous input was an int and we need a String input next
		String skip = userInput.nextLine();
		
		System.out.print("Login: ");
		String login = userInput.nextLine();
		
		System.out.print("GPA (0.0 - 4.3): ");
		float gpa = userInput.nextFloat();
		
		// A simple interface for the output
		System.out.println();
		System.out.println("--------------------------");
		System.out.println("Student Information System");
		System.out.println("--------------------------");
		System.out.println();
		
		// Output using all the user information
		System.out.println("Hello " + fname + " " + lname);
		System.out.println("Login: " + login);
		System.out.println("Student Number: " + snumber);
		System.out.println("Field and year: " + major + ", " + year);
		System.out.println("GPA: " + gpa);
		System.out.println();
		
		System.out.println("Goodbye.");
		
		userInput.close();
	}
}
