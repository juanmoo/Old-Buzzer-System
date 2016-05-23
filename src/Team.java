public class Team {
   
   public Player[] players;
   private String name;
   private String[] categories; 
   
   public Team(String n, Player[] pys, String[] cats) {
      players = pys;
      name = n;
      categories = cats;
   }
   
   public int getTeamScore(String cat) {
      int sum = 0;
      for (Player p: players) {
         sum += p.getScore(cat);
      }
      
      return sum;
   }
   
   public int getTotalTeamScore() {
      int sum = 0;
      for (String cat: categories) {
         sum += getTeamScore(cat);
      }
      
      return sum;
   } 
   
    
}