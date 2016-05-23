import java.util.Arrays;


import java.util.ArrayList;

public class Player {

	private String name;
	private int[] scores;
   private String[] categories;
   private int[] prevScores;
   
	
	public Player(String n, String[] r1Cat, String[] r2Cat, String[] eCat) {
		
		name = n;
		
      ArrayList<String> s = new ArrayList<String>();
      for (String a: r1Cat) { s.add(a); }
      for (String a: r2Cat) { s.add(a); }
      for (String a: eCat) { s.add(a); }
      
      categories = new String[s.size()];
      scores = new int[s.size()];
      prevScores = new int[s.size()];
      
      for (int i = 0; i<s.size(); i++) {
         categories[i] = s.get(i);
      }
      
      
		
	}
   
   public int getScore(String cat) {
      return scores[Arrays.asList(categories).indexOf(cat)];
   }
   
   public int setScore (String cat, int pts) {
      System.arraycopy(scores, 0, prevScores, 0, scores.length);
      scores[Arrays.asList(categories).indexOf(cat)] += pts;
      return scores[Arrays.asList(categories).indexOf(cat)];
   }
   
   public void cancelScoreChange() {
      System.arraycopy(prevScores, 0, scores, 0, scores.length);
   }
   
   
	
}

