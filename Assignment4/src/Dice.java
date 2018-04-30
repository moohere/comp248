import java.util.Random;
public class Dice {
	private String colour;
	public int currentSide;
	
	public Dice() {
		this.colour = "white";
		this.currentSide = rollDice();
	}
	
	public Dice(String startColour) {
		this.colour = startColour;
		this.currentSide = rollDice();
	}
	
	public static int rollDice() {
		Random randomNum = new Random();
		return randomNum.nextInt(6) + 1;
	}
	
	public String getColour() {
		return this.colour;
	}
	
	public void setColour(String newColour) {
		this.colour = newColour;
	}
	
	public int getCurrentSide() {
		return this.currentSide;
	}
	
	public String toString() {
		return this.colour + " dice: " + this.currentSide;
	}
	
	public static void main (String[] args) {
		Dice a = new Dice();
		Dice b = new Dice("black");
		
		System.out.println(a);
		System.out.println(b);
	}
}


