package day3;

public class ExampleOne {
    public static void main(String[] args) {
        //variables are meant to store and eventually recall data/information
        //the data could be anything (a number or a string of chracters, or true or false, a list of accounts etc.)

        //before you use a variable you must declare it
        //when we declare a variable we must specify the data type it will hold

        //primitive types store the value 
        //double is what you use when you need to have a number with decimal numbers
        //boolean is what you use for true or false

        int numberOfstudents = 14; //number of students has been declared as an int

        double testaverage = 63.7; //declared and initilized on the same line and gave it an initial value

        final double pi = 3.14; //pi cannot be changed when adding (final) before the primitive variable

        //naming convention for final is all uppercase with underscores between words

        boolean isheads = false;
        boolean istails = true;

        System.out.println("There are " + numberOfstudents + " students in the class.");
    
    }
    
}
