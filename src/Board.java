import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.*;

public class Board{

   JFrame frame;
   InfoGetter iGetter;
   playerInfoGetter pIGetter;
   JPanel topP, centerP, bottomP;
   JPanel[]  panels = {topP, centerP, bottomP};
   JButton button;
   JLabel title, testLabel; 
   ArrayList<Round> rounds = new ArrayList<Round>();
   
   
   
   
   

   public Board() throws IOException {
      
      iGetter = new InfoGetter();
      pIGetter = new playerInfoGetter();
      
      getInfo();
      
      gui();
      
      
      
      
   }
   
   public void getInfo() {
      //Fill Round List
      rounds.add(new Round("Round 1", iGetter.getCatNames("r1Cats"), iGetter.getInts("r1Qs"), iGetter.getInts("r1Pts")));
      rounds.add(new Round("Round 2", iGetter.getCatNames("r2Cats"), iGetter.getInts("r2Qs"), iGetter.getInts("r2Pts")));
      
      String[] eCats = iGetter.getCatNames("eCats");
      int[] eCatsQs = iGetter.getIntArray("eCQs");
      int[] eCatsPts = iGetter.getIntArray("eCPts");
      
      for(int i = 0; i<eCats.length; i++) {
         rounds.add(new Round(eCats[i], eCatsQs[i], eCatsPts[i]));
      }  
      
          
      
   }
   
   public JTable makeTable(Round r) {
      if (r.getCats().length>1) {
         Object[][] data = new Object[r.getCats().length][r.getQuestionNumber()+2]; 
         for(int i = 0; i<data.length; i++) {
            data[i][0] = r.getCats()[i];
         }
         
         Object[] titles = new Object[r.getQuestionNumber()+2];
         titles[0] = " ";
         for(int i = 1; i<titles.length; i++) {
           titles[i] = i!=titles.length-1?"Question "+i:"Total";
         }
         
         
         JTable table = new JTable(data, titles);
         
         return table;
      }
      
      else {
      
         Object[][] data = new Object[r.getQuestionNumber()][4];
         //Fills Question Number column
         for(int l = 0; l<data.length; l++) {
            if (l == 0) {
               data[l][0] = " ";
            }
            
            else {
               data[l][0] = "Question "+l;
            }
         }
         
                  
         for (int i = 0; i<data[0].length; i++) {
            if (i == 0) {
               data[0][i] = "Question #";
            }
            
            else if (i == 1 || i == 2) {
               data[0][i] = pIGetter.getTeamName(i);
            }
            
            else {
               data[0][i] = "Total";
            }
         }
         
         Object[] titles = new Object[1];
         for(int i = 0; i<titles.length; i++) {
            titles[i] = "Hello";
         }
         
         
         

         
         return new JTable(data,titles);
      
      }
   
      //return new JTable();
   }
   
   public void gui() {
      frame = new JFrame("Academic Team Match");
      frame.setVisible(true);
      frame.setSize(1200,800);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      topP = new JPanel();
      topP.setVisible(true);
      bottomP = new JPanel();
      bottomP.setVisible(true);
      centerP = new JPanel();
      centerP.setVisible(true);
      
            
      
      //Title 
      topP.setBackground(Color.BLACK);
      title = new JLabel(pIGetter.getTeamName(1)+" vs "+pIGetter.getTeamName(2));
      Font font = title.getFont();
      title.setFont(new Font("Times New Roman", Font.BOLD, 40));
      title.setForeground(Color.WHITE);
      topP.add(title);
      frame.add(topP, BorderLayout.NORTH);
      
      //Center Panel -- Rounds
      centerP.setBackground(Color.WHITE);
      
      /*//Round 1
      JTable r1Table = makeTable(rounds.get(0));
      centerP.add(new JScrollPane(r1Table));
      
      //Round 2     
      JTable r2Table = makeTable(rounds.get(1));
      centerP.add(new JScrollPane(r2Table));*/
      
      //Extra Rounds
      
      for (Round r: rounds) {
         JTable j = makeTable(r);
         centerP.add(new JScrollPane(j));
      }
      
      frame.add(centerP, BorderLayout.CENTER);
      
      
      
      
      
      
      
      
      
      
      
            
   }
   
   
   public static void main(String args[]) throws IOException {
      Board b = new Board();
      
      
   }
}