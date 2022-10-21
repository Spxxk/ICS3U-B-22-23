package day1;

public class BooleanExpressions {
    public static void main(String[] args) {
        boolean exp1 = 17 > 5; //true
        boolean exp2 = 17 == 17; //true
        boolean IsRed = true; //true
        boolean IsHard = false; //false
        
        boolean exp3 = IsHard == IsRed; //therefore this is also false

        int x = 7;
        boolean exp4 = (x < 3) != (x > 5); // when false is not equal to true it is true

        int y = 3;
        boolean exp5 = (x < y) == (y > 7); // when false = false it is true

        //Compound boolean Expressions
        //AND (&&) OR (||) NOT (!)


        //not  operator
        boolean isGreen = true;

        boolean exp6 = !isGreen;
        boolean exp7 = !true; //false
        boolean exp8 = !false; //true

        boolean IsBlue = false;
        IsHard = true;


        boolean isHardBlue = IsBlue && IsHard; //(&& requires both left and right side to be true)

        boolean isBlueOrHard = IsBlue || IsHard; //false || true therefore if oen is ture the whole thing is true

        x=7;
        y=17;
        boolean exp9 = (x>7) && (y<25); //false and anything = false









    
    }
}
