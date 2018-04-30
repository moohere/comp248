// ---------------------------------------------
// Assignment 3 - Question 1
// Written by: Muherthan Thalayasingam, 27223064
// For COMP 248-S - Winter 2018
// ---------------------------------------------

// This program runs a simulated dart game that shows how many shots of each region was needed
// to get a total points of at least 1000. It uses two 1-D arrays, one to store the point value
// of each region, and one to keep a tally of how many times these regions were hit. The total
// is then added by multiplying the two arrays together. The result is outputted in a  table format.

// Import scanner to take user input.
import java.util.Random;

public class a3q1 {
	public static void main (String[] args) {	
		
		// Variable used to later generate a random number
		Random randomNum = new Random();
		
		// Variables initialized to keep track of the total, and the counter of each hit as well as the arrays
		int total = 0;
		int counter = 0;
		int[] ptValue = {7, 5, 5, 5, 3, 3, 3, 1, 1, 1};
		int[] numHits = new int[10];
	
		// This while loop continuously generates a random number to see which region is hit
		// and then the total is tallied up until the 1000 points goal is reached
		while (total < 1000) {
			int hit = randomNum.nextInt(10);
			numHits[hit]++;
			total += ptValue[hit];
		}
		
		// Simple strings to showcase above the output
		System.out.println("|------------------------->>>><<<<-------------------------|");
		System.out.println("|           Welcome to the Simplified Dart Game!           |");
		System.out.println("|------------------------->>>><<<<-------------------------|");
		System.out.println();
		System.out.println("Region\tHits\tPoints" );
		System.out.println("----------------------"
				+ "");
		
		// This for loop is used to iterate through each value of the first array (+1 to start tracking at 1)
		// and then also to show how many times each region were hit. Then finally the total value by multiplying the two.
		for (int i = 0; i < 10; i++) 
			System.out.println(" " + (i+1) + "\t" + numHits[i] + "\t" + ptValue[i]*numHits[i]);
		
		// This for loop is used to count the total number of tosses
		for (int i = 0; i < 10; i++) 
			counter += numHits[i];
		
		// This is the final print out that shows the total number of tosses and the total points.
		System.out.println();
		System.out.println("It took " + counter + " tosses for a total of " + total);
		System.out.println();
		System.out.println("That was an effortless game of darts!");
	}
}
