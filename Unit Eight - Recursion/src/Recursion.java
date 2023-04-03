public class Recursion{
    public static void main(String[]args){
        //System.out.println("Factorial");
        System.out.println(fibonacci(1000));

        int[] arr = {6,12,87,1,90,200,2,3,4,5,12,5,3,5,6,2,6,346};
        Arrays.sort(arr);


        for(int i : arr){
            System.out.println();
        }
    }

    static Long[] results = new Long[1001];

    private static Long fibonacci(int n){
        if(results(n) != 0)
        return results(n);

        if (n == 1 || n == 2)
        return (long) 1;

        return fibonacci(n - 1) + fibonacci(n - 2);

        return results[n];
    }

    private static int Factorial(int n){
        if(n==1)
        return 1;

        return n * Factorial(n - 1);
    }
}