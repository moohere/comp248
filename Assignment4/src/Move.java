public class Move {
	private char colour;
	private int number;
	
	public Move(char colour, int number) {
		this.colour = colour;
		this.number = number;
	}
	
	public char getColour() {
		return this.colour;
	}
	
	public void setColour(char colour) {
		this.colour = colour;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public static int convertColourtoNum(char colour) {
		int index = 0;
		switch (colour) {
		case 'R':
			index = 0;
			break;
		case 'Y':
			index = 1;
			break;
		case 'G':
			index = 2;
			break;
		case 'B':
			index = 3;
			break;
		}
		return index;
	}
}
