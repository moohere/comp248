import java.util.Scanner;

public class Driver {
	public static void main (String[] args) {
			Scanner input = new Scanner(System.in);
			
			System.out.print("Please enter the number of players (2-5): ");
			int numPlayers = input.nextInt();
			while (numPlayers < 2 || numPlayers >5) {
				System.out.println("You must have between 2 and 5 players.");
				System.out.print("Please enter the number of players (2-5): ");
				numPlayers = input.nextInt();
			}
			
			Player[] players = new Player[numPlayers];
			
			for (int i = 0; i < numPlayers; i++) {
				System.out.print("Please enter the name of player" + (i+1) + ": ");
				String name = input.next();
				players[i] = new Player(name);
				
				players[i].printGameBoard();
				System.out.println();
			}
			Qwixx game = new Qwixx(players);
			
			while (game.checkGameFinished() == false) {
				int counter = 0;
				while (counter != numPlayers && game.checkGameFinished() == false) {
					System.out.println("----- New Round -----");
					for (int j = 0; j < game.dice.length; j++)
						System.out.print(game.dice[j] + " | ");
						
					System.out.println();
					System.out.println();
					
					game.rollDice();
					
					game.playWhiteDiceMove();
					
					game.playColourDiceMove(players[counter]);
					counter++;
				}
			}
			input.close();
		}
}
