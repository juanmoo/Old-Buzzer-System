import java.util.*;
import java.io.*;

public class playerInfoGetter{

   //Temporarily Stores the players obtained from the file.
   private ArrayList<String> team1Players = new ArrayList<String>();
   private ArrayList<String> team2Players = new ArrayList<String>();
   private String teamName1, teamName2;
   
   File playerList;
   Scanner reader;
   
   public String[] getPlayerNames(int n) {
      ArrayList<String> team = null;
      if( n == 1 ) { team = team1Players; }
      else if ( n == 2 ) { team = team2Players; }
      else { 
         
         System.out.println("*** Invalid Number of Teams ***");
         System.exit(0);
      }
      
      String[] names = new String[team.size()];
      for(int i = 0; i<team.size(); i++) {
         names[i] = team1Players.get(i);
      }
      
      return names;
   }  
   
   public String getTeamName(int i) {
      if (i == 1) {
         return teamName1;
      }
      
      else if (i == 2) {
         return teamName2;
      }
      
      else {
         return "Generic Team Name "+((int)(Math.random()*10)+1);
      }
   }
   
   public playerInfoGetter() throws IOException {
      playerList = new File("../Settings/Players.confi");
      reader = new Scanner(playerList);
      
      while(!reader.nextLine().trim().equals("*start*")){} // Skips lines until '*start*' is found.
      String line = reader.nextLine().trim();
      
      while(!line.contains(":")) {
         line = reader.nextLine().trim();
      }
      line = reader.nextLine().trim();
      
      while(!line.contains(":")) {
         if(line.trim().length()>0) team1Players.add(line);
         line = reader.nextLine().trim();
      }
      
      line = reader.nextLine().trim();
      while(true) {
         if (line.equals("*end*")) break;
         if(line.trim().length()>0) team2Players.add(line);
         line = reader.nextLine().trim();
      }
      
      File tNames = new File("../Settings/Teams.confi");
      Scanner tReader = new Scanner(tNames);
      while(!tReader.nextLine().contains(":")){}
      
      int count = 0;
      while(true) {
         line = tReader.nextLine().trim();
         if (line.contains(":")&&count == 0) {
            line = line.substring(line.indexOf(":")+1).trim();
            
            teamName1 = line;
            count++;
         }
         
         else if(line.contains(":")&&count >0) {
            line = line.substring(line.indexOf(":")+1).trim();
            teamName2 = line;
            count++;
         }
         
         if(count>=2) break;
         
      }
      
      
      
      
      
   }
   
   
   
   
   
   
   
}  