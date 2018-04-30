// ---------------------------------------------
// Assignment 3 - Question 2
// Written by: Muherthan Thalayasingam, 27223064
// For COMP 248-S - Winter 2018
// ---------------------------------------------

// This program prompts user to select one of 8 square patterns to create, and for each one
// there may be some follow-up questions for user to input a value for. Once all input received
// the program outputs the desired square with the appropriate patterns. The user may continue
// to play around and test out all of the squares over and over until they select the 9th option
// to exit the program. 

// Import scanner to take user input.
import java.util.Scanner;

public class a3q2 {
	public static void main (String[] args) {
		// Create the scanner
		Scanner input = new Scanner (System.in);
		// Boolean variable used for the loop that ends when user selects the 9th option
		boolean end = false;
		// Variables to keep track of the choice and the size of the squares
		int choice = 0, size = 0;
		// Variable used for the first two squares to keep track of the desired patterns
		char pattern = ' ';
		// Variable used for the third square which uses a pattern for the X and another for the space around it
		char x = ' ', aroundX = ' ';
		// Variables used for the 4th and 5th squares, keeps track of the patterns for odds or even rows/columns
		char even = ' ', odd = ' ';
		// Variables used for the 6th square, keeps track of the even or odd patterns depending on the diagonals
		char evenDiag = ' ', oddDiag = ' ';
		// Variable for the 7th square, keeps track of the starting integer
		int start = 0;
		// Variables for the 8th square, keeps track of the first and second patterns
		char first = ' ', second = ' ';
		
		// Used an array to store all the options the users can select
		String[] options = {"1 - Full square", "2 - Hollow square", "3 - An X", "4 - Horizontal bars",
				"5 - Vertical bars", "6 - Diagonal bars", "7 - Integer filled square", 
				"8 - Checkered (must be a multiple of 4)", "9 - Quit"};
		
		// Welcome message string
		System.out.println("|------------------------->>>><<<<-------------------------|");
		System.out.println("|     Welcome to the Decorated Square Drawing Program!     |");
		System.out.println("|------------------------->>>><<<<-------------------------|");
		System.out.println();
		
		// While loop that contains the program, ends when user selects option 9
		while (end == false) {
			
			// Prints all the options stored in the array using a for loop
			System.out.println("What type of square would you like?");
			for (int i = 0; i < 9; i++) {
				System.out.println("\t" + options[i]);
			}
			
			// Prompts user for the choice of square to print
			System.out.print("Enter your choice (1 to 9): ");
			choice = input.nextInt();
			
			// Ensures that the user selects an appropriate choice
			while (choice < 1 || choice > 9) {
				System.out.println("Sorry! That is an illegal choice.");
				System.out.print("Enter your choice (1 to 9): ");
				choice = input.nextInt();
			}
			System.out.println();
					
			// Switch case for size, if the choice is 1-7, it asks for rows and columns above 4, below 20
			// If choice is 8, it asks for max 20, multiple of 4, if choice 9 it exits the program
			switch(choice) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
					System.out.print("How many rows and columns (min 4 & max 20)? ");
					size = input.nextInt();
					while (size < 4 || size > 20) {
						System.out.print("How many rows and columns (min 4 & max 20)? ");
						size = input.nextInt();
					}
					break;
				case 8:
					System.out.print("How many rows and columns (max 20 and multiple of 4)? ");
					size = input.nextInt();
					while (size > 20 || size%4 != 0){
						System.out.print("How many rows and columns (max 20 and multiple of 4)? ");
						size = input.nextInt();
					}
					break;
				case 9:
					end = true;
					break;
					
			}
			
			// array1 is used for all choices aside choice 7 for which array2 is used instead
			char[][] array1 = new char[size][size];
			int[][] array2 = new int[size][size];
			
			// Switch cases to go through each choice
			switch(choice) {
			// If the first or second choice, prompts user for the pattern 
			case 1: 
				System.out.print("Which character do you want to fill your square with? ");
				pattern = input.next().charAt(0);
				System.out.println();
				// It simply prints a 2-d array that holds the pattern
				if (choice == 1) {
					System.out.println("Here is your pattern");
					System.out.println();
					for (int i = 0; i < size; i++) {
						for (int j = 0; j < size; j++) {
							array1[i][j] = pattern;	
							System.out.print(array1[i][j] + " ");
						}
						System.out.println();
					}
					System.out.println();
				}
				break;
			case 2:
				System.out.print("Which character do you want for the border? ");
				pattern = input.next().charAt(0);
				System.out.println();
				// If choice 2, it prints the pattern for the first row and the second row completely.
				// Every other row, it prints the pattern for the first and last value, but leaves the space
				// in between blank (space). 
				if (choice == 2) {
					System.out.println("Here is your pattern");
					System.out.println();
					for (int i = 0; i < size; i++) {
						for (int j = 0; j < size; j++) {
							for (int k = 0; k < size && (i != 0 || i != (size-1)); k++) {
								if (k == 0 || k == (size-1) ) 
									array1[i][k] = pattern;
								else 
									array1[i][k] = ' ';
							}
							array1[0][j] = pattern;
							array1[size-1][j] = pattern;
							System.out.print(array1[i][j] + " ");
						}
						System.out.println();
					}
					System.out.println();
				}
				break;
			// If the 3rd choice is selected, prompts user for the pattern of X and the pattern around X
			case 3:
				System.out.print("Which character do you want for the X? ");
				x = input.next().charAt(0);
				System.out.print("Which character do you want around the X? ");
				aroundX = input.next().charAt(0);
				// If choice 3, it prints the X for the two diagonals, and then puts the pattern
				// around X for the remaining values
				if (choice == 3) {
					System.out.println("Here is your pattern");
					System.out.println();
					for (int i = 0; i < size; i++) {
						array1[i][i] = x;
						array1[i][size-1-i] = x;
						for (int j = 0; j < size; j++) {
							if (array1[i][j] != x)
								array1[i][j] = aroundX;
							System.out.print(array1[i][j] + " ");
						}
						System.out.println();
					}
					System.out.println();
				}
				break;
			// If the 4th choice, prompts user for the character of the even and odd rows
			case 4:
				System.out.print("Which character do you want for the even rows? ");
				even = input.next().charAt(0);
				System.out.print("Which character do you want for the odd rows? ");
				odd = input.next().charAt(0);
				// If choice 4, it prints the odd pattern for every row that is odd (counting index + 1)
				// and prints even for every even rows (counting index + 1)
				if (choice == 4) {
					System.out.println("Here is your pattern");
					System.out.println();
					for (int i = 0; i < size; i++) {
						for (int j = 0; j < size; j++) {
							if (i%2 == 0) 
								array1[i][j] = odd;
							else
								array1[i][j] = even;
							System.out.print(array1[i][j] + " ");
						}
						System.out.println();
					}
					System.out.println();
				}
				break;
			// If the 5th choice, prompts user for the character for the even and odd columns
			case 5:
				System.out.print("Which character do you want for the even columns? ");
				even = input.next().charAt(0);
				System.out.print("Which character do you want for the odd columns? ");
				odd = input.next().charAt(0);
				// If choice 5, it prints the odd pattern for every column that is odd (counting index + 1)
				// and prints even for every even columns (counting index + 1)
				if (choice == 5) {
					System.out.println("Here is your pattern");
					System.out.println();
					for (int i = 0; i < size; i++) {
						for (int j = 0; j < size; j++) {
							if (j%2 == 0) 
								array1[i][j] = odd;
							else
								array1[i][j] = even;
							System.out.print(array1[i][j] + " ");
						}
						System.out.println();
					}
					System.out.println();
				}
				break;
			// If the 6th choice, prompts user for the the character for the even and odd diagonals
			case 6:
				System.out.print("Which character do you want for the even diagonals? ");
				evenDiag = input.next().charAt(0);
				System.out.print("Which character do you want for the odd diagonals? ");
				oddDiag = input.next().charAt(0);
				// If choice 6, it prints the even pattern for every value whose index i and j
				// are both even or are both odd and prints the odd pattern for every other value
				if (choice == 6) {
					System.out.println("Here is your pattern");
					System.out.println();
					for (int i = 0; i < size; i++) {
						for (int j = 0; j < size; j++) {
							if ((i%2 == 0 && j%2 == 0) || (i%2 != 0 && j%2 != 0) ) 
								array1[i][j] = evenDiag;
							else
								array1[i][j] = oddDiag;
							System.out.print(array1[i][j] + " ");
						}
						System.out.println();
					}
					System.out.println();
				}
				break;
			// If the 7th choice, prompts user for the starting integer and ensures it is above 0 and below 50 inclusive
			case 7:
				System.out.print("What is the starting number for your inteeger filled"
						+ " square (between 0 and 50 inclusive): ");
				start = input.nextInt();
				while (start < 0 || start > 50){
					System.out.print("What is the starting number for your inteeger filled"
							+ " square (between 0 and 50 inclusive): ");
					start = input.nextInt();
				}
				// If choice 7, it prints values starting with the start integer and adding one going 
				// down on from first row and column, and the adding as it goes down on the second row and column
				// and so on until it reaches the last row and column. Then the count goes upwards starting from the
				// second last row and last column, and decreasing the row and column
				if (choice == 7) {
					System.out.println("Here is your pattern");
					System.out.println();
					for (int i = 0; i < size; i++) {
						for (int j = 0+i; j < size; j++) {
							array2[j][i] = start;
							start++;
						}
					}
					for (int z = size-1; z > 0 ; z--) {
						for (int k = z-1; k >= 0; k--) {
							array2[k][z] = start;
							start++;
						}
					}
					for (int a = 0; a < size; a++) {
						for (int b = 0; b < size; b++)
							System.out.printf("%3d", array2[a][b]);
						System.out.println();
					}
					System.out.println();
				}
				break;
			// If the 8th choice, prompts user for the size and ensures it is below 20 and is a multiple of 4
			case 8:
				// Prompts user for the first and second checker once the size is appropriate
				System.out.print("Which character do you want for the 1st checker? ");
				first = input.next().charAt(0);
				System.out.print("Which character do you want for the 2nd checker? ");
				second = input.next().charAt(0);
				// If choice 8, it prints the second checker twice in a row within a row and column
				// then when the counter hits a multiple of 2, it changes the pattern to the first checker
				// and does the same twice in a row, and repeat until the 2-d array is filled
				if (choice == 8) {
					System.out.println("Here is your pattern");
					System.out.println();
					// This choice includes two counters - one to track the counter for the rows and one for the columns
					// the temp variable is used to switch between the two checkers, and the proc is used to make the switch
					int counter1 = 0, counter2 = 0;
					char temp = second;
					boolean proc = false;
					for (int i = 0; i < size; i++) {
						for (int j = 0; j < size; j++) {
							// If proc is 'enabled', the temp picks up the other pattern
							if (proc == true && temp == second) {
								temp = first;
								proc = false;
							} else if (proc == true && temp == first) {
								temp = second;
								proc = false;
							}
							// Fills the array with the temp pattern and adds the counter
							array1[i][j] = temp;
							counter1++;
							// Once the counter hits 2, it 'enables' the proc which changes the temp above
							if (counter1 %2 == 0)
								proc = true;
							System.out.print(array1[i][j] + " ");
						}
						// Similar concept as above, but this is used for the rows instead of columns
						counter2++;
						if (proc == true && temp == second) {
							temp = first;
							proc = false;
						} else if (proc == true && temp == first) {
							temp = second;
							proc = false;
						}
						if (counter2 %2 == 0)
							proc = true;
						System.out.println();
					}
					System.out.println();
				}
				break;
			}
		}
		
		// Exit message and closing of scanner.
		System.out.println("\nHope you enjoyed your patterns!! Come back soon ...");
		input.close();
	}
}
