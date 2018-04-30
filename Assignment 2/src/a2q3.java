// ---------------------------------------------
// Assignment 2 - Question 3
// Written by: Muherthan Thalayasingam, 27223064
// For COMP 248-S - Winter 2018
// ---------------------------------------------

// Prompts user to get a size and see. The size will determine the size of the output and the
// seed will determine at which number the output begins at. Then, the output will print out a 
// triangle that starts with the seed number and each row and column will increase by one until both
// are equal to the size. The increment of the value will reset to 1 after it reaches 9.

// Imported Scanner to allow user inputs to be recorded
import java.util.Scanner;

public class a2q3 {
	public static void main (String[] args) {
		Scanner input = new Scanner (System.in);

		// Starting message to welcome users
		System.out.println("**********************************************");
		System.out.println("Welcome to Nancy's Parksides Triangle Producer");
		System.out.println("**********************************************");
		System.out.println();
		
		// Prompts user to give a size for the output
		System.out.print("Size (must be between 5 and 10 inclusive): ");
		int size = input.nextInt();
		
		// Ensures that the size is above 4 and below 11, otherwise prompt user again
		while (size < 5 || size > 10) {
			System.out.print("Size (must be between 5 and 10 inclusive): ");
			size = input.nextInt();
		}
		
		// Prompts user to give a seed as a starting point
		System.out.print("Seed (must be between 1 and 9 inclusive): ");
		int seed = input.nextInt();
		
		// Ensures that the seed is above 0 and below 10, otherwise prompt user again
		while (seed < 1 || seed > 9) {
			System.out.print("Seed (must be between 1 and 9 inclusive): ");
			seed = input.nextInt();
		}
		
		// Starts the row at 1, and until the row is equal to the size, it will loop
		int row = 1;
		while (row <= size) {
			// This ensures that depending on which iteration we're on, the row size is equivalent
			// For example, on the 2nd row, we only have 2 columns.
			int i = row;
			// This portion does the increment so that each column increases by one
			// The seed resets to 1 after 9.
			while (i>0) {
				System.out.print(seed++ +"\t");
				if (seed == 10) {
					seed = 1;
				}
				i--;
			}
			System.out.println();
			row++;
		}
		
		// Exit message.
		System.out.println();
		System.out.println("All done!");
		
	}
}
