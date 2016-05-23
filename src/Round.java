public class Round {
   private String name;
   private String[] Categories;
   private int questionNumber;
   private int points;
   
   public Round(String n, String[] cats, int num, int pts) {
      name = n;
      Categories = cats;
      questionNumber = num;
      points = pts;
   }
   
   public Round(String n, int num, int pts) {
      name = n;
      Categories = new String[]{n};
      questionNumber = num;
      points = pts;
   }
   
   public String getName() {
      return name;
   }
   
   public String[] getCats() {
      return Categories;
   }
   
   public int getQuestionNumber() {
      return questionNumber;
   }
   
   @Override
   public String toString() {
      return name;
   }
}