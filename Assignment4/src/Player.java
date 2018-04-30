
public class Player {
	private String name;
	private String[][] gameBoard = new String[4][11];
	private int numR, numY, numG, numB, negativePoints;
	
	public Player() {
		this.name = null;
		this.gameBoard = initializeGameboard();
		this.numR = 0;
		this.numY = 0;
		this.numG = 0;
		this.numB = 0;
		this.negativePoints = 0;
	}
	
	public Player(String name) {
		this.name = name;
		this.gameBoard = initializeGameboard();
		this.numR = 0;
		this.numY = 0;
		this.numG = 0;
		this.numB = 0;
		this.negativePoints = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumR() {
		return this.numR;
	}
	
	public int getNumY() {
		return this.numY;
	}
	
	public int getNumG() {
		return this.numG;
	}

	public int getNumB() {
		return this.numB;
	}

	public int getNegativePoints() {
		return this.negativePoints;
	}
	
	public void setNegativePoints(int negativePoints) {
		this.negativePoints = negativePoints;
	}
	
	private String[][] initializeGameboard() {
		return new String[][]{
				{"2","3","4","5","6","7","8","9","10","11","12"},
				{"2","3","4","5","6","7","8","9","10","11","12"},
				{"12","11","10","9","8","7","6","5","4","3","2"},
				{"12","11","10","9","8","7","6","5","4","3","2"}
			};
	}
	
	public void addNegativePoints(int pts) {
		this.negativePoints += pts;
	}
	
	public void printGameBoard() {
		System.out.println("Name: " + this.name);
		for (int i = 0; i < this.gameBoard.length; i++) {
			for (int j = 0; j < this.gameBoard[0].length; j++)
				System.out.printf(this.gameBoard[i][j] + "\t");
			System.out.println();
		}
	}

	public boolean makeMove(Move m) {
		int number = m.getNumber();
		int index = Move.convertColourtoNum(m.getColour());
		int j;
		int length = this.gameBoard[index].length - 1;
		boolean valid = true;
		int i = length;
		
		while (!this.gameBoard[index][i].equals(Integer.toString(number))) {
			if (this.gameBoard[index][i].equals("x") || this.gameBoard[index][length].equals("x")) {
				valid = false;
				break;
			}
			i--;
		}
		
		j = i;
		while (!this.gameBoard[index][j].equals("x") && j < length - 1)
			j++;
		if (this.gameBoard[index][j].equals("x"))
			valid = false;

		if (valid) {
			switch(index) {
			case 0:
				this.numR = Integer.parseInt(this.gameBoard[index][i]);
				break;
			case 1:
				this.numY = Integer.parseInt(this.gameBoard[index][i]);
				break;
			case 2:
				this.numG = Integer.parseInt(this.gameBoard[index][i]);
				break;
			case 3:
				this.numB = Integer.parseInt(this.gameBoard[index][i]);
				break;
			}
			this.gameBoard[index][i] = "x";
		}
		return valid;
	}
	
	public int getBoardTotal() {
		int total = 0;
		for (int i = 0; i < this.gameBoard.length; i++) {
			int counter = 0;
			for (int j = 0; j < this.gameBoard[0].length; j++)
				if (this.gameBoard[i][j].equals("x"))
					counter++;
			switch(counter) {
			case 1:
				total++;
				break;
			case 2:
				total += 3;
				break;
			case 3:
				total += 6;
				break;
			case 4:
				total += 10;
				break;
			case 5:
				total += 15;
				break;
			case 6:
				total += 21;
				break;
			case 7:
				total += 28;
				break;
			case 8:
				total += 36;
				break;
			case 9:
				total += 45;
				break;
			case 10:
				total += 55;
				break;
			case 11:
				total += 66;
				break;
			case 12:
				total += 78;
				break;
			}
		}
		return total - this.negativePoints;
	}
	
	public static void main(String[] args) {
		Player a = new Player("Muher");
		Move b = new Move('R', 3);
		Move c = new Move('R', 2);
		Move d = new Move('B', 12);
		Move r = new Move('B', 11);
		
		a.makeMove(b);
		a.makeMove(c);
		a.makeMove(d);
		a.makeMove(r);
		a.addNegativePoints(5);
		a.printGameBoard();
		System.out.println(a.getBoardTotal());
		System.out.println(a.getNumB());
	}
 }
