// ---------------------------------------------
// Assignment 2 - Question 2
// Written by: Muherthan Thalayasingam, 27223064
// For COMP 248-S - Winter 2018
// ---------------------------------------------

// This program adds two numbers together step by step. First it begins by adding the last digit
// of the two numbers and moves the carry over. Then it adds the carry and the two middle digits
// and moves the carry over again if any. Finally, it adds the first digits together with the carry
// and outputs the final answer with a carry if possible. Users can continue to add numbers as 
// long as they answer y to continue.

// Imported Scanner to allow user inputs to be recorded
import java.util.Scanner;

public class a2q2 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		// Starting message to welcome users
		System.out.println("********************************************");
		System.out.println("Welcome to Nancy's Addition Tutorial Program");
		System.out.println("********************************************");
		
		// Created a boolean variable to use to later stop the loop when user decides to stop.
		boolean cont = true;
		
		while (cont == true) {
		
			// Prompts for user input to see which two numbers will be added.
			System.out.print("Enter two numbers with at most 3-digits each, separated"
					+ " by a space and press enter: ");
			int num1 = input.nextInt();
			int num2 = input.nextInt();
			
			// Prints the two numbers to be added
			System.out.println("");
			System.out.println("You requested the following operation:");
			System.out.println();
			System.out.println("num1: " + num1);
			System.out.println("num2: " + num2);
			System.out.println();
			
			// This calculates the last digit of each number to later be added
			int num1_001 = num1%10;
			int num2_001 = num2%10;
			
			// This calculates the second/middle digit of each number to later be added
			int num1_010 = (num1%100)/10;
			int num2_010 = (num2%100)/10;
			
			// This calculates the first digit of each number to later be added
			int num1_100 = num1/100;
			int num2_100 = num2/100;
			
			// This portion is where the addition of the last digits are made
			System.out.println("1st addition:");
			System.out.println("\tlast digit of each number");
			// This is the sum of the last two digits followed by the remainder and the carry
			int sum3 = num1_001 + num2_001;
			int ans3 = sum3 % 10;
			int car3 = sum3 / 10;
			System.out.println("\t" + num1_001 + " + " + num2_001 + " = " + sum3 +" so answer is " + ans3 
				+ " with a carry of " + car3);
			System.out.println();
			
			// This portion is where the middle digits are added together
			System.out.println("2nd addition:");
			System.out.println("\tthe carry from previous addition plus the middle digit of each number");
			// This is the sum of the middle two digits with the carry followed by the remainder and the carryover
			int sum2 = num1_010 + num2_010 + car3;
			int ans2 = sum2 % 10;
			int car2 = sum2 / 10;
			System.out.println("\t" + car3 + " + " + num1_010 + " + " + num2_010 + " = " + sum2 +" so answer is " + ans2 
					+ " with a carry of " + car2);
			
			// This portion is where the addition of the first two digits are made
			System.out.println("3rd addition:");
			System.out.println("\tthe carry from previous addition plus the first digit of each number");
			// This is the sum of the first two digits with the carry followed by the remainder and the carryover
			int sum1 = num1_100 + num2_100 + car2;
			int ans1 = sum1 % 10;
			int car1 = sum1 / 10;
			System.out.println("\t" + car2 + " + " + num1_100 + " + " + num2_100 + " = " + sum1 +" so answer is " + ans1 
					+ " with a carry of " + car1);
			
			// This outputs the final answer of the addition of the two numbers
			System.out.println("Final answer:");
			System.out.println("\tnum1: " + (num1<100? "\t ": "\t") + num1);
			System.out.println("\tnum2: + " + (num2<100? "\t": "") + num2);
			System.out.println("\t----------");
			System.out.println("\tAnswer: " + (car1 == 0? "": Integer.toString(car1)) + Integer.toString(ans1) + 
					Integer.toString(ans2) + Integer.toString(ans3));
			
			System.out.println();
			
			// Prompts user to see if they wish to add another pair of numbers, based on their answer it loops or ends
			String skip = input.nextLine();
			System.out.print("Do you want to try another one? (y or Y to repeat) ");
			String confirmation = input.next();
			System.out.println("");
			
			// When the user decides to end the program, we make the aforementioned boolean false which ends the loop
			if (!confirmation.toLowerCase().equals("y")) {
				cont = false;
				System.out.println("Hope you are more comfortable with additions now! If not, don't hesitate to come back :-)");
			}
			
		}
		
		
		input.close();
	}
}
