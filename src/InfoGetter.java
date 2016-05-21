import java.util.*;
import java.io.File;
import java.io.*;


public class InfoGetter {
      public String[] r1Cats, r2Cats, eCats;
      public int r1Questions, r2Questions;
      public int[] eCatsQuestions;
      public int r1Points, r2Points;
      public int[] eCatsPoints;
      public static File infoFile;
      
      //Temporary ArralyLists
      private ArrayList<String> r1 = new ArrayList<String>();
      private ArrayList<String> r2 = new ArrayList<String>();
      private ArrayList<String> eC = new ArrayList<String>();
      private ArrayList<Integer> eCQs = new ArrayList<Integer>();
      private ArrayList<Integer> eCPts = new ArrayList<Integer>();
      
      public InfoGetter() throws IOException{
         makeFile();
         getInfo();
      }
      
      public static void makeFile() {
         infoFile = new File("../Settings/Categories.confi");
      }
      
      public void getInfo() throws FileNotFoundException {
      
         Scanner reader = new Scanner(infoFile);
         while(!reader.nextLine().trim().equals("***")) {
            //Skips all lines before *** is found
         }
         
         String line = null;
         
         
         //Sets the value of r1Questions
         do {
            line = reader.nextLine();
         } while(!line.contains("umber"));
         
         line = line.substring(1+line.indexOf(":")).trim();
         try {
            r1Questions = Integer.valueOf(line);
         }
         
         catch (NumberFormatException nfe) {
            System.out.println("*** Invalid input ***");
            System.exit(0);
         }
         
         //Sets the value of r1Points
         do {
            line = reader.nextLine();
         } while(!line.contains("oints"));
         
         line = line.substring(1+line.indexOf(":")).trim();
         try {
            r1Points = Integer.valueOf(line);
         }
         
         catch (NumberFormatException nfe) {
            System.out.println("*** Invalid input ***");
            System.exit(0);
         }
         
         //Skips lines until if finds ':'
         
         while(true) {
            line = reader.nextLine();
            if (line.contains(":")) break;
         }
         
         
         do {
            line = reader.nextLine();
            line = line.trim();
            if (line.length()>0 && !line.equals("*end*")) r1.add(line);
         } while(!line.trim().equals("*end*"));
         
         while (true) {
            line = reader.nextLine();
            if(line.contains("umber")) break;
         }
         
         line = line.substring(line.indexOf(":")+1).trim();
         
         try {
            r2Questions = Integer.valueOf(line);
         }
         
         catch (NumberFormatException nfe) {
            System.out.println("*** Invalid input ***");
            System.exit(0);
         }


         while (true) {
            line = reader.nextLine();
            if(line.contains("oints")) break;
         }
         
         line = line.substring(line.indexOf(":")+1).trim();
         
         try {
            r2Points = Integer.valueOf(line);
         }
         
         catch (NumberFormatException nfe) {
            System.out.println("*** Invalid input ***");
            System.exit(0);
         }
         
         while(true) {
            line = reader.nextLine().trim();
            if (line.contains(":")) break;
         }
         
         do {
            line = reader.nextLine().trim();
            if (line.length()>0 && !line.equals("*end*")) r2.add(line);
         }while(!line.equals("*end*"));
         
         //Skip until Extra Categories begin
         
         while(true) {
            line = reader.nextLine().trim();
            if(line.contains(",") && line.indexOf(",") != line.lastIndexOf(",")) break;
         }
         
         while (true) {
            line = reader.nextLine().trim();
            if (line.equals("***")) break;
            String[] cat = line.split(",");
            for(int i = 0; i<cat.length; i++) {
               cat[i] = cat[i].trim();
            }
            eC.add(cat[0]);
            eCQs.add(Integer.valueOf(cat[1]));
            eCPts.add(Integer.valueOf(cat[2]));
         }
   
   
         r1Cats = new String[r1.size()];
         for(int i = 0; i< r1.size(); i++) {
            r1Cats[i] = r1.get(i);
         }
         
         r2Cats = new String[r2.size()];
         for(int i = 0; i< r2.size(); i++) {
            r2Cats[i] = r2.get(i);
         }
         
         eCats = new String[eC.size()];
         for (int i = 0; i<eC.size(); i++) {
            eCats[i] = eC.get(i);
         }
         
         eCatsQuestions = new int[eCQs.size()];
         for (int i = 0; i<eCQs.size(); i++) {
            eCatsQuestions[i] = eCQs.get(i);
         }
         
         eCatsPoints = new int[eCPts.size()];
         for (int i = 0; i<eCPts.size(); i++) {
            eCatsPoints[i] = eCPts.get(i);
         }
         

         

         
         
         

         
         
      }
      
            
      
      
}
