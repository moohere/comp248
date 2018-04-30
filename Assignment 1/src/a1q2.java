// ---------------------------------------------
// Assignment 1 - Question 2
// Written by: Muherthan Thalayasingam, 27223064
// For COMP 248-S - Winter 2018
// ---------------------------------------------

// Retrieves user's name and age and then returns
// what the user cannot do based on age restrictions

// Imported Scanner to allow user inputs to be recorded
import java.util.Scanner;

public class a1q2 {
	public static void main (String[] args) {
		Scanner userInput = new Scanner (System.in);
		
		// Starting message to welcome users and ask for their information
		System.out.println("Welcome, let's find out what you cannot do.");
		System.out.println("Please enter your name and age below.");
		
		// Below are the information gathered from the user, assigned to a variable
		System.out.print("Name: ");
		String name = userInput.nextLine();
		
		System.out.print("Age: ");
		int age = userInput.nextInt();
		
		// A basic interface for the output
		System.out.println();
		System.out.println("--------------------");
		System.out.println("Things you cannot do:");
		System.out.println("--------------------");
		System.out.println();
		
		// The conditional statement which returns a specific output based on the input
		System.out.print("Okay " + name + ", ");
		if (age < 16) {
			System.out.print("you can't drive, vote, nor rent a car.");
		} else if (age < 18) {
			System.out.print("you can't vote nor rent a car.");
		} else if (age < 25) {
			System.out.print("you can't rent a car.");
		} else {
			System.out.print("you can do anything legal.");
		}
		
		// A goodbye message for the end of the program
		System.out.println();
		System.out.println();
		System.out.println("Goodbye.");
		
		userInput.close();
	}
}
