package day3;

public class ExampleTwo {
    public static void main(String[] args) {
        int age1 = 16, age2 = 17, age3 = 20;
        double averageAge;
        final int NUMBER_OF_STUDENTS = 3;

        averageAge = (double)(age1 + age2 + age3) / NUMBER_OF_STUDENTS;

        System.out.println(averageAge);

        int x = (int) 6.4;
        //boolean IsFun = (boolean) ismax; // you cannot case a number to the boolean
    }
}
