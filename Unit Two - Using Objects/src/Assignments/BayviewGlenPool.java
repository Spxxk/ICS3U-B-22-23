package Assignments;
import java.util.Scanner;

public class BayviewGlenPool {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Prompts/sets code for the user
        System.out.println("Enter the length of the transition in meters: ");
        double transitionSlope = in.nextDouble();

        System.out.println("Enter the length of shallow end in meters: ");
        double shallowLength = in.nextDouble();

        System.out.println("Enter the price of liner per meter squared: ");
        double PriceOfLiner = in.nextDouble();

        System.out.println("Enter the length of the pool in meters: ");
        double length = in.nextDouble();
        
        System.out.println("Enter the width in meters: ");
        double width = in.nextDouble();

        System.out.println("Enter the depth of the shallow end in meters ");
        double heightOfShallowEnd = in.nextDouble();

        System.out.println("Enter the depth of the deep end depth in meters ");
        double heightOfDeepEnd = in.nextDouble();


        //Volume of the pool Step 1: calculates the volume of the pool by getting the volume of the deep end,
        //the shallow end, the square area above the transition, and the transition.
        double transitionHeight = heightOfDeepEnd-heightOfShallowEnd;
        // sqrt
        double lengthOfTransition = Math.sqrt(Math.pow(transitionSlope,2) - Math.pow(transitionHeight, 2));
        double lengthOfDeepEnd = length - lengthOfTransition - shallowLength;

        double volume = (lengthOfDeepEnd * heightOfDeepEnd * width) + (shallowLength * heightOfShallowEnd * width) + (heightOfShallowEnd * width * lengthOfTransition) + (0.5 * transitionHeight * lengthOfTransition * width);

        double lNeeded = 1000*(volume*0.9);


        //Rounding Step 2: Rounds the volume to the hundreths place
        double lNeededRounded = Math.round(lNeeded*100)/100.0;
        System.out.println("The amount of water to keep pool at 90% is: " + lNeededRounded + "L.");


        //Calculating surface area Step 3: Calculate the surface area by getting the surface area of the shallow end, deep end, and transition.
        double SurfaceArea = ((heightOfDeepEnd * width) + (2 * (lengthOfDeepEnd * heightOfDeepEnd)) + (lengthOfDeepEnd * width))
                + ((heightOfShallowEnd * width) + (2*(shallowLength*heightOfShallowEnd)) + (shallowLength * width)) +
                ((transitionSlope*width) + (2 * (transitionHeight*lengthOfTransition) /2 ) + ( 2 * (lengthOfTransition*heightOfShallowEnd)));


        //Rounding Step 4: Rounds the surface area to the hundreths place
        double SurfaceAreaRounded = Math.round(SurfaceArea*100)/100.0;

        System.out.println("the amount of lining needed is: " + SurfaceAreaRounded + "m^2");


        //calculating the cost of the liner Step 5:
        double liner = SurfaceAreaRounded*PriceOfLiner;

        System.out.println("the lining price is : $" + liner + ".");

        in.close();

    }
}