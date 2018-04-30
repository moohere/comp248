// ---------------------------------------------
// Assignment 2 - Question 1
// Written by: Muherthan Thalayasingam, 27223064
// For COMP 248-S - Winter 2018
// ---------------------------------------------

// This program prompts for user input in order to figure out the punishment that the culprits
// will have to endure. Based on the situation at which the culprit was stopped at, a 
// different punishment is given. 

// Imported Scanner to allow user inputs to be recorded
import java.util.Scanner;

public class a2q1 {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Starting message to welcome users
		System.out.println("************************************************");
		System.out.println("Welcome to the Fine and Demerit Point Evaluator!");
		System.out.println("************************************************");
		
		// Prompts for user information about where the driver was stopped
		System.out.println("Hello Officer - I need some information before I tell you what "
				+ "the fine and demerit points are.");
		System.out.println("Here are the possible locations:");
		System.out.println("1. The Driver was stopped on the highway.");
		System.out.println("2. The driver was stopped in a school zone.");
		System.out.println("3. The driver was stopped at a stop sign or a traffic light.");
		System.out.println("4. None of the above.");
		System.out.println();
		System.out.println("Please enter the digit corresponding to your case: ");
		int location = input.nextInt();
		
		// Asks the user for more information about the driver's demerit points
		System.out.println("How many demerit points did the driver have prior to being stopped?");
		int demeritPoints = input.nextInt();
	
		// This input is used to skip lines since the previous input was Int and the next is a String
		String skip = input.nextLine();
		
		// In this case, depending on whether or not it is the user's first offence, the punishment 
		// is more or less severe. A new input is used to keep track of the user's record of offence. 
		if (location == 1 ) {
			System.out.println("Is this the driver's first offence? (Answer with 'yes' or 'no')");
			String firstOffence = input.nextLine(); 
			
			if (firstOffence.equalsIgnoreCase("yes")) {
				demeritPoints += 1;
				System.out.println("Write a ticket for $80 and inform the driver that they now have "
						+ demeritPoints + " demerit points.");
			}
			else {
				demeritPoints += 2;
				System.out.println("Write a ticket for $80 and inform the driver that they now have " 
						+ demeritPoints + " demerit points.");
			}
		}	
		
		// This is the case where depending on how long the driver held his/her license
		// their punishment will become more or less severe. A new input is used to keep track of the duration.
		// Also, depending on whether or not they already have 12 demerit points, a different message is 
		// outputted when they get their license revoked. This is to avoid repeating the same thing twice.
		else if (location == 2) {
			System.out.println("How many months has the driver been driving for?");
			int licenseDuration = input.nextInt();
			
			if (licenseDuration < 24 && demeritPoints < 12) {
				System.out.println("Write a ticket for $100 and inform the driver that their "
						+ "license is revoked immediately.");
				System.out.println("Furthermore, inform them that they have " 
						+ demeritPoints + " demerit points.");
			}
			else if (licenseDuration < 24 && demeritPoints >= 12)
				System.out.println("Write a ticket for $100. Furthermore, inform them that they have " 
						+ demeritPoints + " demerit points.");
			else {
				demeritPoints += 4;
				System.out.println("Write a ticket for $100 and inform the driver that they now have " 
						+ demeritPoints + " demerit points.");
			}
		}
		
		// This is the case where depending on whether or not the driver uses an iPhone
		// his/her punishment is more or less severe. A new input is used to keep track of the choice of phone.
		else if (location == 3) {
			System.out.println("Does the driver use an iPhone? (Answer with 'yes' or 'no') ");
			String phoneChoice = input.nextLine();
			
			if (phoneChoice.equalsIgnoreCase("yes")) {
				demeritPoints += 2;
				System.out.println("Write a ticket for $100 and inform the driver that they now have " 
						+ demeritPoints + " demerit points.");
			}
			else {
				demeritPoints += 1;
				System.out.println("Write a ticket for $80 and inform the driver that they now have " 
						+ demeritPoints + " demerit points.");
			}
		}
		
		// In every other case, the punishment is as follows
		else {
			demeritPoints += 3;
			System.out.println("Write a ticket for $90 and inform the driver that they now have " 
					+ demeritPoints + " demerit points.");
		}
		
		if (demeritPoints >= 12)
			System.out.println("Inform the driver that their license is revoked immediately"
					+ " as they have 12 or more demerit points.");
		
		System.out.println();
		// Exit message
		System.out.println("Good job officer! Crazy Nancy's tells you to keep up the good work!");
		// Close the scanner
		input.close();
	}
}
