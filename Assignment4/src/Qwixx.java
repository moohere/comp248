import java.util.Scanner;


public class Qwixx {
	static Scanner input = new Scanner(System.in);
	public Dice[] dice = new Dice[6];
	private Player[] players;
	private boolean lockedR, lockedY, lockedG, lockedB;
	public static int NEGPTS = 5;
	
	public Qwixx(Player[] players) {
		this.players = players;
		Dice red = new Dice("Red");
		Dice yellow = new Dice("Yellow");
		Dice green = new Dice("Green");
		Dice blue = new Dice("Blue");
		Dice white1 = new Dice("White1");
		Dice white2 = new Dice("White2");
		this.dice = new Dice[]{red, yellow, green, blue, white1, white2};
	}
	
	public void rollDice() {
		for (int i = 0; i < dice.length; i++) {
			dice[i].currentSide = Dice.rollDice();
		}
	}
	
	public int getWhiteDiceTotal() {
		return this.dice[4].currentSide + this.dice[5].currentSide;
	}
	
	public boolean checkValidMove(Player p, Move m){
		return p.makeMove(m);
	}
	
	public boolean checkColourFinished(Player p, char colour) {
		int index = Move.convertColourtoNum(colour);
		int num;
		boolean finished = false;
		switch(index) {
		case 0:
			num = p.getNumR();
			if (num == 12) {
				this.lockedR = true;
				finished = true;
			}
			break;
		case 1:
			num = p.getNumY();
			if (num == 12) {
				this.lockedY = true;
				finished = true;
			}
			break;
		case 2:
			num = p.getNumG();
			if (num == 2) {
				this.lockedG = true;
				finished = true;
			}
			break;
		case 3:
			num = p.getNumB();
			if (num == 2) {
				this.lockedB = true;
				finished = true;
			}
			break;
		}
		return finished;
	}
	
	public boolean checkGameFinished() {
		boolean lost = false;
		for (int i = 0; i < this.players.length; i++)
			if (this.players[i].getNegativePoints() >= 20)
				lost = true;
		return (this.lockedR && this.lockedY || this.lockedR && this.lockedG || this.lockedR && this.lockedB || this.lockedY && this.lockedG || this.lockedY && this.lockedB || this.lockedG && this.lockedB || lost);
	}
	
	public void playWhiteDiceMove() {
		String answer;
		char colour;
		int total = getWhiteDiceTotal();
		
		System.out.println("***** Move on white dice *****");
		System.out.println("The total for the white dice is " + total);

		for (int i = 0; i < this.players.length; i++) {
			System.out.println(this.players[i].getName() + " it's your turn...");
			this.players[i].printGameBoard();
			System.out.print("Would you like to cross off a number on the game board using the white dice total? (anything other than 'yes' is taken to mean no): ");
			answer = input.next();
			System.out.println();
			if (answer.equalsIgnoreCase("yes")) {
				System.out.print("What colour would you like to cross out? (R = red, Y = yellow, G = green, B = blue): ");
				colour = input.next().charAt(0);
				Move whiteMove = new Move(colour, total);
				
				while (!checkValidMove(this.players[i], whiteMove)) {
					if (checkColourFinished(this.players[i], colour))
						System.out.println("Invalid move; " + whiteMove.getColour() + " is locked.");
					else
						System.out.println("Invalid move; " + whiteMove.getNumber() + " is already crossed off in " + whiteMove.getColour());
					System.out.println();
					System.out.print("Would you like to cross off a number on the game board using the white dice total? (anything other than 'yes' is taken to mean no): ");
					answer = input.next();
					System.out.println();
					if (answer.equalsIgnoreCase("yes")) {
						System.out.print("What colour would you like to cross out? (R = red, Y = yellow, G = green, B = blue): ");
						colour = input.next().charAt(0);
						whiteMove.setColour(colour);
					}
				}
				
				if ((checkGameFinished() == false) && (checkColourFinished(this.players[i], colour) == false)) {
					System.out.println("You've crossed off " + colour + " " + total);
					this.players[i].makeMove(whiteMove);
					this.players[i].printGameBoard();
					
				} 
			}
			System.out.println();
		}
	}
	
	public void playColourDiceMove (Player p) {
		int whiteChoice;
		String answer;
		char colour;
		
		System.out.println(p.getName() + " it's your turn...");
		System.out.println();
		System.out.println("***** Move on any colour dice *****");
		p.printGameBoard();
		System.out.println();
		
		for (int i = 0; i < this.dice.length; i++)
			System.out.print(this.dice[i] + " | ");
		System.out.println();
		System.out.println();
		
		System.out.print("Would you like to cross off a number on the game board using one of the coloured dice and a white dice? (anything other than 'yes' is taken to mean no): ");
		answer = input.next();
		if (answer.equalsIgnoreCase("yes")) {
			System.out.print("Which white dice would you like to use? (White1 = 1, White2 = 2): ");
			whiteChoice = input.nextInt();
			System.out.print("What colour would you like to cross out? (R = red, Y = yellow, G = green, B = blue): ");
			colour = input.next().charAt(0);
			
			int index = Move.convertColourtoNum(colour);
			int total = dice[3 + whiteChoice].currentSide + dice[index].currentSide;
			
			Move colourMove = new Move(colour, total);
			
			while (!checkValidMove(p, colourMove)) {
				if (checkColourFinished(p, colour))
					System.out.println("Invalid move; " + colourMove.getColour() + " is locked.");
				else
					System.out.println("Invalid move; " + colourMove.getNumber() + " precedes a crossed number in " + colourMove.getColour());
				System.out.println();
				System.out.print("Would you like to cross off a number on the game board using one of the coloured dice and a white dice? (anything other than 'yes' is taken to mean no): ");
				answer = input.next();
				if (answer.equalsIgnoreCase("yes")) {
					System.out.print("Which white dice would you like to use? (White1 = 1, White2 = 2): ");
					whiteChoice = input.nextInt();
					System.out.print("What colour would you like to cross out? (R = red, Y = yellow, G = green, B = blue): ");
					colour = input.next().charAt(0);
					
					index = Move.convertColourtoNum(colour);
					total = dice[3 + whiteChoice].currentSide + dice[index].currentSide;
					colourMove.setColour(colour);
					colourMove.setNumber(total);
				}
			}
			
			if ((checkGameFinished() == false) && (checkColourFinished(p, colour) == false)) {
				System.out.println("You've crossed off: " + colour + " " + total);
				p.makeMove(colourMove);
				p.printGameBoard();
			} 
		} else {
			p.addNegativePoints(NEGPTS);
			System.out.println("For passing you lose 5 points. You now have a total loss of -" + p.getNegativePoints() + ".");
		}
		System.out.println();
	}
}
