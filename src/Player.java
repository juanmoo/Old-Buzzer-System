import java.util.Arrays;


public class Player {

	private String name;
	private int[] scores;
	private String[] categories;
	
	public Player(String n, String[] cats) {
		
		name = n;
		categories = cats;
		scores = new int[cats.length];
		
	}
	
}

