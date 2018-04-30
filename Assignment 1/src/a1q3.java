// ---------------------------------------------
// Assignment 1 - Question 3
// Written by: Muherthan Thalayasingam, 27223064
// For COMP 248-S - Winter 2018
// ---------------------------------------------

// Asks the user if they would like to take a quiz ( answer doesn't matter), 
// and then proceeds to ask them 4 questions to answer on a scale of 1 to 10.
// Returns the user's personality type based on their answers.

// Imported Scanner to allow user inputs to be recorded
import java.util.Scanner;

public class a1q3 {
	public static void main (String[] args) {
		Scanner userInput = new Scanner (System.in);
		char enLevel, infoLevel, decLevel, planLevel;
		
		// Starting message to welcome users and ask for their information
		System.out.println("Welcome to the personality test.");
		// Prompt user for their consent (though it does not matter in this specific case)
		System.out.print("Would you like to find out about your personality? (Type Yes or No): " );
		String consent = userInput.nextLine();
		
		// A conditional statement that gives a different output based on user's input to the above question
		if (consent.equalsIgnoreCase("yes")) {
			System.out.println("Great, let's begin. Please answer the following questions"
					+ " on a scale from 1 to 10.");
		} else if (consent.equalsIgnoreCase("no")) {
			System.out.println("That was just a test (not really). Let's begin. Please answer the following questions"
					+ " on a scale from 1 to 10.");
		}
		
		System.out.println();
		
		// The following are questions asked to users to categorize them, the input is assigned to a variable
		System.out.println("How do you get your energy?");
		System.out.println("1 -- By spending time alone.");
		System.out.println("10 -- By spending time with others.");
		System.out.print("Answer: ");
		int energy = userInput.nextInt();
		System.out.println();
		
		System.out.println("How do you see the world & gather information?");
		System.out.println("1 -- In concrete terms.");
		System.out.println("10 -- In abstract terms.");
		System.out.print("Answer: ");
		int info = userInput.nextInt();
		System.out.println();
		
		System.out.println("How do you make your decisions?");
		System.out.println("1 -- Using my head.");
		System.out.println("10 -- Using my heart.");
		System.out.print("Answer: ");
		int decision = userInput.nextInt();
		System.out.println();
		
		System.out.println("How much do you like to plan?");
		System.out.println("1 -- Make plans for in advance.");
		System.out.println("10 -- Go with the flow.");
		System.out.print("Answer: ");
		int plan = userInput.nextInt();
		System.out.println();
		
		// Based on the user's input for each question, we assign a personality trait. 
		// If the user's input is 5 or below, they get assigned the former of the two choices.
		// Otherwise, they get assigned the latter. 
		if (energy <=5) {
			enLevel = 'I';
		} else {
			enLevel = 'E';
		}

		if (info <=5) {
			infoLevel = 'S';
		} else {
			infoLevel = 'N';
		}
		
		if (decision <=5) {
			decLevel = 'T';
		} else {
			decLevel = 'F';
		}
		
		if (plan <=5) {
			planLevel = 'J';
		} else {
			planLevel = 'P';
		}

		// Print out the combination of the four letters received from the quiz results. 
		System.out.println("Your personality type is: " + 
				enLevel + infoLevel + decLevel + planLevel);
		System.out.println("To find out more about that type of personality, check out: ");
		System.out.println("https://www.truity.com/view/types");
		System.out.println();
		System.out.println("Goodbye.");
	
		userInput.close();
	}
}
