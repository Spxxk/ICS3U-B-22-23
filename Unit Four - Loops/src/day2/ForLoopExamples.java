package day2;

public class ForLoopExamples {
   public static void main(String[] args) {
      exampleOne();
      exampleTwo(1, 1000);
      exampleThree("Check this String");

   }

   /* Introduction to for loops (counting loops) */
   private static void exampleOne() {
    //int i = 0;
    //int sum = 0;
    //while(i<10){
    //sum += 1;
    //i++;
    //}
    int sum = 0;
    for (int i = 0; i < 10; i++){
        sum += i;
    }
    for(;true;){}
   }

   /* Obtain the sum of the numbers from start to end */
   private static void exampleTwo(int start, int end) {
    int sum = 0;

    for (int i = start; i <= end; i++) {
        sum += 1;
        
    }
    System.out.println();

   }

   /* count the number of words in the sentence */
   private static void exampleThree(String sentence) {

   }
}