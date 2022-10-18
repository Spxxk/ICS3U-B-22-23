package day3;

public class ExampleOne {
   public static void main(String[] args) {
    CoffeeCup venti = new CoffeeCup(20, true); //full coffee
    CoffeeCup grande = new CoffeeCup(16);   //empty coffee
    System.out.println(venti.isFull());
    grande.addCoffee(0);
    System.out.println(grande.isFull());
    int amountToAdd = grande.getAmountLeft();
    grande.addCoffee(amountToAdd);
    System.out.println(grande.isFull);


   }
}